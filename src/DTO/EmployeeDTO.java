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

/*    EMPLOYEE_ID     NUMBER NOT NULL,
    FULLNAME        VARCHAR2(30) NOT NULL,
    GENDER          VARCHAR2(6) NOT NULL,
    ADDRESS         VARCHAR2(200) NOT NULL,
    NUMBERPHONE     NUMBER(11) NOT NULL,
    SALARY          NUMBER NOT NULL,
    DATEOFBIRTH     DATE NOT NULL,
    DATESTARTWORKING DATE NOT NULL,
    USERNAME        VARCHAR2(20) NOT NULL,*/

public class EmployeeDTO {
    private int EmployeeID;
    private String fullname;
    private String gender;
    private String address;
    private int numberphone;
    private int salary;
    private String dateofbirth;
    private String datestartworking;
    private String username;

    public EmployeeDTO() {
    }

    public EmployeeDTO(int EmployeeID, String fullname, String gender, String address, int numberphone, int salary, String dateofbirth, String datestartworking, String username) {
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

    /**
     * @return the EmployeeID
     */
    public int getEmployeeID() {
        return EmployeeID;
    }

    /**
     * @param EmployeeID the EmployeeID to set
     */
    public void setEmployeeID(int EmployeeID) {
        this.EmployeeID = EmployeeID;
    }

    /**
     * @return the fullname
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * @param fullname the fullname to set
     */
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the numberphone
     */
    public int getNumberphone() {
        return numberphone;
    }

    /**
     * @param numberphone the numberphone to set
     */
    public void setNumberphone(int numberphone) {
        this.numberphone = numberphone;
    }

    /**
     * @return the salary
     */
    public int getSalary() {
        return salary;
    }

    /**
     * @param salary the salary to set
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }

    /**
     * @return the dateofbirth
     */
    public String getDateofbirth() {
        return dateofbirth;
    }

    /**
     * @param dateofbirth the dateofbirth to set
     */
    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    /**
     * @return the datestartworking
     */
    public String getDatestartworking() {
        return datestartworking;
    }

    /**
     * @param datestartworking the datestartworking to set
     */
    public void setDatestartworking(String datestartworking) {
        this.datestartworking = datestartworking;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }
    
    
    
    
    
    
}
    
