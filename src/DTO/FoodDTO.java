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
    private String FoodID;
    private String foodname;
    private String describe;
    private String price;
    
    public FoodDTO(String FoodID, String foodname, String describe, String price){
        this.FoodID = FoodID;
        this.foodname = foodname;
        this.describe = describe;
        this.price = price;
    }

    public String getFoodID() {
        return FoodID;
    }

    public void setFoodID(String FoodID) {
        this.FoodID = FoodID;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
