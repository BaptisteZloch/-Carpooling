/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covoiturage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 *
 * @author tserre
 */
public class Trajet {

    private String villeDepart;
    private String villeArrivee;
    private int placesDispo;
    private int placesPrises = 0;
    private Conducteur pilote;
    private LocalDate date;
    private int prix;
    private ArrayList<Passager> tabPassager = new ArrayList<>();
    private ArrayList<Passager> tabPassagerAtt = new ArrayList<>();
    private boolean fait;

    /**
     *
     * @param villeDepart
     * @param villeArrivee
     * @param placesDispo
     * @param pilote
     * @param date
     * @param prix
     */
    public Trajet(String villeDepart, String villeArrivee, int placesDispo, Conducteur pilote, LocalDate date, int prix) {
        this.villeDepart = villeDepart;
        this.villeArrivee = villeArrivee;
        this.placesDispo = placesDispo;
        this.pilote = pilote;
        this.date = date;
        this.prix = prix;
        fait = !date.isAfter(LocalDate.now());//test si le trajet est effectué 
    }

    public String getVilleDepart() {
        return villeDepart;
    }

    public String getVilleArrivee() {
        return villeArrivee;
    }

    public int getPlacesDispo() {
        return placesDispo;
    }

    public int getPlacesPrises() {
        return placesPrises;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getPrix() {
        return prix;
    }

    
    
    /**
     *
     * @param tabPassager
     */
    public void setTabPassager(ArrayList<Passager> tabPassager) {
        this.tabPassager = tabPassager;
    }

    /**
     *
     * @param placesPrises
     */
    public void setPlacesPrises(int placesPrises) {
        this.placesPrises = placesPrises;
    }

    /**
     *
     */
    public void varDispoPlus() {
        Iterator<Passager> it = tabPassagerAtt.iterator();
        while (it.hasNext()) {
            this.placesPrises = placesPrises + it.next().getplacesPrises();
        }
    }

    /**
     *
     * @param pass
     */
    public void ajoutPlacePrise(Passager pass) {
        int place = placesPrises;
        placesPrises = pass.getplacesPrises() + place;
    }

    /**
     *
     * @param pilote
     */
    public void setPilote(Conducteur pilote) {
        this.pilote = pilote;
    }

    /**
     *
     * @param pmail
     * @return
     */
    public boolean testMail(String pmail) {
        return pilote.getMail().equals(pmail);
    }

    /**
     *
     * @return
     */
    public boolean testDispo() {
        return (placesPrises < placesDispo);
    }

    /**
     *
     * @param pass
     */
    public void setPassager(Passager pass) {
        this.tabPassager.add(pass);
    }

    /**
     *
     * @param tabPassagerAtt
     */
    public void setTabPassagerAtt(ArrayList<Passager> tabPassagerAtt) {
        this.tabPassagerAtt = tabPassagerAtt;
    }

    /**
     *
     * @param pass
     */
    public void setPassagerAtt(Passager pass) {
        this.tabPassagerAtt.add(pass);
    }

    /**
     *
     * @param villeDep
     * @return
     */
    public boolean testVilleDepart(String villeDep) {
        return villeDepart.equals(villeDep);
    }

    /**
     *
     * @param villeArr
     * @return
     */
    public boolean testVilleArrive(String villeArr) {
        return villeArrivee.equals(villeArr);
    }

    /**
     *
     * @param pdate
     * @return
     */
    public boolean testDate(LocalDate pdate) {
        return date.equals(pdate);
    }

    /**
     *
     * @return
     */
    public ArrayList<Passager> getTabPassagerAtt() {
        return tabPassagerAtt;
    }

    /**
     *
     * @return
     */
    public ArrayList<Passager> getTabPassager() {
        return tabPassager;
    }

    /**
     *
     * @param nom
     * @return
     */
    public Passager rechercherPassager(String nom) {
        for (int i = 0; i < tabPassager.size(); i++) {
            Passager pass = tabPassager.get(i);
            if (pilote.testmail(nom) == true) {
                return pass;
            }
        }
        return null;
    }

    /**
     *
     * @return
     */
    public Conducteur getPilote() {
        return pilote;
    }

    /**
     *
     * @param nom
     * @return
     */
    public boolean testNompass(String nom) {//methode de test si le nom rentré est dans le tableau de trajet i
        Iterator<Passager> it = tabPassager.iterator();
        while (it.hasNext()) {
            if (it.next().getNom().equals(nom)) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @return
     */
    public String versFichiers() {
        String listeNom = "";
        for (int i = 0; i < tabPassager.size(); i++) {
            if (tabPassager.get(i) != null) {
                listeNom = (tabPassager.get(i).getMail()) + ",";
            }
        }
        String listeNomAtt = "";
        for (int i = 0; i < tabPassagerAtt.size(); i++) {
            if (tabPassagerAtt.get(i) != null) {
                listeNomAtt += (tabPassagerAtt.get(i).getMail()) + ",";
            }
        }
        return villeDepart + "\n" + villeArrivee + "\n" + placesDispo + "\n" + placesPrises + "\n" + pilote.getMail() + "\n" + date + "\n" + prix + "\n" + listeNom + "\n" + listeNomAtt + "\n";
    }

    /**
     *
     * @param pass
     */
    public void supprPassagerAtt(Passager pass) {
        tabPassagerAtt.remove(pass);
    }

    /**
     *
     * @param pass
     */
    public void addPassager(Passager pass) {
        tabPassager.add(pass);
    }

    /**
     *
     * @param pass
     */
    public void addPassagerAtt(Passager pass) {
        tabPassagerAtt.add(pass);
    }

    /**
     *
     * @return
     */
    public boolean isFait() {
        return fait;
    }

    /**
     *
     * @param fait
     */
    public void setFait(boolean fait) {
        this.fait = fait;
    }

    /**
     *
     * @return
     */
    public String toStringList() {
        return pilote.getNom() + "   " + villeDepart + "   " + villeArrivee + "   " + date + "   " + prix + "€";
    }

    public String toStringNomsPassAtt() {
        String listeNomAtt = "";
        for (int i = 0; i < tabPassagerAtt.size(); i++) {
            if (tabPassagerAtt.get(i) != null) {
                listeNomAtt += (tabPassagerAtt.get(i).getNom()) + "\n";
            }
        }
        return listeNomAtt;
    }

    public String stringDate(){
        return date+ " "; 
        
    }
    public String toStringNomsPass() {
        String listeNom = "";
        for (int i = 0; i < tabPassager.size(); i++) {
            if (tabPassager.get(i) != null) {
                listeNom = (tabPassager.get(i).getNom()) + "\n";
            }
        }
        return listeNom;
    }

    @Override
    public String toString() {
        String listeNom = "";
        for (int i = 0; i < tabPassager.size(); i++) {
            if (tabPassager.get(i) != null) {
                listeNom = (tabPassager.get(i).getMail()) + "  ";
            }
        }
        String listeNomAtt = "";
        for (int i = 0; i < tabPassagerAtt.size(); i++) {
            if (tabPassagerAtt.get(i) != null) {
                listeNomAtt += (tabPassagerAtt.get(i).getMail()) + "  ";
            }
        }
        return "Départ : " + villeDepart + "\nArrivée : " + villeArrivee + "\nPlaces disponibles : " + placesDispo + "\nPlaces prises : " + placesPrises + "\nConducteur : " + pilote.getNom() + "\nVéhicule : " + pilote.getVehicule() + "\nDate : " + date + "\nPrix : " + prix + "€\n" + "Les passagers : \n - Acceptés : " + listeNom + "\n - En attente : " + listeNomAtt + "\n Effectué : " + fait + "\n";
    }

}
