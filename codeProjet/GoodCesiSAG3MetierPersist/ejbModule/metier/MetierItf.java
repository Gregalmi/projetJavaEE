package metier;

import java.util.List;

import entite.Administrateur;
import entite.Article;
import entite.Categorie;
import entite.Commande;
import entite.UConnecte;
import entite.Utilisateur;


public interface MetierItf {
	
	/*
	
	//UTILISATEUR CONNECTE VENDEUR
	//-------  Gestion des articles en vente
	
	List<Article> lireTousArticleVendeur(String login);	
	List<Article> lireTousArticles();
	void creerArticle(String login, Article article);
	void supprimerArticle(Article article);
	void modifierArticle(Article article);
	Article lireArticle (Long id);
	
	//--------  Gestion commandes en cours
	public List<Commande> lireTousVenteEnCours(String login);
	boolean validationCommande(String num);
	void envoyerCommande(Long id);
	List<Commande> lireListCommandesEnCours();
	List<Commande> lireListCommandeValide();
	List<Commande> lireListCommandeEnvoye();
	
	
	//UTILISATEUR CONNECTE ACHETEUR
	//--------  Gestion Achats
	void creerCommande(String login, Article article, Commande commande);
	Commande lireCommande(Long id);
	List<Commande> lireTousAchats(String login);
	
	//VISITEUR - INTERNAUTE
	
	void creerArticle(String login, Article article);
	*/
	
	//-------  Gestion des articles en vente
	//COMMANDE
	
	void creerCom(Commande commande);	
	boolean validationCommande(String num);
	void creerCommande(String acheteurlogin, Long articleid);
	Commande lireCommande(Long id);
	public void statutEncoursCommande(Long id);
	public void statutValideCommande(Long id);
	public void statutEnvoyeCommande(Long id);
	
	
	
	//ARTICLE
	//	List<Article> lireTousArticleVendeur(String login);	
		List<Article> lireTousArticles();
		void creerArticle(Article article);
	//	void modifierArticle(Article article);
		Article lireArticle (Long id);
		void supprimerArticleNC(String login, Long articleId);
		void supprimerArticle(String login, Long articleId);
		void modifierArticle(Long id, String nomArticle, String description, double prix, double fdp, String nomCat);
		
	//USERS
	void creerUConnecte(UConnecte uconnecte);
	void creerAdministrateur(Administrateur administrateur);
	Utilisateur lireUtilisateur(String login);
	//List<Utilisateur> lireTousUtilisateurs();
	void creerArticleParVendeur(String login, String nomArticle, String description, double prix, double fdp, String nomCat);
	List<Commande> lireTousAchats(String login);
	List<Article> lireTousArticleVendeur(String login);
	List<Commande> lireTousVenteEnCours(String login);
	
	//CATEGORIE
	//Premiere ligne, on ne s'en sert pas pour l'instant.
	//List<Article> lireTousArticleCategorie(String nomCat); 
	void creerCategorie(Categorie categorie);
	Categorie lireCategorie(String nomCat);
	void supprimerCategorie(Categorie categorie);
	List<Categorie> lireTousCategories();
	Utilisateur connexionUtilisateur(String login,String password);
	
}
