package persistance;

import java.util.List;

import entite.Categorie;

public interface PersistanceCategorieItf {
	void creerCategorie(Categorie categorie);
	Categorie lireCategorie(String nomCat);
	void supprimerCategorie(Categorie categorie);
	List<Categorie> lireTousCategorie();

}
