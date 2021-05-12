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
    private String ReservationID ;
    private String CustomerID;
    private String bookingdate;
    
    public ReservationDTO(String ReservationID, String CustomerID, String bookingdate){
        this.ReservationID = ReservationID;
        this.CustomerID = CustomerID;
        this.bookingdate = bookingdate;
    }

    public String getReservationID() {
        return ReservationID;
    }

    public void setReservationID(String ReservationID) {
        this.ReservationID = ReservationID;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String CustomerID) {
        this.CustomerID = CustomerID;
    }

    public String getBookingdate() {
        return bookingdate;
    }

    public void setBookingdate(String bookingdate) {
        this.bookingdate = bookingdate;
    }
         
}
