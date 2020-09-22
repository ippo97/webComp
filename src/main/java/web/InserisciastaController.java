package web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import dao.AstaDao;
import dao.VeicoloDao;
import model.Asta;
import model.Veicolo;

/**
 * Servlet implementation class InserisciastaController
 */
public class InserisciastaController extends HttpServlet {
	// location to store file uploaded
	private static final String UPLOAD_DIRECTORY = "imageAuto";

	// upload settings
	private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3; // 3MB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String us = (String) session.getAttribute("email");
		
		
		Asta asta = new Asta();
		int bAsta = 0;
		Date dat = null;
		// se sono loggato
		if (us != null) {
			System.err.println("Utente inserimento asta -->" + us);
			Veicolo v = new Veicolo();
			List<String> urlImage = new ArrayList<String>();
			/*
			 * =========================================================================
			 * CARICAMENTO IMMAGINE/CAMPI FORM
			 * =========================================================================
			 */
			// checks if the request actually contains upload file
			if (!ServletFileUpload.isMultipartContent(request)) {
				// if not, we stop here
				PrintWriter writer = response.getWriter();
				writer.println("Error: Form must has enctype=multipart/form-data.");
				writer.flush();
				return;
			}

			// configures upload settings
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// sets memory threshold - beyond which files are stored in disk
			factory.setSizeThreshold(MEMORY_THRESHOLD);
			// sets temporary location to store files
			factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

			ServletFileUpload upload = new ServletFileUpload(factory);

			// sets maximum size of upload file
			upload.setFileSizeMax(MAX_FILE_SIZE);

			// sets maximum size of request (include file + form data)
			upload.setSizeMax(MAX_REQUEST_SIZE);

			// constructs the directory path to store upload file
			// this path is relative to application's directory
			String uploadPath = getServletContext().getRealPath("") + UPLOAD_DIRECTORY;

			// creates the directory if it does not exist
			/*
			 * File uploadDir = new File(uploadPath); if (!uploadDir.exists()) {
			 * System.out.println("Ho creato la director nuovamente!"); uploadDir.mkdir(); }
			 */

			String ora = null;
			String te = null;

			try {
				// parses the request's content to extract file data
				List<FileItem> formItems = new ServletFileUpload(new DiskFileItemFactory())
						.parseRequest(new ServletRequestContext(request));

				if (formItems != null && formItems.size() > 0) {
					// iterates over form's fields
					for (FileItem item : formItems) {
						// processes only fields that are not form fields
						if (!item.isFormField()) {
							String fileName = new File(item.getName()).getName();
							urlImage.add(fileName);
							String filePath = uploadPath + File.separator + fileName;
							request.setAttribute("linkImage", "imageAuto\\" + fileName);
							File storeFile = new File(filePath);
							System.out.println(filePath);
							System.out.println("2 " + storeFile.getAbsolutePath());
							// saves the file on disk
							item.write(storeFile);

						} else {
							// PRENDO I DATI DELLA FORMA INERENTI AL VEICOLO CHE SI VUOLE INSERIRE
							String fieldname = item.getFieldName();
							String fieldvalue = item.getString();
							System.out.println(fieldname + " " + fieldvalue);

							if (fieldname.equals("Modelli")) {
								v.setIdModello(fieldvalue);
							} else if (fieldname.equals("descrizione")) {
								v.setDescrizione(fieldvalue);
							} else if (fieldname.equals("annoImmatr")) {
								v.setAnnoImmatricolazione(Integer.parseInt(fieldvalue));
							} else if (fieldname.equals("kmVeicolo")) {
								v.setKm(Integer.parseInt(fieldvalue));
							} else if (fieldname.equals("prezzo")) {
								v.setPrezzo(Integer.parseInt(fieldvalue));
							} else if (fieldname.equals("baseAsta")) {
								bAsta = Integer.parseInt(fieldvalue);
							} else if (fieldname.equals("data")) {
								
								te = fieldvalue;
								System.out.println("DATA1 " + te);
								//dat = new SimpleDateFormat("yyyy-mm-dd hh:mm").parse(fieldvalue);
								
							} else if (fieldname.contentEquals("mydatetime")) {
								ora = fieldvalue;
							}
						}

					}
				}
			} catch (Exception ex) {
				request.setAttribute("messageErr", "C'è stato un errore nel caricamento: " + ex.getMessage());
			}

			try {
				dat = new SimpleDateFormat("yyyy-MM-dd HH:mm",Locale.ITALIAN).parse(te + " " + ora);
				System.out.println("Date2 " + dat);
			} catch (Exception e) {
				System.out.println("problema data! " + e);
			}

			/*
			 * ===========================================================================
			 * FINE GESTIONE CARICAMENTO IMMAGINE/CAMPI FORM
			 * ==========================================================================
			 */

			/*
			 * ==========================================================================
			 * GESTIONE DEI DATI INSERIMENTO ANNUNCIO
			 * ==========================================================================
			 */
			int cont = 0;
			for (String a : urlImage) {
				if (cont == 0)
					v.setLinkUno(a);
				else if (cont == 1)
					v.setLinkDue(a);
				else if (cont == 2)
					v.setLinkTre(a);

				cont++;
			}

			// imposto la data in cui è sato inserito l'annuncio
			Date date = new Date();
			v.setDataInserimentoAnnuncio(date);

			// carico il valore della email
			v.setEmail(us);
			//imposto che è un'asta
			v.setAsta(true);
			
			// inserisco sul DB il veicolo
			VeicoloDao vDao = new VeicoloDao();
			int idAnnuncio = vDao.inserisciVeicolo(v);

			// inserisco sul DB l'asta
			if (idAnnuncio > 0) {
				asta.setId_venditore(us);
				asta.setId_veicolo(idAnnuncio);
				asta.setDataFineAsta(dat);	//|---------->possibile problema con la data
				asta.setBaseAsta(bAsta);
				AstaDao astaDao = new AstaDao();
				astaDao.inseriscoAsta(asta);
			}

			request.setAttribute("message", "Asta inserita correttamente!");
			// reindirizzamento ad annuncio completo
			getServletContext().getRequestDispatcher("/inseriscoAsta.jsp").forward(request, response);
		} else {

			request.setAttribute("problem", "Prima di inserire un asta devi prima eseguire l'accesso!!");
			getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);

		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("inseriscoAsta.jsp");
	}
}
