/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covoiturage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author tserre
 */
public class Conducteur extends Utilisateur {
//ATTRIBUTS DE LA CLASSE

    private String vehicule;
    private boolean animal;
    private boolean enfant;
    private ArrayList<Trajet> tabTrajet = new ArrayList<>();

    //CONSTRUCTEUR
    /**
     *
     * @param nom
     * @param mail
     * @param mdp
     */
    public Conducteur(/*String vehicule, */String nom, String mail, String mdp) {
        super(nom, mail, mdp);
        //this.vehicule = vehicule;
    }

    /**
     *
     * @param car
     */
    public void changerVehicule(String car) {
        vehicule = car;
    }

    /**
     *
     * @param traj
     */
    public void setTrajet(Trajet traj) { //setter pour modifier l'arrayList
        this.tabTrajet.add(traj);
    }

    //Setter pour modifier le fait qu'un conducteur accepte ou non un animal
    //ou un enfant 
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

    //Setter pour modifier le vehicule du conducteur
    /**
     *
     * @param vehicule
     */
    public void setVehicule(String vehicule) {
        this.vehicule = vehicule;
    }

    //Récup le nom du véhicule
    /**
     *
     * @return
     */
    public String getVehicule() {
        return vehicule;
    }

    //supprimer un trajet de l'array List
    /**
     *
     * @param trajet
     */
    public void supprTrajet(Trajet trajet) {
        tabTrajet.remove(trajet);
    }

    /**
     *
     * @param tabTrajet
     */
    public void setTabTrajet(ArrayList<Trajet> tabTrajet) {
        this.tabTrajet = tabTrajet;
    }

    // récup l'arrayList des trajets
    /**
     *
     * @return
     */
    public ArrayList<Trajet> getTabTrajet() {
        return tabTrajet;
    }

    /**
     *
     * @return
     */
    public String versFichiers() {
        return this.getNom() + "\n" + this.getNoteMoyenne() + "\n" + this.getMail() + "\n" + this.getMdp() + "\n" + vehicule + "\n" + super.getPdp().getNomFichier() + "\n";
    }

    /**
     *
     * @return
     */
    @Override
    public String toStringList() {
        return super.toStringList() + "   " + vehicule;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return super.toString() + "\nVéhicule : " + vehicule + "\n" + tabTrajet.size() + " Trajets\nAnimal autorisé :" + animal + "\nEnfant autorisé:" + enfant;
    }

}
