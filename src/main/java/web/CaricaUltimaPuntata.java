package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AstaDao;
import dao.PuntataDao;
import model.Puntata;

/**
 * Servlet implementation class CaricaUltimaPuntata
 */
public class CaricaUltimaPuntata extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int att = Integer.parseInt(request.getParameter("idAsta"));
		
		PuntataDao pDao = new PuntataDao();
		ArrayList<Puntata> pList = pDao.dammiPuntataAttuale(att);
		System.out.println(pList.get(0).getPuntata());
		
		
	}

}
