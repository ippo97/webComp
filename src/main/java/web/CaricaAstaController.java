package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AstaDao;
import dao.MarcaDao;
import dao.RecensioneVenditoreDao;
import dao.VeicoloDao;
import model.Asta;
import model.RecensioneVenditore;
import model.Veicolo;

/**
 * Servlet implementation class CaricaAstaController
 */
public class CaricaAstaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idAsta =Integer.parseInt(request.getParameter("idAsta"));
		AstaDao aDao = new AstaDao();
		VeicoloDao vDao = new VeicoloDao();
		ArrayList<Asta> ad = aDao.cercaAstaById(idAsta);
		
	 	if(ad.size() > 0) {			
			Asta asta = ad.get(0);
			List<Veicolo> veico = vDao.findById(asta.getId_veicolo());
			Veicolo veicolo = veico.get(0);
			RecensioneVenditoreDao rDao = new RecensioneVenditoreDao();
			
			
			
			
			//recensione venditore
			List<RecensioneVenditore> rece = rDao.dammiRecensioneVenditore(veicolo.getEmail());
			request.setAttribute("recensioni", rece);
			//marca veicolo
			MarcaDao m = new MarcaDao();
			request.setAttribute("marca", m.trovaMarca(veicolo.getIdModello()));
			//veicolo
			request.setAttribute("veicolo", veicolo);
			//Asta
			ArrayList<Asta> asteV = aDao.dammiAstePerVisualizzare();
			ArrayList<String> modello = new ArrayList<String>();
			ArrayList<String> path = new ArrayList<String>();
			
			for(Asta ast : asteV) {
				Veicolo v1 = vDao.findById(ast.getId_veicolo()).get(0);
				path.add(v1.getLinkUno());
				modello.add(v1.getIdModello() + " Anno: " + v1.getAnnoImmatricolazione());
			}
			
			request.setAttribute("asta", asta);
			request.setAttribute("model", modello);
			request.setAttribute("path", path);
			request.setAttribute("aste", asteV);
			
			
			
			getServletContext().getRequestDispatcher("/product-page.jsp").forward(
                request, response); 
		
	 	
	 	
	 	}
		else
		{
			getServletContext().getRequestDispatcher("/NotFound.jsp").forward(
	                request, response);
		}
	}
}
