package persistance;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entite.Categorie;

@Stateless
public class PersistanceCategorie implements PersistanceCategorieItf {
	@PersistenceContext(unitName="UP_GOODCESI") // nom unité de persistence
	private EntityManager entityManager;

	@Override
	public void creerCategorie(Categorie categorie) {
		entityManager.persist(categorie);
		
	}

	@Override
	public Categorie lireCategorie(String nomCat) {
		return entityManager.find(Categorie.class, nomCat);
	}

	@Override
	public void supprimerCategorie(Categorie categorie) {
		entityManager.merge(categorie);
		entityManager.remove(categorie);
	}
	
	@Override
	public List<Categorie> lireTousCategorie() {
		Query req = entityManager.createQuery("select c from Categorie c");
		return req.getResultList();
	}
}
