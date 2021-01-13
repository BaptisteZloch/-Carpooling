/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import covoiturage.Conducteur;
import covoiturage.Passager;
import covoiturage.Trajet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JList;

/**
 *
 * @author tibse
 */
public class FParametresConducteur extends javax.swing.JDialog {

    private ArrayList<Trajet> listeTrajetPasFait;
    private ArrayList<Trajet> listeTrajetFait;//pour avis
    private Trajet trajetfait;//pour avis
    private Trajet trajetpasfait;
    private ArrayList<Passager> listePassagerAttente;
    private ArrayList<Passager> listePassager;//pour avis
    private Passager passagerAvis;
    private Passager passagerAccRef;

    /**
     *
     */
    public void initialiserListeTrajetPasFait() {
        TAVous.setText(((FAccueil) getParent()).getLeSite().getActivUser().toString());
        ((FAccueil) getParent()).getLeSite().getActivUser().getPdp().afficher(LPhoto);
        listeTrajetPasFait = ((FAccueil) getParent()).getLeSite().visualierTrajetAvenir(LAvenir);//charge dans les listes les trajets à venir
    }

    /**
     *
     */
    public void initialiserListeTrajetFait() {
        TAVous.setText(((FAccueil) getParent()).getLeSite().getActivUser().toString());
        listeTrajetFait = ((FAccueil) getParent()).getLeSite().visualierTrajetEffectues(LEffectues);//charge la liste des trajet effectués
    }

    /**
     *
     */
    public void initisaliserTrajetPasFait() {
        if (listeTrajetPasFait.isEmpty() == false && LAvenir.getSelectedIndex() >= 0) {
            trajetpasfait = listeTrajetPasFait.get(LAvenir.getSelectedIndex());
            LDépartPasFait.setText(trajetpasfait.getVilleDepart());
            LArrivéePasFait.setText(trajetpasfait.getVilleArrivee());
            LDatePasFait.setText(trajetpasfait.stringDate());
            LPrixPasFait.setText(trajetpasfait.getPrix() + " ");
            int placesRestantes = trajetpasfait.getPlacesDispo() - trajetpasfait.getPlacesPrises();
            LPlacesRestantes.setText(placesRestantes + " ");
            TAPassAtt.setText(trajetpasfait.toStringNomsPass());
            //TATrajet.setText(trajetpasfait.toString());
        } else {
            // System.out.println("erreur1"+"indice"+LAvenir.getSelectedIndex());
        }
    }

    /**
     *
     */
    public void initialiserTrajetFait() {
        if (listeTrajetFait.isEmpty() == false && LEffectues.getSelectedIndex() >= 0) {
            trajetfait = listeTrajetFait.get(LEffectues.getSelectedIndex());
        } else {
            //System.out.println("erreur2"+"indice"+LEffectues.getSelectedIndex());
        }
    }

    /**
     *
     */
    public void initialiserlistePassagerAttente() {
        if (trajetpasfait != null) {
            listePassagerAttente = ((FAccueil) getParent()).getLeSite().visualiserPassagerAtt(LPassagersAtt, trajetpasfait);
        } else {
            //System.out.println("erreur3");
        }
    }

    /**
     *
     */
    public void initialiserlistePassager() {
        if (trajetfait != null) {
            listePassager = ((FAccueil) getParent()).getLeSite().visualiserPassager(LPassagers, trajetfait);
            //System.out.println("mes passagers acceptés : " + listePassager);
        } else {
            //System.out.println("erreur4");
        }
    }

    /**
     *
     */
    public void initialiserPassagerAvis() {
        if (listePassager.isEmpty() == false && LPassagers.getSelectedIndex() >= 0) {
            passagerAvis = listePassager.get(LPassagers.getSelectedIndex());
            //System.out.println("mon passager accepté : " + passagerAvis);
        } else {
            // System.out.println("erreur5");
        }
    }

    /**
     *
     */
    public void initialiserPassagerAccRef() {
        if (listePassagerAttente.isEmpty() == false && LPassagersAtt.getSelectedIndex() >= 0) {
            passagerAccRef = listePassagerAttente.get(LPassagersAtt.getSelectedIndex());
            // TAPassager.setText(passagerAccRef.toString());
            LPet.setEnabled(passagerAccRef.isAnimal());
            Lbaby.setEnabled(passagerAccRef.isEnfant());
            LNoteMoy.setText(passagerAccRef.getNoteMoyenne() + "/5");
            LNom.setText(passagerAccRef.getNom());
            passagerAccRef.getPdp().afficher(LPhotos2);
        } else {
            //System.out.println("erreur6");
        }
    }

    /**
     * Creates new form FParametres
     *
     * @param parent
     * @param modal
     */
    public FParametresConducteur(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BMessages = new javax.swing.JButton();
        BOuAller = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        BDeconnexion = new javax.swing.JButton();
        LParametres = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        BAvis = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        TAVous = new javax.swing.JTextArea();
        LPhoto = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        SPEffectues = new javax.swing.JScrollPane();
        LEffectues = new javax.swing.JList<>();
        SPPassagers = new javax.swing.JScrollPane();
        LPassagers = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        BLaisserAvis1 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        LAvenir = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        LDépartPasFait = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        LArrivéePasFait = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        LDatePasFait = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        LPrixPasFait = new javax.swing.JLabel();
        Prix = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        LPlacesRestantes = new javax.swing.JLabel();
        BSupprimer = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        TAPassAtt = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        SPPassagers1 = new javax.swing.JScrollPane();
        LPassagersAtt = new javax.swing.JList<>();
        jLabel14 = new javax.swing.JLabel();
        LNoteMoy = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        BRefuser = new javax.swing.JButton();
        BAccepter = new javax.swing.JButton();
        LPet = new javax.swing.JLabel();
        Lbaby = new javax.swing.JLabel();
        LNom = new javax.swing.JLabel();
        LPhotos2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1150, 720));

        BMessages.setFont(new java.awt.Font("Avenir LT Std 35 Light", 0, 35)); // NOI18N
        BMessages.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Messages 32.png"))); // NOI18N
        BMessages.setText(" Messages");
        BMessages.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BMessagesActionPerformed(evt);
            }
        });

        BOuAller.setFont(new java.awt.Font("Avenir LT Std 35 Light", 0, 35)); // NOI18N
        BOuAller.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Go 32 UI.png"))); // NOI18N
        BOuAller.setText(" Où allez vous ?");
        BOuAller.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BOuAllerActionPerformed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(204, 51, 0));
        jPanel6.setPreferredSize(new java.awt.Dimension(871, 100));

        BDeconnexion.setFont(new java.awt.Font("Avenir LT Std 35 Light", 0, 30)); // NOI18N
        BDeconnexion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Déconnexion 32 UI.png"))); // NOI18N
        BDeconnexion.setText(" Déconnexion");
        BDeconnexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BDeconnexionActionPerformed(evt);
            }
        });

        LParametres.setFont(new java.awt.Font("Avenir LT Std 35 Light", 0, 70)); // NOI18N
        LParametres.setForeground(new java.awt.Color(255, 255, 255));
        LParametres.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/road 64.png"))); // NOI18N
        LParametres.setText(" Gérer trajets");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(LParametres, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BDeconnexion)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LParametres)
                    .addComponent(BDeconnexion))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel7.setText("Vos infos :");

        BAvis.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BAvis.setText("Vos avis");
        BAvis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAvisActionPerformed(evt);
            }
        });

        TAVous.setColumns(20);
        TAVous.setRows(5);
        jScrollPane4.setViewportView(TAVous);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(BAvis)
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(LPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(LPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                                .addComponent(BAvis, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane4))
                        .addGap(10, 10, 10))))
        );

        LEffectues.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        LEffectues.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                LEffectuesValueChanged(evt);
            }
        });
        SPEffectues.setViewportView(LEffectues);

        LPassagers.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        LPassagers.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                LPassagersValueChanged(evt);
            }
        });
        SPPassagers.setViewportView(LPassagers);

        jLabel1.setText("Vos trajet effectués :");

        jLabel2.setText("Les passagers :");

        BLaisserAvis1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BLaisserAvis1.setText(" Laisser Avis");
        BLaisserAvis1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BLaisserAvis1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SPEffectues, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(SPPassagers, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(BLaisserAvis1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SPEffectues, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SPPassagers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BLaisserAvis1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        LAvenir.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        LAvenir.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                LAvenirValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(LAvenir);

        jLabel3.setFont(new java.awt.Font("Avenir LT Std 35 Light", 0, 20)); // NOI18N
        jLabel3.setText("Prochains trajets");

        LDépartPasFait.setFont(new java.awt.Font("Avenir LT Std 35 Light", 0, 25)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Avenir LT Std 35 Light", 0, 20)); // NOI18N
        jLabel8.setText("Départ");

        jLabel9.setFont(new java.awt.Font("Avenir LT Std 35 Light", 0, 20)); // NOI18N
        jLabel9.setText("Arrivée");

        LArrivéePasFait.setFont(new java.awt.Font("Avenir LT Std 35 Light", 0, 25)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Avenir LT Std 35 Light", 0, 20)); // NOI18N
        jLabel10.setText("Date");

        LDatePasFait.setFont(new java.awt.Font("Avenir LT Std 35 Light", 0, 25)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Avenir LT Std 35 Light", 0, 20)); // NOI18N
        jLabel12.setText("Prix");

        LPrixPasFait.setFont(new java.awt.Font("Avenir LT Std 35 Light", 0, 25)); // NOI18N

        Prix.setFont(new java.awt.Font("Avenir LT Std 35 Light", 0, 25)); // NOI18N
        Prix.setText("€");

        jLabel13.setFont(new java.awt.Font("Avenir LT Std 35 Light", 0, 20)); // NOI18N
        jLabel13.setText("Places restantes");

        LPlacesRestantes.setFont(new java.awt.Font("Avenir LT Std 35 Light", 0, 25)); // NOI18N

        BSupprimer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Quit 32.png"))); // NOI18N
        BSupprimer.setText("Supprimer ce trajet");
        BSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BSupprimerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LDatePasFait, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(Prix, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(LPrixPasFait, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LPlacesRestantes, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LDépartPasFait, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LArrivéePasFait, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(BSupprimer)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LDépartPasFait, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LArrivéePasFait, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(LDatePasFait, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LPrixPasFait, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Prix, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13)
                        .addGap(7, 7, 7))
                    .addComponent(LPlacesRestantes, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(BSupprimer)
                .addGap(1, 1, 1))
        );

        TAPassAtt.setColumns(20);
        TAPassAtt.setRows(5);
        TAPassAtt.setCaretColor(new java.awt.Color(240, 240, 240));
        jScrollPane5.setViewportView(TAPassAtt);

        jLabel11.setFont(new java.awt.Font("Avenir LT Std 35 Light", 0, 20)); // NOI18N
        jLabel11.setText("Passagers acceptés");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        LPassagersAtt.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        LPassagersAtt.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                LPassagersAttValueChanged(evt);
            }
        });
        SPPassagers1.setViewportView(LPassagersAtt);

        jLabel14.setFont(new java.awt.Font("Avenir LT Std 35 Light", 0, 20)); // NOI18N
        jLabel14.setText("Passagers en attentes");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SPPassagers1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(SPPassagers1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        BRefuser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BRefuser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Quit 32.png"))); // NOI18N
        BRefuser.setText(" Refuser");
        BRefuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BRefuserActionPerformed(evt);
            }
        });

        BAccepter.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BAccepter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/OK 32 UI.png"))); // NOI18N
        BAccepter.setText(" Accepter");
        BAccepter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAccepterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(BRefuser, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BAccepter)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BAccepter)
                    .addComponent(BRefuser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        LPet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pet.png"))); // NOI18N
        LPet.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pet barré.png"))); // NOI18N

        Lbaby.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/baby.png"))); // NOI18N
        Lbaby.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/baby barré.png"))); // NOI18N

        LNom.setFont(new java.awt.Font("Avenir LT Std 35 Light", 0, 20)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LPet)
                .addGap(31, 31, 31)
                .addComponent(Lbaby)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LPhotos2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LNom, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 2, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(LPhotos2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LNom, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LPet, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Lbaby, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(492, 492, 492)
                        .addComponent(LNoteMoy, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addGap(21, 21, 21)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(279, 279, 279))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                                    .addGap(459, 459, 459)
                                    .addComponent(LNoteMoy, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)))
        );

        jButton1.setFont(new java.awt.Font("Avenir LT Std 35 Light", 0, 35)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Paramètres 32 UI.png"))); // NOI18N
        jButton1.setText(" Option");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 1150, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 1150, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(BMessages)
                        .addGap(33, 33, 33)
                        .addComponent(BOuAller))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jButton1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BOuAller)
                    .addComponent(BMessages)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BOuAllerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BOuAllerActionPerformed
        this.setVisible(false);
        ((FAccueil) getParent()).getfPropTraj().setVisible(true);
    }//GEN-LAST:event_BOuAllerActionPerformed

    private void BMessagesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BMessagesActionPerformed
        this.setVisible(false);
        ((FAccueil) getParent()).getfmsg().initialiser();
        ((FAccueil) getParent()).getfmsg().setVisible(true);
    }//GEN-LAST:event_BMessagesActionPerformed

    private void LAvenirValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_LAvenirValueChanged
        try {
            this.initisaliserTrajetPasFait();
            this.initialiserlistePassagerAttente();
        } catch (Exception NullPointerException) {

        }
    }//GEN-LAST:event_LAvenirValueChanged

    private void LEffectuesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_LEffectuesValueChanged
        try {
            this.initialiserTrajetFait();
            this.initialiserlistePassager();
        } catch (Exception NullPointerException) {

        }
    }//GEN-LAST:event_LEffectuesValueChanged

    private void LPassagersAttValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_LPassagersAttValueChanged
        try {
            this.initialiserPassagerAccRef();
        } catch (Exception NullPointerException) {

        }
    }//GEN-LAST:event_LPassagersAttValueChanged

    private void BLaisserAvis1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BLaisserAvis1ActionPerformed
        this.setVisible(false);
        ((FAccueil) getParent()).getfLaisserAvis().initialiser(passagerAvis);
        ((FAccueil) getParent()).getfLaisserAvis().setVisible(true);
    }//GEN-LAST:event_BLaisserAvis1ActionPerformed

    private void BAvisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAvisActionPerformed
        this.setVisible(false);
        ((FAccueil) getParent()).getfaviscond().initialiser();
        ((FAccueil) getParent()).getfaviscond().setVisible(true);
    }//GEN-LAST:event_BAvisActionPerformed

    private void LPassagersValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_LPassagersValueChanged
        try {
            this.initialiserPassagerAvis();
        } catch (Exception NullPointerException) {

        }
    }//GEN-LAST:event_LPassagersValueChanged

    private void BDeconnexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BDeconnexionActionPerformed
        this.setVisible(false);
        try {
            ((FAccueil) getParent()).getLeSite().sauvegarde();//sauvegarde dans les fichiers
        } catch (IOException ex) {
            Logger.getLogger(FMessage.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((FAccueil) getParent()).desinit();
        //((FAccueil) getParent()).getLeSite().flushListes();//nettoie les listes pour éviter les doublons
        ((FAccueil) getParent()).setVisible(true);//permet le connexion d'un autre utilisateur
    }//GEN-LAST:event_BDeconnexionActionPerformed

    private void BSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BSupprimerActionPerformed
        ((FAccueil) getParent()).getLeSite().supprimerTrajet(trajetpasfait, LAvenir);
        //this.TATrajet.setText("");//nettoie la visu
        //this.TAPassager.setText("");
        this.initialiserListeTrajetPasFait();
        String tab[] = new String[1];
        tab[0] = "";
        this.LPassagersAtt.setListData(tab);
    }//GEN-LAST:event_BSupprimerActionPerformed

    private void BAccepterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAccepterActionPerformed
        ((FAccueil) getParent()).getLeSite().accepterPassager(trajetpasfait, passagerAccRef);
        this.initisaliserTrajetPasFait();
        this.initialiserlistePassagerAttente();
        // this.TAPassager.setText("");
    }//GEN-LAST:event_BAccepterActionPerformed

    private void BRefuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BRefuserActionPerformed
        ((FAccueil) getParent()).getLeSite().supprimerPassager(trajetpasfait, passagerAccRef);
        this.initialiserlistePassagerAttente();
        this.initisaliserTrajetPasFait();
        //  this.TAPassager.setText("");
    }//GEN-LAST:event_BRefuserActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        ((FAccueil) getParent()).getFopcond().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     *
     * @return
     */
    public Passager getPassagerAvis() {
        return passagerAvis;
    }

    public String getNomPassager(Passager passager) {

        return passager.getNom();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FParametresConducteur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FParametresConducteur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FParametresConducteur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FParametresConducteur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FParametresConducteur dialog = new FParametresConducteur(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BAccepter;
    private javax.swing.JButton BAvis;
    private javax.swing.JButton BDeconnexion;
    private javax.swing.JButton BLaisserAvis1;
    private javax.swing.JButton BMessages;
    private javax.swing.JButton BOuAller;
    private javax.swing.JButton BRefuser;
    private javax.swing.JButton BSupprimer;
    private javax.swing.JLabel LArrivéePasFait;
    private javax.swing.JList<String> LAvenir;
    private javax.swing.JLabel LDatePasFait;
    private javax.swing.JLabel LDépartPasFait;
    private javax.swing.JList<String> LEffectues;
    private javax.swing.JLabel LNom;
    private javax.swing.JLabel LNoteMoy;
    private javax.swing.JLabel LParametres;
    private javax.swing.JList<String> LPassagers;
    private javax.swing.JList<String> LPassagersAtt;
    private javax.swing.JLabel LPet;
    private javax.swing.JLabel LPhoto;
    private javax.swing.JLabel LPhotos2;
    private javax.swing.JLabel LPlacesRestantes;
    private javax.swing.JLabel LPrixPasFait;
    private javax.swing.JLabel Lbaby;
    private javax.swing.JLabel Prix;
    private javax.swing.JScrollPane SPEffectues;
    private javax.swing.JScrollPane SPPassagers;
    private javax.swing.JScrollPane SPPassagers1;
    private javax.swing.JTextArea TAPassAtt;
    private javax.swing.JTextArea TAVous;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    // End of variables declaration//GEN-END:variables
}
