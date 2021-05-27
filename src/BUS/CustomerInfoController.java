/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author lvlsp
 */
public class CustomerInfoController implements Initializable {

    @FXML
    private TextField txt_username;
    @FXML
    private TextField txt_fullname;
    @FXML
    private TextField txt_phone;
    @FXML
    private Button btn_back;
    @FXML
    private TextField tx_password;
    @FXML
    private TextField txt_confirmpass;
    @FXML
    private RadioButton btn_male;
    @FXML
    private RadioButton btn_female;
    @FXML
    private Button btn_change;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       }    

    @FXML
    private void act_back(ActionEvent event) {
        ((Node) (event.getSource())).getScene();
            Stage stage = new Stage();
            stage.close();
    }

    @FXML
    private void act_male(ActionEvent event) {
        btn_female.setSelected(false);
    }

    @FXML
    private void act_female(ActionEvent event) {
         btn_male.setSelected(false);
        }

    @FXML
    private void act_apply(ActionEvent event) {
    }
    }

    


