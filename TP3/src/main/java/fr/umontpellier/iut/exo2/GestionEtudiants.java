package fr.umontpellier.iut.exo2;

public class GestionEtudiants {

    public static void copier(Etudiant e1, Etudiant e2){
        e1.setNom(e2.getNom());
        e1.setPrenom(e2.getPrenom());
        e1.setMail(e2.getMail());
        e1.setAdresse(e2.getAdresse());
        e1.setDateNaissance(e2.getDateNaissance());
    }

    public static void main(String[] args) {
        //Etudiant Steb = new Etudiant("Schrader","Stéban","stéban.schrader@etu.umontpellier.fr","Restinclieres tu connais",17,5,2005);
        Etudiant lolo = new Etudiant("Lolo","Lolo","lolo@wanadoo.fr","1 rue lolo",1,1,2001);
//        System.out.println(lolo);
//        lolo.setNom("LeGrand");
//        System.out.println(lolo);

        Etudiant toto = new Etudiant("Lolo","Lolo","lolo@wanadoo.fr","1 rue lolo",1,1,2001);
//        System.out.println(lolo == toto); Ils sont différents cars, ils n'ont pas la meme adresse mémoire

        toto = lolo;
        toto.setNom("LePetit");
//        System.out.println(lolo);

        copier(toto,lolo);
//        System.out.println(toto);
//        System.out.println(lolo);
//        System.out.println(toto == lolo);

        Departement monDepInfo = new Departement("Informatique","IUT-Montpellier");
        Etudiant fifi = new Etudiant("Fifi","Fifi","fifi@wanadoo.fr","1 rue fifi",1,1,2001);
        Etudiant riri = new Etudiant("Riri","Riri","Riri@wanadoo.fr","1 rue riri",1,1,2001);
        monDepInfo.inscrire(lolo);
        monDepInfo.inscrire(fifi);
        monDepInfo.inscrire(toto);
        monDepInfo.inscrire(riri);

//        System.out.println(monDepInfo);

        monDepInfo.desinscrire(toto);
        Matiere maths = new Matiere("maths",5);
        Matiere dev = new Matiere("dev",6);
        Matiere bd = new Matiere("bd",4);

        fifi.noter(maths,18);
        fifi.noter(dev,16);
        fifi.noter(bd,14);
        System.out.println(fifi.calculerMoyenne());

//        System.out.println(monDepInfo);
        //Lolo a été désinscrit, car toto et lolo on la meme adresse mémoire
    }
}
