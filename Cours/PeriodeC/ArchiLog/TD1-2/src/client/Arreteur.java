package client;

import java.io.IOException;

public class Arreteur implements Runnable{
	private Compteur compte;
	
	public Arreteur(Compteur c) {
		this.compte = c;
	}

	public void lancer() {
		new Thread(this).start();
	}

	@Override
	public void run() {
		try {
			System.in.read();
		} catch (IOException e) {
			// rien
		}
		finally {
			arreterCompteur();
		}
	}
	
	public void arreterCompteur() {
        compte.setFin(true);
    }

}
