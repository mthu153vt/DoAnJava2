/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author lvlsp
 */
public class MenuController implements Initializable {

    @FXML
    private Button btn_back;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btn_back(ActionEvent event) throws IOException {
        Stage stage = (Stage) btn_back.getScene().getWindow();
         stage.close();
//        ((Node) (event.getSource())).getScene().getWindow().hide();
//            Stage stage = new Stage();
//            Parent root = FXMLLoader.load(getClass().getResource("../GUIs/CustomerHome.fxml"));
//            Scene scene = new Scene(root);
//            stage.setScene(scene);
//            stage.show();
    }
    
}
