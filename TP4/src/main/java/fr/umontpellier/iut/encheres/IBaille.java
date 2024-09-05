package fr.umontpellier.iut.encheres;

import java.util.Scanner;

public class IBaille {

    private static Scanner saisie = new Scanner(System.in);

    public static void saisirOffre(Compte c, Produit p){
        System.out.println(p);
        attendre(1.5);
        System.out.println(c.getPseudo() + ", pour faire une offre, saisissez votre prix et votre max!");
        System.out.print("Prix en cours : ");
        int pc = saisie.nextInt();
        System.out.print("Prix max : ");
        int pm = saisie.nextInt();
        OffreEnchere o = c.creerOffre(p,pc,pm);
        if(o != null)
            p.ajouterOffre(o);
        System.out.println(p);
    }

    public static void attendre(double secondes){
        try {
            Thread.sleep((long) (secondes * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.print("Créer un compte :\nnom d'utilisateur : ");
        String usr = saisie.next();
        System.out.print("Montant à créditer sur votre compte iBaille : ");
        int solde = saisie.nextInt();

        Compte c1 = new Compte(usr,solde);
        System.out.println(c1);
        attendre(4);
        Compte c2 = new Compte("grenouilletheo",9999);
        Compte c3 = new Compte("pastalover",50);

        Produit p1 = new Produit(1,"Lampe de chevet",20,2);
        p1.demarrerEnchere();

        /*Produit p2 = new Produit(2,"Lustre",60,2);
        p2.demarrerEnchere();

        Produit p3 = new Produit(3,"Bureau",200,2);
        p3.demarrerEnchere();

        Produit p4 = new Produit(4,"Bateau miniature de collection",10,2);
        p4.demarrerEnchere();

        c.creerOffre(p1,10,25);
        c.creerOffre(p2,10,25);
        c.creerOffre(p3,10,25);
        c.creerOffre(p4,10,25);*/
        ///////////////////////////////////////////////
        saisirOffre(c1,p1);
        saisirOffre(c1,p1);
        attendre(5);

        c3.creerOffre(p1,40,60);
        System.out.println(c3.getPseudo()+" a fait une enchère!\n" +p1);
        attendre(3);

        String choix = "null";
        while(!choix.equals("oui") && !choix.equals("non")){
            System.out.println("Souhaitez vous encore enchérir ? (oui/non)\n");
            choix = saisie.next();
        }
        if(choix.equals("oui")){
            saisirOffre(c1,p1);
        }
        attendre(3);

        c2.creerOffre(p1,9000,9000);
        System.out.println(c2.getPseudo()+" a fait une enchère!\n" +p1);
        p1.arreterEnchere();
        System.out.println(c2);
    }
}
