package model;

public class Zombie {
	String Name;
	int NbAction;
	
	public Zombie(String n,int nb) {
		Name=n;
		NbAction=nb;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getNbAction() {
		return NbAction;
	}

	public void setNbAction(int nbAction) {
		NbAction = nbAction;
	}
	

}
