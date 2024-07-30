package fr.umontpellier.iut.exercice1;

public class SalleAttente{
	private FilePriorite filePriorite;

	public SalleAttente(){
		filePriorite = new FilePriorite();
	}

	public void entrer(Personne p, int priorite){
		filePriorite.ajouter(new PersonnePriorisee(p, priorite));
	}

	public Personne sortir(){
		return filePriorite.enlever().getPersonne();
	}




}