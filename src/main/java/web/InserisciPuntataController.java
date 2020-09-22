package web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AstaDao;
import dao.MarcaDao;
import dao.PuntataDao;
import dao.RecensioneVenditoreDao;
import dao.VeicoloDao;
import model.Asta;
import model.Puntata;
import model.RecensioneVenditore;
import model.Veicolo;

/**
 * Servlet implementation class InserisciPuntataController
 */
public class InserisciPuntataController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recuperoIdPuntata
		
		int idAsta = Integer.parseInt(request.getParameter("idAsta"));
		double puntata = Double.parseDouble(request.getParameter("puntataUn"));
		
		//Controllo login!
		HttpSession session = request.getSession();
		String us = (String)session.getAttribute("email");
		
		if(us != null ) {
			//l'utente è loggato!
			//recupero dati
			Puntata p = new Puntata();
			p.setIdAsta(idAsta);
			p.setIdPersona(us);
			p.setPuntata(puntata);
			Date data = new Date();
			p.setOraPuntata(data);
			//effettua una puntata!
			
			PuntataDao pDao = new PuntataDao();
			if(pDao.inseriscoPuntata(p)) {
			request.setAttribute("state1", "Puntata inserita correttamente!");}
			else
			{request.setAttribute("state2", "Problemi con l'inserimento della puntata!");}
			
			/*-----------Prendo i dati per visualizzare l'annuncio------*/
			AstaDao aDao = new AstaDao();
			VeicoloDao vDao = new VeicoloDao();
			ArrayList<Asta> ad = aDao.cercaAstaById(idAsta);
			if(ad.size() > 0) {			
				Asta asta = ad.get(0);
				
				SimpleDateFormat formaterData = new SimpleDateFormat("dd/MM/YYYY");
				SimpleDateFormat formaterOra = new SimpleDateFormat("HH:mm");
				String dataVis = formaterData.format(asta.getDataFineAsta());
				String oraVis = formaterOra.format(asta.getDataFineAsta());
				
				System.out.println("Data: " + dataVis + " " + oraVis);
				
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


				//Puntata
				double punt = -1;
				
					AstaDao astaDao = new AstaDao();
					Asta asta1 = astaDao.dammiIdAstaPerVeicolo(veicolo.getIdVeicolo()).get(0);
					PuntataDao pDao1 = new PuntataDao();
					ArrayList<Puntata> puntata1 = pDao1.dammiPuntataAttuale(asta1.getId_asta());
					//se non ci sono puntate per quella data asta, puntata = basaAsta
					if(puntata1.size() <= 0) {
						punt = asta.getBaseAsta();}
					else {
						punt = puntata1.get(0).getPuntata();}
					
				request.setAttribute("dataFineAsta", dataVis);
				request.setAttribute("oraFineAsta", oraVis);
				
				request.setAttribute("pun", punt);
				request.setAttribute("asta", asta);
				request.setAttribute("model", modello);
				request.setAttribute("path", path);
				request.setAttribute("aste", asteV);
				request.setAttribute("idAsta", idAsta);
				
			}
				getServletContext().getRequestDispatcher("/product-page.jsp").forward(
	                request, response); 
				
			/*----------------------------------------------------------*/
		}
		else {
			//effettuare login,l'utente non è loggato!
			request.setAttribute("problem", "Prima di effettuare una puntata devi eseguire l'accesso!");
			getServletContext().getRequestDispatcher("/Login.jsp").forward(
	                request, response);
		}
			
	}

	}
