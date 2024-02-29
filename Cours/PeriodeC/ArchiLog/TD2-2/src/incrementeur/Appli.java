package incrementeur;

public class Appli {
	public static void main(String args[]) throws InterruptedException {
	    Compteur c = new Compteur();
	    System.out.println("VALEUR " + c.getValue());
	    
	    Thread t1 = new Thread(new Incrementeur("Thread1", c));
	    t1.start();
	    Thread t2 = new Thread(new Incrementeur("Thread2", c));
	    t2.start();
	    Thread t3 = new Thread(new Decrementeur("Thread3", c));
	    t3.start();
	    Thread t4 = new Thread(new Decrementeur("Thread4", c));
	    t4.start();
	    
	    t1.join();
	    t2.join();
	    t3.join();
	    t4.join();
	    
	    System.out.println("VALEUR FINALE " + c.getValue());
	  }
}
