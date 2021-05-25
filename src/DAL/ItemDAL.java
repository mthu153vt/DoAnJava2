/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BUS.LoginController;
import DTO.EmployeeDTO;
import DTO.ItemDTO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

/**
 *
 * @author htthi
 */
public class ItemDAL {
    public ItemDAL(){}
    
    ObservableList<ItemDTO> Data = FXCollections.observableArrayList();
    
    public boolean Insert(ItemDTO item) {
        try{
            String item_sql;
            item_sql = String.format("INSERT INTO ITEM VALUES (ITEMID_SEQ.nextval, ?,?,?)");
            PreparedStatement pres = LoginController.connection.con.prepareStatement(item_sql);
            
            pres.setString(1, item.getItemname());
            pres.setString(2, item.getDescribe());
            pres.setInt(3, item.getPrice());
            
            int rows = pres.executeUpdate();
            if(rows > 0)
                return true;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.toString(),"Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return false;
    }
    
    public boolean Delete(ItemDTO item) {
        try{    
            String item_sql;
            item_sql = String.format("DELETE FROM ITEM WHERE ITEM_ID = ?");
            PreparedStatement pres = LoginController.connection.con.prepareStatement(item_sql);
            pres.setInt(1, item.getItemID());
            
            int rows = pres.executeUpdate();
            if(rows > 0)
                return true;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.toString(),"Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return false;
    }
    
    public boolean Update(ItemDTO item, int id) {
        try{    
            String item_sql;
            item_sql = String.format("UPDATE ITEM SET ITEMNAME=?, DESCRIBE=?, PRICE=? WHERE ITEM_ID = ?");
            PreparedStatement pres = LoginController.connection.con.prepareStatement(item_sql);
            
            pres.setString(1, item.getItemname());
            pres.setString(2, item.getDescribe());
            pres.setInt(3, item.getPrice());
            pres.setInt(4, item.getItemID());
 
            int rows = pres.executeUpdate();
            if(rows > 0)
                return true;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.toString(),"Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return false;    
    }
}
