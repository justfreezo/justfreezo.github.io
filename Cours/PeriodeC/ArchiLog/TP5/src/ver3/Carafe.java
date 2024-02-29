package ver3;

public interface Carafe {

	void remplir();

	void retirer(int q) throws InterruptedException;

	boolean estVide();

}