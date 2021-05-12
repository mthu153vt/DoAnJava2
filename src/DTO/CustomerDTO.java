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
public class CustomerDTO {
    private String customerID;
    private String fullname;
    private String gender;
    private String numberphone;
    private String membershiptier;
    private String membershippoint;
    private String username;
    
    public CustomerDTO(String customerID,String fullname, String gender, String numberphone, String membershiptier, String membershipoint, String username){
        this.customerID = customerID;
        this.fullname = fullname;
        this.gender = gender;
        this.numberphone = numberphone;
        this.membershiptier = membershiptier;
        this.membershippoint = membershippoint;
        this.username = username;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
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


    public String getMembershippoint() {
        return membershippoint;
    }

    public void setMembershippoint(String membershippoint) {
        this.membershippoint = membershippoint;
    }

    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }
}
