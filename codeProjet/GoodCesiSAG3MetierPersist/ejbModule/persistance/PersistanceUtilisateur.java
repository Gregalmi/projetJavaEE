package persistance;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entite.Administrateur;
import entite.Article;
import entite.Categorie;
import entite.Commande;
import entite.UConnecte;
import entite.Utilisateur;

@Stateless
public class PersistanceUtilisateur implements PersistanceUtilisateurItf {
	@PersistenceContext(unitName="UP_GOODCESI") // nom unité de persistence
	private EntityManager entityManager;
	
	@Override
	public void creerUConnecte(UConnecte uconnecte) {
		entityManager.persist(uconnecte);
	}
	
	@Override
	public void creerAdministrateur(Administrateur administrateur) {
		entityManager.persist(administrateur);
	}
	
	@Override
	public Utilisateur lireUtilisateur(String login) {
		return entityManager.find(Utilisateur.class, login);		
	}
	
	@Override
	public List<Utilisateur> lireTousUtilisateurs(){
		Query req = entityManager.createQuery("select u from Utilisateur u");
		return req.getResultList();		
	}

	@Override
	public Utilisateur connexionUtilisateur(String login,String password) {
		Utilisateur utilisateur = null;
		
		try {
			Query query = entityManager.createQuery("select u from Utilisateur u where login=:login and password=:password");
			query.setParameter("login", login);
			query.setParameter("password", password);
			utilisateur = (Utilisateur) query.getSingleResult();
		} catch (Exception e) {
			utilisateur = null;
		}
		
		return utilisateur;
				
	}
	
	/*@Override
	public void creerArticleParVendeur(String login, Article article) {
		UConnecte uconnecte = entityManager.find(UConnecte.class, login);	
	}*/

	@Override
	public List<Article> lireTousArticleVendeur(String login) {
		Query req = entityManager.createQuery("select a from Article a where vendeur.login=:login");
		req.setParameter("login", login);
		return req.getResultList();
	}	
	@Override
	public List<Commande> lireTousAchats(String login) {
		Query req = entityManager.createQuery("select c from Commande c where acheteur.login=:login");
		req.setParameter("login", login);
		return req.getResultList();		
	}
	
	@Override
	public List<Commande> lireTousVenteEnCours(String login) {
		Query req = entityManager.createQuery("select c from Commande c where article.vendeur.login=:login");
		req.setParameter("login", login);
		return req.getResultList();			
	}

}
