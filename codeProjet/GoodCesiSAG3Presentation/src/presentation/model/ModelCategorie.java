package presentation.model;

import java.util.ArrayList;
import java.util.List;

import entite.Categorie;

public class ModelCategorie {
	
	private List<Categorie> categories;
	private String nomCat;

	public ModelCategorie() {
		categories = new ArrayList<>();	
	}

	public List<Categorie> getCategories() {
		return categories;
	}

	public void setCategories(List<Categorie> categories) {
		this.categories = categories;
	}

	public String getNomCat() {
		return nomCat;
	}

	public void setNomCat(String nomCat) {
		this.nomCat = nomCat;
	}
	
	

}
