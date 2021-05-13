/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doantest3;

import java.io.IOException;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 *
 * @author Computer
 */
public class MainProject extends Application{

    
    
    /*
    Stage: Khung cửa sổ
    Scene: nội dung trong khung màn hình
    Dimension: kích thước 
    */
       

    @Override
    public void start(Stage stage) throws Exception {
      Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
      stage.setTitle("Login Page");
      Scene scene = new Scene(root);
      stage.setScene(scene);
      //Hiển thị 
      stage.show();
    }
       public static void main(String[] args) throws IOException {
           launch(args);
    }
       
       /*public static void ShowForm(String fxml , boolean newwindow, ActionEvent event) throws IOException{
        
        Task<Parent> task = new Task<Parent>() {
            @Override
            protected Parent call() throws Exception {
                return FXMLLoader.load(Main.class.getResource(fxml));
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
        thread.start();*/
    
}
