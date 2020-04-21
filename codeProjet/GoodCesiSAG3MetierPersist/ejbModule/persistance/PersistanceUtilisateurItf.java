package persistance;

import java.util.List;

import entite.Administrateur;
import entite.Article;
import entite.Commande;
import entite.UConnecte;
import entite.Utilisateur;

public interface PersistanceUtilisateurItf {
	
	void creerUConnecte(UConnecte uconnecte);
	void creerAdministrateur(Administrateur administrateur);
	Utilisateur lireUtilisateur(String login);
	List<Utilisateur> lireTousUtilisateurs();
	Utilisateur connexionUtilisateur(String login,String password);
	//void creerArticleParVendeur(String login, Article article);
	List<Article> lireTousArticleVendeur(String login);
	List<Commande> lireTousVenteEnCours(String login);	
	List<Commande> lireTousAchats(String login);
	

}
