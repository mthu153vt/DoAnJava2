/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAL.CustomerDAL;
import DTO.CustomerDTO;
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
public class CustomerManagementController implements Initializable {

    @FXML
    private Button btn_delete_customer;
    @FXML
    private Button btn_apply_edit_cus;
    @FXML
    private ListView<CustomerDTO> ls_customer;
    @FXML
    private TextField txt_customer_name;
    @FXML
    private TextField txt_customer_gender;
    @FXML
    private TextField txt_customer_point;
    @FXML
    private TextField txt_customer_numberphone;
    @FXML
    private Button btn_back;
    

    /**
     * Initializes the controller class.
     */
    
    ObservableList<CustomerDTO> cus_data = FXCollections.observableArrayList();
    CustomerDAL cus_dal = new CustomerDAL();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cus_data = cus_dal.GetData();
        ls_customer.setItems(cus_data);
        
        //thuộc tính hiện trên listView
        ls_customer.setCellFactory(param -> new ListCell<CustomerDTO>() {
            @Override
            protected void updateItem(CustomerDTO e, boolean empty) {
                super.updateItem(e, empty);

                if (empty || e == null || e.getUsername() == null) {
                    setText(null);
                } else {
                    setText("ID: " + e.getCustomerID()+ "          " + "Username: " + e.getUsername() +"          "+e.getFullname() + "          " + e.getMembershiptier());
                }
            }
        });
    }    

    @FXML
    private void Action_Con_DelCus(ActionEvent event) throws SQLException {
        
        CustomerDTO cus = ls_customer.getSelectionModel().getSelectedItem();
        cus_dal.Delete(cus);
        cus_data = cus_dal.GetData();
        JOptionPane.showMessageDialog(null,"Deleting Successful","Customer", JOptionPane.INFORMATION_MESSAGE);
    }
    
    @FXML
    private void Action_Con_EditCus(ActionEvent event) throws SQLException {
        if (CheckInputCus()){
            CustomerDTO cus = getCustomerFromGUI();
            CustomerDTO cusid = ls_customer.getSelectionModel().getSelectedItem();
        
            if(cus_dal.Update(cus, cusid.getCustomerID())){
                cus_data = cus_dal.GetData();
                JOptionPane.showMessageDialog(null,"Editing Successful","Customer", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    @FXML
    private void displayCus(MouseEvent event) {
        CustomerDTO cus = ls_customer.getSelectionModel().getSelectedItem();
        
        txt_customer_name.setText(cus.getFullname());
        txt_customer_gender.setText(cus.getGender());
        txt_customer_numberphone.setText(cus.getNumberphone());
        txt_customer_point.setText(Integer.toString(cus.getMembershippoint()));
        
    }

    @FXML
    private void act_back(ActionEvent event) {
       Stage stage = (Stage) btn_back.getScene().getWindow();
       stage.close();
    }
    
    
    private CustomerDTO getCustomerFromGUI(){
        String str;
        if(Integer.parseInt(txt_customer_point.getText()) > 2000000 && Integer.parseInt(txt_customer_point.getText()) < 5000000)
            str = "GOLD";
        else if(Integer.parseInt(txt_customer_point.getText()) > 5000000)
            str = "PLATINUM";
        else str = "SILVER";
        
        CustomerDTO cus;
        cus = new CustomerDTO(0, txt_customer_name.getText(), txt_customer_gender.getText(), txt_customer_numberphone.getText(),str, Integer.parseInt(txt_customer_point.getText()), " ");
        
        return cus;
    }
    
    private boolean CheckInputCus(){
        
        String input[] = {txt_customer_name.getText(),txt_customer_gender.getText(),txt_customer_numberphone.getText(),txt_customer_point.getText()};
        String property[] = {"NAME", "GENDER", "NUMBERPHONE", "POINT"};
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
