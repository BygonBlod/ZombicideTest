import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import DataBase.CarteMainDB;
import DataBase.PersoDB;
import model.CarteMain;
import model.Perso;

public class test {
	public static void main (String [] args) throws SQLException {
		//essaie por utiliser une arme
		//
		PersoDB persodb=new PersoDB();
		Perso perso=new Perso(persodb.ranomPerso());
		System.out.println(perso.toString());
		CarteMainDB testCarte=new CarteMainDB();
		ArrayList<CarteMain> res=new ArrayList<CarteMain>();
		res=perso.getCarteMain();
		for(int i=0;i<res.size();i++) {
			System.out.println("\n"+i+" :"+res.get(i).toString());
		}
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
		}
	}

}
