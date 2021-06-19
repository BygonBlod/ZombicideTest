import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import DataBase.CarteMainDB;
import DataBase.JoueurDB;
import DataBase.PersoDB;
import model.CarteMain;
import model.Joueur;
import model.Perso;

public class test {
	static ArrayList<Perso> listePerso=new ArrayList<Perso>();
	static ArrayList<CarteMain> listeCarteMain=new ArrayList<CarteMain>();
	static ArrayList<Joueur> listeJoueurs=new ArrayList<Joueur>();
	
	public static void main (String [] args) throws SQLException {
		initialisation();
		
		//essaie por utiliser une arme
		//
				
		/*Perso perso=new Perso(persodb.ranomPerso());
		System.out.println(perso.toString());
		CarteMainDB testCarte=new CarteMainDB();
		ArrayList<CarteMain> res=new ArrayList<CarteMain>();
		res=perso.getCarteMain();
		for(int i=0;i<res.size();i++) {
			System.out.println("\n"+i+" :"+res.get(i).toString());
		}
		
		
		//pour que le perso fasse toutes ses actions
		for(int j=perso.getNbAction();j>0;j--) {
			System.out.println("\nil te reste "+j+" action(s)");
			
			//pour une attaque
			int arme=0;
			boolean nb=false;
			while(nb!=true){
				Scanner sc = new Scanner(System.in);
				System.out.println(" Choisissez le numéro de l'arme et écrivez le chiffre");
				String str = sc.nextLine();
				try {
					 arme= Integer.valueOf(str);
					 if(arme<res.size())nb=true;
				}catch (Exception e) {
					
				}
				if(nb==false)System.out.println("ce n'est pas un nombre d'une arme");
			}
			int nbMort=0;
			CarteMain carte=res.get(arme);
			System.out.println("vous avez choisi :"+carte.getNomCarte());
			for(int i=1;i<=carte.getNbDes();i++) {
				int des = (int) (1+Math.random()*(6-1));
				if(des>=carte.getScoreDe())nbMort+=1;
			}
			System.out.println("vous avez tué "+nbMort+" zombie(s)");
			perso.setXp(perso.getXp()+nbMort);
			System.out.println("tu as "+perso.getXp()+" Xp");
			//
		}*/
	}
	public static void initialisation() throws SQLException {
		PersoDB persodb=new PersoDB();
		CarteMainDB cartemaindb=new CarteMainDB();
		JoueurDB joueurdb=new JoueurDB();
		
		
		//connection des joueurs
		Joueur j=joueurdb.connexion("antonin", "non");
		Joueur j2=joueurdb.connexion("antonin", "non");
		Joueur j3=joueurdb.connexion("antonin", "non");
		listeJoueurs.add(j);
		listeJoueurs.add(j2);
		listeJoueurs.add(j3);
		
		//mise en place 
		System.out.println("----------------------PERSONNAGES DISPO-------------------------\n");
		listePerso=persodb.getPersos();
		for(int i=0;i<listePerso.size();i++) {
			System.out.println(listePerso.get(i)+"\n");
		}
		System.out.println("----------------------ARMES DISPO-------------------------\n");
		listeCarteMain=cartemaindb.getCarteMain();
		for(int i=0;i<listeCarteMain.size();i++) {
			System.out.println(listeCarteMain.get(i)+"\n");
		}
		//selection perso et première arme
		System.out.println("----------------------PERSONNAGE JOUER-------------------------\n");
		for(int i=0;i<listeJoueurs.size();i++) {	
			int pe=(int) (Math.random()*(listePerso.size()));
			int ar=(int) (Math.random()*(listeCarteMain.size()));
			Perso p=listePerso.get(pe);
			p.setMainGauche(listeCarteMain.get(ar));
			listeJoueurs.get(i).setPersoParti(p);
			listePerso.remove(pe);
			listeCarteMain.remove(ar);
			System.out.println(listeJoueurs.get(i).getName()+" joue :"+p+"\n");
		}
		
	}

}
