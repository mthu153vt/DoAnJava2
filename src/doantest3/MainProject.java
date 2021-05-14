package doantest3;

import java.io.IOException;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
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
        Parent root = FXMLLoader.load(getClass().getResource("../GUIs/Login.fxml"));
        primaryStage.setTitle("Login Page");
        primaryStage.setScene(new Scene(root));
        primaryStage.show(); 
    }
    
    public static void ShowForm(String fxml , boolean newwindow, ActionEvent event) throws IOException{
        
        Task<Parent> task = new Task<Parent>() {
            @Override
            protected Parent call() throws Exception {
                return FXMLLoader.load(MainProject.class.getResource(fxml));
            }
        };

        task.setOnSucceeded(event2 -> {
            Parent root = task.getValue();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            if (!newwindow){
                ((Node)(event.getSource())).getScene().getWindow().hide();
            }
        });
        Thread thread = new Thread(task);
        thread.start();
    }
}