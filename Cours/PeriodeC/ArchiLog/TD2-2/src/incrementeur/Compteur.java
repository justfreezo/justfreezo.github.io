package incrementeur;

public class Compteur {
	private int cpt = 1;

	public void incrementer() {
		cpt++;
	}
	
	public int getValue() {
		return cpt;
	}

	public void decrementer() {
		cpt--;
	}
	
}
