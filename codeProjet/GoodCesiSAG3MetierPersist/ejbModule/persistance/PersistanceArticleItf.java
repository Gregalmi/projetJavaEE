package persistance;

import java.util.List;

import entite.Article;

public interface PersistanceArticleItf {
	
	void persisterArticle(Article article); //on crée l'article dans l'UConnecte (par le vendeur)

	Article lireArticle(Long id);

	Article modifierArticle(Article article); //Modification de l'article = évolution V2 du projet

	void supprimerArticle(Article article); 

	List<Article> lireTousArticle();

}
