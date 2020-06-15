package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogOutController
 */
public class LogOutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession oldSession = req.getSession(false);
		if (oldSession != null) {
			oldSession.invalidate(); // invalida la sessione se esiste
		}
		resp.sendRedirect("index.jsp");
	}

}
