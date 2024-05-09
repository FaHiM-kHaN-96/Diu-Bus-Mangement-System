package test.logi_in;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage1) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("selectport.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage1.setTitle("Hello!");
        stage1.setScene(scene);
        stage1.setResizable(false);
        stage1.show();
    }

    public static void main(String[] args) {
        launch();
    }
}