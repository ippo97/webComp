package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.MarcaDao;
import model.Marca;

/**
 * Servlet implementation class DammiMarche
 */
public class DammiMarche extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DammiMarche() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Marca> marc = new ArrayList<Marca>();
		MarcaDao marche = new MarcaDao();
		marc = marche.findAll();
		
		for (Marca c : marc) {
			response.getOutputStream().println("<option value=\"" + c.getIdMarca() +"\">" + c.getIdMarca() + "</option>");
		}
		
		
		
		
	}
}
