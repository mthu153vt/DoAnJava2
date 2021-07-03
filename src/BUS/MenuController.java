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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author lvlsp
 */
public class MenuController implements Initializable {

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
