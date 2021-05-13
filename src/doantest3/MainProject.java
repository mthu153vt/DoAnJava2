package doantest3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class MainProject extends Application {

    
    public static void main(String[] args) {
        Application.launch(args);
    
    }
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("./GUIs/Login.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    
}