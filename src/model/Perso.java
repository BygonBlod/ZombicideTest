package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import DataBase.CarteMainDB;
import DataBase.CompetenceDB;

public class Perso {
	String namePerso;
	int NbVie;
	int Xp;
	int NbAction=3;
	int niveaux=1;
	String [] ListeComp= new String [4];
	CarteMain MainDroite;
	CarteMain MainGauche;
	CarteTorse Torse;
	CarteMain[] deck=new CarteMain [5];
	
	public Perso(String namePerso,String comp1) {
		this.namePerso=namePerso;
		this.NbVie=3;
		this.Xp=0;
		ListeComp[0]=comp1;
		/*CompetenceDB comp=new CompetenceDB();
		try {
			ListeComp[0]=comp.getFirst(namePerso);
		} catch (SQLException e) {
			System.out.println("n'a pas de compétences");
		}*/
		/*CarteMainDB testCarte=new CarteMainDB();
		try {
			MainGauche=testCarte.getAleaCarte();
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
	}
	
	public int getNiveaux() {
		return niveaux;
	}

	public void setNiveaux(int niveaux) {
		this.niveaux = niveaux;
		
	}

	private void pasNivquatre() {
		CompetenceDB comp=new CompetenceDB();
		ArrayList<String> res=new ArrayList<String>();
		try {
			res=comp.getFourth(namePerso);
		} catch (SQLException e) {
			System.out.println("n'a pas de compétences");
		}
		System.out.println("\tChoix de votre compétence:");
		System.out.println("0 :"+res.get(0));
		System.out.println("1 :"+res.get(1));
		System.out.println("2 :"+res.get(2));
		int arme =0;
		boolean nb=false;
		while(nb!=true){
			Scanner sc = new Scanner(System.in);
			System.out.println(" Choisissez le numéro de la compétence");
			String str = sc.nextLine();
			try {
				 arme= Integer.valueOf(str);
				 if(arme<res.size())nb=true;
			}catch (Exception e) {
				
			}
		}
		ListeComp[3]=(res.get(arme));
		
	}

	private void pasNivtrois() {
		CompetenceDB comp=new CompetenceDB();
		ArrayList<String> res=new ArrayList<String>();
		try {
			res=comp.getThird(namePerso);
		} catch (SQLException e) {
			System.out.println("n'a pas de compétences");
		}
		System.out.println("\tChoix de votre compétence:");
		System.out.println("0 :"+res.get(0));
		System.out.println("1 :"+res.get(1));
		int arme =0;
		boolean nb=false;
		while(nb!=true){
			Scanner sc = new Scanner(System.in);
			System.out.println(" Choisissez le numéro de la compétence");
			String str = sc.nextLine();
			try {
				 arme= Integer.valueOf(str);
				 if(arme<res.size())nb=true;
			}catch (Exception e) {
				
			}
		}
		ListeComp[2]=(res.get(arme));
	}

	private void pasNivdeux() {
		CompetenceDB comp=new CompetenceDB();
		try {
			ListeComp[1]=comp.getSecond(namePerso);
			this.NbAction+=1;
		} catch (SQLException e) {
			System.out.println("n'a pas de compétences");
		}		
	}

	public String getNamePerso() {
		return namePerso;
	}
	public void setNamePerso(String namePerso) {
		this.namePerso = namePerso;
	}
	public int getNbVie() {
		return NbVie;
	}
	public void setNbVie(int nbVie) {
		NbVie = nbVie;
	}
	public int getXp() {
		return Xp;
	}
	public void setXp(int xp) {
		int t=this.Xp;
		Xp = xp;
		System.out.println("avant "+t+" après "+Xp);
		if(t<7 && Xp>=7) {
			pasNivdeux();
			this.setNiveaux(2);
			System.out.println("------------------------------------------------CHANGEMENT DE NIVEAU-----------------------------------------------");
			System.out.println(this);
		}
		if(t<19 && Xp>=19) {
			pasNivtrois();
			this.setNiveaux(3);
			System.out.println("------------------------------------------------CHANGEMENT DE NIVEAU-----------------------------------------------");
			System.out.println(this);
		}
		if(t<43 && Xp>=43) {
			pasNivquatre();
			this.setNiveaux(4);
			System.out.println("------------------------------------------------CHANGEMENT DE NIVEAU-----------------------------------------------");
			System.out.println(this);
		}
	}
	public int getNbAction() {
		return NbAction;
	}
	public void setNbAction(int nbAction) {
		NbAction = nbAction;
	}
	public String[] getListeComp() {
		return ListeComp;
	}
	public void setListeComp(String[] listeComp) {
		ListeComp = listeComp;
	}
	public CarteMain getMainDroite() {
		return MainDroite;
	}
	public void setMainDroite(CarteMain mainDroite) {
		MainDroite = mainDroite;
	}
	public CarteMain getMainGauche() {
		return MainGauche;
	}
	public void setMainGauche(CarteMain mainGauche) {
		MainGauche = mainGauche;
	}
	public CarteTorse getTorse() {
		return Torse;
	}
	public void setTorse(CarteTorse torse) {
		Torse = torse;
	}
	public CarteMain[] getDeck() {
		return deck;
	}
	public void setDeck(CarteMain[] deck) {
		this.deck = deck;
	}
	public String toString() {
		String s=namePerso+" \n comp: "+ListeComp[0]+" ,"+ListeComp[1]+" ,"+ListeComp[2]+" ,"+ListeComp[3]+" \n equip : ";
		if(MainGauche!=null)s+=MainGauche.getNomCarte()+" ,";
		else s+="null ,";
		if(MainDroite!=null)s+=MainDroite.getNomCarte()+" ,";
		else s+="null ,";
		s+=Torse+" \n deck : "+deck[0]+" ,"+deck[1]+" ,"+deck[2]+" ,"+deck[3]+" ,"+deck[4];
		return s;
	}
	public ArrayList<CarteMain> getCarteMain(){
		ArrayList<CarteMain> res= new ArrayList<CarteMain>();
		if(MainDroite!=null)res.add(MainDroite);
		if(MainGauche!=null)res.add(MainGauche);
		return res;
	}
}
