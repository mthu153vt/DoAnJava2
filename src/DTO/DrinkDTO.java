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
    private int DrinkID;
    private String drinkname;
    private int price;

    public DrinkDTO() {}

    public DrinkDTO(int DrinkID, String drinkname, int price) {
        this.DrinkID = DrinkID;
        this.drinkname = drinkname;
        this.price = price;
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
     * @return the drinkname
     */
    public String getDrinkname() {
        return drinkname;
    }

    /**
     * @param drinkname the drinkname to set
     */
    public void setDrinkname(String drinkname) {
        this.drinkname = drinkname;
    }

    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }

    
    
    
}
