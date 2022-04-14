module com.example.screenshotapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;



    opens com.example.App to javafx.fxml;
    exports App;
    exports Controlleur;
    exports Modele;
    exports Vue;
}