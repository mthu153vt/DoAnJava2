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
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    String gender = null;
    AccountDTO account;
    AccountDAL acc_dal = new AccountDAL();
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
        gender = "MALE";
    }

    @FXML
    private void act_female(ActionEvent event) {
        gender = "FEMALE";
    }

    @FXML
    private void act_apply(ActionEvent event) {
        if(CheckInput()){
            
        }
    }
    
    private CustomerDTO getCustomerFromGUI(){
        CustomerDTO cus;
        cus = new CustomerDTO(0, txt_fullname.getText(), gender, txt_phone.getText(),txt_username.getText());
        
        return cus;
    }
    
    private boolean CheckInput(){
        
        String input[] = {txt_fullname.getText(), txt_phone.getText(), tx_password.getText(), gender};
        String property[] = {"FULLNAME", "NUMBERPHONE","PASSWORD", "GENDER"};
        for (int i = 0 ; i< input.length; i++){
            if (input[i] == null || input[i].equals("")){
                String ErrorStr = property[i] + " is empty";
                JOptionPane.showMessageDialog(null,ErrorStr,"Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        if( !(tx_password.getText().equals(txt_confirmpass.getText()))){
            String ErrorStr = "Re-type Password wrong";
            JOptionPane.showMessageDialog(null,ErrorStr,"Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    public void showinfoCus(AccountDTO account){
        String username = account.getUsername();
        CustomerDTO cus = cus_dal.getCusInfo(username);
        
        txt_username.setText(cus.getUsername());
        txt_fullname.setText(cus.getFullname());
        txt_phone.setText(cus.getNumberphone());
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
    
    public void getAccount(AccountDTO acc){
        this.account = acc;
    }
    
}
