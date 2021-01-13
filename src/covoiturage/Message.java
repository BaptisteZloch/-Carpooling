/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covoiturage;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.Collections;

/**
 *
 * @author admin
 */
public class Message {
// Attributd de la classe

    private String emeteur; //l'émetteur du message (mail) 
    private String destinataire; //le destinataire
    private LocalDate date; //date  d'écriture du message
    private String contenu; //texte du message
    private boolean vu; //message lu ou pas

    // CONSTRUCTEUR DE LA CLASSE
    /**
     *
     * @param emeteur
     * @param destinataire
     * @param date
     * @param contenu
     */
    public Message(String emeteur, String destinataire, LocalDate date, String contenu) {
        this.emeteur = emeteur;//mail emetteur
        this.destinataire = destinataire;//mail destinataire
        this.date = date;
        this.contenu = contenu;
        this.vu = false;//le message n'est pas vu
    }

    // recup date d'émission du message
    /**
     *
     * @return
     */
    public LocalDate getDate() {
        return date;
    }

    //récup le contenu
    /**
     *
     * @return
     */
    public String getContenu() {
        return contenu;
    }

    //modifier la valeur de vu 
    /**
     *
     * @param vu
     */
    public void setVu(boolean vu) {
        this.vu = vu;
    }

    // récup nom de l'emetteur
    /**
     *
     * @return
     */
    public String getEmeteur() {
        return emeteur;
    }

    // recup si le message a été vu ou pas
    /**
     *
     * @return
     */
    public boolean getVu() {
        return vu;
    }

    // récup le nom destinataire (mail) 
    /**
     *
     * @return
     */
    public String getDestinataire() {
        return destinataire;
    }

    /**
     *
     * @return
     */
    public String versFichiers() {
        return emeteur + "\n" + destinataire + "\n" + date + "\n" + contenu + "\n" + vu + "\n";
    }

    /**
     *
     * @return
     */
    public String toStringList() {
        return emeteur + "   " + date + "   " + destinataire;
    }

    @Override
    public String toString() {
        return "Emetteur : " + emeteur + "\nDestinataire : " + destinataire + "\nDate : " + date + "\nContenu : " + contenu + "\n";
    }

}
