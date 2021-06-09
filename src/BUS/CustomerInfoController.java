/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAL.AccountDAL;
import DAL.CustomerDAL;
import DTO.AccountDTO;
import DTO.CustomerDTO;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author htthi
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
    private RadioButton btn_male;
    @FXML
    private RadioButton btn_female;
    @FXML
    private Button btn_change;
    @FXML
    private Button btn_changepass;
    /**
     * Initializes the controller class.
     */
    String gender = null;
    
    AccountDTO account;
    AccountDAL acc_dal = new AccountDAL();
    
    CustomerDTO customer;
    CustomerDAL cus_dal = new CustomerDAL();

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    @FXML
    private void act_back(ActionEvent event) {
        Stage stage = (Stage) btn_back.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void act_male(ActionEvent event) {
        btn_female.setSelected(false);
        gender = "MALE";
    }

    @FXML
    private void act_female(ActionEvent event) {
        btn_male.setSelected(false);
        gender = "FEMALE";
    }

    @FXML
    private void act_apply(ActionEvent event) throws SQLException{
        if(CheckInput()){
            CustomerDTO cus = getCustomerFromGUI();
            if(acc_dal.UpdateUsername(cus.getUsername(), account)){
                cus_dal.Update(cus);
                JOptionPane.showMessageDialog(null,"Editing Successful","Customer", JOptionPane.INFORMATION_MESSAGE);
                
            }
        }
    }
    
    @FXML
    private void act_change_pass(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUIs/ChangePassword.fxml"));
        Parent root = loader.load();
        ChangePasswordController controller = loader.getController();
        controller.getAccount(account);
                
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();                    
    }
    
    private CustomerDTO getCustomerFromGUI(){
        CustomerDTO cus;
        cus = new CustomerDTO(customer.getCustomerID(), txt_fullname.getText(), gender, txt_phone.getText(),txt_username.getText());
        
        return cus;
    }
    
    private boolean CheckInput(){
        
        String input[] = {txt_username.getText(), txt_fullname.getText(), txt_phone.getText(), gender};
        String property[] = {"USERNAME", "FULLNAME", "NUMBERPHONE", "GENDER"};
        for (int i = 0 ; i< input.length; i++){
            if (input[i] == null || input[i].equals("")){
                String ErrorStr = property[i] + " is empty";
                JOptionPane.showMessageDialog(null,ErrorStr,"Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }
    
    public void showinfoCus(AccountDTO account){
        String username = account.getUsername();
        customer = cus_dal.getCusInfo(username);
        
        txt_username.setText(customer.getUsername());
        txt_fullname.setText(customer.getFullname());
        txt_phone.setText(customer.getNumberphone());
        if(customer.getGender() == null){
            gender = null;
        }
        else if(customer.getGender().equals("MALE")) {
            btn_male.setSelected(true); 
            gender = "MALE";
        }
        else if(customer.getGender().equals("FEMALE")) {
            btn_female.setSelected(true);
            gender = "FEMALE";
        }
    }
    
    public void getAccount(AccountDTO acc){
        this.account = acc;
    }

    

    
    
}
