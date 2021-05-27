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
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author htthi
 */
public class CustomerManagementController implements Initializable {

    @FXML
    private Button btn_delete_customer;
    @FXML
    private Button btn_apply_edit_cus;
    @FXML
    private ListView<?> ls_customer;
    @FXML
    private TextField txt_customer_user_name;
    @FXML
    private TextField txt_customer_name;
    @FXML
    private TextField txt_customer_gender;
    @FXML
    private TextField txt_customer_birthday;
    @FXML
    private TextField txt_customer_point;
    @FXML
    private Button btn_back;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Action_Con_DelCus(ActionEvent event) {
    }

    @FXML
    private void Action_Con_EditCus(ActionEvent event) {
    }

    @FXML
    private void displayCus(MouseEvent event) {
    }

    @FXML
    private void act_back(ActionEvent event) {
       Stage stage = (Stage) btn_back.getScene().getWindow();
       stage.close();
    }
    
}
