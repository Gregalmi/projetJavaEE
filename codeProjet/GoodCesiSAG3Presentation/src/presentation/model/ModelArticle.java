package presentation.model;

import java.util.ArrayList;
import java.util.List;

import entite.Article;

public class ModelArticle {
	private List<Article> articles;
	
	public ModelArticle() {
		articles = new ArrayList<>();
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	
}
