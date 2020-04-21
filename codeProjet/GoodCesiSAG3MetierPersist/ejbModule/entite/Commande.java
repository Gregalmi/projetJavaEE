package entite;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Commande implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Date dateAchat;
	private Date dateExpedition;
	@OneToOne
	private Article article;
	@ManyToOne
	private UConnecte acheteur;
	protected EtatCommande etatCommande;
	
	
	public Commande() {}
/*	
	public Commande(Long id, Date dateAchat, Date dateExpedition, Article article,
			UConnecte acheteur, EtatCommande etatCommande) {
		this.id = id;
		this.dateAchat = dateAchat;
		this.dateExpedition = dateExpedition;
		this.article = article;
		this.acheteur = acheteur;
		this.etatCommande = etatCommande;
	}
*/	
	public Commande(Long id, Article article,
			UConnecte acheteur, EtatCommande etatCommande) {
		this.id = id;
		this.article = article;
		this.acheteur = acheteur;
		this.etatCommande = etatCommande;
	}
	
	public Commande(Article article,
			UConnecte acheteur) {
		this.article = article;
		this.acheteur = acheteur;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateAchat() {
		return dateAchat;
	}

	public void setDateAchat(Date dateAchat) {
		this.dateAchat = dateAchat;
	}

	public Date getDateExpedition() {
		return dateExpedition;
	}

	public void setDateExpedition(Date dateExpedition) {
		this.dateExpedition = dateExpedition;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public UConnecte getAcheteur() {
		return acheteur;
	}

	public void setAcheteur(UConnecte acheteur) {
		this.acheteur = acheteur;
	}


	public EtatCommande getEtatCommande() {
		return etatCommande;
	}

	public void setEtatCommande(EtatCommande etatCommande) {
		this.etatCommande = etatCommande;
	}

	@Override
	public String toString() {
		return "Commande [id=" + id + ", article="
				+ article + ", acheteur=" + acheteur + ", etatCommande=" + etatCommande + "]";
	}

	
}
