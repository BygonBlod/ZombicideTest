package model;

public class CarteMain {
	String NomCarte;
	int distance;
	int NbDes;
	int ScoreDe;
	int degat;
	boolean porte;
	boolean magic;
	String Bonus;
	
	public CarteMain(String string, int int1, int int2, int int3, int int4, int int5,int int6, String string2) {
		this.NomCarte=string;
		this.distance=int1;
		this.NbDes=int2;
		this.ScoreDe=int3;
		this.degat=int4;
		if(int5==0)this.porte=false;
		else this.porte=true;
		if(int6==0)magic=false;
		else magic=true;
		this.Bonus=string2;
	}
	public String toString() {
		String str=NomCarte+" \n distance:"+distance+" \n Nb de des:"+NbDes+" \n Min des:"+ScoreDe+" \n degat(s):"+degat+" \n porte:"+porte+" \n magique:"+magic+" \n bonus:"+Bonus;
		return str;
	}
	public String getNomCarte() {
		return NomCarte;
	}
	public void setNomCarte(String nomCarte) {
		NomCarte = nomCarte;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public int getNbDes() {
		return NbDes;
	}
	public void setNbDes(int nbDes) {
		NbDes = nbDes;
	}
	public int getScoreDe() {
		return ScoreDe;
	}
	public void setScoreDe(int scoreDe) {
		ScoreDe = scoreDe;
	}
	public int getDegat() {
		return degat;
	}
	public void setDegat(int degat) {
		this.degat = degat;
	}
	public boolean isPorte() {
		return porte;
	}
	public void setPorte(boolean porte) {
		this.porte = porte;
	}
	public String getBonus() {
		return Bonus;
	}
	public void setBonus(String bonus) {
		Bonus = bonus;
	}
}
