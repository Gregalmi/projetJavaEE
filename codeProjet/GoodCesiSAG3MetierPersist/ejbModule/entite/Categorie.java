package entite;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Categorie implements Serializable{
	@Id
	private String nomCat;
	
	public Categorie() {}
	
	public Categorie(String nomCat) {
		this.nomCat = nomCat;
	}
		
	public String getNomCat() {
		return nomCat;
	}


	public void setNomCat(String nomCat) {
		this.nomCat = nomCat;
	}


	@Override
	public String toString() {
		return "Categorie [nomCat=" + nomCat + "]";
	}
		
}
