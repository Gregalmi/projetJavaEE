package presentation.controleur;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entite.UConnecte;
import entite.Utilisateur;
import metier.Metier;
import metier.MetierItf;
import presentation.model.ModelInscription;


@WebServlet("/InscriptionServlet")
public class InscriptionServlet extends HttpServlet {
	//private static final long serialVersionUID = 1L;
	
	@EJB
	private MetierItf metier; 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("InscriptionServlet doGet");
		//String urlVue = "achats.jsp";
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("InscriptionServlet doPost");
		String urlVue = "inscription.jsp";
		
		if(request.getParameter("login") != null){
			String login = request.getParameter("login");  
			String password = request.getParameter("password");
			UConnecte uconnecte = new UConnecte(login,password);
			metier.creerUConnecte(uconnecte);
			System.out.println(uconnecte);
			response.sendRedirect( request.getContextPath() + "/ConnexionServlet");
		}
		
		//Ajouter des structures de control pour 
		// 1/ Vérifier que le login n'est pas déjà existant en BDD
		// 2/ Vérifier que les 2 champs sont bien remplis
		
		ModelInscription model = new ModelInscription();
	//	List<Utilisateur> uconnectes = metier.lireTousUtilisateurs();
	//	System.out.println(uconnectes);
	//	model.setUtilisateurs(uconnectes);
		request.setAttribute("model", model);
		request.getRequestDispatcher(urlVue).forward(request, response);
	}

}
