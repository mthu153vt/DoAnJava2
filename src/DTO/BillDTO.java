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

/*-------------TABLE BILL-------------------
CREATE TABLE BILL(
    BILL_ID     NUMBER NOT NULL,
    CUSTOMER_ID NUMBER,
    BILLDATE    DATE,
    PAYMENTMETHOD   VARCHAR2(50),
    TOTAL       NUMBER,
    CONSTRAINT PK_BILL PRIMARY KEY (BILL_ID)
)
*/


public class BillDTO {
    private int BillID;
    private int CustomerID;
    private String billdate;
    private String paymentmethod;
    private int total;

    public BillDTO() {
    }

    public BillDTO(int BillID, int CustomerID, String billdate, String paymentmethod) {
        this.BillID = BillID;
        this.CustomerID = CustomerID;
        this.billdate = billdate;
        this.paymentmethod = paymentmethod;
    }

    public BillDTO(int BillID, int CustomerID, String billdate, String paymentmethod, int total) {
        this.BillID = BillID;
        this.CustomerID = CustomerID;
        this.billdate = billdate;
        this.paymentmethod = paymentmethod;
        this.total = total;
    }

    public int getBillID() {
        return BillID;
    }

    public void setBillID(int BillID) {
        this.BillID = BillID;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int CustomerID) {
        this.CustomerID = CustomerID;
    }

    public String getBilldate() {
        return billdate;
    }

    public void setBilldate(String billdate) {
        this.billdate = billdate;
    }

    public String getPaymentmethod() {
        return paymentmethod;
    }

    public void setPaymentmethod(String paymentmethod) {
        this.paymentmethod = paymentmethod;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    

    
    
    
        
}
