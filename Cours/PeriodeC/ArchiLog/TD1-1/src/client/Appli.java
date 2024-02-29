// Appli.java
package client;

import voiture.Voiture;
import voiture.Usine;
import static voiture.Usine.Version;

import voiture.TestMoteur;

public class Appli {

  public static int testMoteur(Voiture v) {
	  int cpt = 0;

	  try {
		  v.setVitesse(0);
		  while (v.getVitesse() < v.getVitesseMaximale()) {
			  v.accelerer();
		      System.out.println(v + " accelere");
		      ++cpt;
		    }
		  while (v.getVitesse() > 0){
			  if(Math.floor(Math.random() * 50 + 1) > 48) {
				  throw new Exception();
			  }
			  v.freiner();
		      System.out.println(v + " freine");  
		  }
	  }
	  catch(Exception e){
		  System.out.println("Le test de freinage de la voiture " + v + " a échoué");
	  }
	  return cpt;
  }

  public static void main(String[] args) {
    Voiture[] tab = { 
        Usine.construit("607", Version.STANDARD),
        Usine.construit("Clio", Version.POPULAIRE),
        Usine.construit("Clio sport", Version.SUICIDAIRE), 
    };
    
    for (Voiture v : tab) {
      new Thread(new TestMoteur(v)).start();
    }
  }
}
