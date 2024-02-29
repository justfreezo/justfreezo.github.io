package client;

public class Compteur implements Runnable{
	// private boolean fin;
	private Thread t;
	
	public Compteur() {
		// this.fin = false;
	}
	
	public void lancer() {
		t = new Thread(this);
		t.start();
	}

	@Override
	public void run() {
		int cpt = 0;
		while(!t.isInterrupted()) {
			System.out.println(cpt++);
		}
	}
	
	public void setFin(boolean fin) {
		//this.fin = fin;
		t.interrupt();
	}

}
