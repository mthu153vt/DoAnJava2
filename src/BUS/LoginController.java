/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAL.DBConnection;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import doantest3.MainProject;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Computer
 */
public class LoginController implements Initializable {

    @FXML
    private Button btnLogin;
    @FXML
    private Button btnCreateAccount;
    @FXML
    private TextField usertextField;
    @FXML
    private PasswordField passtextField;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void click_login(MouseEvent event) throws IOException {
        String username = usertextField.getText();
        String password = passtextField.getText();
        String role = "";
        if (username.equals("admin") && password.equals("admin")){
            role = "Admin";
        }else if (username.equals("employee") && password.equals("employee")){
            role = "employee";
        }else if (username.equals("customer") && password.equals("customer")){
            role = "customer";
        }else {
            return;
        }
       // if ( connection.OpenConnection()){
            ((Node) (event.getSource())).getScene().getWindow().hide();
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../GUIs/" +role + ".fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        //}
        
        
    }
    public static DBConnection connection = new DBConnection();
}