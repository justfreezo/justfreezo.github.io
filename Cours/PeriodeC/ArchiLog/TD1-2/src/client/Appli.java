package client;

public class Appli {
	public static void main(String[] args) {
		Compteur compte = new Compteur();
		compte.lancer(); // lancement du compteur
		new Arreteur(compte).lancer(); // lancement de l'arreteur du compteur
	}
}
