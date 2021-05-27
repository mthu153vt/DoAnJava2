/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author htthi
 */
public class MenuManagementController implements Initializable {

    @FXML
    private Button btn_delete_item;
    @FXML
    private Button btn_apply_edit_item;
    @FXML
    private ListView<?> ls_item;
    @FXML
    private TextField txt_item_name;
    @FXML
    private TextField txt_item_description;
    @FXML
    private TextField txt_item_price;
    @FXML
    private ImageView img_item;
    @FXML
    private Button btn_add_item;
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
    private void Action_Con_DelItem(ActionEvent event) {
    }

    @FXML
    private void Action_Con_EditItem(ActionEvent event) {
    }

    @FXML
    private void displayItem(MouseEvent event) {
    }

    @FXML
    private void Action_Con_AddItem(ActionEvent event) {
    }

    @FXML
    private void act_back(ActionEvent event) {
        Stage stage = (Stage) btn_back.getScene().getWindow();
         stage.close();
    }
    
}
