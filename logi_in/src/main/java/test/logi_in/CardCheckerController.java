package test.logi_in;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.sql.ResultSet;

public class CardCheckerController {

    @FXML
    private ComboBox<String> bus_name_combo;

    @FXML
    private Button clearance;

    public void initialize() {

        try {
            String sql2 = "SELECT bus_nam FROM busmangement.assign_busn";
            ResultSet rs2 = DBdetails.executeQuery1(sql2);

            while (rs2.next()) {
                bus_name_combo.getItems().add(rs2.getString("bus_nam"));
            }

        } catch (Exception e) {

        }
    }

    @FXML
    void bus_switcher(ActionEvent event) {
        String bus_fd = bus_name_combo.getValue();

        if (DBdetails.ontrip(bus_fd)){
            if(DBdetails.Student_delete_assign(bus_fd)){

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle(null);
                alert.setHeaderText(null);
                alert.setContentText("Clearance successfully");
                alert.showAndWait();
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("card_cheacker.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());
                    Stage stage = new Stage();
                    stage.setTitle("card checker");
                    stage.setScene(scene);
                    stage.setResizable(false);
                    stage.show();
                    Stage currentStage = (Stage) clearance.getScene().getWindow();
                    currentStage.close();
                }catch (Exception e){
                    e.printStackTrace();
                }

            }else{

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle(null);
                alert.setHeaderText(null);
                alert.setContentText("deleting error");
                alert.showAndWait();


            }
        }else{

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText("Bus is already cleared");
            alert.showAndWait();
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("card_cheacker.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                Stage stage = new Stage();
                stage.setTitle("card checker");
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
                Stage currentStage = (Stage) clearance.getScene().getWindow();
                currentStage.close();
            }catch (Exception e){
                e.printStackTrace();
            }


        }


    }

}
