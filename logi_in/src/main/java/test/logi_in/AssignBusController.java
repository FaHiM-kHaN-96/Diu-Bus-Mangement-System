package test.logi_in;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.ResultSet;

public class AssignBusController {



    @FXML
    private ComboBox<String> am_pm;


    @FXML
    private ComboBox<String> bus_name;

    @FXML
    private Button assign_button;

    @FXML
    private ComboBox<String> rootneme;

    @FXML
    private ComboBox<String> houre_combo;

    @FXML
    private Button ok_btn;

    @FXML
    private ComboBox<String> minute_combo;


    public void initialize() {

        try {
            String sql2 = "SELECT bus_name FROM busmangement.avilable_busp";
            ResultSet rs2 = DBdetails.executeQuery1(sql2);

            while (rs2.next()){
                bus_name.getItems().add(rs2.getString("bus_name"));
            }

        } catch (Exception e){
            e.printStackTrace();

        }

        for (int i = 1; i <= 12; i++) {
            houre_combo.getItems().add(String.valueOf(i));
        }
        houre_combo.setValue("Houre");


        for (int i = 0; i < 60; i++) {
            minute_combo.getItems().add(String.valueOf(i));
        }
        minute_combo.setValue("Minute");

        am_pm.getItems().addAll("AM", "PM");
        am_pm.setValue("AM");

        rootneme.getItems().addAll("Dhanmondi <> DSC", "Uttara - Rajlokkhi <> Uttara Metro rail Center <> DSC","Tongi College gate <> DSC","ECB Chattor <> Mirpur <> DSC","Konabari Pukur Par <> Zirabo <> Ashulia Bazar <> DSC","Baipail <> Nabinagar <> C&B <> DSC","Dhamrai Bus Stand <> Nabinagar <> C&B <> DSC","Savar <> C&B <> DSC","Narayanganj Chasara > Dhanmondi > DSC","Green Model Town <> Mugdha Model Thana <> Malibag <> Rampura <> DSC","Mirpur-1, Sony Cinema Hall <> DSC","Uttara Moylar Mor <> Uttara Metro rail Center<> DSC","DSC <> Uttara Moylar Mor <> Uttara Metro rail Center", "DSC <> Mirpur-1, Sony Cinema Hall", "DSC <> Green Model Town <> Mugdha Model Thana <> Malibag <> Rampura", "DSC <> Narayanganj Chasara > Dhanmondi", "DSC <> Savar <> C&B", "DSC <> Dhamrai Bus Stand <> Nabinagar <> C&B", "DSC <> Baipail <> Nabinagar <> C&B", "DSC <> Konabari Pukur Par <> Zirabo <> Ashulia Bazar", "DSC <> ECB Chattor <> Mirpur", "DSC <> Tongi College gate", "DSC <> Uttara - Rajlokkhi <> Uttara Metro rail Center", "DSC <> Dhanmondi");

    }


    private void displayAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    void assign_database_btn(ActionEvent event) {

        String  bus_feld = bus_name.getValue();
        String houre = houre_combo.getValue();
        String minute = minute_combo.getValue();
        String am_pm_picker = am_pm.getValue();
        String roots = rootneme.getValue();
        if (bus_name.getValue() != null  && rootneme.getValue() != null && houre_combo.getValue() != null && minute_combo.getValue() != null && am_pm.getValue() != null) {
            if (DBdetails.ath_assign_busname(bus_feld,houre,minute,am_pm_picker,roots)){
                if (DBdetails.student_assign_busname(bus_feld,houre,minute,am_pm_picker,roots)){
                    if (DBdetails.deleteBus(bus_feld)){
                        if (DBdetails.card_checker(bus_feld)){
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle(null);
                            alert.setHeaderText(null);
                            alert.setContentText("Assign successfully");
                            alert.showAndWait();
                            try {
                                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("assign_bus_form.fxml"));
                                Scene scene = new Scene(fxmlLoader.load());
                                Stage stage = new Stage();
                                stage.setTitle("Assign");
                                stage.setScene(scene);
                                stage.setResizable(false);
                                stage.show();
                                Stage currentStage = (Stage) assign_button.getScene().getWindow();
                                currentStage.close();

                            }catch (Exception e){
                                e.printStackTrace();
                            }
                        }else{
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle(null);
                            alert.setHeaderText(null);
                            alert.setContentText("something went to wrong1");
                            alert.showAndWait();
                        }
                    }else{

                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle(null);
                        alert.setHeaderText(null);
                        alert.setContentText("something went to wrong2");
                        alert.showAndWait();

                    }

                }else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle(null);
                    alert.setHeaderText(null);
                    alert.setContentText("something went to wrong63");
                    alert.showAndWait();
                }



            }else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle(null);
                alert.setHeaderText(null);
                alert.setContentText("Bus is already assigned");
                alert.showAndWait();
            }


        }
    }




}


