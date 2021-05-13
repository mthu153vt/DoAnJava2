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

/*CREATE TABLE RESERVATION(
    RESERVATION_ID  NUMBER NOT NULL,
    CUSTOMER_ID  	NUMBER CONSTRAINT FK_CUSTOMER_RESERVE REFERENCES CUSTOMER(CUSTOMER_ID) NOT NULL,
    BOOKINGDATE 	DATE NOT NULL,
    TABLE_ID    NUMBER CONSTRAINT FK_S_TABLE_RESERVE REFERENCES S_TABLE(TABLE_ID) NOT NULL,
    CONSTRAINT PK_RESERVATION PRIMARY KEY (RESERVATION_ID)  
)*/

public class ReservationDTO {
    private int ReservationID ;
    private int CustomerID;
    private String bookingdate;
    private int TableID;

    public ReservationDTO() {
    }

    public ReservationDTO(int ReservationID, int CustomerID, String bookingdate, int TableID) {
        this.ReservationID = ReservationID;
        this.CustomerID = CustomerID;
        this.bookingdate = bookingdate;
        this.TableID = TableID;
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
     * @return the bookingdate
     */
    public String getBookingdate() {
        return bookingdate;
    }

    /**
     * @param bookingdate the bookingdate to set
     */
    public void setBookingdate(String bookingdate) {
        this.bookingdate = bookingdate;
    }

    /**
     * @return the TableID
     */
    public int getTableID() {
        return TableID;
    }

    /**
     * @param TableID the TableID to set
     */
    public void setTableID(int TableID) {
        this.TableID = TableID;
    }
    
    
         
}
