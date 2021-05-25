/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Computer
 */

/*
CREATE TABLE  EMPLOYEE(
    EMPLOYEE_ID     NUMBER NOT NULL,
    FULLNAME        VARCHAR2(30) NOT NULL,
    GENDER          VARCHAR2(6) NOT NULL,
    ADDRESS         VARCHAR2(200) NOT NULL,
    NUMBERPHONE     VARCHAR2(11) NOT NULL,
    SALARY          NUMBER NOT NULL,
    DATEOFBIRTH     DATE NOT NULL,
    DATESTARTWORKING DATE NOT NULL,
    USERNAME        VARCHAR2(20),
    
    CONSTRAINT PK_EMPLOYEE PRIMARY KEY (EMPLOYEE_ID)
)
CREATE SEQUENCE EMPLOYEEID_SEQ START WITH 1;
*/


public class EmployeeDTO {
    private int EmployeeID;
    private String fullname;
    private String gender;
    private String address;
    private String numberphone;
    private int salary;
    private String dateofbirth;
    private String datestartworking;
    private String username;

    public EmployeeDTO() {
    }

    public EmployeeDTO(int EmployeeID, String fullname, String gender, String address, String numberphone, int salary, String dateofbirth, String datestartworking, String username) {
        this.EmployeeID = EmployeeID;
        this.fullname = fullname;
        this.gender = gender;
        this.address = address;
        this.numberphone = numberphone;
        this.salary = salary;
        this.dateofbirth = dateofbirth;
        this.datestartworking = datestartworking;
        this.username = username;
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int EmployeeID) {
        this.EmployeeID = EmployeeID;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumberphone() {
        return numberphone;
    }

    public void setNumberphone(String numberphone) {
        this.numberphone = numberphone;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getDatestartworking() {
        return datestartworking;
    }

    public void setDatestartworking(String datestartworking) {
        this.datestartworking = datestartworking;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    
    
    
    
    
    
}
    
