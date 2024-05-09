package test.logi_in;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AthdashboardController {

    @FXML
    private Button Bus_return_btn;

    @FXML
    private Button Card_chacker_btn;

    @FXML
    private GridPane ath_gardpane;

    @FXML
    private Button add_bus_btn;

    @FXML
    private Button refresh_btn;

    @FXML
    private Button assign_trip_btn;

    @FXML
    private Button ath_logout_btn;

    @FXML
    private TableColumn<Bus, String> available_bus_table;

    @FXML
    private Button bus_requiest_btn;

    @FXML
    private TableColumn<Bus, Integer> capacity_table;

    @FXML
    private TableColumn<Bus, String> on_trip_table;

    @FXML
    private TableView<Bus> ath_table_vies;

    @FXML
    private TableColumn<Bus, String> all_buses;

    public class Bus {
        private StringProperty busName;
        private IntegerProperty seatCapacity;
        private StringProperty busnm;
        private StringProperty on_trip;

        public Bus(String busName, int seatCapacity, String busnm, String on_trip) {
            this.busName = new SimpleStringProperty(busName);
            this.seatCapacity = new SimpleIntegerProperty(seatCapacity);
            this.busnm = new SimpleStringProperty(busnm);
            this.on_trip = new SimpleStringProperty(on_trip);
        }

        public StringProperty busnmProperty() {
            return busnm;
        }

        public StringProperty On_tripProperty() {
            return on_trip;
        }

        public String getBusnm() {
            return busnm.get();
        }

        public String getOn_trip() {
            return on_trip.get();
        }

        public void setBusnm(String busnm) {
            this.busnm.set(busnm);
        }

        public void setOn_trip(String on_trip) {
            this.on_trip.set(on_trip);
        }

        public StringProperty busNameProperty() {
            return busName;
        }

        public String getBusName() {
            return busName.get();
        }

        public void setBusName(String busName) {
            this.busName.set(busName);
        }

        public IntegerProperty seatCapacityProperty() {
            return seatCapacity;
        }

        public int getSeatCapacity() {
            return seatCapacity.get();
        }

        public void setSeatCapacity(int seatCapacity) {
            this.seatCapacity.set(seatCapacity);
        }
    }

    public void initialize() {
        try {
            String sql = "SELECT bus_name, bus_capacity FROM busmangement.add_bus";
            String sql2 = "SELECT bus_name FROM busmangement.avilable_busp";
            String sql3 = "SELECT bus_nme FROM busmangement.on_trip";

            ResultSet rs = DBdetails.executeQuery1(sql);
            ResultSet rs2 = DBdetails.executeQuery1(sql2);
            ResultSet rs3 = DBdetails.executeQuery1(sql3);

            ath_table_vies.getItems().clear();

            all_buses.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getBusName()));
            capacity_table.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getSeatCapacity()).asObject());
            available_bus_table.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getBusnm()));
            on_trip_table.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getOn_trip()));

            List<String> availableBuses = new ArrayList<>();
            List<String> onTrip = new ArrayList<>();

            while (rs3.next()) {
                onTrip.add(rs3.getString("bus_nme"));
            }
            while (rs2.next()) {
                availableBuses.add(rs2.getString("bus_name"));
            }

            while (rs.next()) {
                String busName = rs.getString("bus_name");
                int seatCapacity = rs.getInt("bus_capacity");
                String availability = availableBuses.contains(busName) ? "Available" : "Not Available";
                String trip = onTrip.contains(busName) ? "ON Trip" : "Off Trip";
                ath_table_vies.getItems().add(new Bus(busName, seatCapacity, availability, trip));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void add_bus_switch(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("add_bus_form.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Dashboard");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void assign_bus_switch(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("assign_bus_form.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Assign");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Stage stage = new Stage();

    @FXML
    void ath_log_out(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to log out?");

        ButtonType buttonTypeOK = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(buttonTypeOK, buttonTypeCancel);

        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == buttonTypeOK) {
            Stage currentStage = (Stage) ath_logout_btn.getScene().getWindow();
            currentStage.close();
        }
    }

    @FXML
    void bus_return_switch(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("bus-returen_clearance.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Return Bus");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void card_checker_switch(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("card_cheacker.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("card checker");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void check_bus_request(ActionEvent event) {
    }

    @FXML
    void refresh_rlode_btn(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("authority_dashboard.fxml"));
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
}
