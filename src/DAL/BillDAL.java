/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BUS.LoginController;
import DTO.BillDTO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

/**
 *
 * @author htthi
 */
public class BillDAL {
    public BillDAL(){}
    
    ObservableList<BillDTO> Data = FXCollections.observableArrayList();
    
    public boolean Insert(BillDTO bill) {
        try{
            String bill_sql;
            bill_sql = String.format("INSERT INTO BILL VALUES (BILLID_SEQ.nextval,?,TO_DATE(?,'YYYY-MM-DD'),?,?)");
            PreparedStatement pres = LoginController.connection.con.prepareStatement(bill_sql);

            pres.setInt(1, bill.getCustomerID());
            pres.setString(2, bill.getBilldate());
            pres.setString(3, bill.getPaymentmethod());
            pres.setInt(4, bill.getTotal());
            
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
