package persistance;

import java.util.List;

import entite.Article;

public interface PersistanceArticleItf {
	
	void persisterArticle(Article article); //on cr�e l'article dans l'UConnecte (par le vendeur)

	Article lireArticle(Long id);

	Article modifierArticle(Article article); //Modification de l'article = �volution V2 du projet

	void supprimerArticle(Article article); 

	List<Article> lireTousArticle();

}
