package test.logi_in;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class StartingController {

    @FXML
    private Button busprt_btn;


    @FXML
    private AnchorPane main_form;


    @FXML
    private Button studentprt_btn;
//    private  Stage stage;
//    public void setStage(Stage stage) {
//        this.stage = stage;
//    }

    @FXML
    void authority_btn(ActionEvent event) {
        try {
            // Load the second screen
            FXMLLoader fxmlLoader1 = new FXMLLoader(HelloApplication.class.getResource("bus_authoruity.fxml"));
            Scene scene1 = new Scene(fxmlLoader1.load());
            Stage stage1 = new Stage();
            stage1.setTitle("Hellaaaa");
            stage1.setScene(scene1);
            stage1.setResizable(false);
            stage1.show();
            Stage currentStage1 = (Stage) busprt_btn.getScene().getWindow();
            currentStage1.close();


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @FXML
    void student_btn(ActionEvent event) {

        try {
            // Load the second screen
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Hellaaaa");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
            Stage currentStage = (Stage) studentprt_btn.getScene().getWindow();
            currentStage.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
