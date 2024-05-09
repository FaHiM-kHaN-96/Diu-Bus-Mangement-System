package test.logi_in;

import com.almasb.fxgl.net.Connection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController {



    @FXML
    private TextField lgpg_emailfeld;

    @FXML
    private PasswordField lgpg_passfeld;

    @FXML
    private Button login_btn;

    @FXML
    private Label passlabel;


    @FXML
    private ToggleButton togglebtn;

    @FXML
    private AnchorPane login_form;

    @FXML
    private Button sign_back_btn;

    @FXML
    private AnchorPane sign_up_form;

    @FXML
    private TextField signpg_emailfeld;

    @FXML
    private TextField signpg_passfeld;

    @FXML
    private TextField signpg_repassfeld;

    @FXML
    private Button signpg_signup_btn;

    @FXML
    private Button signup_btn;

   private boolean passwordVisible = false;

    @FXML
    void back_btn(ActionEvent event) {
        login_form.setVisible(true);
        sign_up_form.setVisible(false);
    }

    @FXML
    void showpass_btn(ActionEvent event) {
        if (!passwordVisible) {
            passlabel.setText(lgpg_passfeld.getText());
            passlabel.setVisible(true);
            lgpg_passfeld.setVisible(false);
            passwordVisible = true;
        }else {
            // Password is currently shown, hide it
            lgpg_passfeld.setText(passlabel.getText());  // Sync text with label
            lgpg_passfeld.setVisible(true);
            passlabel.setVisible(false);
            passwordVisible = false;
        }
    }


    @FXML
    void lgpg_login_btn(ActionEvent event) {

        String email = lgpg_emailfeld.getText();
        String pass = lgpg_passfeld.getText();
        if (!email.isEmpty() && !pass.isEmpty()){
            if (DBdetails.userlogin(email,pass)){

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle(null);
                alert.setHeaderText(null);
                alert.setContentText("Log in success");
                alert.showAndWait();
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("dashbord.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());
                    Stage stage = new Stage();
                    stage.setTitle("Hellaaaa");
                    stage.setScene(scene);
                    stage.setResizable(false);
                    stage.show();
                    Stage currentStage = (Stage) login_btn.getScene().getWindow();
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
    void lgpg_signup_btn(ActionEvent event) {
        login_form.setVisible(false);
        sign_up_form.setVisible(true);
    }

    @FXML
    void sign_sg_up(ActionEvent event) {

        String signemail = signpg_emailfeld.getText();
        String signpass = signpg_passfeld.getText();
        String signre_pass = signpg_repassfeld.getText();

        if (!signpass.isEmpty() && !signpass.isEmpty() && !signre_pass.isEmpty() ){
            if (signpass.equals(signre_pass)){

                if (DBdetails.signup(signemail,signre_pass)){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle(null);
                    alert.setHeaderText(null);
                    alert.setContentText("Sign Up success");
                    alert.showAndWait();
                    login_form.setVisible(true);
                    sign_up_form.setVisible(false);

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
    void initialize(URL location , ResourceBundle resources) {

    }


    public void userInformation(String email, String passord) {

    }
}