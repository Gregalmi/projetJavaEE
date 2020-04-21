package presentation.model;

import java.util.ArrayList;
import java.util.List;

import entite.Article;
import entite.Categorie;

public class AccueilModel {
	private List<Categorie> categories;
	private List<Article> articles;
	private String nomCat;
	
	
	public AccueilModel() {
		categories = new ArrayList<>();
		articles = new ArrayList<>();
	}

	public List<Categorie> getCategories() {
		return categories;
	}

	public void setCategories(List<Categorie> categories) {
		this.categories = categories;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public String getNomCat() {
		return nomCat;
	}

	public void setNomCat(String nomCat) {
		this.nomCat = nomCat;
	}	
	
	

}
