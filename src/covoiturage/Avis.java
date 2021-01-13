/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covoiturage;

/**
 *
 * @author tserre
 */
public class Avis {
// ATTRIBUTS DE LA CLASSE

    private String texte;  //Contenu de l'avis
    private int note; // Note sur 5 
    private String auteur; // auteur de l'avis 
    private String destinataire; // destinataire de l'avis 

    //CONSTRUCTEUR DE LA CLASSE AVIS 
    /**
     *
     * @param note
     * @param texte
     * @param auteur
     * @param destinataire
     */
    public Avis(int note, String texte, String auteur, String destinataire) {
        this.texte = texte;
        this.note = note;
        this.auteur = auteur;
        this.destinataire = destinataire;
    }

    public String getTexte() {
        return texte;
    }

    /**
     *
     * @return
     */
    public String getAuteur() { //récup nom auteur 
        return auteur;
    }

    /**
     *
     * @param pmail
     * @return
     */
    public boolean testMail(String pmail) {
        return destinataire.equals(pmail);
    }

    /**
     *
     * @return
     */
    public String getDestinataire() { //récup nom destinataire
        return destinataire;
    }

    /**
     *
     * @return
     */
    public int getNote() {//permet de récupérer la note 
        return note;
    }

    /**
     *
     * @return
     */
    public String versFichier() {
        return destinataire + "\n" + note + "\n" + texte + "\n" + auteur + "\n";
    }

    /**
     *
     * @return
     */
    public String toStringList() {
        return auteur + "   " + note;
    }

    @Override
    public String toString() {
        return "Destinataire : " + destinataire + "\nNote : " + note + "/5\nContenu : " + texte + "\nAuteur : " + auteur + "\n";
    }
}
