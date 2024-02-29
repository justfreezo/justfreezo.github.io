package serveur;

import java.net.Socket;

public abstract class Service implements Runnable{
	private Socket client;
	
	public Service(Socket socket) {
		this.client = socket;
	}
	
	public Service() {
		this.client = null;
	}

	public void setSocket(Socket s) {
		client = s;
	}

	public Socket getClient() {
		return client;
	}

}
