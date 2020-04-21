package presentation.model;

import entite.Article;
import entite.Commande;

public class ModelCommande {
	
	private Commande commande;
	private Article article;
	
	public ModelCommande() {}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

}
