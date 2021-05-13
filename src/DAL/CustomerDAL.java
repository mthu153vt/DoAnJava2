/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BUS.LoginController;
import DTO.CustomerDTO;

import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

/**
 *
 * @author Computer
 */
public class CustomerDAL {
    public CustomerDAL(){}
    
    ObservableList<CustomerDTO> Data = FXCollections.observableArrayList();
    
    public boolean Insert(CustomerDTO customer) {
        try {
            Object arg_acc[] = {customer.getUsername()};
            Object arg_cus[] = {customer.getCustomerID(), customer.getFullname(), customer.getGender(),customer.getNumberphone(), customer.getMembershippoint(), 
                customer.getMembershiptier()};
            
            String acc_sql;
            acc_sql = String.format("INSERT INTO ACCOUNT VALUES ('HV'||to_char(seq_student_id.currval,'FM00000'),'%s')", arg_acc);
            String cus_sql;
            cus_sql = String.format("INSERT INTO CUSTOMER VALUES ('HV'||to_char(seq_student_id.nextval,'FM00000'),'%s','%s',TO_DATE('%s','YYYY-MM-DD'),'%s','%s','%s','%s')", arg_cus);
            
//            Statement statement = LoginController.connection.con.createStatement();
//            int rows_acc = statement.executeUpdate(acc_sql);
//            int rows_cus = statement.executeUpdate(cus_sql);
//            if (rows_cus > 0 && rows_acc >0){
//                System.out.println("Insert successfull");
//            }else {
//                System.out.println("Insert fail");
//            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.toString(),"Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}
}
