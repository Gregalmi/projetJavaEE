package presentation.controleur;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entite.Categorie;
import entite.UConnecte;
import entite.Utilisateur;
import metier.Metier;
import metier.MetierItf;
import presentation.model.ModelCategorie;



@WebServlet("/CategorieServlet")
public class CategorieServlet extends HttpServlet {
	//private static final long serialVersionUID = 1L;

	@EJB
	private MetierItf metier; 
	
    public CategorieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("CategorieServlet doGet");
		doPost(request,response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("CategorieServlet doPost");
		String urlVue = "/WEB-INF/categorie.jsp";
		
		
		if(request.getParameter("nomCategorie") != null){
			String nomCategorie = request.getParameter("nomCategorie");  
			Categorie categorie = new Categorie (nomCategorie);
			metier.creerCategorie(categorie);
			System.out.println("Création d'une Catégorie" + categorie);
		}
		
		ModelCategorie model = new ModelCategorie();
		List<Categorie> categories = metier.lireTousCategories();
		System.out.println(categories);
		model.setCategories(categories);
		request.setAttribute("model", model);
		request.getRequestDispatcher(urlVue).forward(request, response);
	}

}
