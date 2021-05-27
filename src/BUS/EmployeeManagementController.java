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
public class EmployeeManagementController implements Initializable {

    @FXML
    private Button btn_delete_emp;
    @FXML
    private Button btn_apply_edit_emp;
    @FXML
    private ListView<?> ls_employee;
    @FXML
    private TextField txt_emp_name;
    @FXML
    private TextField txt_emp_birthday;
    @FXML
    private TextField txt_emp_gender;
    @FXML
    private TextField txt_start_date;
    @FXML
    private TextField txt_salary;
    @FXML
    private Button btn_add_emp;
    @FXML
    private Button btn_back;
    @FXML
    private TextField txt_emp_address;
    @FXML
    private TextField txt_emp_numberphone;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Action_Con_DelEmp(ActionEvent event) {
    }

    @FXML
    private void displayEmp(MouseEvent event) {
    }

    @FXML
    private void act_back(ActionEvent event) {
        Stage stage = (Stage) btn_back.getScene().getWindow();
        stage.close();
    }
    
}
