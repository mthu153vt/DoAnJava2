/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

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
    private BorderPane border_pane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void click_login(MouseEvent event) throws IOException {
        Parent loginPage = FXMLLoader.load(getClass().getResource("/GUIs/Login.fxml"));
        
         border_pane.setCenter(loginPage);
    }
    
}
