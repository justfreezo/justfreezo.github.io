import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.Buffer;
import java.util.Scanner;

public class Client {
	
	public static void main(String[] args) {
		int port = 1234;
		try {
			Socket socketClient = new Socket("localhost",port);
			System.out.println("Connecté au serveur " +  socketClient.getLocalAddress() + " port " + port);
			
			PrintWriter output = new PrintWriter(socketClient.getOutputStream(),true); // Permet d'envoyer
            Scanner sc = new Scanner(System.in);
            System.out.print("Tapez une chaine de caractères\n > ");
            
            output.println(sc.nextLine()); // Le message à envoyer au serveur
            System.out.println("Votre chaîne inversée");
            BufferedReader br = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
            System.out.println(br.readLine());
		} catch (IOException e) {
			System.out.println("Erreur client");
		}
	}
}