package ver2;
public class Convive implements Runnable {

	private static final int CAPACITE_VERRE = 10;
	private String nom;
	private Carafe carafe;
	private int tempsPourBoireSonVerre;

	public Convive(String nom, Carafe carafe, int tempsPourBoireSonVerre) {
		this.nom = nom;
		this.carafe = carafe;
		this.tempsPourBoireSonVerre = tempsPourBoireSonVerre;
		new Thread(this).start();
	}

	public void run() {
		System.out.println(nom + " commence a boire");
		try {
			while (true) {
				retirer();
				System.out.println(nom + " boit son verre");
				Thread.sleep(tempsPourBoireSonVerre);
			}
		} catch (InterruptedException e) {
			System.out.println(nom + " arrete de boire");
		}
	}

	private void retirer() throws InterruptedException {
		synchronized (carafe) {
			while(carafe.estVide()) {
				carafe.wait();
			}
			carafe.retirer(CAPACITE_VERRE);
		}
	}
}
