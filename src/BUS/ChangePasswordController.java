/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAL.AccountDAL;
import DTO.AccountDTO;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author htthi
 */
public class ChangePasswordController implements Initializable {

    @FXML
    private Text txt_username;
    @FXML
    private Button btn_changepass;
    @FXML
    private PasswordField txt_password;
    @FXML
    private PasswordField txt_newpassword;
    @FXML
    private PasswordField txt_confirmpass;
    /**
     * Initializes the controller class.
     */
    AccountDTO account;
    AccountDAL acc_dal = new AccountDAL();
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void act_change_pass(ActionEvent event) throws SQLException{
        if(CheckInput()){
            AccountDTO acc = getInfoFromGUI();
            if(acc_dal.UpdatePassword(acc.getPassword(), account)){
                account.setPassword(acc.getPassword());
                JOptionPane.showMessageDialog(null,"Editing Successful","Customer", JOptionPane.INFORMATION_MESSAGE);
            }
            Stage stage = (Stage) btn_changepass.getScene().getWindow();
            stage.close();
        }
    }
    
    private boolean CheckInput(){
        String input[] = {txt_password.getText(), txt_newpassword.getText()};
        String property[] = {"PASSWORD", "NEW PASSWORD"};
        for (int i = 0 ; i< input.length; i++){
            if (input[i] == null || input[i].equals("")){
                String ErrorStr = property[i] + " is empty";
                JOptionPane.showMessageDialog(null,ErrorStr,"Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        if(!(account.getPassword().equals(txt_password.getText()))){
            String ErrorStr = "Password wrong!";
            JOptionPane.showMessageDialog(null,ErrorStr,"Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if( !(txt_newpassword.getText().equals(txt_confirmpass.getText()))){
            String ErrorStr = "Confirm Password doesnt match with the password!";
            JOptionPane.showMessageDialog(null,ErrorStr,"Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    private AccountDTO getInfoFromGUI(){
        AccountDTO acc;
        acc = new AccountDTO(" ", txt_newpassword.getText(), " ");
        
        return acc;
    }
    
    public void getAccount(AccountDTO acc){
        this.account = acc;
    }
}
