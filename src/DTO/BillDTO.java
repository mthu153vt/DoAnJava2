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
    private int BillID;
    private int FoodID;
    private int DrinkID;
    private int CustomerID;
    private int ReservationID;
    private String billdate;
    private String paymentmethod;
    private int total;

    public BillDTO() {
    }

    public BillDTO(int BillID, int FoodID, int DrinkID, int CustomerID, int ReservationID, String billdate, String paymentmethod, int total) {
        this.BillID = BillID;
        this.FoodID = FoodID;
        this.DrinkID = DrinkID;
        this.CustomerID = CustomerID;
        this.ReservationID = ReservationID;
        this.billdate = billdate;
        this.paymentmethod = paymentmethod;
        this.total = total;
    }

    /**
     * @return the BillID
     */
    public int getBillID() {
        return BillID;
    }

    /**
     * @param BillID the BillID to set
     */
    public void setBillID(int BillID) {
        this.BillID = BillID;
    }

    /**
     * @return the FoodID
     */
    public int getFoodID() {
        return FoodID;
    }

    /**
     * @param FoodID the FoodID to set
     */
    public void setFoodID(int FoodID) {
        this.FoodID = FoodID;
    }

    /**
     * @return the DrinkID
     */
    public int getDrinkID() {
        return DrinkID;
    }

    /**
     * @param DrinkID the DrinkID to set
     */
    public void setDrinkID(int DrinkID) {
        this.DrinkID = DrinkID;
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
     * @return the ReservationID
     */
    public int getReservationID() {
        return ReservationID;
    }

    /**
     * @param ReservationID the ReservationID to set
     */
    public void setReservationID(int ReservationID) {
        this.ReservationID = ReservationID;
    }

    /**
     * @return the billdate
     */
    public String getBilldate() {
        return billdate;
    }

    /**
     * @param billdate the billdate to set
     */
    public void setBilldate(String billdate) {
        this.billdate = billdate;
    }

    /**
     * @return the paymentmethod
     */
    public String getPaymentmethod() {
        return paymentmethod;
    }

    /**
     * @param paymentmethod the paymentmethod to set
     */
    public void setPaymentmethod(String paymentmethod) {
        this.paymentmethod = paymentmethod;
    }

    /**
     * @return the total
     */
    public int getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(int total) {
        this.total = total;
    }
    
    
        
}
