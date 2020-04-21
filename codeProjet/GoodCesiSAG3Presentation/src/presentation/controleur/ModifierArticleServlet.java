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

import entite.Categorie;
import metier.MetierItf;
import presentation.model.CreerArticleModel;
import presentation.model.ModelModifierArticle;


@WebServlet("/ModifierArticleServlet")
public class ModifierArticleServlet extends HttpServlet {

	@EJB
	private MetierItf metier;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String login = (String) session.getAttribute("login");
		String urlVue = "/WEB-INF/modifierArticle.jsp";
		List<Categorie> categories = metier.lireTousCategories();
		String nomCat = categories.get(0).getNomCat();
		if(request.getParameter("modifier") != null) {
			session.setAttribute("idart", request.getParameter("modifier"));
			System.out.println(session.getAttribute("idart"));
		}
		if(request.getParameter("mettreajour") != null){
			System.out.println(request.getAttribute("idart"));
			System.out.println("Modifier article");
			Long id = Long.parseLong((String)session.getAttribute("idart"));
			String nomArticle = request.getParameter("nomArticle");
			String description = request.getParameter("description");
			double prix =Double.parseDouble(request.getParameter("prix"));
			double fdp =Double.parseDouble(request.getParameter("fdp"));
			nomCat = request.getParameter("categorie");	
			metier.modifierArticle(id, nomArticle, description, prix, fdp, nomCat);  
			System.out.println(metier.lireTousArticles());
			response.sendRedirect( request.getContextPath() + "/ArticleServlet");
			}
		ModelModifierArticle model = new ModelModifierArticle(); 
		model.setCategories(categories);
		model.setNomCat(nomCat);
		request.setAttribute("model", model);
		request.getRequestDispatcher(urlVue).forward(request, response);
		
	}

}
