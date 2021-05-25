/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAL.EmployeeDAL;
import DTO.EmployeeDTO;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author htthi
 */
public class AdminController implements Initializable {

    @FXML
    private Tab tab_customer;
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
    private Tab tab_employee;
    @FXML
    private Button btn_delete_emp;
    @FXML
    private Button btn_apply_edit_emp;
    @FXML
    private ListView<EmployeeDTO> ls_employee;
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
    private TextField txt_emp_address;
    @FXML
    private TextField txt_emp_numberphone;
    @FXML
    private Tab tab_food;
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
    private ImageView img_logo;
    @FXML
    private Text txt_title;

    ObservableList<EmployeeDTO> emp_data = FXCollections.observableArrayList();
    EmployeeDAL emp_dal = new EmployeeDAL();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        emp_data = emp_dal.GetData();
//        ls_employee.setItems(emp_data);

        EmployeeDTO e1, e2;
        e1 = new EmployeeDTO(10, "hello", "nam", "123abc", "0987651123", 2044444, "11-11-2000", "20-10-2012", "employee");
        e2 = new EmployeeDTO(20, "hi", "nu", "2abc", "09000009", 200003, "11-08-1999", "29-11-2015", "admin");
        
        emp_data.addAll(e1, e2);
        ls_employee.setItems(emp_data);
    }    

    

    @FXML
    private void displayEmp(MouseEvent event) {
        EmployeeDTO employee  = ls_employee.getSelectionModel().getSelectedItem();
        
        txt_emp_name.setText(employee.getFullname());
        txt_emp_birthday.setText(employee.getDateofbirth());
        txt_emp_address.setText(employee.getAddress());
        txt_emp_gender.setText(employee.getGender());
        txt_start_date.setText(employee.getDatestartworking());
        txt_salary.setText(Double.toString(employee.getSalary()));
        txt_emp_numberphone.setText(employee.getNumberphone());
    }
    
    @FXML
    private void Action_Con_DelEmp(ActionEvent event) throws SQLException {
        
        EmployeeDTO emp = ls_employee.getSelectionModel().getSelectedItem();
        emp_dal.Delete(emp);
        emp_data = emp_dal.GetData();
    }

    @FXML
    private void Action_Con_EditEmp(ActionEvent event) {
        if (CheckInputEmp()){
        EmployeeDTO emp = getEmployeeFromGUI();
        EmployeeDTO empid = ls_employee.getSelectionModel().getSelectedItem();
        emp_dal.Update(emp, empid.getEmployeeID());
        emp_data = emp_dal.GetData();
       }
    }

    @FXML
    private void Action_Con_AddEmp(ActionEvent event) throws SQLException {
       if (CheckInputEmp()){
        EmployeeDTO emp = getEmployeeFromGUI();
        emp_dal.Insert(emp);
        emp_data = emp_dal.GetData();
       }
    }
    
    private EmployeeDTO getEmployeeFromGUI(){
        EmployeeDTO emp;
        emp = new EmployeeDTO(0,txt_emp_name.getText(), txt_emp_gender.getText(),txt_emp_address.getText(), txt_emp_numberphone.getText(), Integer.parseInt(txt_salary.getText()),txt_emp_birthday.getText(), txt_start_date.getText(), " " );
        
        return emp;
    }
    
    private boolean CheckInputEmp(){
        
        String input[] = {txt_emp_name.getText(),txt_emp_birthday.getText(),txt_emp_address.getText(),txt_emp_gender.getText(),txt_start_date.getText(), txt_salary.getText(), txt_emp_numberphone.getText()};
        String property[] = {"NAME", "BIRTHDAY", "ADDRESS", "GENDER", "START DAY", "SALARY", "NUMBERPHONE"};
        for (int i = 0 ; i< input.length; i++){
            if (input[i] == null || input[i].equals("")){
                String ErrorStr = property[i] + " is empty";
                JOptionPane.showMessageDialog(null,ErrorStr,"Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++   
    
    @FXML
    private void Action_Con_DelItem(ActionEvent event) {
    }

    @FXML
    private void Action_Con_EditItem(ActionEvent event) {
    }

    @FXML
    private void displayItem(MouseEvent event) {
    }

    @FXML
    private void Action_Con_AddItem(ActionEvent event) {
    }
    
    
    
    @FXML
    private void Action_Con_DelCus(ActionEvent event) {
    }
    
    @FXML
    private void Action_logout_Emp(ActionEvent event) {
    }
}
