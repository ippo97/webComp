package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AstaDao;
import dao.VeicoloDao;
import model.Asta;
import model.Veicolo;

/**
 * Servlet implementation class indexAstaController
 */
public class indexAstaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public indexAstaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AstaDao aDao = new AstaDao();
		ArrayList<Asta> asteV = aDao.dammiAstePerVisualizzare();
		ArrayList<String> modello = new ArrayList<String>();
		ArrayList<String> path = new ArrayList<String>();
		
		VeicoloDao vDao = new VeicoloDao();
		for(Asta ast : asteV) {
			Veicolo v = vDao.findById(ast.getId_veicolo()).get(0);
			path.add(v.getLinkUno());
			modello.add(v.getIdModello() + " Anno: " + v.getAnnoImmatricolazione());
		}
		
		
		request.setAttribute("model", modello);
		request.setAttribute("path", path);
		request.setAttribute("aste", asteV);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		

	}

	

}
