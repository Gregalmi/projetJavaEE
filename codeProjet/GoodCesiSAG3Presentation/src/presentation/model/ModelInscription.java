package presentation.model;

import java.util.ArrayList;
import java.util.List;

import entite.UConnecte;
import entite.Utilisateur;

public class ModelInscription {
	
	private List <Utilisateur> utilisateurs;

	public ModelInscription() {
		utilisateurs = new ArrayList<>();
	}

	public List<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}
	
	
}
