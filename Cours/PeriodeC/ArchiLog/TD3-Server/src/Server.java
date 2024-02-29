import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
	private static int cpt;
	
	public static void main(String[] args) throws IOException {
		int numPort = 1234;
		cpt = 0;
		ServerSocket serveur = new ServerSocket(numPort); // On démarre le serveur
		System.out.println("Serveur lancé sur le port " + numPort);
		
		while (true) {
			Socket socketServ = serveur.accept(); // On accepte un client
			++cpt;
			System.out.println("Connexion " + cpt + " démarrée");
			
			ServiceInversion service = new ServiceInversion(socketServ);
			PrintWriter pw = new PrintWriter(socketServ.getOutputStream());
			service.inversion();
			
			System.out.println("Connexion " + cpt + " terminée");
		}
	}
	
	public static int getCpt() {
		return cpt;
	}
}