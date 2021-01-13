/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covoiturage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 *
 * @author tserre
 */
public class Utilisateur {

    private String nom;
    private float noteMoyenne;
    private String mail;
    private String mdp;
    private Photo pdp;
    private ArrayList<Avis> tabAvis = new ArrayList<>();

    /**
     *
     * @param nom
     * @param mail
     * @param mdp
     */
    public Utilisateur(String nom, String mail, String mdp) {
        this.nom = nom;
        this.mail = mail;
        this.mdp = mdp;
    }
    
    /**
     *
     * @param npdp
     */
    public void changerPhoto(Photo npdp){
        pdp=npdp;
    }

    /**
     *
     * @param mdp
     */
    public void setMdp(String mdp){
        this.mdp=mdp;
    }
    /**
     *
     * @param mdp
     * @return
     */
    public boolean testmdp(String mdp) {
        return mdp.equals(this.mdp);
    }

    /**
     *
     * @param pmail
     * @return
     */
    public boolean testmail(String pmail) {
        return mail.equals(pmail);
    }
    
    /**
     *
     * @param photoprofile
     */
    public void setPdp(Photo photoprofile){
        pdp=photoprofile;
    }

    /**
     *
     * @return
     */
    public Photo getPdp() {
        return pdp;
    }

    /**
     *
     * @param pmail
     * @return
     */
    public boolean contientMail(String pmail) {
        return mail.contains(pmail);
    }

    /**
     *
     * @param avis
     */
    public void setTabAvis(ArrayList<Avis> avis) {
        tabAvis = avis;
        this.calculMoyenne();
    }

    /**
     *
     * @return
     */
    public float getNoteMoyenne() {
        return noteMoyenne;
    }

    /**
     *
     */
    public void calculMoyenne() {
        float note = 0;
        Iterator<Avis> it = tabAvis.iterator();
        while (it.hasNext()) {
            Avis avis = it.next();
            note = note + avis.getNote();
            noteMoyenne = note / tabAvis.size();
        }
    }

    /**
     *
     * @param avis
     */
    public void setAvis(Avis avis) {
        tabAvis.add(avis);
    }

    /**
     *
     * @return
     */
    public String getNom() {
        return nom;
    }

    /**
     *
     * @return
     */
    public String getMail() {
        return mail;
    }

    /**
     *
     * @return
     */
    public ArrayList<Avis> getTabAvis() {
        return tabAvis;
    }

    /**
     *
     * @return
     */
    public String getMdp() {
        return mdp;
    }

    /**
     *
     * @param noteMoyenne
     */
    public void setNoteMoyenne(float noteMoyenne) {
        this.noteMoyenne = noteMoyenne;
    }

    /**
     *
     * @return
     */
    public String toStringList() {
        return nom + "   " + noteMoyenne + "/5 "/*\nLes avis : " + tabAvis*/;
    }

    @Override
    public String toString() {
        return "Nom : " + nom + "\nNote moyenne : " + noteMoyenne + "/5\nLes avis : \n" + tabAvis;
    }
}
