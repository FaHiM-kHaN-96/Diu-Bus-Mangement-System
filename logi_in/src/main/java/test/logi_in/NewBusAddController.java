package test.logi_in;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class NewBusAddController {





    @FXML
    private TextField bus_capacity;

    @FXML
    private TextField bus_name;

    @FXML
    private Button newbus_submit_btn;

    @FXML
    private Button ok_btn;


    private void displayAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


    @FXML
    void new_bus_sbmt(ActionEvent event) {

        String add_bus = bus_name.getText();
        String add_bus2 = new String(add_bus);
        String capacityText = bus_capacity.getText();
        if (!add_bus.isEmpty() && !capacityText.isEmpty()) {
            try {
                int bus1_capacity = Integer.parseInt(capacityText);

                if (DBdetails.ath_available_busname(add_bus2)){
                    if (DBdetails.ath_busname(add_bus, bus1_capacity)) {

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle(null);
                    alert.setHeaderText(null);
                    alert.setContentText("Add successfully");
                    alert.showAndWait();
                        try {
                            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("add_bus_form.fxml"));
                            Scene scene = new Scene(fxmlLoader.load());
                            Stage stage = new Stage();
                            stage.setTitle("Dashboard");
                            stage.setScene(scene);
                            stage.setResizable(false);
                            stage.show();
                            Stage currentStage = (Stage) newbus_submit_btn.getScene().getWindow();
                            currentStage.close();
                        }catch (Exception e){
                            e.printStackTrace();
                        }




                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle(null);
                    alert.setHeaderText(null);
                    alert.setContentText("Allready exict");
                    alert.showAndWait();
                }}else{
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle(null);
                    alert.setHeaderText(null);
                    alert.setContentText("Database error");
                    alert.showAndWait();
                }






            } catch (NumberFormatException e) {
                displayAlert("Error", capacityText + " is not an integer.", Alert.AlertType.ERROR);
            }
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText("Please fill the feld");
            alert.showAndWait();
        }

    }



}
