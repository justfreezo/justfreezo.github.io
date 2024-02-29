package voiture;

import client.Appli;

public class TestMoteur implements Runnable{
	private Voiture voiture;
	
	public TestMoteur(Voiture v) {
		this.voiture = v;
	}
	
	public void run() {
		int nb = Appli.testMoteur(voiture);
		System.out.println(voiture + " nb d'accelerations -> " + nb);
	}
}
