package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PersonaDao;
import model.Persona;

/**
 * Servlet implementation class InserisciPersonaController
 */
public class InserisciPersonaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*Preparazione de dati provenienti dalla form */
		String email = request.getParameter("email");
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String password =request.getParameter("password");
		
		email.toLowerCase();
		nome.toLowerCase();
		cognome.toLowerCase();
		

		Persona p1= new Persona();
		
		
		p1 = new Persona(email, nome, cognome, password);

		/*Inseriamo dati nel database se è aggiungo un parametro per lo stato prima di reindirizzasre*/
		
		PersonaDao pDao = new PersonaDao();		
		boolean state = pDao.inseriscoNuonoUtente(p1);
		/*Aggiungo atributo per visualizzare se tutto è andato a buon fine*/
		String message1 = null;
		String message2 = null;
		if(state) {
			message1 = "Utente inserito correttamente!";
			request.setAttribute("statoInserimentoTrue", message1);}
		else {
			message2 = "Problemi con l'inserimento dell'utente!";
			request.setAttribute("statoInserimentoFalse", message2);}
		
		
		request.getRequestDispatcher("SignIn.jsp").forward(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("SignIn.jsp");
	}


}
