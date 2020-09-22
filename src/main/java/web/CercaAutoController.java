package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VeicoloDao;
import model.Veicolo;

/**
 * Servlet implementation class CercaAutoController
 */
public class CercaAutoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String modello = request.getParameter("Modelli");
		int prezzoMax = Integer.parseInt(request.getParameter("PrezzoMax")); 
		//int anno = Integer.parseInt(request.getParameter("annoImmatr"));
		
		VeicoloDao vDao = new VeicoloDao();
		List<Veicolo> veicoli = new ArrayList<Veicolo>();
		veicoli = vDao.crecaByModelloMarcaPrezzo(modello, prezzoMax);
		
		request.setAttribute("annunci", veicoli);
		
		if(veicoli.size() > 0)
			getServletContext().getRequestDispatcher("/products.jsp").forward(
                request, response);
		else
			getServletContext().getRequestDispatcher("/NotFound.jsp").forward(
	                request, response);
	}

}
