package model;

import java.util.ArrayList;

public class Joueur {
	private String name;
	private String pwd;
	ArrayList<Perso> PersoDejaJouer;
	Perso PersoParti;
	public Joueur(String string) {
		setName(string);
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public ArrayList<Perso> getPersoDejaJouer() {
		return PersoDejaJouer;
	}
	public void ajouterPersoJouer(Perso p) {
		PersoDejaJouer.add(p);
	}
	public void setPersoDejaJouer(ArrayList<Perso> persoDejaJouer) {
		PersoDejaJouer = persoDejaJouer;
	}
	public Perso getPersoParti() {
		return PersoParti;
	}
	public void setPersoParti(Perso persoParti) {
		PersoParti = persoParti;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
