package incrementeur;
public final class Incrementeur implements Runnable {

	private Compteur cpt;
	private String name;

	public Incrementeur(String name, Compteur c) {
		this.name = name;
		this.cpt = c;
	}
	public String getName() {
		return name;
	}

	public int getValeur() {
		return cpt.getValue();
	}

	public void run() {
		for (int i = 1; i <= 10; i++) {
			synchronized(cpt){
				int c = cpt.getValue();
				System.out.println("valeur a incrementer (round " + i + ") : " 
						+ c + " par " + getName());
				cpt.incrementer();
				System.out.println("valeur calculee (round " + i + ") par " + getName() 
						+ " est : " + cpt.getValue());
			}
		}
	}	
}