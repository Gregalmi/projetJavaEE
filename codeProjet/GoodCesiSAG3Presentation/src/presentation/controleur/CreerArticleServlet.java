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

import entite.Article;
import entite.Categorie;
import entite.UConnecte;
import metier.Metier;
import metier.MetierItf;
import presentation.model.AccueilModel;
import presentation.model.CreerArticleModel;


@WebServlet("/CreerArticleServlet")
public class CreerArticleServlet extends HttpServlet {
	
	@EJB
	private MetierItf metier;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String login = (String) session.getAttribute("login");
		String urlVue = "/WEB-INF/CreerArticle.jsp";
		System.out.println("creation article");
		List<Categorie> categories = metier.lireTousCategories();
		String nomCat = categories.get(0).getNomCat();
		if(request.getParameter("ajouter") != null){
		System.out.println("Ajouter article");
		String nomArticle = request.getParameter("nomArticle");
		String description = request.getParameter("description");
		double prix =Double.parseDouble(request.getParameter("prix"));
		double fdp =Double.parseDouble(request.getParameter("fdp"));
		nomCat = request.getParameter("categorie");
		//Categorie categorie = metier.lireCategorie(nomCat);		
		//Article article = new Article(nomArticle, description, prix, fdp, categorie );		
		metier.creerArticleParVendeur(login, nomArticle, description, prix, fdp, nomCat); // LIRE LA SESSION POUR LE VENDEUR 
		System.out.println(metier.lireTousArticles());
		response.sendRedirect( request.getContextPath() + "/ArticleServlet");
		}
		CreerArticleModel model = new CreerArticleModel(); 
		model.setCategories(categories);
		model.setNomCat(nomCat);
		request.setAttribute("model", model);
		request.getRequestDispatcher(urlVue).forward(request, response);
		//doGet(request, response);
	}

}
