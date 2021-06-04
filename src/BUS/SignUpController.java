/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAL.AccountDAL;
import DAL.CustomerDAL;
import DTO.AccountDTO;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author lvlsp
 */
public class SignUpController implements Initializable {

    @FXML
    private PasswordField txt_password;
    @FXML
    private Button btn_Login;
    @FXML
    private TextField txt_username;
    @FXML
    private Button btn_CreateAccount;
    @FXML
    private PasswordField txt_retype_password;

    /**
     * Initializes the controller class.
     */
    
    AccountDAL acc_dal = new AccountDAL();
    CustomerDAL cus_dal = new CustomerDAL();
    @Override 
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Action_Login(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../GUIs/Login.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    }

    @FXML
    private void Action_CreateAccount(ActionEvent event) throws SQLException, IOException {
        if(CheckInputAccount()){
            AccountDTO account = getAccountFromGUI();
            
            if(acc_dal.Insert(account)){
                cus_dal.Insert(account.getUsername());
                
//                ((Node) (event.getSource())).getScene().getWindow().hide();
//                Stage stage = new Stage();
//                Parent root = FXMLLoader.load(getClass().getResource("../GUIs/CustomerHome.fxml"));
//                Scene scene = new Scene(root);
//                stage.setScene(scene);
//                stage.show();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUIs/CustomerHome.fxml"));
                Parent root = loader.load();
                
                CustomerController controller = loader.getController();
                controller.getAccount(account);
                
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
            else{
                JOptionPane.showMessageDialog(null,"Sign Up Failed"," Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    
    private AccountDTO getAccountFromGUI(){
        AccountDTO acc;
        acc = new AccountDTO(txt_username.getText(), txt_password.getText(), "customer");
        
        return acc;
    }
    
    private boolean CheckInputAccount(){
        String input[] = {txt_username.getText(), txt_password.getText(), txt_retype_password.getText()};
        String property[] = {"USERNAME ", "PASSWORD", "RE-TYPE PASSWORS"};
        for (int i = 0 ; i< input.length; i++){
            if (input[i] == null || input[i].equals("")){
                String ErrorStr = property[i] + " is empty";
                JOptionPane.showMessageDialog(null,ErrorStr,"Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        if( !(txt_password.getText().equals(txt_retype_password.getText()))){
            String ErrorStr = "Re-type Password wrong";
            JOptionPane.showMessageDialog(null,ErrorStr,"Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
}
