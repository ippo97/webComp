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
			
			//gestione della data
			SimpleDateFormat formaterData = new SimpleDateFormat("dd/MM/YYYY");
			SimpleDateFormat formaterOra = new SimpleDateFormat("HH:mm");
			String dataVis = formaterData.format(asta.getDataFineAsta());
			String oraVis = formaterOra.format(asta.getDataFineAsta());
			
			List<Veicolo> veico = vDao.findById(asta.getId_veicolo());
			Veicolo veicolo = veico.get(0);
			
			
			Date controlloAstaScaduta = new Date();
			
			//System.out.println("controllo dataAsta: "+ asta.getDataFineAsta()+ controlloAstaScaduta + (controlloAstaScaduta.before(asta.getDataFineAsta())));
			//System.out.println(asta.getUtenteVincitore());
			//controllo se l'asta è scaduta
			if(controlloAstaScaduta.after(asta.getDataFineAsta())) {
				//cerco venditore se non è presente ed considero l'asta conclusa!
				if(asta.getUtenteVincitore() == null) {
					AstaDao astaDao = new AstaDao();
					Asta asta1 = astaDao.dammiIdAstaPerVeicolo(veicolo.getIdVeicolo()).get(0);
					PuntataDao pDao = new PuntataDao();
					ArrayList<Puntata> puntata = pDao.dammiPuntataAttuale(asta1.getId_asta());
					System.out.println("Controllo 1: " + astaDao.dammiIdAstaPerVeicolo(veicolo.getIdVeicolo()).size());
					System.out.println("controllo 2: " + puntata.size());
					//se non ci sono puntate per quella data asta, puntata = basaAsta
					if(puntata.size() <= 0) {
						System.out.println("Asta conclusa senza offeerte!");
						//asta conclusa senza offerte
						String senzaOpperte = "Asta conclusa senza offerte!";
						request.setAttribute("senzaOf", senzaOpperte);
						request.setAttribute("vincAsta", "Non sono state effettuate puntate!");
					}
					else {
						//inseire vincitore asta
						astaDao.inserisciVincitoreAsta(puntata.get(0).getIdAsta(), puntata.get(0).getIdPersona(),(int)puntata.get(0).getPuntata());
						request.setAttribute("vincAsta", puntata.get(0).getIdPersona());
						//invio mail al vincitore
						String RECIPIENT = puntata.get(0).getIdPersona();
						String[] to = { RECIPIENT };
						String body ="Benvenuto in C-SHOP! Risulti vincitore di questa asta: http://localhost:8080/SitoConTemplateNuovo/CaricaAstaController?idAsta=" + puntata.get(0).getIdAsta();
						String sub = "Decretato vincitore asta su C-SHOP!";
						InviaMailTest.sendFromGMail(to, sub, body);
						System.out.println("Email vittoria inviata");
					}
				}
				else {
					request.setAttribute("vincAsta", asta.getUtenteVincitore());
					
				}
				
			}
			
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
			PuntataDao pDao = new PuntataDao();
			ArrayList<Puntata> puntata = pDao.dammiPuntataAttuale(asta1.getId_asta());
			//se non ci sono puntate per quella data asta, puntata = basaAsta
			if(puntata.size() <= 0) {
				punt = asta.getBaseAsta();}
			else {
				punt = puntata.get(0).getPuntata();
				}
				
			request.setAttribute("dataFineAsta", dataVis);
			request.setAttribute("oraFineAsta", oraVis);
			
			request.setAttribute("pun", punt);
			request.setAttribute("asta", asta);
			request.setAttribute("model", modello);
			request.setAttribute("path", path);
			request.setAttribute("aste", asteV);
			request.setAttribute("idAsta", idAsta);
			
			
			getServletContext().getRequestDispatcher("/product-page.jsp").forward(
                request, response); 
		
	 	
	 	
	 	}
		else
		{
			getServletContext().getRequestDispatcher("/NotFound.jsp").forward(
	                request, response);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
