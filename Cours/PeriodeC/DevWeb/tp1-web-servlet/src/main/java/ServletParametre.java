import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletParametre extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletParametre() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
		String age = request.getParameter("age");

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		try {
			int ageInt = Integer.valueOf(age);
			String s = ageInt < 18 ? "mineur.e" : ageInt > 65 ? "âgé.e" : "majeur.e";
			out.println("<html><head><title>Bonjour</title></head>");
			out.println("<body><h2>Bonjour " + nom + ", vous avez " + age + " ans et vous êtes " + s + " !</h2></body></html>");
		}
		catch (Exception e) {
			out.println("<html><head><title>Erreur</title></head>");
			out.println("<body><h2>Paramètres manquants. Veuillez saisir le nom et l'âge.</h2></body></html>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
