package presentation.controleur;

import java.io.IOException;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entite.Administrateur;
import entite.Role;
import entite.UConnecte;
import entite.Utilisateur;
import metier.Metier;
import metier.MetierItf;


@WebServlet("/ConnexionServlet")
public class ConnexionServlet extends HttpServlet {
	public static final String ATTRIBUT_LOGIN        = "login";
    public static final String ATTRIBUT_ERREUR_MSG   = "msgErreur";
    public static final String URL_VUE_CONNEXION     = "connexion.jsp";
    public static final String URL_ADMIN  			 = "CategorieServlet";
    public static final String URL_UCONNECTE		 = "AccueilServlet";
	private String erreurMsg;
	
	@EJB
	private MetierItf metier;
	
	public ConnexionServlet() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ConnexionServlet - doGet");
		request.getRequestDispatcher(URL_VUE_CONNEXION).forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ConnexionServlet - doPost 3");
		
	     String login = request.getParameter("login");
	     String password = request.getParameter("password");
	     
	     Utilisateur utilisateur = null;
	     System.out.println(utilisateur);
	     try {
	    	 utilisateur = connecterUtilisateur(login, password);
	    	 System.out.println(utilisateur);
	     }
	     catch(Exception e) {
	    	 erreurMsg = "L'utilisateur saisi n'existe pas";
	    	 utilisateur = null;
	    	 System.out.println("Utilisateur inconnu");
	     }
	     System.out.println("ConnexionServlet utilisateur="+ utilisateur); 
	     HttpSession session = request.getSession();
	       
	     if(utilisateur!=null) {
	     	session.setAttribute(ATTRIBUT_LOGIN, utilisateur.getLogin());
	     	session.setAttribute("role", utilisateur.getRole());
	     	
	     }
	     else {
	     	request.setAttribute(ATTRIBUT_ERREUR_MSG,erreurMsg);
	     	session.setAttribute("ATTRIBUT_USER",null);
	     }
	     
	     if(utilisateur instanceof Administrateur) {
	    	 System.out.println("Administrateur");
	    	 request.getRequestDispatcher(URL_ADMIN).forward(request, response);  
	     }
	     else if(utilisateur instanceof UConnecte) {
	    	 System.out.println("UtilisateurConnecte");
	     	 request.getRequestDispatcher(URL_UCONNECTE).forward(request, response); 
	     }
	     else {
	    	 System.out.println("utilisateur inconnu");
	    	 request.getRequestDispatcher(URL_VUE_CONNEXION).forward(request, response); 
	     }
	     
	 }

	private Utilisateur connecterUtilisateur(String login,String password) {
	    Utilisateur utilisateur = metier.connexionUtilisateur(login,password);
        if(utilisateur==null)
	       	erreurMsg = "L'utilisateur " + login + " - " + password + ", n'a pas de compte associé.";   
	     return utilisateur;
	}
	 
}


