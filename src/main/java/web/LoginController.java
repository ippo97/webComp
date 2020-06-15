package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import dao.PersonaDao;
import model.Persona;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String paramEmail = request.getParameter("email");
		String paramPassword = request.getParameter("password");

		System.out.println(paramEmail + " " + paramPassword);

		PersonaDao pDao = new PersonaDao();
		List<Persona> utenti = new ArrayList<Persona>();
		utenti = pDao.findById(paramEmail);

		System.out.println(utenti.toString() + "size" + utenti.size());

		// se l'autenticazione va a buon fine
		if (utenti.size() != 0 && paramEmail.equals(utenti.get(0).getEmail())
				&& paramPassword.equals(utenti.get(0).getPassword())) {

			// controlllo se era presente gia un'altra sessione
			HttpSession oldSession = request.getSession(false);
			if (oldSession != null) {
				oldSession.invalidate(); // invalida la sessione se esiste
			}
			// creo una nuova sessione
			HttpSession currentSession = request.getSession();
			currentSession.setAttribute("email", paramEmail);
			currentSession.setMaxInactiveInterval(10 * 60);

			request.getRequestDispatcher("index.jsp").forward(request, response);

		} else {
			// se l'autenticazione fallisce
			response.sendRedirect("Login.jsp");
		}

	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("Login.jsp");
	}
	


}
