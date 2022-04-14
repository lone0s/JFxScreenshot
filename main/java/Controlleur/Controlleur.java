package Controlleur;

import Modele.Modele;
import Vue.Vue;
import javafx.scene.input.MouseEvent;

import java.awt.*;
import java.io.IOException;

public class Controlleur {
    private final Vue vue;
    Modele modele;

    public Controlleur(Vue vue) {
        this.vue = vue;
        setVue(vue);
    }

    private void setVue(Vue vue) {
        this.modele = new Modele();


        vue.getScreenshot().addEventHandler(MouseEvent.MOUSE_CLICKED,mouseEvent -> {
            try {
                System.out.println("Marche");
                if (vue.correctFolderName) {
                    modele.saveFile("Screenshot", "\\"+vue.getFolderName().getText());
                    System.out.println(modele.getFilename());
                }
                else
                    modele.saveFile("Screenshot",Modele.DEFAULT_FOLDERNAME);
                System.out.println("Marche Encore");
            }
            catch (IOException e) {
                System.out.println("Couldn't create screenshot file");
            }
            catch (AWTException e) {
                System.out.println("Couldn't make screenshot");
            }
        });
    }

    public Vue getVue() {
        return vue;
    }
}
