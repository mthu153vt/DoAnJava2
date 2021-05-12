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

/*CREATE TABLE DRINK(
    DRINK_ID     NUMBER NOT NULL,
    DRINKNAME    VARCHAR2(20) NOT NULL,
    PRICE        NUMBER NOT NULL,
    CONSTRAINT   PK_DRINK PRIMARY KEY (DRINK_ID)
)*/

public class DrinkDTO {
    private String DrinkID;
    private String drinkname;
    private String price;
    
    public DrinkDTO(String DrinkID, String drinkname, String price){
        this.DrinkID = DrinkID;
        this.drinkname = drinkname;
        this.price = price;
    }

    public String getDrinkID() {
        return DrinkID;
    }

    public void setDrinkID(String DrinkID) {
        this.DrinkID = DrinkID;
    }

    public String getDrinkname() {
        return drinkname;
    }


    public void setDrinkname(String drinkname) {
        this.drinkname = drinkname;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    
}
