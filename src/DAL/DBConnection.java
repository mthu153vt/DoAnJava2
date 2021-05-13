/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;


import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    String connectionURL= "jdbc:oracle:thin:@//localhost:1521/QLyNhaHang";
    String username = "doan";
    String password = "12345";
   // ("jdbc:oracle:thin:@//localhost:1521/QLyNhaHang","doan","12345");*/
    
    public DBConnection() {
    }
    public Connection con;
    
    // Ket noi voi database
    public boolean OpenConnection(){
        try {
            this.con = DriverManager.getConnection(connectionURL, username, password);
           // this.con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl","test","password");
            System.out.println("Connecting...");
            System.out.println("Connect to database successfull!");
        } catch (SQLException except) {
            //Ngoai le, khi k ket noi duoc 
            JOptionPane.showMessageDialog(null,except.toString(),"Cant connect...", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    public void CloseConnection(){
        try{
            con.close();
        } catch (SQLException except){
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, except);
        }
    }
    
}

/*
    //Cach khac de ket noi database:
    public class DBConnection{
        public static Connection ConnectDb(){
            try{
                Class.forName("oracle.jdbc.OracleDriver");
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl,"test","password");
                return con;
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,e.toString(),"Cant connect",JOptionPane.ERROR_MESSAGE);
        }
    }
}

*/