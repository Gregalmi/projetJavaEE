package entite;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class UConnecte extends Utilisateur {
	

	@OneToMany
	private List <Article> listeArticle; // Liste des articles en vente de l'utilisateur

	
	public UConnecte() {
		super();
	}
	public UConnecte(String login, String password,List<Article> listeArticle) {
		super(login, password);
		//this.listeVente = listeVente;
		//this.listeAchat = listeAchat;
		this.listeArticle = listeArticle;
		role = Role.UCONNECTE;
	}
	
	
	public UConnecte(String login, String password) {
		super(login, password);
		role = Role.UCONNECTE;
		listeArticle = new ArrayList<Article>();
		}
	
	public void addArticle(Article article) {
		listeArticle.add(article);
	}
	
	public void removeArticle(Article article) {
		listeArticle.remove(article);
	}
/*	
	public void addAchat(Commande commande) {
		listeAchat.add(commande);
	}
	
	public void addVente(Commande commande) {
		listeVente.add(commande);
	}
	
	public List<Commande> getListeAchat() {
		return listeAchat;
	}
	public void setListeAchat(List<Commande> listeAchat) {
		this.listeAchat = listeAchat;
	}
*/
	public List<Article> getListeArticle() {
		return listeArticle;
	}
	public void setListeArticle(List<Article> listeArticle) {
		this.listeArticle = listeArticle;
	}
	@Override
	public String toString() {
		return ", role=" + role + super.toString() + "]";
	}
/*	public List<Commande> getListeVente() {
		return listeVente;
	}
	public void setListeVente(List<Commande> listeVente) {
		this.listeVente = listeVente;
	}
*/	
	
	
	
}
