package presentation.controleur;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entite.Commande;
import entite.UConnecte;
import metier.Metier;
import metier.MetierItf;
import presentation.model.ModelAchat;


@WebServlet("/AchatServlet")
public class AchatServlet extends HttpServlet {
	//private static final long serialVersionUID = 1L;
    
	
	@EJB
	private MetierItf metier;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AchatServlet doGet");
		//String urlVue = "achats.jsp";
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AchatServlet doPost");
		String urlVue = "/WEB-INF/achat.jsp";
		//RECUP DU LONG PAR LA SESSION
		HttpSession session = request.getSession();
		String login = (String) session.getAttribute("login");
		
		
		List<Commande> listeAchat = metier.lireTousAchats(login);	
		System.out.println(listeAchat);
		
		ModelAchat model = new ModelAchat(); 
		model.setListeAchats(listeAchat);
		request.setAttribute("model", model);
		request.getRequestDispatcher(urlVue).forward(request, response);
	}

}
