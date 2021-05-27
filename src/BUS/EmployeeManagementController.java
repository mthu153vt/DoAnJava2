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
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

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
    private Button btn_back;
    @FXML
    private TextField txt_emp_address;
    @FXML
    private TextField txt_emp_numberphone;

    /**
     * Initializes the controller class.
     */
    
    ObservableList<EmployeeDTO> emp_data = FXCollections.observableArrayList();
    EmployeeDAL emp_dal = new EmployeeDAL();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        emp_data = emp_dal.GetData();
        ls_employee.setItems(emp_data);
        
        //thuộc tính hiện trên listView
        ls_employee.setCellFactory(param -> new ListCell<EmployeeDTO>() {
            @Override
            protected void updateItem(EmployeeDTO e, boolean empty) {
                super.updateItem(e, empty);

                if (empty || e == null || e.getFullname() == null) {
                    setText(null);
                } else {
                    setText("ID: " + e.getEmployeeID() + "          " +e.getFullname());
                }
            }
        });
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
        
        if(emp_dal.Update(emp, empid.getEmployeeID())){
            emp_data = emp_dal.GetData();
            JOptionPane.showMessageDialog(null,"Editing Successful","Employee", JOptionPane.INFORMATION_MESSAGE);
        }
        
//        emp_dal.Update(emp, empid.getEmployeeID());
//        emp_data = emp_dal.GetData();
       }
    }

    @FXML
    private void Action_Con_AddEmp(ActionEvent event) throws SQLException {
        if (CheckInputEmp()){
        EmployeeDTO emp = getEmployeeFromGUI();
        if(emp_dal.Insert(emp)){
            emp_data = emp_dal.GetData();
            JOptionPane.showMessageDialog(null,"Adding Successful","Employee", JOptionPane.INFORMATION_MESSAGE);
        }
       }
    }
    
    @FXML
    private void displayEmp(MouseEvent event) {
        EmployeeDTO employee  = ls_employee.getSelectionModel().getSelectedItem();
        
        txt_emp_name.setText(employee.getFullname());
        txt_emp_birthday.setText(employee.getDateofbirth());
        txt_emp_address.setText(employee.getAddress());
        txt_emp_gender.setText(employee.getGender());
        txt_start_date.setText(employee.getDatestartworking());
        txt_salary.setText(Integer.toString(employee.getSalary()));
        txt_emp_numberphone.setText(employee.getNumberphone());
    }

    @FXML
    private void act_back(ActionEvent event) {
        Stage stage = (Stage) btn_back.getScene().getWindow();
        stage.close();
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
    
}
