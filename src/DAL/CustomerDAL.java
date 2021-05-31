/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BUS.LoginController;
import DTO.CustomerDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
            String cus_sql;
            
            cus_sql = String.format("INSERT INTO CUSTOMER VALUES (CUSTOMERID_SEQ.nextval,?,?,?,?,?,?)");
            PreparedStatement pres2 = LoginController.connection.con.prepareStatement(cus_sql);
            pres2.setString(1, customer.getFullname());
            pres2.setString(2, customer.getGender());
            pres2.setString(3, customer.getNumberphone());
            pres2.setString(4, customer.getMembershiptier());
            pres2.setInt(5, customer.getMembershippoint());
            pres2.setString(6, customer.getUsername());
            int rows_cus = pres2.executeUpdate();
            
            if (rows_cus >0)
                return true;

        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.toString(),"Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return false;
    }
    
    public boolean Insert(String username) {
        try {
            String cus_sql;
            
            cus_sql = String.format("INSERT INTO CUSTOMER(CUSTOMER_ID, USERNAME) VALUES (CUSTOMERID_SEQ.nextval,?)");
            PreparedStatement pres = LoginController.connection.con.prepareStatement(cus_sql);
            pres.setString(1, username);
            int rows_cus = pres.executeUpdate();
            
            if (rows_cus > 0)
                return true;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.toString(),"Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return false;
    }
    
    
    public boolean Delete(CustomerDTO customer){
        try {
            String cus_sql, acc_sql;
            
            cus_sql = String.format("DELETE FROM CUSTOMER WHERE CUSTOMER_ID = ?");
            PreparedStatement pres1 = LoginController.connection.con.prepareStatement(cus_sql);
            pres1.setInt(1, customer.getCustomerID());
            int rows_cus = pres1.executeUpdate();
            
            acc_sql = String.format("DELETE FROM ACCOUNT WHERE USERNAME = ?");
            PreparedStatement pres2 = LoginController.connection.con.prepareStatement(acc_sql);
            pres2.setString(1, customer.getUsername());
            int rows_acc = pres2.executeUpdate();
            
            if (rows_acc > 0 && rows_cus >0)
                return true;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.toString(),"Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return false;
    }
    
    public boolean Update (CustomerDTO customer, int id ) {
        try {
            String cus_sql;
            cus_sql = String.format("UPDATE CUSTOMER SET fullname =?, gender =?, numberphone =?, membershiptier =?, membershippoint =? WHERE CUSTOMER_ID =?");
            PreparedStatement pres = LoginController.connection.con.prepareStatement(cus_sql);
            
            pres.setString(1, customer.getFullname());
            pres.setString(2, customer.getGender());
            pres.setString(3, customer.getNumberphone());
            pres.setString(4, customer.getMembershiptier());
            pres.setInt(5, customer.getMembershippoint());
            pres.setInt(6, id);
            
            int rows = pres.executeUpdate();
            if(rows > 0)
                return true;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.toString(),"Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return false;    
    }
    
    
    public void LoadData(){
        try{
        this.Data.clear();    
        Statement statement = LoginController.connection.con.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM CUSTOMER");
        while(rs.next())
        {
            CustomerDTO customer =  new CustomerDTO();
            
            customer.setCustomerID(rs.getInt(1));
            customer.setFullname(rs.getString(2));
            customer.setGender(rs.getString(3));
            customer.setNumberphone(rs.getString(4));
            customer.setMembershiptier(rs.getString(5));
            customer.setMembershippoint(rs.getInt(6));
            customer.setUsername(rs.getString(7));
            
            Data.add(customer);
        }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.toString(),"Error", JOptionPane.ERROR_MESSAGE); 
        }
        
    }
    
    public ObservableList<CustomerDTO> GetData(){
        try{
            LoadData();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.toString(),"Error at GetData()", JOptionPane.ERROR_MESSAGE);
        }  
        
        return this.Data;
    }
    
}

