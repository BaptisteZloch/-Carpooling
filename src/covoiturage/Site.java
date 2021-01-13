/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covoiturage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import static java.time.LocalDate.now;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import javax.swing.JList;

/**
 *
 * @author tserre
 */
public class Site {

    // ATTRIBUTS DE LA CLASSE
    private String nomSite;
    private ArrayList<Conducteur> tabConducteur = new ArrayList<>();
    private ArrayList<Passager> tabPassager = new ArrayList<>();
    private ArrayList<Trajet> tabTrajet = new ArrayList<>();
    private ArrayList<Message> tabMessages = new ArrayList<>();
    private ArrayList<Avis> tabAvis = new ArrayList<>();
    private Utilisateur ActivUser;
    private Administrateur admin = new Administrateur();

    //CONSTRUCTEUR
    /**
     *
     * @param nomSite
     */
    public Site(String nomSite) {
        this.nomSite = nomSite;
    }

    /**
     *
     * @return
     */
    public Utilisateur getActivUser() {
        return ActivUser;
    }

    /**
     *
     * @return
     */
    public ArrayList<Conducteur> getTabConducteur() {
        return tabConducteur;
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
     * @return
     */
    public ArrayList<Trajet> getTabTrajet() {
        return tabTrajet;
    }

    /**
     *
     * @return
     */
    public ArrayList<Message> getTabMessages() {
        return tabMessages;
    }

    /**
     *
     * @return
     */
    public ArrayList<Avis> getTabAvis() {
        return tabAvis;
    }

    //faite
    /**
     *
     * @param mail
     * @param mdp
     * @return
     */
    public boolean connexionPassager(String mail, String mdp) {
        Passager pass;
        pass = this.testExistePassa(mail); // si il est dans la liste
        ActivUser = pass;
        if (pass != null) {
            if (pass.testmdp(mdp) == true) { // verification du mdp
                return true; // user connecté
            }
        }
        return false;
    }

    public String GetTypeUser(String mail) { // Afin de déterminer à partir de n'importe quel mail si 
        Passager pass;                      // ce dernier correspond à un Passager ou à u conducteur
        if (this.testExistePassa(mail) != null) {
            return "Passager";
        } else if (this.testExisteConduc(mail) != null) {
            return "Conducteur";
        } else {
            return "Inconnu";
        }
    }
    
    

    //faite
    /**
     *
     * @param mail
     * @param mdp
     * @return
     */
    public boolean connexionConducteur(String mail, String mdp) {
        Conducteur conduc;
        conduc = this.testExisteConduc(mail);//test si existe dans la liste
        ActivUser = conduc;
        if (conduc != null) {//il existe un conducteur dans la liste
            if (conduc.testmdp(mdp) == true) {//on regarde si le mdp est le bon
                //System.out.println(conduc.getMdp());
                return true;
            }
        }
        return false;
    }

    //faite
    /**
     *
     * @param mail
     * @param mdp
     * @return
     */
    public boolean connexionAdmin(String mail, String mdp) {
        Administrateur admin1 = new Administrateur();
        if (admin1.testMail(mail) && admin1.testMdp(mdp)) {
            admin = admin1;
            return true;
        }
        return false;
    }

    //faite
    /**
     *
     * @param liste
     * @param index
     */
    public void navigAdmin(JList liste, int index) {
        switch (index) {
            case 0:
                String donnees[] = new String[tabConducteur.size()];
                for (int i = 0; i < tabConducteur.size(); i++) {
                    donnees[i] = tabConducteur.get(i).toStringList();
                }
                liste.setListData(donnees);//affichage dans le liste
                break;
            case 1:
                String donnees1[] = new String[tabPassager.size()];
                for (int i = 0; i < tabPassager.size(); i++) {
                    donnees1[i] = tabPassager.get(i).toStringList();
                }
                liste.setListData(donnees1);//affichage dans le liste
                break;
            case 2:
                String donnees2[] = new String[tabTrajet.size()];
                for (int i = 0; i < tabTrajet.size(); i++) {
                    donnees2[i] = tabTrajet.get(i).toStringList();
                }
                liste.setListData(donnees2);//affichage dans le liste
                break;
            case 3:
                String donnees3[] = new String[tabAvis.size()];
                for (int i = 0; i < tabAvis.size(); i++) {
                    donnees3[i] = tabAvis.get(i).toStringList();
                }
                liste.setListData(donnees3);//affichage dans le liste
                break;
            case 4:
                String donnees4[] = new String[tabMessages.size()];
                for (int i = 0; i < tabMessages.size(); i++) {
                    donnees4[i] = tabMessages.get(i).toStringList();
                }
                liste.setListData(donnees4);//affichage dans le liste
                break;
        }
    }

    //faite
    /**
     *
     * @param mail
     * @param mdp
     * @param nom
     * @param vehicule
     * @param pdp
     */
    public void inscription(String mail, String mdp, String nom, String vehicule, Photo pdp) {//inscription conducteur
        Conducteur conduct = new Conducteur(nom, mail, mdp);
        ActivUser = conduct;
        conduct.setVehicule(vehicule);
        conduct.setPdp(pdp);
        tabConducteur.add(conduct);
    }

    //faite
    /**
     *
     * @param mail
     * @param mdp
     * @param nom
     * @param pdp
     */
    public void inscription(String mail, String mdp, String nom, Photo pdp) {//inscription passager
        Passager pass = new Passager(nom, mail, mdp);
        pass.setPdp(pdp);
        ActivUser = pass;
        tabPassager.add(pass);
    }

    /**
     *
     * @param liste
     * @return
     */
    public ArrayList<Trajet> toutTrajets(JList liste) {
        ArrayList<Trajet> tabtampon = rechercherlisteTrajets();
        String donnees[] = new String[tabtampon.size()];
        for (int i = 0; i < tabtampon.size(); i++) {
            donnees[i] = tabtampon.get(i).toStringList();
        }
        liste.setListData(donnees);//affichage dans le liste
        return tabtampon;
    }

    /**
     *
     * @param voit
     */
    public void changerVoit(String voit) {
        ((Conducteur) ActivUser).changerVehicule(voit);
    }

    //conducteur //faite //marche pas 
    /**
     *
     * @param villeD
     * @param villeA
     * @param places
     * @param date
     * @param prix
     * @param animal
     * @param enfant
     * @throws ParseException
     */
    public void proposerTrajet(String villeD, String villeA, int places, LocalDate date, int prix, boolean animal, boolean enfant) throws ParseException {
        Trajet trajet = new Trajet(villeD, villeA, places, ((Conducteur) ActivUser), date, prix);
        ((Conducteur) ActivUser).setAnimal(animal);
        ((Conducteur) ActivUser).setEnfant(enfant);
        trajet.setPilote((Conducteur) ActivUser);
        ((Conducteur) ActivUser).setTrajet(trajet);
        tabTrajet.add(trajet);
    }

    //Conducteur   //faite
    /**
     *
     * @param trajet
     * @param listetraj
     */
    public void supprimerTrajet(Trajet trajet, JList listetraj) {
        ((Conducteur) ActivUser).supprTrajet(trajet);
        tabTrajet.remove(trajet);

//        String donnees[] = new String[((Conducteur) ActivUser).getTabTrajet().size()];
//        for (int i = 0; i < ((Conducteur) ActivUser).getTabTrajet().size(); i++) {
//            donnees[i] = ((Conducteur) ActivUser).getTabTrajet().get(i).toStringList();//mise a jour de la liste
//        }
//        listetraj.setListData(donnees);//affichage dans le liste
    }

    //passager  //faite
    /**
     *
     * @param liste
     * @param VilleDep
     * @param VilleArriv
     * @param date
     * @param enfant
     * @param animal
     * @return
     */
    public ArrayList<Trajet> rechercherTrajet(JList liste, String VilleDep, String VilleArriv, LocalDate date, boolean enfant, boolean animal) {
        ((Passager) ActivUser).setAnimal(animal);
        ((Passager) ActivUser).setEnfant(enfant);
        ArrayList<Trajet> tabtampon = rechercherlisteTrajets(VilleDep, VilleArriv, date);
        String donnees[] = new String[tabtampon.size()];
        for (int i = 0; i < tabtampon.size(); i++) {
            donnees[i] = tabtampon.get(i).toStringList();
        }
        liste.setListData(donnees);//affichage dans le liste
        return tabtampon;
    }

    /**
     *
     * @param liste
     * @return
     */
    public ArrayList<Avis> affichageAvisUser(JList liste) {

        String donnees[] = new String[ActivUser.getTabAvis().size()];
        for (int i = 0; i < ActivUser.getTabAvis().size(); i++) {
            donnees[i] = ActivUser.getTabAvis().get(i).toStringList();
        }
        liste.setListData(donnees);//affichage dans le liste
        return ActivUser.getTabAvis();
    }

    //passager //faite
    /**
     *
     * @param trajet
     */
    public void reserverTrajet(Trajet trajet) { //reservation il clic sur la ligne du trajet qu'il souhaite
        trajet.setPassagerAtt(((Passager) ActivUser));//ajout en liste d'attente
    }

    //faite
    /**
     *
     */
    public void flushListes() {
        tabConducteur.clear();
        tabPassager.clear();
        tabTrajet.clear();
        tabMessages.clear();
        tabAvis.clear();
    }

    //faite
    /**
     *
     * @param trajet
     * @param pass
     */
    public void supprimerPassager(Trajet trajet, Passager pass) {
        trajet.supprPassagerAtt(pass);//on ajoute ce qui n'ont pas été viré
        this.contacter("Vous n'avez pas été accepter dans le trajet : " + trajet.toStringList(), pass);//previens le passager qu'il n'a pas été accepté
        //System.out.println("passager supprimé ");
    }

    //faite
    /**
     *
     * @param trajet
     * @param pass
     */
    public void accepterPassager(Trajet trajet, Passager pass) {
        trajet.supprPassagerAtt(pass);//l'enleve de la liste d'attente 
        trajet.addPassager(pass);//l'ajoute a la liste des passagers du trajet = accepté 
        trajet.ajoutPlacePrise(pass);
        this.contacter("Vous avez été accepter dans le trajet : " + trajet.toStringList(), pass);//previens le passager qu'il a été accepté
        //System.out.println("passager accepté ");
    }

    /**
     *
     * @param mdpnew
     */
    public void changermdp(String mdpnew) {
        ActivUser.setMdp(mdpnew);
    }

    //pour les 2 //faite
    /**
     *
     * @param listemsg
     * @return
     */
    public ArrayList<Message> chargementMessages(JList listemsg) {
        ArrayList<Message> tabmsg = new ArrayList<>();//tableau des messages ou l'utilisateur est destinataire
        for (int i = 0; i < tabMessages.size(); i++) {
            if (tabMessages.get(i).getDestinataire().equals(ActivUser.getMail()) && tabMessages.get(i).getVu() == false) {//test si destinataire
                tabmsg.add(tabMessages.get(i));//rempli le tableau
            }
        }
        String donnees[] = new String[tabmsg.size()];
        for (int i = 0; i < tabmsg.size(); i++) {
            donnees[i] = tabmsg.get(i).toStringList();
        }
        listemsg.setListData(donnees);//affichage dans le liste
        return tabmsg;
    }

    /**
     *
     * @return
     */
    public int messagesNonLus() {
        int compteur = 0;
        for (int i = 0; i < tabMessages.size(); i++) {
            if (tabMessages.get(i).getDestinataire().equals(ActivUser.getMail()) && tabMessages.get(i).getVu() == false) {//test si destinataire
                compteur = compteur + 1;
            }
        }
        return compteur;
    }

    //passager //faite
    /**
     *
     * @param contenu
     * @param conduc
     */
    public void contacter(String contenu, Conducteur conduc) {//contacter pilote
        LocalDate pdate = now();
        Message msg = new Message(((Passager) ActivUser).getMail(), conduc.getMail(), pdate, contenu);
        tabMessages.add(msg);
        Collections.sort(tabMessages, (Message o1, Message o2) -> o1.getDate().compareTo(o2.getDate()));//tri de l'arraylist par date
    }

    //faite
    /**
     *
     * @param contenu
     * @param passa
     */
    public void contacter(String contenu, Passager passa) {//contacte le pasager qui n'a pas été accepter
        Message msg = new Message(((Conducteur) ActivUser).getMail(), passa.getMail(), LocalDate.now(), contenu);
        tabMessages.add(msg);
        Collections.sort(tabMessages, (Message o1, Message o2) -> o1.getDate().compareTo(o2.getDate()));//tri de l'arraylist par date
    }

    /**
     *
     * @param mailEm
     * @param mailDest
     * @param contenu
     */
    public void contacter(String mailEm, String mailDest, String contenu) {
        Message msg = new Message(mailEm, mailDest, LocalDate.now(), contenu);
        tabMessages.add(msg);
        Collections.sort(tabMessages, (Message o1, Message o2) -> o1.getDate().compareTo(o2.getDate()));//tri de l'arraylist par date
    }

    //faite
    /**
     *
     * @param msgAncien
     * @param date
     * @param contenu
     */
    public void repondreMessage(Message msgAncien, LocalDate date, String contenu) {
        msgAncien.setVu(true);
        Message msg1 = new Message(ActivUser.getMail(), msgAncien.getEmeteur(), date, contenu);
        tabMessages.add(msg1);
        Collections.sort(tabMessages, (Message o1, Message o2) -> o1.getDate().compareTo(o2.getDate()));//tri de l'arraylist par dates
    }

    //les 2
    /**
     *
     * @param note
     * @param texte
     * @param user2
     */
    public void ajouterAvis(int note, String texte, Utilisateur user2) {
        Avis avis = new Avis(note, texte, ActivUser.getMail(), user2.getMail());
        tabAvis.add(avis);
        user2.setAvis(avis);//ajoutre l'avis dans la liste d'avis de l'utilisateur en question
        //System.out.println("Votre avis : " + avis);
        user2.calculMoyenne();
    }

    /**
     *
     * @param listeavis
     * @param tabavis
     */
    public void afficherAvisConducteur(JList listeavis, ArrayList<Avis> tabavis) {
        String donnees[] = new String[tabavis.size()];
        for (int i = 0; i < tabavis.size(); i++) {
            donnees[i] = tabavis.get(i).toStringList();
        }
        listeavis.setListData(donnees);//affichage dans le liste
    }

    //faite
    /**
     *
     * @param liste
     * @return
     */
    public ArrayList<Trajet> visualierTrajetEffectues(JList liste) {//visualise les trajets fait par un conducteur
        ArrayList<Trajet> trajetfait = new ArrayList<>();
        for (int i = 0; i < ((Conducteur) ActivUser).getTabTrajet().size(); i++) {
            if (((Conducteur) ActivUser).getTabTrajet().get(i).isFait()) {
                trajetfait.add(((Conducteur) ActivUser).getTabTrajet().get(i));
            }
        }
        String donnees[] = new String[trajetfait.size()];
        for (int i = 0; i < trajetfait.size(); i++) {
            donnees[i] = trajetfait.get(i).toStringList();
        }
        liste.setListData(donnees);//affichage dans le liste
        return trajetfait;
    }

    //faite
    /**
     *
     * @param liste
     * @return
     */
    public ArrayList<Trajet> visualierTrajetAvenir(JList liste) {//visualise les trajets à vanir par un conducteur
        ArrayList<Trajet> trajetpasfait = new ArrayList<>();
        for (int i = 0; i < ((Conducteur) ActivUser).getTabTrajet().size(); i++) {
            if (((Conducteur) ActivUser).getTabTrajet().get(i).isFait() == false) {
                trajetpasfait.add(((Conducteur) ActivUser).getTabTrajet().get(i));
            }
        }
        String donnees[] = new String[trajetpasfait.size()];
        for (int i = 0; i < trajetpasfait.size(); i++) {
            donnees[i] = trajetpasfait.get(i).toStringList();
        }
        liste.setListData(donnees);//affichage dans le liste
        return trajetpasfait;
    }

    //faite
    /**
     *
     * @param liste
     * @param trajet
     * @return
     */
    public ArrayList<Passager> visualiserPassager(JList liste, Trajet trajet) {
        String donnees[] = new String[trajet.getTabPassager().size()];
        for (int i = 0; i < trajet.getTabPassager().size(); i++) {
            if (trajet.getTabPassager().isEmpty()) {//si le tableau est vide on le remplie avec rien
                donnees[i] = "";
            } else {//sinon on le remplie normalement
                donnees[i] = trajet.getTabPassager().get(i).toStringList();
            }
        }
        liste.setListData(donnees);//affichage dans le liste
        return trajet.getTabPassager();
    }

    //faite
    /**
     *
     * @param liste
     * @param trajet
     * @return
     */
    public ArrayList<Passager> visualiserPassagerAtt(JList liste, Trajet trajet) {
        String donnees[] = new String[trajet.getTabPassagerAtt().size()];
        for (int i = 0; i < trajet.getTabPassagerAtt().size(); i++) {
            if (trajet.getTabPassagerAtt().isEmpty()) {//si le tableau est vide on le remplie avec rien
                donnees[i] = "";
            } else {//sinon on le remplie normalement
                donnees[i] = trajet.getTabPassagerAtt().get(i).toStringList();
            }
        }
        liste.setListData(donnees);//affichage dans le liste
        return trajet.getTabPassagerAtt();
    }

    //faite
    /**
     *
     * @param liste
     * @return
     */
    public ArrayList<Trajet> rechercherlisteTrajets(JList liste) {//rempli un table de trajet correspondant a ceux du passager
        String donnees[] = new String[((Passager) ActivUser).getMesTrajets().size()];
        for (int i = 0; i < ((Passager) ActivUser).getMesTrajets().size(); i++) {
            donnees[i] = ((Passager) ActivUser).getMesTrajets().get(i).toStringList();
        }
        liste.setListData(donnees);//affichage dans le liste
        return ((Passager) ActivUser).getMesTrajets();
    }

    /**
     *
     * @param villedep
     * @param villeArr
     * @param pdate
     * @return
     */
    public ArrayList<Trajet> rechercherlisteTrajets(String villedep, String villeArr, LocalDate pdate) {//methode qui renvoi une liste des trajets proposés
        ArrayList<Trajet> tabtampon = new ArrayList<>();
        for (int i = 0; i < tabTrajet.size(); i++) {
            Trajet trajet = tabTrajet.get(i);
            if (trajet.testVilleDepart(villedep) == true && trajet.testVilleArrive(villeArr) == true && trajet.testDate(pdate) == true && trajet.testDispo() == true && trajet.isFait() == false) {
                tabtampon.add(trajet);
            }
        }
        return tabtampon;
    }

    /**
     *
     * @return
     */
    public ArrayList<Trajet> rechercherlisteTrajets() {//methode qui renvoi une liste des trajets proposés
        ArrayList<Trajet> tabtampon = new ArrayList<>();
        for (int i = 0; i < tabTrajet.size(); i++) {
            Trajet trajet = tabTrajet.get(i);
            if (trajet.isFait() == false) {
                tabtampon.add(trajet);
            }
        }
        return tabtampon;
    }

    /**
     *
     * @param user
     * @return
     */
    public ArrayList<Avis> rechercherlisteAvis(Utilisateur user) {
        ArrayList<Avis> tabAvisTampon = new ArrayList<>();
        for (int i = 0; i < tabAvis.size(); i++) {
            Avis avis = tabAvis.get(i);
            if (avis.getDestinataire().equals(user.getMail())) {
                tabAvisTampon.add(avis);
            }
        }
        return tabAvisTampon;
    }

    /**
     *
     * @param mail
     * @return
     */
    public Conducteur rechercherConducteur(String mail) {
        for (int i = 0; i < tabConducteur.size(); i++) {
            Conducteur pilote = tabConducteur.get(i);
            if (pilote.testmail(mail) == true) {
                return pilote;
            }
        }
        return null;
    }

    /**
     *
     * @param mail
     * @return
     */
    public Passager rechercherPassager(String mail) {
        for (int i = 0; i < tabPassager.size(); i++) {
            Passager passag = tabPassager.get(i);
            if (passag.testmail(mail) == true) {
                return passag;
            }
        }
        return null;
    }

    /**
     *
     * @param mail
     * @return
     */
    public Conducteur testExisteConduc(String mail) {
        for (int i = 0; i < tabConducteur.size(); i++) {
            Conducteur pilote = tabConducteur.get(i);
            if (pilote.testmail(mail) == true) {
                return pilote;
            }
        }
        return null;
    }

    /**
     *
     * @param mail
     * @return
     */
    public Passager testExistePassa(String mail) {
        for (int i = 0; i < tabPassager.size(); i++) {
            Passager pass = tabPassager.get(i);
            if (pass.testmail(mail) == true) {
                return pass;
            }
        }
        return null;
    }

    //methodes de sauvegardes des différents instances
    /**
     *
     * @throws IOException
     */
    public void sauvegardeCondcuteur() throws IOException {
        Iterator<Conducteur> it2 = tabConducteur.iterator();//iterator pour faire varier la liste de passagers
        try (FileWriter sortie2 = new FileWriter("Fichier_Conducteurs.txt")) {//init de la sortie
            while (it2.hasNext()) {//afin de couvrir la liste entière
                sortie2.write(it2.next().versFichiers());//ecrit la chaine dans le fichier
            }
            sortie2.close();
        }
    }

    /**
     *
     * @throws IOException
     */
    public void sauvegardeTrajets() throws IOException {
        Iterator<Trajet> it3 = tabTrajet.iterator();//iterator pour faire varier la liste de passagers
        try (FileWriter sortie3 = new FileWriter("Fichier_Trajets.txt")) {//init de la sortie
            while (it3.hasNext()) {//afin de couvrir la liste entière
                sortie3.write(it3.next().versFichiers());//ecrit la chaine dans le fichier
            }
            sortie3.close();
        }
    }

    /**
     *
     * @throws IOException
     */
    public void sauvegardePassager() throws IOException {
        Iterator<Passager> it = tabPassager.iterator();//iterator pour faire varier la liste de passagers
        try (FileWriter sortie = new FileWriter("Fichier_Passagers.txt")) {//init de la sortie
            while (it.hasNext()) {//afin de couvrir la liste entière
                sortie.write(it.next().versFichiers());//ecrit la chaine dans le fichier
            }
            sortie.close();
        }
    }

    /**
     *
     * @throws IOException
     */
    public void sauvegarderMassages() throws IOException {

        Iterator<Message> it4 = tabMessages.iterator();//iterator pour faire varier la liste de passagers
        try (FileWriter sortie4 = new FileWriter("Fichier_Messages.txt")) {//init de la sortie
            while (it4.hasNext()) {//afin de couvrir la liste entière
                sortie4.write(it4.next().versFichiers());//ecrit la chaine dans le fichier
            }
            sortie4.close();
        }
    }

    /**
     *
     * @throws IOException
     */
    public void sauvegarderAvis() throws IOException {

        Iterator<Avis> it4 = tabAvis.iterator();//iterator pour faire varier la liste de passagers
        try (FileWriter sortie4 = new FileWriter("Fichier_Avis.txt")) {//init de la sortie
            while (it4.hasNext()) {//afin de couvrir la liste entière
                sortie4.write(it4.next().versFichier());//ecrit la chaine dans le fichier
            }
            sortie4.close();
        }
    }

    /**
     *
     * @throws IOException
     */
    public void sauvegardeAdmin() throws IOException {
        try (FileWriter sortie3 = new FileWriter("Fichier_Admin.txt")) {//init de la sortie
            sortie3.write(admin.versFichier());//ecrit la chaine dans le fichier
            sortie3.close();
        }
    }

    /**
     *
     * @throws IOException
     */
    public void sauvegarde() throws IOException {
        this.sauvegardeCondcuteur();
        this.sauvegardePassager();
        this.sauvegardeTrajets();
        this.sauvegarderMassages();
        this.sauvegarderAvis();
        this.sauvegardeAdmin();
    }

    /**
     *
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void ChargerPassager() throws FileNotFoundException, IOException {
        String nom;
        float notemoy;
        String mail;
        String mdp;
        FileReader entree = new FileReader("Fichier_Passagers.txt");
        try (BufferedReader br = new BufferedReader(entree)) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                nom = ligne;
                notemoy = Float.valueOf(br.readLine());
                mail = br.readLine();
                mdp = br.readLine();
                String fichierphoto = br.readLine();
                Photo photo = new Photo(fichierphoto);
                Passager pass = new Passager(nom, mail, mdp);
                pass.setPdp(photo);
                pass.setNoteMoyenne(notemoy);
                tabPassager.add(pass);//rempli de nouveau le tableau
                pass.setTabAvis(rechercherlisteAvis(pass));

            }
            entree.close();
        }
    }

    /**
     *
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void ChargerAvis() throws FileNotFoundException, IOException {//chargement des messages 
        int note;
        String contenu;
        String emeteur;
        String destinataire;
        FileReader entree = new FileReader("Fichier_Avis.txt");
        try (BufferedReader br = new BufferedReader(entree)) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                destinataire = ligne;
                note = Integer.valueOf(br.readLine());
                contenu = br.readLine();
                emeteur = br.readLine();
                Avis avis = new Avis(note, contenu, emeteur, destinataire);
                tabAvis.add(avis);//rempli le tableau

            }
            entree.close();
        }
    }

    /**
     *
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void ChargerMessages() throws FileNotFoundException, IOException {//chargement des messages 
        String emeteur;
        String destinataire;
        LocalDate date;
        String contenu;
        boolean vu;
        FileReader entree = new FileReader("Fichier_Messages.txt");
        try (BufferedReader br = new BufferedReader(entree)) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                emeteur = ligne;
                destinataire = br.readLine();
                date = LocalDate.parse(br.readLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                contenu = br.readLine();
                vu = Boolean.valueOf(br.readLine());
                Message msg = new Message(emeteur, destinataire, date, contenu);
                msg.setVu(vu);
                tabMessages.add(msg);//rempli de nouveau le tableau
            }
            entree.close();
        }
    }

    /**
     *
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void ChargerConducteur() throws FileNotFoundException, IOException {
        String nom;
        float notemoy;
        String mail;
        String mdp;
        String vehicule;
        FileReader entree = new FileReader("Fichier_Conducteurs.txt");
        try (BufferedReader br = new BufferedReader(entree)) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                nom = ligne;
                String snotemoy = br.readLine();
                notemoy = Float.parseFloat(snotemoy);
                mail = br.readLine();
                mdp = br.readLine();
                Conducteur conduct = new Conducteur(nom, mail, mdp);
                conduct.setNoteMoyenne(notemoy);
                vehicule = br.readLine();
                String fichierphoto = br.readLine();
                Photo photo = new Photo(fichierphoto);
                conduct.setPdp(photo);
                conduct.setVehicule(vehicule);
                tabConducteur.add(conduct);//rempli de nouveau le tableau
                conduct.setTabAvis(rechercherlisteAvis(conduct));
            }

            entree.close();
        }
    }

    /**
     *
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void ChargerTrajet() throws FileNotFoundException, IOException {
        String villeDep;
        String villeArr;
        int placesDispo;
        int placesPrises;
        String mailPilote;
        LocalDate date;
        int prix;
        FileReader entree = new FileReader("Fichier_Trajets.txt");
        try (BufferedReader br = new BufferedReader(entree)) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                villeDep = ligne;
                villeArr = br.readLine();
                placesDispo = Integer.valueOf(br.readLine());
                placesPrises = Integer.valueOf(br.readLine());
                mailPilote = br.readLine();
                date = LocalDate.parse(br.readLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                prix = Integer.valueOf(br.readLine());
                Conducteur pilote = this.rechercherConducteur(mailPilote);
                Trajet trajet = new Trajet(villeDep, villeArr, placesDispo, pilote, date, prix);
                String[] tab;
                tab = br.readLine().split(",");//sépare notre chaine de caractère entre chaque "," et stock le tout dans un tableau
                for (String tab1 : tab) {
                    Passager pass = rechercherPassager(tab1);
                    if (pass != null) {
                        pass.addTrajet(trajet);
                        trajet.addPassager(pass);
                    }
                }
                String[] tabAtt;
                tabAtt = br.readLine().split(",");//sépare notre chaine de caractère entre chaque "," et stock le tout dans un tableau
                for (String tabAtt1 : tabAtt) {
                    trajet.addPassagerAtt(rechercherPassager(tabAtt1));
                }
                tabTrajet.add(trajet);//rempli de nouveau le tableau
                trajet.setPlacesPrises(placesPrises);
                boolean fait;
                fait = date.isBefore(LocalDate.now());
                trajet.setFait(fait);

                pilote.setTrajet(trajet);//rajoute le trajet au condcuteur correspondant
            }
            entree.close();
        }
    }

    /**
     *
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void ChargerAdmin() throws FileNotFoundException, IOException {
        String nom;
        String mail;
        String mdp;
        try (FileReader entree = new FileReader("Fichier_Admin.txt"); BufferedReader br = new BufferedReader(entree)) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                nom = ligne;
                mail = br.readLine();
                mdp = br.readLine();
            }
        }
    }

    /**
     *
     * @throws IOException
     */
    public void charger() throws IOException {//méthode de chargement global
        this.ChargerAvis();
        this.ChargerMessages();
        this.ChargerPassager();
        this.ChargerConducteur();
        this.ChargerTrajet();
        this.ChargerAdmin();
        //System.out.println("mes listes : \n"+tabAvis + "" + tabMessages + tabConducteur + tabPassager + tabTrajet+"\n\n\n");//balise
    }

    @Override
    public String toString() {
        return "Bienvenu sur : " + nomSite;
    }

}
