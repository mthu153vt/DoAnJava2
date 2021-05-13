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

/*CREATE TABLE FOOD(
    FOOD_ID     NUMBER NOT NULL,
    FOODNAME    VARCHAR2(40) NOT NULL,
    DESCRIBE    VARCHAR2(200),
    PRICE       NUMBER NOT NULL,
    CONSTRAINT  PK_FOOD PRIMARY KEY (FOOD_ID)
)*/

public class FoodDTO {
    private int FoodID;
    private String foodname;
    private String describe;
    private int price;

    public FoodDTO() {
    }

    public FoodDTO(int FoodID, String foodname, String describe, int price) {
        this.FoodID = FoodID;
        this.foodname = foodname;
        this.describe = describe;
        this.price = price;
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
     * @return the foodname
     */
    public String getFoodname() {
        return foodname;
    }

    /**
     * @param foodname the foodname to set
     */
    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    /**
     * @return the describe
     */
    public String getDescribe() {
        return describe;
    }

    /**
     * @param describe the describe to set
     */
    public void setDescribe(String describe) {
        this.describe = describe;
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
