package presentation.controleur;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entite.Article;
import entite.Categorie;
import metier.Metier;
import metier.MetierItf;
import presentation.model.AccueilModel;


@WebServlet("/AccueilServlet")
public class AccueilServlet extends HttpServlet {
	
	@EJB
	private MetierItf metier;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String urlVue = "Accueil.jsp";
		System.out.println("Accueil");
		List<Article> articles = metier.lireTousArticles();
		//List<Categorie> categories = metier.lireTousCategories();
		//String nomCat = categories.get(0).getNomCat();
		//List<Article> articlesparcat = metier.lireTousArticleCategorie(nomCat);
		/*if(request.getParameter("categorie") != null){
			System.out.println("Action select");
			nomCat = request.getParameter("categorie");
			articlesparcat = metier.lireTousArticleCategorie(nomCat);
		}*/
		//il faut lire tousarticlesparcat();
		AccueilModel model = new AccueilModel(); 
		model.setArticles(articles);
		//model.setCategories(categories);
		//model.setNomCat(nomCat);
		request.setAttribute("model", model);
		request.getRequestDispatcher(urlVue).forward(request, response);
		//doGet(request, response);
	}

}
