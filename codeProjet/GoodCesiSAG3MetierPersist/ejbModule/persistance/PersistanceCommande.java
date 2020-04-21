package persistance;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entite.Article;
import entite.Commande;
import entite.EtatArticle;
import entite.EtatCommande;
import entite.UConnecte;
import entite.Utilisateur;

@Stateless
public class PersistanceCommande implements PersistanceCommandeItf{
	@PersistenceContext(unitName="UP_GOODCESI") // nom unité de persistence
	private EntityManager entityManager;
	
	@Override
	public void creerCom(Commande commande) {
		entityManager.persist(commande);
	}
	@Override
	public Commande lireCommande(Long id) {
		return entityManager.find(Commande.class, id);
	}
	@Override
	public void supprimerCommande(Long articleId) {
		Query query = entityManager.createQuery("select c from Commande c where article.id=:articleId");
		query.setParameter("articleId", articleId);
		Commande commande = (Commande) query.getSingleResult();
		commande = entityManager.merge(commande);
		entityManager.remove(commande);
	}
}
