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

public class ReturenBusController {

    @FXML
    private Button clear_btn;

    @FXML
    private ComboBox<String> trip_combo;

    public void initialize() {

        try {
            String sql2 = "SELECT bus_nme FROM busmangement.on_trip";
            ResultSet rs2 = DBdetails.executeQuery1(sql2);

            while (rs2.next()) {
                trip_combo.getItems().add(rs2.getString("bus_nme"));
            }

        } catch (Exception e) {

        }
    }

    @FXML
    void clearance_switch(ActionEvent event) {

        String bus_nme = trip_combo.getValue();
        if (DBdetails.avilable_bs(bus_nme)){
            if (DBdetails.card_delet(bus_nme)){
                if (DBdetails.Offtrip(bus_nme)){
                    if (DBdetails.delete_assign(bus_nme)){
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle(null);
                            alert.setHeaderText(null);
                            alert.setContentText("Clearance successfully");
                            alert.showAndWait();
                        try {
                            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("bus-returen_clearance.fxml"));
                            Scene scene = new Scene(fxmlLoader.load());
                            Stage stage = new Stage();
                            stage.setTitle("Return Bus");
                            stage.setScene(scene);
                            stage.setResizable(false);
                            stage.show();
                            Stage currentStage = (Stage) clear_btn.getScene().getWindow();
                            currentStage.close();
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                        }else{ Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle(null);
                            alert.setHeaderText(null);
                            alert.setContentText("System Error2");
                            alert.showAndWait();
                        }



                }else {

                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle(null);
                    alert.setHeaderText(null);
                    alert.setContentText("System Error");
                    alert.showAndWait();

                }

            }else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle(null);
                alert.setHeaderText(null);
                alert.setContentText("System Error");
                alert.showAndWait();


            }

        }else{

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText("Bus is already cleared");
            alert.showAndWait();

        }



    }

}
