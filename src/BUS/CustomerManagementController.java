/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAL.CustomerDAL;
import DTO.CustomerDTO;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private TextField txt_customer_name;
    @FXML
    private TextField txt_customer_point;
    @FXML
    private TextField txt_customer_numberphone;
    @FXML
    private Button btn_back;
    @FXML
    private TableView<CustomerDTO> tb_customer;
    @FXML
    private RadioButton btn_male;
    @FXML
    private RadioButton btn_female;
    @FXML
    private ToggleGroup group_gender;
    /**
     * Initializes the controller class.
     */
    
    ObservableList<CustomerDTO> cus_data = FXCollections.observableArrayList();
    CustomerDAL cus_dal = new CustomerDAL();
    String gender = null;
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        TableColumn customerIDCol = new TableColumn("ID");
        TableColumn fullnameCol = new TableColumn("FULL NAME");
        TableColumn genderCol = new TableColumn("GENDER");
        TableColumn numberphoneCol = new TableColumn("NUMBERPHONE");
        TableColumn membershiptierCol = new TableColumn("MEMBERSHIPTIER");        
        TableColumn membershippointCol = new TableColumn("POINT"); 
        TableColumn usernameCol = new TableColumn("USERNAME"); 
        
        customerIDCol.setCellValueFactory(new PropertyValueFactory<>("CustomerID"));
        fullnameCol.setCellValueFactory(new PropertyValueFactory<>("fullname"));
        genderCol.setCellValueFactory(new PropertyValueFactory<>("gender"));
        numberphoneCol.setCellValueFactory(new PropertyValueFactory<>("numberphone"));
        membershiptierCol.setCellValueFactory(new PropertyValueFactory<>("membershiptier"));
        membershippointCol.setCellValueFactory(new PropertyValueFactory<>("membershippoint"));
        usernameCol.setCellValueFactory(new PropertyValueFactory<>("username"));
        
        tb_customer.getColumns().addAll(customerIDCol, fullnameCol, genderCol, numberphoneCol, membershiptierCol, membershippointCol, usernameCol);
        cus_data = cus_dal.GetData();
        tb_customer.setItems(cus_data);

    }    

    @FXML
    private void displayCus(MouseEvent event) {
        CustomerDTO cus = tb_customer.getSelectionModel().getSelectedItem();
        
        txt_customer_name.setText(cus.getFullname());
        txt_customer_numberphone.setText(cus.getNumberphone());
        txt_customer_point.setText(Integer.toString(cus.getMembershippoint()));
        if(cus.getGender() == null){
            gender = null;
        }
        else if(cus.getGender().equals("MALE")) {
            btn_male.setSelected(true); 
            gender = "MALE";
        }
        else if(cus.getGender().equals("FEMALE")) {
            btn_female.setSelected(true);
            gender = "FEMALE";
        }
    }
    
    @FXML
    private void Action_Con_DelCus(ActionEvent event) throws SQLException {
        
        CustomerDTO cus = tb_customer.getSelectionModel().getSelectedItem();
        cus_dal.Delete(cus);
        cus_data = cus_dal.GetData();
        JOptionPane.showMessageDialog(null,"Deleting Successful","Customer", JOptionPane.INFORMATION_MESSAGE);
    }
    
    @FXML
    private void Action_Con_EditCus(ActionEvent event) throws SQLException {
        if (CheckInputCus()){
            CustomerDTO cus = getCustomerFromGUI();
            CustomerDTO cusid = tb_customer.getSelectionModel().getSelectedItem();
        
            if(cus_dal.Update(cus, cusid.getCustomerID())){
                cus_data = cus_dal.GetData();
                JOptionPane.showMessageDialog(null,"Editing Successful","Customer", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    @FXML
    private void act_back(ActionEvent event) throws IOException {
//       Stage stage = (Stage) btn_back.getScene().getWindow();
//       stage.close();
            ((Node) (event.getSource())).getScene().getWindow().hide();
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../GUIs/AdminHome.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    }
    
    
    private CustomerDTO getCustomerFromGUI(){
        String str;
        if(Integer.parseInt(txt_customer_point.getText()) > 2000000 && Integer.parseInt(txt_customer_point.getText()) < 5000000)
            str = "GOLD";
        else if(Integer.parseInt(txt_customer_point.getText()) >= 5000000)
            str = "PLATINUM";
        else str = "SILVER";
        
        CustomerDTO cus;
        cus = new CustomerDTO(0, txt_customer_name.getText(), gender, txt_customer_numberphone.getText(),str, Integer.parseInt(txt_customer_point.getText()), " ");
        
        return cus;
    }
    
    private boolean CheckInputCus(){
        
        String input[] = {txt_customer_name.getText(),gender,txt_customer_numberphone.getText(),txt_customer_point.getText()};
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

    @FXML
    private void act_male(ActionEvent event) {
        gender = "MALE";
    }

    @FXML
    private void act_female(ActionEvent event) {
        gender = "FEMALE";
    }

    
}
