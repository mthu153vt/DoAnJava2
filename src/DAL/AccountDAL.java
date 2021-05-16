/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BUS.LoginController;
import DTO.AccountDTO;
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

    /**
     * @param args the command line arguments
     */
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
            Object arg_acc[] = {account.getUsername(), account.getPassword(), account.getAccountrole()};
            
            String acc_sql;
            acc_sql = String.format("INSERT INTO ACCOUNT VALUES ('%s', '%s', '%s')", arg_acc);
            
            Statement statement = LoginController.connection.con.createStatement();
            
            int rows_acc = statement.executeUpdate(acc_sql);
            
            if (rows_acc > 0){
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
    
    public boolean Update(String username, String password) {
        try {
            Object arg_acc[] = {username, password};
            
            String sql;
            sql = String.format("UPDATE ACCOUNT SET password = '%s' WHERE username = '%d'", arg_acc);
            
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
    
    public static void main(String args[]) {
        // TODO code application logic here
    }
}
