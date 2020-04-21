package entite;

import javax.persistence.Entity;

@Entity
public class Administrateur extends Utilisateur {

	public Administrateur() {
		super();
	}

	public Administrateur(String login, String password) {
		super(login, password);
		role = Role.ADMINISTRATEUR;
	}

	@Override
	public String toString() {
		return "Administrateur [role=" + role + super.toString()  + "]";
	}
	
	
}
