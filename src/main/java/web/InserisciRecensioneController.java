package web;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RecensioneVenditoreDao;
import model.RecensioneVenditore;

/**
 * Servlet implementation class InserisciRecensioneController
 */
public class InserisciRecensioneController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nom");
		String email = request.getParameter("emai");
		String rec = request.getParameter("recens");
		String venditore = request.getParameter("vendit");
		String stelle = request.getParameter("stel");
		Date date = new Date();
		System.out.println(rec);
		
		RecensioneVenditore r = new RecensioneVenditore();
		r.setData(date);
		r.setEmailRecensitore(email);
		r.setEmailVenditore(venditore);
		r.setTesto(rec);
		r.setStelle(Integer.parseInt(stelle));
		r.setNomeRevensitore(nome);
		System.out.println(r.toString() +" " + stelle);
		RecensioneVenditoreDao rDao = new RecensioneVenditoreDao();
		
		if(rDao.inseriscoRecensione(r)) {
			response.getOutputStream().println("Succes!");
		}else
		{
			response.getOutputStream().println("Problem!");
		}
		
	}

}
