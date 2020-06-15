package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ModelloDao;
import model.Modello;

/**
 * Servlet implementation class DammiModelliController
 */
public class DammiModelliController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DammiModelliController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idMarca = request.getParameter("marche");
		List<Modello> mod = new ArrayList<Modello>();
		mod = new ModelloDao().findbyKey(idMarca);
		
		for (Modello c : mod) {
			response.getOutputStream().println("<option value=\"" + c.getIdModello() +"\">" + c.getIdModello() + "</option>");
		}
	}

	

}
