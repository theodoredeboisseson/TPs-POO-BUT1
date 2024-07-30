package fr.umontpellier.iut.exercice1;

public class App {
    public static void main(String[] args) {
        SalleAttente s = new SalleAttente();
	Personne p1 = new Personne("Roberto");
	Personne p2 = new Personne("Pedro");

	s.entrer(p1,4);
	s.entrer(p2,3);

	System.out.println(s.sortir());
	System.out.println(s.sortir());
    }
}
