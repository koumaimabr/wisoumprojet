package afnTOafd;

import java.util.*;

public class Afd{
	
private ArrayList <Character> alphabet;
private ArrayList <String> etats;
private ArrayList <String> etatsFinaux;
private String [][] fonctionTransition;
private String etatInitial;

Scanner lectureClavier=new Scanner(System.in);
//////////////////////constructeur ///////////////////////////////////////////////////////////////////
public Afd(){

	alphabet= new ArrayList <Character> ();
	etats= new ArrayList <String> () ;
	etatsFinaux= new ArrayList <String>() ;
}
//////////////////////alphabet /////////////////////////////////////////////////////////////////////
public void ajouterSymbole(){
	char a;int z;
	System.out.print("donner un symbole de type charact�re:   ");
	a=lectureClavier.next().charAt(0);
	if(tailleAlphabet()!=0){
		z=alphabet.indexOf(a);
		if(z !=-1){
		 System.out.println("ce sympole existe deja, le  charact�re est refus�");}
		
		else{alphabet.add(new Character(a));
		System.out.println("votre symbole ajout� est :   "+a);}
			}
		else{
	alphabet.add(new Character(a));
	System.out.println("votre symbole ajout� est :   "+a);}
	
}

public void supprimerSymbole(){
    int num;char choix;
    System.out.println("Saisir le symbole que vous voulez supprimer :");
    choix=lectureClavier.next().charAt(0);
    Character ch=new Character(choix);
	num=alphabet.indexOf(ch);
	if(num >= 0){
	alphabet.remove(num);
	System.out.println("la suppression est faite avec succ�s ");
	}
	else
	System.out.println("ce charact�re n'existe pas ");
}

public int tailleAlphabet(){
	return alphabet.size();
}

public void affichageAlphabet(){
	 int taille=tailleAlphabet();
	 for(int i=0;i<taille;i++){
		 System.out.print(alphabet.get(i)+"\t");
	 }
}

public void menuAlphabet(){
	System.out.println("choix 1: ajouter symbole");
	System.out.println("choix 2: supprimer symbole");
	System.out.println("choix 3: afficher alphabet");
	System.out.println("choix 4: afficher taille alphabet");
	System.out.println("choix 5: sortir de ce menu");
}
//////////////////////////Etats
public void menuEtat(){
	System.out.println("choix 1: ajouterun �tat:    ");
	//System.out.println("choix 2: supprimer etat:    ");
	System.out.println("choix 2: afficher etat:     ");
	System.out.println("choix 3: afficher taille etats");
	System.out.println("choix 4: sortir de ce menu ");
}

public void ajouterEtats(){
	int  a;String e;
   
	System.out.print("donnez le nombre des �tats que vous souhaitez utilis�s \n dans ce afd, par la suite on vous g�n�ra les noms de ce �tats comme suit en respectant l'ordre : q0,q1,q2,q3,....tel que q0 est \n l'�tat initial;cette d�marche simplifie l'�tude par la suite:    ");
	a=lectureClavier.nextInt();

	for(int i=0;i<a;i++){
	e="q"+i;	
	etats.add(e);
	}
	
}

public void supprimeretat(){
    int num;
    String choix;
    System.out.print("saisir l'�tat : ");
    choix=lectureClavier.nextLine();
    num=alphabet.indexOf(choix);
    if(num != -1)
	alphabet.remove(num);
    else 
    	System.out.print("cette �tat n'existe pas ");	
	
}

public int tailleEtats(){
	return etats.size();
}

 public void affichageEtats(){
	 int taille=tailleEtats();
	 for(int i=0;i<taille;i++){
		 System.out.print(etats.get(i)+"\t");
	 }
	 System.out.println();
 }
///////////////////////////////////////////fonction transition/:::::::::::::::::::::::::::::
public void fonctionTrans(){
	int i,j;String etatTest;char c;String f;boolean test;
	fonctionTransition = new String[tailleEtats()][tailleAlphabet()];
	for(i=0;i<tailleEtats();i++){
		etatTest=etats.get(i);
		for (j=0;j<tailleAlphabet();j++){
			c=alphabet.get(j);
			System.out.print("f("+etatTest+","+c+")=");
			do{
			f=lectureClavier.nextLine();
			test=verifierEtat(f);
			}while(test==false);
			fonctionTransition[i][j]=f;
		}
	}	
}
public void AfficherFonctionTrans(){
	System.out.print("\t");
	affichageAlphabet();
	System.out.print("\n");
	
	for(int i=0;i<tailleEtats();i++){
		System.out.print(etats.get(i)+"\t");
		for(int j=0;j<tailleAlphabet();j++){
			System.out.print(fonctionTransition[i][j]+"\t");
		}
		System.out.print("\n");
	}
}

private boolean verifierEtat(String f) { 
	int position=etats.indexOf(f);
	if(position==-1)return false;
	else 
	return true;
}
/////////////////////////////////////////Etats finaux
public void saisirEtatFinaux(){
	String f;boolean test;
	System.out.println("Veuillez saisir le nombre d'�tats finaux: ");
	int nombreEtatFinaux=lectureClavier.nextInt();
	for(int i=0;i<nombreEtatFinaux;i++){
		System.out.print("Veuillez saisir le"+(1+i)+" �tat final: ");
	do{
		f=lectureClavier.nextLine();
		test=verifierEtat(f);
		}while(test==false);
	etatsFinaux.add(f);
}
	System.out.print("\n");
}

public void affichageEtatsFinaux(){
	 int taille=tailleEtatsFinaux();
	 for(int i=0;i<taille;i++){
		 System.out.print(etatsFinaux.get(i)+"\t");
	 }
	 System.out.print("\n");
}

public int tailleEtatsFinaux(){
	return etatsFinaux.size();
}
///////////////////////////////////// Etat initial                 
/*
public void saisirEtatInitial(){
	String f;boolean test;
	System.out.print("Veuillez saisir l'�tat initial:   ");
	do{
		f=lectureClavier.nextLine();
		test=verifierEtat(f);
		}while(test==false);
	etatInitial=f;	
}
*/
public String getEtatInitial(){
	etatInitial="q0";
	return etatInitial;
}

public void affichageEtatsInitial(){
  System.out.println("l'�tat initial de votre AFD est : "+getEtatInitial());
}

}
