import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServiceInversion {
	private Socket maSocket;
	
	public ServiceInversion(Socket s) {
		this.maSocket = s;
	}
	
	public void inversion() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(maSocket.getInputStream())); // Permet de lire
		StringBuffer msg = new StringBuffer(input.readLine()); // Le message envoyé par le client
		
		System.out.println("Connexion " + Server.getCpt() + " a recu " + msg);
	}
}
