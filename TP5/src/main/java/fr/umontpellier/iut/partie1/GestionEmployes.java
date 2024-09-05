package fr.umontpellier.iut.partie1;

public class GestionEmployes {

    public static void main(String[] args) {
//        Employe e1 = new Employe("1546546878464","Charles",1,20,160);
//        Employe e2 = new Employe("4984984","Bobert Kurva Yapierdole",66,80,9000);
//        Employe e3 = new Employe("9468212791","Pediluve",20,12,2);
//        Employe e4 = new Employe("9468212792","Kurva pingvin",22,15,2);
//        System.out.printf("%s\n%s\n%s\n%s", e1, e2, e3, e4);

//       Commercial ec1 = new Commercial("98798465498","Bilo",21,21,21,999999,90.0);
//       ec1.negocierTransaction(1);
//
//       Fabricant ef1 = new Fabricant("212121","Théodore",10000,10000,9,10000,100.0);
//       ef1.fabriquerProduits(10000);
//
//       Technicien et1 = new Technicien("123456789","Charles Autofrèze",1,1,1);
//       et1.effectuerTacheTechnique();

        Employe e5 = new Fabricant("123","Toto",69498498,10,10,10,10);
        System.out.println(e5.getSalaireBrut());
        System.out.println(e5.getSalaireNet());
    }

}
