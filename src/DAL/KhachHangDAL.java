 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;
import java.sql.*;

/**
 *
 * @author Computer
 */
public class KhachHangDAL {
    public void Insert(KhachHangDTO kh){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","test","password");
            Statement stmt = con.createStatement();
            String customer1 = "INSERT INTO CUSTOMER (ID, FULLNAME)" + "VALUES(kh.CustomerID,)";
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
