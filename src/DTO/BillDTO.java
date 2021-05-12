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

/*CREATE TABLE BILL(
    BILL_ID     NUMBER NOT NULL,
    FOOD_ID     NUMBER CONSTRAINT FK_FOOD_BILL REFERENCES FOOD(FOOD_ID) NOT NULL,
    DRINK_ID    NUMBER CONSTRAINT FK_DRINK_BILL REFERENCES DRINK(DRINK_ID) NOT NULL,
    CUSTOMER_ID NUMBER CONSTRAINT FK_CUSTOMER_BILL REFERENCES CUSTOMER(CUSTOMER_ID) NOT NULL,
    RESERVATION_ID  NUMBER CONSTRAINT FK_RESERVE_BILL REFERENCES RESERVATION(RESERVATION_ID) NOT NULL,
    BILLDATE    DATE NOT NULL,
    PAYMENTMETHOD   VARCHAR2(50),
    TOTAL       NUMBER NOT NULL,
    CONSTRAINT PK_BILL PRIMARY KEY (BILL_ID)
)*/

public class BillDTO {
    private String BillID;
    private String FoodID;
    private String DrinkID;
    private String CustomerID;
    private String ReservationID;
    private String billdate;
    private String paymentmethod;
    private String total;
    
    public BillDTO(String BillID, String FoodID, String DrinkID, String CustomerID, String ReservationID, String billdate, String paymentmethod,String total){
        this.BillID = BillID;
        this.CustomerID = CustomerID;
        this.DrinkID = DrinkID;
        this.FoodID = FoodID;
        this.ReservationID = ReservationID;
        this.billdate = billdate;
        this.paymentmethod = paymentmethod;
        this.total = total;
    }

    public String getBillID() {
        return BillID;
    }

    public void setBillID(String BillID) {
        this.BillID = BillID;
    }

    public String getFoodID() {
        return FoodID;
    }

    public void setFoodID(String FoodID) {
        this.FoodID = FoodID;
    }

    public String getDrinkID() {
        return DrinkID;
    }

    public void setDrinkID(String DrinkID) {
        this.DrinkID = DrinkID;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String CustomerID) {
        this.CustomerID = CustomerID;
    }

    public String getReservationID() {
        return ReservationID;
    }

    public void setReservationID(String ReservationID) {
        this.ReservationID = ReservationID;
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

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
        
}
