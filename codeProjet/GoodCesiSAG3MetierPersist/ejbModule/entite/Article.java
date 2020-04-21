package entite;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Article implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nomArticle;
	private String description;
	private double prix;
	private double fdp;
	@OneToOne
	private UConnecte vendeur;
	@ManyToOne
	private Categorie categorie;
	protected EtatArticle etatArticle;
	
	public Article() {} 
	
	public Article(Long id, String nomArticle, String description, double prix, double fdp, UConnecte vendeur,
			Categorie categorie, EtatArticle etatArticle) {
		this.id = id;
		this.nomArticle = nomArticle;
		this.description = description;
		this.prix = prix;
		this.fdp = fdp;
		this.vendeur = vendeur;
		this.categorie = categorie;
		this.etatArticle = etatArticle;
	}
	
	//POUR AURELIE ** AJOUT DE DEUX CONSTRUCTEURS
	
	public Article(String nomArticle, String description, double prix, double fdp, UConnecte vendeur,
			Categorie categorie, EtatArticle etatArticle) {
		this.nomArticle = nomArticle;
		this.description = description;
		this.prix = prix;
		this.fdp = fdp;
		this.vendeur = vendeur;
		this.categorie = categorie;
		this.etatArticle = etatArticle;
	}
	
	public Article(String nomArticle, String description, double prix, double fdp,
			Categorie categorie) {
		this.nomArticle = nomArticle;
		this.description = description;
		this.prix = prix;
		this.fdp = fdp;
		this.categorie = categorie;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomArticle() {
		return nomArticle;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public double getFdp() {
		return fdp;
	}

	public void setFdp(double fdp) {
		this.fdp = fdp;
	}

	public UConnecte getVendeur() {
		return vendeur;
	}

	public void setVendeur(UConnecte vendeur) {
		this.vendeur = vendeur;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public EtatArticle getEtatArticle() {
		return etatArticle;
	}

	public void setEtatArticle(EtatArticle etatArticle) {
		this.etatArticle = etatArticle;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", nomArticle=" + nomArticle + ", description=" + description + ", prix=" + prix
				+ ", fdp=" + fdp + ", vendeur=" + vendeur + ", categorie=" + categorie + ", etatArticle=" + etatArticle
				+ "]";
	}
	
	
	
	
	

}
