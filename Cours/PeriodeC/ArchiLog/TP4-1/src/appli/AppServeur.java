package appli;

import java.io.IOException;

import serveur.Serveur;

public class AppServeur {
	private final static int PORT = 1234;

	public static void main(String[] args) {
		try {
			new Thread(new Serveur(ServiceInversion.class, PORT)).start();
		} catch (IOException e) {
				System.err.println("Pb lors de la creation du serveur : " +  e);			
		}
	}
}
