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
            Object arg_cus[] = {customer.getFullname(), customer.getGender(),customer.getNumberphone(),customer.getMembershiptier(),
                customer.getMembershippoint(), customer.getUsername()};
            
            String acc_sql;
            acc_sql = String.format("INSERT INTO ACCOUNT(USERNAME, ACCOUNTROLE) VALUES ('%s', 'customer')", arg_acc);
            String cus_sql;
            cus_sql = String.format("INSERT INTO CUSTOMER VALUES (CUSTOMERID_SEQ.nextval,'%s','%s','%d','%s','%d','%s')", arg_cus);
            
            Statement statement = LoginController.connection.con.createStatement();
            
            int rows_acc = statement.executeUpdate(acc_sql);
            int rows_cus = statement.executeUpdate(cus_sql);
            
            if (rows_cus > 0 && rows_acc >0){
                System.out.println("Insert successfull");
            }else {
                System.out.println("Insert fail");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.toString(),"Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    public boolean Delete(CustomerDTO customer){
        try {
            Object arg_cus[]= {customer.getUsername()};
            String acc_sql,cus_sql;
            
            cus_sql = String.format("DELETE FROM CUSTOMER WHERE USERNAME = '%s'", arg_cus);
            acc_sql = String.format("DELETE FROM ACCOUNT WHERE USERNAME = '%s'", arg_cus);
            
            Statement statement = LoginController.connection.con.createStatement();
            int rows_cus = statement.executeUpdate(cus_sql);
            int rows_acc = statement.executeUpdate(acc_sql);
            if (rows_acc > 0 && rows_cus >0){
                System.out.println("Delete successfull");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.toString(),"Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    public boolean Update(String ID ,CustomerDTO customer) {
        try {
            Object arg[]= {customer.getFullname(), customer.getGender(),customer.getNumberphone(), customer.getMembershiptier(), 
                customer.getMembershippoint(),ID};
            String sql;
            sql = String.format("UPDATE CUSTOMER SET Fullname = '%s', Gender = '%s', Numberphone = '%d', Membershiptier = '%s', Membershippoint = '%d' WHERE CustomerID = '%d'", arg);
            Statement statement = LoginController.connection.con.createStatement();
            int rows = statement.executeUpdate(sql);
            if (rows > 0){
                System.out.println("Update successfull");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.toString(),"Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;

    }
}


