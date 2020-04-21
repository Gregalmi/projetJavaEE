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
import entite.EtatArticle;
import metier.Metier;
import metier.MetierItf;
import presentation.model.ModelArticle;

@WebServlet("/ArticleServlet")
public class ArticleServlet extends HttpServlet {
	public static final String ATTRIBUT_ERREUR_MSG   = "msgErreur";
	private String erreurMsg;
	
	@EJB
	private MetierItf metier;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String urlVue = "/WEB-INF/article.jsp";
		
		System.out.println("Mes articles en ventes");
		//RAJout
		HttpSession session = request.getSession();
		String login = (String) session.getAttribute("login");
		if(request.getParameter("supprimer") != null) {
			System.out.println("suppression");
			Long id = Long.parseLong(request.getParameter("supprimer"));
			System.out.println("supprimer id=" + id);
			Article article = metier.lireArticle(id);
			if(article.getEtatArticle() == EtatArticle.RESERVE ) {
				erreurMsg =  "Vous ne pouvez pas supprimer un article déjà commandé.";
				request.setAttribute(ATTRIBUT_ERREUR_MSG,erreurMsg);
			} else if(article.getEtatArticle() == EtatArticle.VENDU ){
			metier.supprimerArticle(login, id);
			} else {
				metier.supprimerArticleNC(login, id);
			}
		}
		if(request.getParameter("creer") != null) {
			response.sendRedirect( request.getContextPath() + "/CreerArticleServlet");
			//request.getRequestDispatcher("CreerArticle.jsp").forward(request, response); 
		}
		
		List<Article> articles = metier.lireTousArticleVendeur(login);
		System.out.println("articles" + articles);
		ModelArticle model = new ModelArticle();
		model.setArticles(articles);
		request.setAttribute("model", model);
		request.getRequestDispatcher(urlVue).forward(request, response);
		//doGet(request, response);
	}

}
