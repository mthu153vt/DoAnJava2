/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import static javafx.application.Platform.exit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author lvlsp
 */
public class AdminController implements Initializable {

    @FXML
    private ImageView img_logo;
    @FXML
    private Text txt_title;
    @FXML
    private Button btn_logout;
    @FXML
    private Button btn_menu;
    @FXML
    private Button btn_voucher;
    @FXML
    private Button btn_info;
    @FXML
    private Button btn_info1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
    }    

   

    @FXML
    private void act_logout(ActionEvent event) throws IOException {
        final String mgs="Are you sure to log out?";
        Alert alert= new Alert (AlertType.CONFIRMATION);
        alert.setContentText(mgs);
        alert.setTitle("Confirm Log Out");
        Optional<ButtonType> result=alert.showAndWait();
        ButtonType button = result.orElse(ButtonType.CANCEL);
        if (button == ButtonType.OK) {
            ((Node) (event.getSource())).getScene().getWindow().hide();
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../GUIs/Login.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }        else {
            System.out.println("canceled");
        }
    }

    @FXML
    private void Act_cus_mag(ActionEvent event) throws IOException {
         ((Node) (event.getSource())).getScene();
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../GUIs/CustomerManagement.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    }
    @FXML
     private void act_emp_mag (ActionEvent event) throws IOException {
         ((Node) (event.getSource())).getScene();
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../GUIs/EmployeeManagement.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    }

    @FXML
    private void act_food_mag(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene();
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../GUIs/MenuManagement.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    }
    
}
