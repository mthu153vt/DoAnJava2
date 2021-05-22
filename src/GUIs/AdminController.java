/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIs;

import DAL.EmployeeDAL;
import DTO.EmployeeDTO;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author htthi
 */
public class AdminController implements Initializable {

    @FXML
    private Button btn_delete_customer;
    @FXML
    private Button btn_apply_edit_cus;
    @FXML
    private ListView<?> ls_customer;
    @FXML
    private TextField txt_customerid;
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
    private Button btn_delete_emp;
    @FXML
    private Button btn_apply_edit_emp;
    @FXML
    private ListView<EmployeeDTO> ls_employee; 
    @FXML
    private TextField txt_emp_id;
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
    private Button btn_delete_item;
    @FXML
    private Button btn_apply_edit_item;
    @FXML
    private ListView<?> ls_item;
    @FXML
    private TextField txt_item_id;
    @FXML
    private TextField txt_item_name;
    @FXML
    private TextField txt_item_description;
    @FXML
    private TextField txt_item_price;
    @FXML
    private ImageView img_item;
    @FXML
    private Button btn_add_item;
    @FXML
    private Button btn_log_out;

    
    ObservableList<EmployeeDTO> emp_data = FXCollections.observableArrayList();
    EmployeeDAL emp_dal = new EmployeeDAL();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        emp_data = emp_dal.GetData();
//        ls_employee.setItems(emp_data);

        EmployeeDTO e1;
        e1 = new EmployeeDTO(10, "hello", "nam", "123abc", 012333, 2044444, "11112000", "20102012", "employee");
        emp_data.add(e1);
        ls_employee.setItems(emp_data);
          
    }    

    
    @FXML
    private void displayEmp(MouseEvent event) {
        EmployeeDTO employee  = ls_employee.getSelectionModel().getSelectedItem();
        
        txt_emp_id.setText(Double.toString(employee.getEmployeeID()));
        txt_emp_name.setText(employee.getFullname());
        txt_emp_birthday.setText(employee.getDateofbirth());
        txt_emp_gender.setText(employee.getGender());
        txt_start_date.setText(employee.getDatestartworking());
        txt_salary.setText(Double.toString(employee.getSalary()));
    }
    
    @FXML
    private void deleteButtonEmp(ActionEvent event) {
    }

    @FXML
    private void editButtonEmp(ActionEvent event) {
    }

    @FXML
    private void addButtonEmp(ActionEvent event) {
    }

    @FXML
    private void logoutButton(ActionEvent event) {
    }
    
    private EmployeeDTO getEmpFromGUI(){
        EmployeeDTO emp;
        emp = new EmployeeDTO(Integer.parseInt(txt_emp_id.getText()),txt_emp_name.getText(), txt_emp_gender.getText(), " ", 0, Integer.parseInt(txt_salary.getText()),txt_emp_birthday.getText(), txt_start_date.getText(), " " );
        
        return emp;
    }
    
    
}
