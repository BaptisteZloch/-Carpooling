/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covoiturage;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author admin
 */
public class Photo {

    private String nomFichier;
    private Image img;

    /**
     *
     */
    public static final String DOSS_IMAGES = "src/Photo_profile/";

    /**
     *
     * @param nomFichier
     */
    public Photo(String nomFichier) {
        this.nomFichier = nomFichier;
        Toolkit t = Toolkit.getDefaultToolkit();
        img = t.getImage(DOSS_IMAGES + nomFichier);
    }

    /**
     *
     * @return
     */
    public String getNomFichier() {
        return nomFichier;
    }

    /**
     *
     * @param monLabel
     */
    public void afficher(JLabel monLabel) {
        if (img != null) {
            img = img.getScaledInstance(monLabel.getWidth(), monLabel.getHeight(),
                    Image.SCALE_DEFAULT);
            monLabel.setIcon(new ImageIcon(img));
        }
    }
}
