package fr.umontpellier.iut;

import java.time.LocalDate;
import java.util.*;

public class Entreprise {
    private double bonusTotal;
    private Collection<Employe> lePersonnel;

    public Entreprise() {
        lePersonnel = new ArrayList<>();
    }

    public void embaucher(Employe e, LocalDate dateEmbauche) {
        lePersonnel.add(e);
        e.setDateEmbauche(dateEmbauche);
    }

    public void licencier(Employe e) {
        lePersonnel.remove(e);
        e.setDateEmbauche(null);
    }

    public Collection<Employe> getEmployesOrdonnes() {
        Comparator<Employe> comparateurNomEtNrInsee =  (e1, e2) -> {
            int compareNom = e1.getNom().compareTo(e2.getNom());

            if(compareNom == 0)
                return e2.getNrINSEE().compareTo(e1.getNrINSEE());
            else
                return compareNom;
        };

        TreeSet<Employe> employesOrdonnes = new TreeSet<>(comparateurNomEtNrInsee);
        employesOrdonnes.addAll(lePersonnel);

        return employesOrdonnes;
    }

    public Collection<Employe> getEmployesDansDesordre() {
        return new HashSet<>(lePersonnel);
    }

    public Collection<Employe> getLePersonnel() {
        return lePersonnel;
    }

    public double getBonusTotal() {
        return bonusTotal;
    }

    public void setBonusTotal(double bonusTotal) {
        this.bonusTotal = bonusTotal;
    }

    public void distribuerBonus() {
        Comparator<Employe> anciennete = Comparator.comparing(Employe::getDateEmbauche);
        PriorityQueue<Employe> employesOrdreAncienete = new PriorityQueue<>(anciennete);
        employesOrdreAncienete.addAll(lePersonnel);

        for (Employe e : employesOrdreAncienete){
            double montantBonus = 3.5 * e.getMoisAnciennete();
            if(bonusTotal - montantBonus < 0){
                e.setBonus(e.getBonus() + bonusTotal);
                bonusTotal = 0;
                break;
            }

            bonusTotal -= montantBonus;
            e.setBonus(e.getBonus() + montantBonus);
        }

    }

    public void remercier(int n) {
        Comparator<Employe> anciennete = (e1, e2) -> e2.getDateEmbauche().compareTo(e1.getDateEmbauche());
        PriorityQueue<Employe> queue = new PriorityQueue<>(anciennete);
        queue.addAll(lePersonnel);

        for (int i = 0; i < n && !queue.isEmpty(); i++) {
            Employe employe = queue.poll();
            lePersonnel.removeIf(e -> e == employe);
        }
    }



    @Override
    public String toString() {
        StringBuilder str;
        if(lePersonnel.isEmpty())
            str = new StringBuilder("L'entreprise n'as pas d'employés");
        else{
            str = new StringBuilder("La liste du personnel de l'entreprise est la suivante:\n");
            for(Employe e : lePersonnel)
                str.append("    ").append(e.getNom()).append(" ").append(e.getNrINSEE()).append(" Embauché le ").append(e.getDateEmbauche()).append("\n");
        }
        return str.toString();
    }
}
