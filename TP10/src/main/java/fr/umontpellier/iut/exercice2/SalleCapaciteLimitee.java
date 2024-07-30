package fr.umontpellier.iut.exercice2;

import fr.umontpellier.iut.exercice1.Personne;
import fr.umontpellier.iut.exercice1.SalleAttente;
import fr.umontpellier.iut.exercice2.exceptions.CapaciteMaximaleAtteinteException;

public class SalleCapaciteLimitee{
	private SalleAttente s;
	private int capacite;
	private int effectif;

	public SalleCapaciteLimitee(int capacite){
		s = new SalleAttente();
		this.capacite = capacite;
		effectif = 0;	
	}

	public void entrer(Personne p, int priorite) throws CapaciteMaximaleAtteinteException {
		if(effectif < capacite){
			s.entrer(p,priorite);
			effectif++;
		} else
			throw new CapaciteMaximaleAtteinteException(capacite);
	}
}