package model;

import java.util.ArrayList;

public class Case {
	int [] disposition=new int[6];//ordre haut,droite,bas,gauche,rue ou int�rieur,spawn zombie
	ArrayList<Perso> joueurs;
	ArrayList<Zombie> zombies;
	
	public Case(int []d,ArrayList<Perso>j,ArrayList<Zombie>z) {
		disposition=d;
		joueurs=j;
		zombies=z;
	}
	/**
	 * retourne vrai si on peut fouiller
	 * @return
	 */
	public boolean PeutFouiller() {
		if(disposition[4]==1)return true;
		else return false;
	}
	/**
	 * retourne vrai si il y a un ou plusieurs spawn sur cette case 
	 * @return
	 */
	public boolean isSpawn() {
		if(disposition[5]>=1)return true;
		else return false;
	}
	/**
	 * affiche les d�placements possible
	 */
	public void DepPossible() {
		if(disposition[0]==0)System.out.println("vous pouvez all� en haut\n");
		if(disposition[1]==0)System.out.println("vous pouvez all� � gauche\n");
		if(disposition[2]==0)System.out.println("vous pouvez all� en bas\n");
		if(disposition[3]==0)System.out.println("vous pouvez all� � droite\n");
	}
}
