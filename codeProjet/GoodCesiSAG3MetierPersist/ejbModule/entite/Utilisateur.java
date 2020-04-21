package entite;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Utilisateur {
	@Id
	private String login;
	private String password;
	protected Role role;
	
	public Utilisateur() {};
	public Utilisateur(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	
	
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Utilisateur [login=" + login + ", password=" + password + ", role=" + role + "]";
	}
	
	
}
