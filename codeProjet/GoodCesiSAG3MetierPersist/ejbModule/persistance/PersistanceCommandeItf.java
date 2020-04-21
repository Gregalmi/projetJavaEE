package persistance;

import java.util.List;

import entite.Article;
import entite.Commande;

public interface PersistanceCommandeItf {
	
	public void creerCom(Commande commande);
	Commande lireCommande(Long id);
	public void supprimerCommande(Long articleId);
		
}
