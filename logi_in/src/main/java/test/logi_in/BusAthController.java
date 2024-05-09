package test.logi_in;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class BusAthController {

    @FXML
    private TextField at_ag_usrnemfld;

    @FXML
    private PasswordField ath_lgpg_passfeld;

    @FXML
    private Button ath_login_btn;

    @FXML
    private AnchorPane ath_loginpage;

    @FXML
    private Label ath_passlabel1;

    @FXML
    private Button ath_signIN_btn;

    @FXML
    private Button ath_sign_back_btn;

    @FXML
    private TextField ath_sign_email;

    @FXML
    private AnchorPane ath_signpage;

    @FXML
    private TextField ath_signpg_passfeld;

    @FXML
    private TextField ath_signpg_repassfeld;

    @FXML
    private Button ath_signpg_signup_btn;

    @FXML
    private ToggleButton ath_togglebtn;

    @FXML
    private Label passlabel;

    private boolean passwordVisible1 = false;

    @FXML
    void ath_back_btn(ActionEvent event) {

        ath_loginpage.setVisible(true);
        ath_signpage.setVisible(false);

    }

    @FXML
    void ath_showpass_btn(ActionEvent event) {
        if (!passwordVisible1) {
            ath_passlabel1.setText(ath_lgpg_passfeld.getText());
            ath_passlabel1.setVisible(true);
            ath_lgpg_passfeld.setVisible(false);
            passwordVisible1 = true;
        }else {
            // Password is currently shown, hide it
            ath_lgpg_passfeld.setText(ath_passlabel1.getText());  // Sync text with label
            ath_lgpg_passfeld.setVisible(true);
            ath_passlabel1.setVisible(false);
            passwordVisible1 = false;
        }

    }

    @FXML
    void ath_sign_sg_up(ActionEvent event) {
        String signemail1 = ath_sign_email.getText();
        String signpass1 = ath_signpg_passfeld.getText();
        String signre_pass1 = ath_signpg_repassfeld.getText();

        if (!signpass1.isEmpty() && !signpass1.isEmpty() && !signre_pass1.isEmpty() ){
            if (signpass1.equals(signre_pass1)){

                if (DBdetails.ath_signup(signemail1,signre_pass1)){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle(null);
                    alert.setHeaderText(null);
                    alert.setContentText("Sign Up success");
                    alert.showAndWait();
                    ath_loginpage.setVisible(true);
                    ath_signpage.setVisible(false);

                }else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle(null);
                    alert.setHeaderText(null);
                    alert.setContentText("signup failed");
                    alert.showAndWait();
                }



            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle(null);
                alert.setHeaderText(null);
                alert.setContentText("password error");
                alert.showAndWait();
            }
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText("Please enter your Email/password");
            alert.showAndWait();
        }

    }

    @FXML
    void switch_to_ath_dashbord(ActionEvent event) {

        String email1 = at_ag_usrnemfld.getText();
        String pass1 = ath_lgpg_passfeld.getText();
        if (!email1.isEmpty() && !pass1.isEmpty()){
            if (DBdetails.ath_userlogin(email1,pass1)){

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle(null);
                alert.setHeaderText(null);
                alert.setContentText("Log in success");
                alert.showAndWait();
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("authority_dashboard.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());
                    Stage stage = new Stage();
                    stage.setTitle("Hellaaaa");
                    stage.setScene(scene);
                    stage.setResizable(false);
                    stage.show();
                    Stage currentStage = (Stage) ath_login_btn.getScene().getWindow();
                    currentStage.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }else {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle(null);
                alert.setHeaderText(null);
                alert.setContentText("Log in failed");
                alert.showAndWait();

            }
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText("Please fill form ");
            alert.showAndWait();

        }

    }

    @FXML
    void switch_to_ath_signform(ActionEvent event) {

        ath_loginpage.setVisible(false);
        ath_signpage.setVisible(true);

    }

}
