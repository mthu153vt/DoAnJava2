/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

//CREATE TABLE CUSTOMER(
//    CUSTOMER_ID        NUMBER NOT NULL,
//    FULLNAME           VARCHAR2(30) NOT NULL,
//    GENDER             VARCHAR2(6) NOT NULL,
//    NUMBERPHONE	       NUMBER(11),
//    MEMBERSHIPTIER     VARCHAR2(10) DEFAULT 'SILVER',
//    MEMBERSHIPPOINT    NUMBER DEFAULT 0,
//    USERNAME           VARCHAR2(20) NOT NULL,
//    
//    CONSTRAINT PK_CUSTOMER PRIMARY KEY (CUSTOMER_ID)
//)
/**
 *
 * @author Computer
 */
public class CustomerDTO {
    private int CustomerID;
    private String fullname;
    private String gender;
    private int numberphone;
    private String membershiptier;
    private int membershippoint;
    private String username;

    public CustomerDTO() {
    }

    public CustomerDTO(int CustomerID, String fullname, String gender, int numberphone, String membershiptier, int membershippoint, String username) {
        this.CustomerID = CustomerID;
        this.fullname = fullname;
        this.gender = gender;
        this.numberphone = numberphone;
        this.membershiptier = membershiptier;
        this.membershippoint = membershippoint;
        this.username = username;
    }

    /**
     * @return the CustomerID
     */
    public int getCustomerID() {
        return CustomerID;
    }

    /**
     * @param CustomerID the CustomerID to set
     */
    public void setCustomerID(int CustomerID) {
        this.CustomerID = CustomerID;
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
     * @return the membershiptier
     */
    public String getMembershiptier() {
        return membershiptier;
    }

    /**
     * @param membershiptier the membershiptier to set
     */
    public void setMembershiptier(String membershiptier) {
        this.membershiptier = membershiptier;
    }

    /**
     * @return the membershippoint
     */
    public int getMembershippoint() {
        return membershippoint;
    }

    /**
     * @param membershippoint the membershippoint to set
     */
    public void setMembershippoint(int membershippoint) {
        this.membershippoint = membershippoint;
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
