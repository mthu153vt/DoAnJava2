/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/*
CREATE TABLE CUSTOMER(
    CUSTOMER_ID        NUMBER NOT NULL,
    FULLNAME           VARCHAR2(30) NOT NULL,
    GENDER             VARCHAR2(6) NOT NULL,
    NUMBERPHONE	       VARCHAR2(11),
    MEMBERSHIPTIER     VARCHAR2(10) DEFAULT 'SILVER',
    MEMBERSHIPPOINT    NUMBER DEFAULT 0,
    USERNAME           VARCHAR2(20) NOT NULL,
    
    CONSTRAINT PK_CUSTOMER PRIMARY KEY (CUSTOMER_ID)
)
CREATE SEQUENCE CUSTOMERID_SEQ START WITH 1;
*/

 /*
 * @author Computer
 */
public class CustomerDTO {
    private int CustomerID;
    private String fullname;
    private String gender;
    private String numberphone;
    private String membershiptier;
    private int membershippoint;
    private String username;

    public CustomerDTO() {
    }

    public CustomerDTO(int CustomerID, String fullname, String gender, String numberphone, String username) {
        this.CustomerID = CustomerID;
        this.fullname = fullname;
        this.gender = gender;
        this.numberphone = numberphone;
        this.username = username;
    }

    public CustomerDTO(int CustomerID, String fullname, String gender, String numberphone, String membershiptier, int membershippoint, String username) {
        this.CustomerID = CustomerID;
        this.fullname = fullname;
        this.gender = gender;
        this.numberphone = numberphone;
        this.membershiptier = membershiptier;
        this.membershippoint = membershippoint;
        this.username = username;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int CustomerID) {
        this.CustomerID = CustomerID;
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

    public String getNumberphone() {
        return numberphone;
    }

    public void setNumberphone(String numberphone) {
        this.numberphone = numberphone;
    }

    public String getMembershiptier() {
        return membershiptier;
    }

    public void setMembershiptier(String membershiptier) {
        this.membershiptier = membershiptier;
    }

    public int getMembershippoint() {
        return membershippoint;
    }

    public void setMembershippoint(int membershippoint) {
        this.membershippoint = membershippoint;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    

    
    
    
    
}
