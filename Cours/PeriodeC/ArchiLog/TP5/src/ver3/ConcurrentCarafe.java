package ver3;

public class ConcurrentCarafe implements Carafe {
	private Carafe carafe;
	
	public ConcurrentCarafe() {
		this.carafe = new SimpleCarafe();
	}

	@Override
	public synchronized void remplir() {
		carafe.remplir();
		this.notifyAll();
	}

	@Override
	public synchronized void retirer(int q) throws InterruptedException {
		while(carafe.estVide()) {
			this.wait();
		}
		carafe.retirer(q);
	}

	@Override
	public boolean estVide() {
		return carafe.estVide();
	}

}
