/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covoiturage;

/**
 *
 * @author admin
 */
public class Administrateur {

    private String nom;
    private String mail;
    private String mdp;

    /**
     *
     */
    public Administrateur() {
        nom = "admin";
        mail = "admin.blablacarpe@gmail.com";
        mdp = "Dxfj8k!";
    }
    
    /**
     *
     * @param pmail
     * @return
     */
    public boolean testMail(String pmail){
        return mail.equals(pmail); 
    }
    
    /**
     *
     * @param pmdp
     * @return
     */
    public boolean testMdp(String pmdp){
        return mdp.equals(pmdp); 
    }
    
    /**
     *
     * @return
     */
    public String versFichier(){
        return nom+"\n"+mail+"\n"+mdp+"\n";
    }

}
