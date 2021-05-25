/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BUS.LoginController;
import DTO.EmployeeDTO;
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
public class EmployeeDAL {
    public EmployeeDAL(){}
    
    ObservableList<EmployeeDTO> Data = FXCollections.observableArrayList();
    
    public boolean Insert(EmployeeDTO employee) {
        try{
            String emp_sql;
            emp_sql = String.format("INSERT INTO EMPLOYEE VALUES (EMPLOYEEID_SEQ.nextval, ?,?,?,?,?,?,?,?)");
            PreparedStatement pres = LoginController.connection.con.prepareStatement(emp_sql);
            pres.setString(1, employee.getFullname());
            pres.setString(2, employee.getGender());
            pres.setString(3, employee.getAddress());
            pres.setString(4, employee.getNumberphone());
            pres.setInt(5, employee.getSalary());
            pres.setString(6, employee.getDateofbirth());
            pres.setString(7, employee.getDatestartworking());
            pres.setString(8, "employee");
            
            int rows = pres.executeUpdate();
            if(rows > 0)
                return true;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.toString(),"Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return false;
    }
    
    public boolean Delete(EmployeeDTO employee) {
        try{    
            String emp_sql;
            emp_sql = String.format("DELETE FROM EMPLOYEE WHERE EMPLOYEE_ID = ?");
            PreparedStatement pres = LoginController.connection.con.prepareStatement(emp_sql);
            pres.setInt(1, employee.getEmployeeID());
            
            int rows = pres.executeUpdate();
            if(rows > 0)
                return true;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.toString(),"Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return false;
    }

    public boolean Update(EmployeeDTO employee, int id) {
        try{    
            String emp_sql;
            emp_sql = String.format("UPDATE EMPLOYEE SET FULLNAME=?, GENDER=?, ADDRESS=?, NUMBERPHONE=?, SALARY=?, DATEOFBIRTH=TO_DATE(?,'DD-MM-YYYY), DATESTARTWORKING=(?,'DD-MM-YYYY)  WHERE EMPLOYEE_ID = ?");
            PreparedStatement pres = LoginController.connection.con.prepareStatement(emp_sql);
            
            pres.setString(1, employee.getFullname());
            pres.setString(2, employee.getGender());
            pres.setString(3, employee.getAddress());
            pres.setString(4, employee.getNumberphone());
            pres.setInt(5, employee.getSalary());
            pres.setString(6, employee.getDateofbirth());
            pres.setString(7, employee.getDatestartworking());
            pres.setInt(8, id);
            
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
        Statement statement = LoginController.connection.con.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM EMPLOYEE");
        
        while(rs.next())
        {
            EmployeeDTO employee =  new EmployeeDTO();
            
            employee.setEmployeeID(rs.getInt(1));
            employee.setFullname(rs.getString(2));
            employee.setGender(rs.getString(3));
            employee.setAddress(rs.getString(4));
            employee.setNumberphone(rs.getString(5));
            employee.setSalary(rs.getInt(6));
            employee.setDateofbirth(rs.getDate(7).toString());
            employee.setDatestartworking(rs.getDate(8).toString());
            employee.setUsername(rs.getString(9));
            
            Data.add(employee);
        }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.toString(),"Error", JOptionPane.ERROR_MESSAGE); 
        }
    }
    
    public ObservableList<EmployeeDTO> GetData(){
        try{
            LoadData();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.toString(),"Error at GetData()", JOptionPane.ERROR_MESSAGE);
        }  
        
        return this.Data;
    }
    
}