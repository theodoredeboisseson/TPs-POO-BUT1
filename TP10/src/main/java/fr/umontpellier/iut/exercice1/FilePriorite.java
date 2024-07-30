package fr.umontpellier.iut.exercice1;

import java.util.ArrayList;

public class FilePriorite{
	private ArrayList<PersonnePriorisee> file;

	public FilePriorite(){
		file = new ArrayList<>();
	}

	public void ajouter(PersonnePriorisee d){
		file.add(d);
	}

	public PersonnePriorisee enlever(){
		if(file.isEmpty())
			throw new ArrayIndexOutOfBoundsException("La liste est vide");

		int index = 0;
		int valeurPetite = file.get(0).getNumeroPassage();
		for(int i = 1; i < file.size(); i++)
			if(file.get(i).getNumeroPassage() < valeurPetite){
				index = i;
				valeurPetite = file.get(index).getNumeroPassage();
			}
				

		return file.remove(index);
	}

}