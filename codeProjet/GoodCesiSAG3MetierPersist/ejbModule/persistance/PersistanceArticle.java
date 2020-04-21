package persistance;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entite.Article;

@Stateless
public class PersistanceArticle implements PersistanceArticleItf {
	@PersistenceContext(unitName="UP_GOODCESI") // nom unité de persistence
	private EntityManager entityManager;

	@Override
	public void persisterArticle(Article article) {
		entityManager.persist(article);
	}

	@Override
	public Article lireArticle(Long id) {
		return entityManager.find(Article.class, id);
	}

	@Override
	public Article modifierArticle(Article article) {
		return entityManager.merge(article);
	}

	@Override
	public void supprimerArticle(Article article) {
		article = entityManager.merge(article);
		entityManager.remove(article);
	}
		
	@Override
	public List<Article> lireTousArticle() {
		Query req = entityManager.createQuery("select a from Article a");
		return req.getResultList();
	}
}
