package BUS;

import DAL.AccountDAL;
import DAL.DBConnection;
import DTO.AccountDTO;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class LoginController implements Initializable {

    @FXML
    private PasswordField passtextField;
    @FXML
    private TextField usertextField;
    @FXML
    private Button btnLogin;
    @FXML
    private Button btnCreateAccount;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public static DBConnection connection = new DBConnection();

    @FXML
    private void Login_button(ActionEvent event) throws IOException {
        String username = usertextField.getText();
        String password = passtextField.getText();
        String role ;
        try{
            if ( connection.OpenConnection()){
                AccountDAL acc_dal = new AccountDAL();
                AccountDTO account = acc_dal.getAccountByUserNameAndPassword(username, password);
                
                if(account == null) {
                    connection.CloseConnection();
                    JOptionPane.showMessageDialog(null,"Login Failed!","Error", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    role = account.getAccountrole();
                    if(role.equals("customer")){
                        ((Node) (event.getSource())).getScene().getWindow().hide();
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
                    ((Node) (event.getSource())).getScene().getWindow().hide();
                    Stage stage = new Stage();
                    Parent root = FXMLLoader.load(getClass().getResource("../GUIs/" +role + "Home.fxml"));
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                    }
                        
                }
            }
                
            }catch(IOException ex) {
                    connection.CloseConnection();
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
          
//        if (username.equals("admin") && password.equals("admin")){
//            role = "Admin";
//        }else if (username.equals("sushimi") && password.equals("sushimi")){
//            role = "employee";
//        }else if (username.equals("potato123") && password.equals("customer")){
//            role = "customer";
//        }else {
//            return;
//        }
//        if ( connection.OpenConnection()){
//            ((Node) (event.getSource())).getScene().getWindow().hide();
//            Stage stage = new Stage();
//            Parent root = FXMLLoader.load(getClass().getResource("../GUIs/" +role + "Home.fxml"));
//            Scene scene = new Scene(root);
//            stage.setScene(scene);
//            stage.show();
//        }
    }     

    @FXML
    private void Action_Sign_up(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../GUIs/SignUp.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        
        
        
    }
    
}
