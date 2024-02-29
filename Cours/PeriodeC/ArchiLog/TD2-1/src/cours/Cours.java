package cours;

public class Cours {

	private final int nbPlacesMax, numeroCours;
	private final String intitule;
	private int nbInscrits;

	public Cours(int numeroCours, String intitule, int nbPlacesMax) {
		this.numeroCours = numeroCours;
		this.intitule = intitule;
		this.nbPlacesMax = nbPlacesMax;
		this.nbInscrits = 0;
	}

	public void inscription(int nbPlaces) throws PasAsseezDePlacesException, InterruptedException {
		synchronized (this) {
			if (nombrePlacesRestant() < nbPlaces)
				throw new PasAsseezDePlacesException(this, nbPlaces);
			Thread.sleep(2);
			nbInscrits += nbPlaces;
			System.out.println(nbPlaces + " inscriptions reussies au cours " + this);
		}		
	}

	private int nombrePlacesRestant() {
		synchronized (this) {
			return (this.nbPlacesMax - this.nbInscrits);
		}
	}

	@Override
	public String toString() {
		synchronized (this) {
			return String.valueOf(this.numeroCours) + " : " + intitule + " " + this.nombrePlacesRestant() + " places restants";	
		}

	}

}
