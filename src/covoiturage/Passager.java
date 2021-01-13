/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covoiturage;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author tserre
 */
public class Passager extends Utilisateur {
    // ATTRIBUTS DE LA CLASSE

    private boolean animal;
    private boolean enfant;
    private int placesPrises = 1;
    private ArrayList<Trajet> mesTrajets = new ArrayList<>();
    // CONSTRUCTEUR

    /**
     *
     * @param nom
     * @param mail
     * @param mdp
     */
    public Passager(String nom, String mail, String mdp) {
        super(nom, mail, mdp);
    }

    // récup le nbr de places prises par un passager si il a un enfant et/ou
    // un animal
    /**
     *
     * @return
     */
    public int getplacesPrises() {
        if (animal == true) {
            placesPrises = placesPrises + 1;
        }
        if (enfant == true) {
            placesPrises = placesPrises + 1;
        }
        placesPrises = 1;
        return placesPrises;
    }

    /**
     *
     * @param animal
     */
    public void setAnimal(boolean animal) {
        this.animal = animal;
    }

    /**
     *
     * @param enfant
     */
    public void setEnfant(boolean enfant) {
        this.enfant = enfant;
    }

    /**
     *
     * @return
     */
    public ArrayList<Trajet> getMesTrajets() {
        return mesTrajets;
    }

    /**
     *
     * @param traj
     */
    public void addTrajet(Trajet traj) {
        mesTrajets.add(traj);
    }

    //getter si il a un animal
    /**
     *
     * @return
     */
    public boolean isAnimal() {
        return animal;
    }

    // getter si il a un enfant
    /**
     *
     * @return
     */
    public boolean isEnfant() {
        return enfant;
    }

    /**
     *
     * @return
     */
    public String versFichiers() {
        return this.getNom() + "\n" + this.getNoteMoyenne() + "\n" + this.getMail() + "\n" + this.getMdp() + "\n" + super.getPdp().getNomFichier() + "\n" /*+ this.getTabAvis() + "\n"*/;
    }

    /**
     *
     * @return
     */
    public String toStringList() {
        return super.toStringList();
    }

    @Override
    public String toString() {
        return super.toString() + "\nAnimal : " + animal + "\nEnfant : " + enfant;
    }

}
