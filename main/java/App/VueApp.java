package App;

import Controlleur.Controlleur;
import Vue.Vue;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class VueApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Controlleur controlleur = new Controlleur(new Vue());
        Scene scene = new Scene(controlleur.getVue().getFlowPane(),320,240);
        stage.setScene(scene);
        stage.show();
    }
}
