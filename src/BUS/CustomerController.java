/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DTO.AccountDTO;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author lvlsp
 */
public class CustomerController implements Initializable {

    @FXML
    private AnchorPane pane;
    @FXML
    private Button btn_menu;
    @FXML
    private Button btn_voucher;
    @FXML
    private Button btn_info;
    @FXML
    private Button btn_logout;

    /**
     * Initializes the controller class.
     */
    AccountDTO account;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Act_menu(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene();
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../GUIs/Menu.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    }

    @FXML
    private void act_voucher(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../GUIs/Voucher.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    }

    @FXML
    private void act_info(ActionEvent event) throws IOException {
//        ((Node) (event.getSource())).getScene().getWindow();
//            Stage stage = new Stage();
//            Parent root = FXMLLoader.load(getClass().getResource("../GUIs/CustomerInfo.fxml"));
//            //Parent root = FXMLLoader.load(getClass().getResource("../GUIs/PersonalInfo.fxml"));
//            Scene scene = new Scene(root);
//            stage.setScene(scene);
//            stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUIs/PersonalInfo.fxml"));
        Parent root = loader.load();
                
        PersonalInfoController controller = loader.getController();
        controller.getAccount(account);
        controller.showinfoCus(account);
        
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }

    @FXML
    private void act_logout(ActionEvent event) throws IOException {
        final String mgs="Are you sure to log out?";
         Alert alert= new Alert (Alert.AlertType.CONFIRMATION);
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
    
    public void getAccount(AccountDTO acc){
        this.account = acc;
    }

}
