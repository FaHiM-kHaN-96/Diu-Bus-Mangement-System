package test.logi_in;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentBoardController {

    @FXML
    private TableColumn<BusInfo, String> Minute_clm;

    @FXML
    private TableColumn<BusInfo, String> ampm;

    @FXML
    private TableColumn<BusInfo, String> bus_no_tbl;

    @FXML
    private ComboBox<String> combo_box;

    @FXML
    private TableColumn<BusInfo, String> houre_clm;

    @FXML
    private Button logout_btn;

    @FXML
    private Button show_btn;

    @FXML
    private TableView<BusInfo> table_viwe_student;

    @FXML
    private Button refresh_btn;

    public class trip {
        public trip(String trip2) {
        }
    }

    public class BusInfo {
        private String busnm;
        private String houre;
        private String minute;
        private String ampm;
        private String trip2;

        public String getBusnm() {
            return busnm;
        }

        public void setBusnm(String busnm) {
            this.busnm = busnm;
        }

        public String getHoure() {
            return houre;
        }

        public void setHoure(String houre) {
            this.houre = houre;
        }

        public String getMinute() {
            return minute;
        }

        public void setMinute(String minute) {
            this.minute = minute;
        }

        public String getAmpm() {
            return ampm;
        }

        public void setAmpm(String ampm) {
            this.ampm = ampm;
        }

        public String getTrip2() {
            return trip2;
        }

        public void setTrip2(String trip2) {
            this.trip2 = trip2;
        }

        public BusInfo(String busname, String houre, String minute, String ampm) {
            this.busnm = busname;
            this.houre = houre;
            this.minute = minute;
            this.ampm = ampm;
        }
    }

    @FXML
    public void initialize() {
        try {
            String sql3 = "SELECT bus_nam, houre, minute, am_pm FROM busmangement.student_prt_bus";

            ResultSet rs3 = DBdetails.executeQuery1(sql3);

            table_viwe_student.getItems().clear();

            bus_no_tbl.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getBusnm()));
            houre_clm.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getHoure()));
            Minute_clm.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMinute()));
            ampm.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAmpm()));

            while (rs3.next()) {
                String busnme = rs3.getString("bus_nam");
                String houre = rs3.getString("houre");
                String minute = rs3.getString("minute");
                String ampm = rs3.getString("am_pm");

                table_viwe_student.getItems().add(new StudentBoardController.BusInfo(busnme, houre, minute, ampm));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        combo_box.getItems().addAll("Dhanmondi <> DSC",
                "Uttara - Rajlokkhi <> Uttara Metro rail Center <> DSC",
                "Tongi College gate <> DSC",
                "ECB Chattor <> Mirpur <> DSC",
                "Konabari Pukur Par <> Zirabo <> Ashulia Bazar <> DSC",
                "Baipail <> Nabinagar <> C&B <> DSC",
                "Dhamrai Bus Stand <> Nabinagar <> C&B <> DSC",
                "Savar <> C&B <> DSC","Narayanganj Chasara > Dhanmondi > DSC",
                "Green Model Town <> Mugdha Model Thana <> Malibag <> Rampura <> DSC",
                "Mirpur-1, Sony Cinema Hall <> DSC",
                "Uttara Moylar Mor <> Uttara Metro rail Center<> DSC",
                "DSC <> Uttara Moylar Mor <> Uttara Metro rail Center",
                "DSC <> Mirpur-1, Sony Cinema Hall",
                "DSC <> Green Model Town <> Mugdha Model Thana <> Malibag <> Rampura",
                "DSC <> Narayanganj Chasara > Dhanmondi", "DSC <> Savar <> C&B",
                "DSC <> Dhamrai Bus Stand <> Nabinagar <> C&B",
                "DSC <> Baipail <> Nabinagar <> C&B",
                "DSC <> Konabari Pukur Par <> Zirabo <> Ashulia Bazar",
                "DSC <> ECB Chattor <> Mirpur",
                "DSC <> Tongi College gate",
                "DSC <> Uttara - Rajlokkhi <> Uttara Metro rail Center",
                "DSC <> Dhanmondi");
    }

    @FXML
    void show_rout_bus(ActionEvent event) {
        String routess = combo_box.getValue();

        table_viwe_student.getItems().clear();

        try {
            String sql3 = "SELECT bus_nam, houre, minute, am_pm FROM busmangement.student_prt_bus WHERE route LIKE '%" + routess + "%'";

            ResultSet rs3 = DBdetails.executeQuery1(sql3);

            while (rs3.next()) {
                String busnme = rs3.getString("bus_nam");
                String houre = rs3.getString("houre");
                String minute = rs3.getString("minute");
                String ampm = rs3.getString("am_pm");

                table_viwe_student.getItems().add(new StudentBoardController.BusInfo(busnme, houre, minute, ampm));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            showErrorAlert("Error fetching data from database");
        }
    }

    @FXML
    void refresh_btn_action(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("dashbord.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Dashboard");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
            Stage currentStage = (Stage) refresh_btn.getScene().getWindow();
            currentStage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void system_logout(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to log out?");

        ButtonType buttonTypeOK = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(buttonTypeOK, buttonTypeCancel);

        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == buttonTypeOK) {
            Stage currentStage = (Stage) logout_btn.getScene().getWindow();
            currentStage.close();
        }
    }

    private void showErrorAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
