package appli;

import java.io.*;
import java.net.*;

import serveur.Service;


public class ServiceInversion extends Service {
	
	private static int cpt = 1;
	
	private final int numero;
	
	public ServiceInversion(Socket socket) {
		super(socket);
		this.numero = cpt++;
	}
	
	public ServiceInversion() {
		super();
		this.numero = cpt++;
	}

	public void run() {
		System.out.println("*********Connexion " + this.numero + " demarree");
		try {
			BufferedReader in = new BufferedReader (new InputStreamReader(getClient().getInputStream ( )));
			PrintWriter out = new PrintWriter (getClient().getOutputStream ( ), true);
			String line = in.readLine();
			System.out.println("Connexion " + this.numero + " <-- " + line);
			String invLine = new String (new StringBuffer(line).reverse());
			out.println(invLine);
			System.out.println("Connexion " + this.numero + " --> " + invLine);
		}
		catch (IOException e) {
		}
		//Fin du service d'inversion
		System.out.println("*********Connexion " + this.numero + " terminee");
		try {getClient().close();} catch (IOException e2) {}
	}
	
	protected void finalize() throws Throwable {
		 getClient().close(); 
	}
	
	@Override
	public String toString() {
		return "Inversion de texte";
	}

}
