/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BUS.LoginController;
import DTO.AccountDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

/**
 *
 * @author htthi
 */
public class AccountDAL {

    
    public AccountDAL(){};
    ObservableList<AccountDTO> Data = FXCollections.observableArrayList();
    
    public AccountDTO getAccountByUserNameAndPassword(String user, String pass) {
    try {
            Object arg[]= {user, pass};

            String acc_sql;
            acc_sql = String.format("SELECT * FROM account WHERE username = '%s' AND password = '%s' ",arg);

            Statement statement = LoginController.connection.con.createStatement();
            ResultSet rs = statement.executeQuery(acc_sql);
            
            if(rs.next()){
                AccountDTO acc = new AccountDTO();
                acc.setUsername( rs.getString("username") );
                acc.setPassword( rs.getString("password") );
                acc.setAccountrole( rs.getString("accountrole") );
                return acc;
            }    
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,ex.toString(),"Error!", JOptionPane.ERROR_MESSAGE);
        }
    return null;
    }
    
    public boolean Insert(AccountDTO account) {
        try {
            String acc_sql;
            acc_sql = String.format("INSERT INTO ACCOUNT VALUES (?,?,?)");
            PreparedStatement pres = LoginController.connection.con.prepareStatement(acc_sql);
            
            pres.setString(1, account.getUsername());
            pres.setString(2, account.getPassword());
            pres.setString(3, account.getAccountrole());
 
            int rows = pres.executeUpdate();
            if(rows > 0)
                return true;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.toString(),"Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return false;
    }
    
    
    public boolean Update(AccountDTO account, String username) {
        try {
            String acc_sql;
            acc_sql = String.format("UPDATE ACCOUNT SET USERNAME =?, PASSWORD=? WHERE USERNAME = ?");
            PreparedStatement pres = LoginController.connection.con.prepareStatement(acc_sql);
            
            pres.setString(1, account.getUsername());
            pres.setString(2, account.getPassword());
            pres.setString(3, username);
            
            int rows = pres.executeUpdate();
            if(rows > 0)
                return true;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.toString(),"Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return false;    
    }
    
    
    public boolean Delete(AccountDTO account) {
        try{    
            String acc_sql;
            acc_sql = String.format("DELETE FROM ACCOUNT WHERE USERNAME = ?");
            PreparedStatement pres = LoginController.connection.con.prepareStatement(acc_sql);
             pres.setString(1, account.getUsername());
            
            int rows = pres.executeUpdate();
            if(rows > 0)
                return true;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.toString(),"Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return false;
    }
    
    public boolean Delete(String username) {
        try{    
            String acc_sql;
            acc_sql = String.format("DELETE FROM ACCOUNT WHERE USERNAME = ?");
            PreparedStatement pres = LoginController.connection.con.prepareStatement(acc_sql);
             pres.setString(1, username);
            
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
