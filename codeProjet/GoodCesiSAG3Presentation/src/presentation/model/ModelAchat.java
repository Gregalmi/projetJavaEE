package presentation.model;

import java.util.ArrayList;
import java.util.List;

import entite.Commande;

public class ModelAchat {
	
	private List <Commande> listeAchats;
	
	public ModelAchat() {
		listeAchats = new ArrayList<>();
	}

	public List<Commande> getListeAchats() {
		return listeAchats;
	}

	public void setListeAchats(List<Commande> listeAchats) {
		this.listeAchats = listeAchats;
	}

}
