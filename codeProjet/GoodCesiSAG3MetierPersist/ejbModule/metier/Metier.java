package metier;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.BeforeCompletion;
import javax.ejb.EJB;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.servlet.http.HttpSession;

import entite.Administrateur;
import entite.Article;
import entite.Categorie;
import entite.Commande;
import entite.EtatArticle;
import entite.EtatCommande;
import entite.Role;
import entite.UConnecte;
import entite.Utilisateur;
import persistance.PersistanceArticleItf;
import persistance.PersistanceCategorieItf;
import persistance.PersistanceCommandeItf;
import persistance.PersistanceUtilisateurItf;

@Stateless
public class Metier implements MetierItf{

	
	@EJB
	private PersistanceCategorieItf persistanceCategorie; 
	
	@EJB
	private PersistanceUtilisateurItf persistanceUtilisateur;
	
	@EJB
	private PersistanceArticleItf persistanceArticle;
	
	@EJB
	private PersistanceCommandeItf persistanceCommande;
	
	
	
	public Metier() {};
	
	@PostConstruct
	private void initMetier() {
		System.out.println("postconstruct");
		init();
	}


	public void creerCom(Commande commande) {
		persistanceCommande.creerCom(commande);
	}
	
	public List<Commande> lireTousVenteEnCours(String login) {
		return persistanceUtilisateur.lireTousVenteEnCours(login);
	}
	
	public List<Commande> lireTousAchats(String login) {
		return persistanceUtilisateur.lireTousAchats(login);
	}
	
	public boolean validationCommande(String num) {
		if(num.length() == 10)
			return true;
			else return false;
	}
	
	public Commande lireCommande(Long id) {
		return persistanceCommande.lireCommande(id);
	}
	
	public void creerCommande(String acheteurLogin, Long articleId) {	
		UConnecte uconnecte = (UConnecte) persistanceUtilisateur.lireUtilisateur(acheteurLogin);
		Article article = persistanceArticle.lireArticle(articleId);
		article.setEtatArticle(EtatArticle.RESERVE);
		Commande commande = new Commande(article,uconnecte);
		commande.setEtatCommande(EtatCommande.ENCOURS);
		commande.setDateAchat(new Date());		
		persistanceCommande.creerCom(commande);
	}
	
	public void statutEncoursCommande(Long id) {
		Commande commande = persistanceCommande.lireCommande(id);
		commande.setEtatCommande(EtatCommande.ENCOURS);
	}
	
	public void statutValideCommande(Long id) {
		Commande commande = persistanceCommande.lireCommande(id);
		commande.setEtatCommande(EtatCommande.VALIDE);
	}
	
	public void statutEnvoyeCommande(Long id) {
		Commande commande = persistanceCommande.lireCommande(id);
		commande.setEtatCommande(EtatCommande.ENVOYE);
		commande.getArticle().setEtatArticle(EtatArticle.VENDU);
		commande.setDateExpedition(new Date());
	}
	
	
	public void creerArticle(Article article) {
		persistanceArticle.persisterArticle(article);
	}
	
	public List<Article> lireTousArticles() {
		return persistanceArticle.lireTousArticle();
	}
	
	public Article lireArticle (Long id) {
		return persistanceArticle.lireArticle(id);
	}
	
	public void supprimerArticleNC(String login, Long articleId) {
		UConnecte uconnecte = (UConnecte) persistanceUtilisateur.lireUtilisateur(login);
		Article article = persistanceArticle.lireArticle(articleId);
		uconnecte.removeArticle(article);
		persistanceArticle.supprimerArticle(article);		
	}
	
	public void supprimerArticle(String login, Long articleId) {
		UConnecte uconnecte = (UConnecte) persistanceUtilisateur.lireUtilisateur(login);
		Article article = persistanceArticle.lireArticle(articleId);
		persistanceCommande.supprimerCommande(articleId);
		uconnecte.removeArticle(article);
		persistanceArticle.supprimerArticle(article);		
	}
	
	@Override
	public List<Article> lireTousArticleVendeur(String login) { //= UConnecte.getListeArticle + Utilisateur.getLogin 
		return persistanceUtilisateur.lireTousArticleVendeur(login);
	}

	public void creerArticleParVendeur(String login, String nomArticle, String description, double prix, double fdp, String nomCat) {
		UConnecte uconnecte = (UConnecte) persistanceUtilisateur.lireUtilisateur(login);
		Categorie categorie = lireCategorie(nomCat);
		Article article = new Article(nomArticle, description, prix, fdp, categorie );
		article.setVendeur(uconnecte);
		article.setEtatArticle(EtatArticle.ENVENTE);
		uconnecte.addArticle(article);
		persistanceArticle.persisterArticle(article);
	}
	
	public void modifierArticle(Long id, String nomArticle, String description, double prix, double fdp, String nomCat) {
		Article article = lireArticle(id);
		Categorie categorie = lireCategorie(nomCat);
		article.setCategorie(categorie);
		article.setNomArticle(nomArticle);
		article.setDescription(description);
		article.setPrix(prix);
		article.setFdp(fdp);
		persistanceArticle.modifierArticle(article);	
	}

	
	public void creerUConnecte(UConnecte uconnecte) {
		persistanceUtilisateur.creerUConnecte(uconnecte);
	}
	
	public void creerAdministrateur(Administrateur administrateur) {
		persistanceUtilisateur.creerAdministrateur(administrateur);
	}
	
	public Utilisateur lireUtilisateur(String login) {
		return persistanceUtilisateur.lireUtilisateur(login);
	}
	

	public Utilisateur connexionUtilisateur(String login,String password) {
		Utilisateur utilisateur = persistanceUtilisateur.connexionUtilisateur(login, password);
		return utilisateur;
	}
	
	//CATEGORIE 
	public void creerCategorie(Categorie categorie) {
		persistanceCategorie.creerCategorie(categorie);
	}
	
	public Categorie lireCategorie(String nomCat) {
		return persistanceCategorie.lireCategorie(nomCat);
	}
	
	public void supprimerCategorie(Categorie categorie) {
		persistanceCategorie.supprimerCategorie(categorie);
	}
	
	public List<Categorie> lireTousCategories() {
		return persistanceCategorie.lireTousCategorie();
	}
	/*
	public List<Article> lireTousArticleCategorie(String nomCat) {
		List<Article> articles = lireTousArticles();
		List<Article> listeArticleCat = new ArrayList<Article>();
		for(int i=0; i<articles.size();i++) {
			if (articles.get(i).getCategorie().getNomCat() == nomCat) {
				listeArticleCat.add(articles.get(i));
			};
			//Article article = articles.get(i);	
			//listeArticleCat.add(articles.get(i));					
		}			 
		return listeArticleCat;
	}*/

	
	public void init() {
		System.out.println("init cat");
		Categorie cycle = new Categorie("cycle");
		creerCategorie(cycle);
		Categorie jouet = new Categorie("jouet");
		creerCategorie(jouet);	
		Administrateur admin1 = new Administrateur("admin1", "admin1");
		creerAdministrateur(admin1);
		UConnecte uco1 = new UConnecte("uco1", "uco1");
		creerUConnecte(uco1);
		UConnecte uco2 = new UConnecte("uco2", "uco2");
		creerUConnecte(uco2);
		creerArticleParVendeur("uco1", "velo", "petit velo", 100, 20, "cycle");
		creerArticleParVendeur("uco2", "moto", "grosse moto", 2000,40, "cycle");
		creerArticleParVendeur("uco1", "UNO", "jeux de cartes", 10,1, "jouet");
		creerArticleParVendeur("uco2", "Fifa", "jeux video", 40,5, "jouet");
	//	creerCommande("uco2", 1L);
	//	creerCommande("uco1", 2L);
	//	creerCommande("uco2", 3L);
	//	creerCommande("uco1", 4L);

	}
}

	
