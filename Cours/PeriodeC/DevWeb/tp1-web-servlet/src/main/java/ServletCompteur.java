

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class ServletCompteur
 */
public class ServletCompteur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int compteur;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCompteur() {
        super();
        this.compteur = 0;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// StringBuffer url = request.getRequestURL();
		PrintWriter out = response.getWriter();
		synchronized (this) {
			compteur++;
			out.println("Ceci est l'appel numero " + compteur);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
