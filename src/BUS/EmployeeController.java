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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author lvlsp
 */
public class EmployeeController implements Initializable {

    @FXML
    private Button btn_billing;
    @FXML
    private Button btn_mem_card;
    @FXML
    private Button btn_log_out;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void act_bill(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow();
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../GUIs/Billing.fxml"));
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

    @FXML
    private void act_print_memcard(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow();
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../GUIs/Membership.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    }
}
    

