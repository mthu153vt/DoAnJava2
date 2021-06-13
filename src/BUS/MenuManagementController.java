/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAL.ItemDAL;
import DTO.ItemDTO;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

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
    @FXML
    private TableView<ItemDTO> tb_item;
    
    /**
     * Initializes the controller class.
     */
    
    ObservableList<ItemDTO> item_data = FXCollections.observableArrayList();
    ItemDAL item_dal = new ItemDAL();

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TableColumn itemIDCol = new TableColumn("ID");
        TableColumn itemnameCol = new TableColumn("ITEMNAME");
        TableColumn priceCol = new TableColumn("PRICE");
        TableColumn describeCol = new TableColumn("DESCRIBE");
        
        itemIDCol.setCellValueFactory(new PropertyValueFactory<>("ItemID"));
        itemnameCol.setCellValueFactory(new PropertyValueFactory<>("itemname"));
        describeCol.setCellValueFactory(new PropertyValueFactory<>("describe"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        
        tb_item.getColumns().addAll(itemIDCol, itemnameCol, priceCol, describeCol);
        item_data = item_dal.GetData();
        tb_item.setItems(item_data);
    }    
    
    
    @FXML
    private void Action_Con_DelItem(ActionEvent event) {
        
        ItemDTO item = tb_item.getSelectionModel().getSelectedItem();
	item_dal.Delete(item);
	item_data = item_dal.GetData();
        JOptionPane.showMessageDialog(null,"Deleting Successful","Menu", JOptionPane.INFORMATION_MESSAGE);
    }


    @FXML
    private void Action_Con_EditItem(ActionEvent event) throws SQLException {
        if (CheckInputItem()){
        ItemDTO item = getItemFromGUI();
        ItemDTO itemid = tb_item.getSelectionModel().getSelectedItem();
        
        if(item_dal.Update(item, itemid.getItemID())){
            item_data = item_dal.GetData();
            JOptionPane.showMessageDialog(null,"Editing Successful","Menu", JOptionPane.INFORMATION_MESSAGE);
        }
        }
    }

    @FXML
    private void displayItem(MouseEvent event) throws SQLException {
        ItemDTO item = tb_item.getSelectionModel().getSelectedItem();
	
	txt_item_name.setText(item.getItemname());
	txt_item_description.setText(item.getDescribe());
	txt_item_price.setText(Integer.toString(item.getPrice()));
    }

    @FXML
    private void Action_Con_AddItem(ActionEvent event) {
        if (CheckInputItem()){
        ItemDTO item = getItemFromGUI();
        if(item_dal.Insert(item)){   
            item_data = item_dal.GetData();
            JOptionPane.showMessageDialog(null,"Adding Successful","Menu", JOptionPane.INFORMATION_MESSAGE);
        }
       }
    }

    @FXML
    private void act_back(ActionEvent event) throws IOException {
//        Stage stage = (Stage) btn_back.getScene().getWindow();
//         stage.close();
            ((Node) (event.getSource())).getScene().getWindow().hide();
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../GUIs/AdminHome.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    }
    
    private ItemDTO getItemFromGUI(){
        ItemDTO item;
        item = new ItemDTO(0,txt_item_name.getText(), txt_item_description.getText(), Integer.parseInt(txt_item_price.getText()));
        
        return item;
    }

    private boolean CheckInputItem(){
        
        String input[] = {txt_item_name.getText(), txt_item_price.getText()};
        String property[] = {"NAME", "PRICE"};
        for (int i = 0 ; i< input.length; i++){
            if (input[i] == null || input[i].equals("")){
                String ErrorStr = property[i] + " is empty";
                JOptionPane.showMessageDialog(null,ErrorStr,"Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }

    
}
