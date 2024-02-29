package ver1;

public class Carafe {

	private static int capacite_STANDARD = 100;
	private int quantite;
	private final int capacite;

	public Carafe(int capacite) {
		this.quantite = 0;
		this.capacite = capacite;
	}

	public Carafe() {
		this(capacite_STANDARD);
	}

	public synchronized void remplir() {
		quantite = capacite;
		this.notifyAll();
	}

	public synchronized void retirer(int q) throws InterruptedException {
		while(q > quantite) {
			this.wait();
		}
		quantite -= q;
		if (quantite <= 0) {
			quantite = 0;
		}
	}

	public boolean estVide() {
		return quantite == 0;
	}

	@Override
	public String toString() {
		return "La carafe contient " + quantite + "cl";
	}
}
