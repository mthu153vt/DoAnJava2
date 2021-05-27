/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author lvlsp
 */
public class SignUpController implements Initializable {

    @FXML
    private PasswordField txt_password;
    @FXML
    private Button btn_Login;
    @FXML
    private TextField txt_username;
    @FXML
    private Button btn_CreateAccount;
    @FXML
    private PasswordField txt_retype_password;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Action_Login(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../GUIs/Login.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    }

    @FXML
    private void Action_CreateAccount(ActionEvent event) {
    }
    
}
