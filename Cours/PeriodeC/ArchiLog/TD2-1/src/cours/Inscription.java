package cours;

public class Inscription implements Runnable {

	private Cours cours;
	private int nbPlaces;

	public Inscription(Cours cours, int nbPlaces) {
		this.cours = cours;
		this.nbPlaces = nbPlaces;
	}

	public void run() {
		synchronized (cours) {
			try {
				cours.inscription(nbPlaces);
			} catch (PasAsseezDePlacesException e) {
				System.out.println(e);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
