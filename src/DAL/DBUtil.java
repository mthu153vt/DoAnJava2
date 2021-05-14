/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
public final class DBUtil {
		private static boolean isDriverLoaded = false;
		static{
			try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				System.out.println("Driver Loaded");
				isDriverLoaded = true;	
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}
		}
		
		private final static String url="jdbc:oracle:thin:@localhost:1521:orcl";
		private final static String user="test";
		private final static String password="password";
		
		public static Connection getConnection() throws SQLException{
			Connection con = null;
			if(isDriverLoaded){
				con  = DriverManager.getConnection(url,user,password);
				System.out.println("Connection established");
			}
			return con;
		}
		
		
		public static void closeConnection(Connection con) throws SQLException{
			if(con!=null){
				con.close();
				System.out.println("connection closed");
			}
		}	
}
