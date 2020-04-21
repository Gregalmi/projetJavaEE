package presentation.controleur;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entite.Commande;
import entite.EtatCommande;
import metier.Metier;
import metier.MetierItf;
import presentation.model.ModelAchat;
import presentation.model.ModelVente;


@WebServlet("/VenteServlet")
public class VenteServlet extends HttpServlet {
	
	@EJB
	private MetierItf metier;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("VenteServlet doPost");
		String urlVue = "/WEB-INF/vente.jsp";	
		//String etatCommande;
		//List<EtatCommande> etatCommandes = Arrays.asList(EtatCommande.values());
		//System.out.println(listeVente);
		//model.setEtatCommandes(etatCommandes);
		/*if(request.getParameter("etatCommande") != null) {
			etatCommande = request.getParameter("etatCommande");
			Commande commande = metier.lireCommande(id);
			commande.setEtatCommande(etatCommande);
		}*/
		if(request.getParameter("encours") != null ) {
			Long id = Long.valueOf(request.getParameter("encours"));
			metier.statutEncoursCommande(id);
		}
		if(request.getParameter("valide") != null ) {
			Long id = Long.valueOf(request.getParameter("valide"));
			metier.statutValideCommande(id);					
		}
		if(request.getParameter("envoye") != null ) {
			Long id = Long.valueOf(request.getParameter("envoye"));
			metier.statutEnvoyeCommande(id);			
		}
		//RECUP DU LONG PAR LA SESSION
		HttpSession session = request.getSession();
		String login = (String) session.getAttribute("login");
		List<Commande> listeVente = metier.lireTousVenteEnCours(login);
		ModelVente model = new ModelVente(); 
		model.setListeVentes(listeVente);
		request.setAttribute("model", model);
		System.out.println(model.getEtatCommandes());
		request.getRequestDispatcher(urlVue).forward(request, response);
		//doGet(request, response);
	}

}
