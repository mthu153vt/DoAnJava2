/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BUS.LoginController;
import DTO.BillDetailDTO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

/**
 *
 * @author htthi
 */
public class BillDetailDAL {
    public BillDetailDAL(){}
    
    ObservableList<BillDetailDTO> Data = FXCollections.observableArrayList();
    
     public boolean Insert(BillDetailDTO billDetail) {
        try{
            String billDetail_sql;
            billDetail_sql = String.format("INSERT INTO BILLDETAIL VALUES (BILLID_SEQ.currval,?,?)");
            PreparedStatement pres = LoginController.connection.con.prepareStatement(billDetail_sql);

            pres.setInt(1, billDetail.getItemID());
            pres.setInt(2, billDetail.getQuantity());
            
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
