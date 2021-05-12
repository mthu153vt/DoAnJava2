/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doantest3;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
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
      Parent root = FXMLLoader.load(getClass().getResource("./View/Login.fxml"));
      Scene scene = new Scene(root);
      stage.setScene(scene);
      //Hiển thị 
      stage.show();
    }
       public static void main(String[] args) throws IOException {
           launch(args);
    }
    
}
