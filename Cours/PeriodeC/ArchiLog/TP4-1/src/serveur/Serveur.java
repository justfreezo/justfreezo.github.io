package serveur;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.net.*;

public class Serveur implements Runnable {
	private ServerSocket listen_socket;
	private Class<? extends Service> service;
	
	// Cree un serveur TCP - objet de la classe ServerSocket
	public Serveur(Class<? extends Service> c, int port) throws IOException {
		listen_socket = new ServerSocket(port);
		this.service = c;
	}

	// Le serveur ecoute et accepte les connexions.
	// pour chaque connexion, il cree un ServiceInversion, 
	// qui va la traiter, et le lance
	public void run() {
		try {
			System.err.println("Lancement du serveur au port " + this.listen_socket.getLocalPort());
			while(true) {
				Service target = service.getDeclaredConstructor().newInstance();
	            target.setSocket(listen_socket.accept());
	            new Thread(target).start();
			}
		}
		catch (IOException | IllegalArgumentException | SecurityException | InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) { 
			try {this.listen_socket.close();} catch (IOException e1) {}
			System.err.println("Arret du serveur au port " + this.listen_socket.getLocalPort());
		}
	}

	 // restituer les ressources --> finalize
	protected void finalize() throws Throwable {
		try {this.listen_socket.close();} catch (IOException e1) {}
	}
}
