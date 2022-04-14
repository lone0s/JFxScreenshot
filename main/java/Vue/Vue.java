package Vue;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;

public class Vue {
    Parent view;
    private BorderPane flowPane;
    private Button screenshot;
    private Button quit;
    private TextField folderName;
    public boolean correctFolderName;

    public Vue() {
        view = initView();
    }

    private Pane initView() {
        screenshot = new Button("Take a Screenshot");
        quit = new Button("exit");
        flowPane = new BorderPane();
        //flowPane.getChildren().addAll(screenshot,quit);
        flowPane.setCenter(screenshot);
        this.folderName = new TextField("Screenshots");
        this.correctFolderName = true;
        Region spacer = new Region();
        HBox.setHgrow(spacer,Priority.ALWAYS);
        spacer.setPrefWidth(Region.USE_PREF_SIZE);
        Region spacerBis = new Region();
        HBox.setHgrow(spacerBis,Priority.ALWAYS);
        spacerBis.setPrefWidth(Region.USE_PREF_SIZE);
        HBox hBox = new HBox();
        hBox.getChildren().addAll(spacer,folderName,spacerBis,quit);
        flowPane.setBottom(hBox);
        flowPane.setPadding(new Insets(10));
        screenshot.setAlignment(Pos.CENTER);
        quit.addEventHandler(MouseEvent.MOUSE_CLICKED,mouseEvent -> {
            Platform.exit();
        });
        return flowPane;
    }

    public Button getQuit() {
        return quit;
    }
    public Button getScreenshot() {
        return screenshot;
    }

    public BorderPane getFlowPane() {
        return flowPane;
    }

    public TextField getFolderName() {
        return folderName;
    }

    public void correctFolderName() {
        this.correctFolderName = (folderName.getText().contains(":") || folderName.getText().contains("/"));
    }
}
