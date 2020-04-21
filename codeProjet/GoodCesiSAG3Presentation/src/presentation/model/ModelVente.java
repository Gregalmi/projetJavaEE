package presentation.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import entite.Commande;
import entite.EtatCommande;

public class ModelVente {
	private List <Commande> listeVentes;
	private List <EtatCommande> etatCommandes;
	//EtatCommande etatCommande;
	
	public ModelVente() {
		listeVentes = new ArrayList<>();
		etatCommandes = new ArrayList<EtatCommande>(Arrays.asList(EtatCommande.values()));
		//etatCommandes = Arrays.asList(EtatCommande.values());
	}

	public List<Commande> getListeVentes() {
		return listeVentes;
	}

	public void setListeVentes(List<Commande> listeVentes) {
		this.listeVentes = listeVentes;
	}

	public List<EtatCommande> getEtatCommandes() {
		return etatCommandes;
	}

	public void setEtatCommandes(List<EtatCommande> etatCommandes) {
		this.etatCommandes = etatCommandes;
	}

	/*public EtatCommande getEtatCommande() {
		return etatCommande;
	}

	public void setEtatCommande(EtatCommande etatCommande) {
		this.etatCommande = etatCommande;
	}	*/
	
}
