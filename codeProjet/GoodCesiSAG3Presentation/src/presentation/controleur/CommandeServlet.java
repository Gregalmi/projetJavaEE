package presentation.controleur;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entite.Article;
import entite.Commande;
import entite.UConnecte;
import metier.Metier;
import metier.MetierItf;
import presentation.model.ModelCategorie;
import presentation.model.ModelCommande;

@WebServlet("/CommandeServlet")
public class CommandeServlet extends HttpServlet {
	
	@EJB
	private MetierItf metier;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String urlVue= "/WEB-INF/commande.jsp";
		HttpSession session = request.getSession();
		String erreurMsg;
		
		if(request.getParameter("idarticle") != null) {
			request.getSession().setAttribute("idarticle",request.getParameter("idarticle"));
		}

		if(request.getParameter("payer") != null) {
			System.out.println("paiement");	
			String num = request.getParameter("numCarte");
			if(metier.validationCommande(num)) {
				System.out.println("commande valide");
				Long id = Long.parseLong((String)session.getAttribute("idarticle"));
				System.out.println(id);
				String login = (String) session.getAttribute("login");
				UConnecte acheteur = (UConnecte) metier.lireUtilisateur(login);
				System.out.println(acheteur);
				metier.creerCommande(login, id);
				response.sendRedirect( request.getContextPath() + "/AccueilServlet");
			} else {
				System.out.println("veuillez entrer un numero à 10 chiffres");
				erreurMsg = "veuillez entrer un numero à 10 chiffres";
				request.setAttribute("msgErreur", erreurMsg);		
			}
		}
		
	/*	ModelCommande model = new ModelCommande();
		model.setArticle();
		request.setAttribute("model", model);*/
		request.getRequestDispatcher(urlVue).forward(request, response);
		
	}

}
