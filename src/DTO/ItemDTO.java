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

/*CREATE TABLE ITEM(
    ITEM_ID     NUMBER NOT NULL,
    ITEMNAME    VARCHAR2(40) NOT NULL,
    DESCRIBE    VARCHAR2(200),
    PRICE       NUMBER NOT NULL,
    CONSTRAINT  PK_ITEM PRIMARY KEY (ITEM_ID)
)
CREATE SEQUENCE ITEMID_SEQ START WITH 1;
)*/

public class ItemDTO {
    private int ItemID;
    private String itemname;
    private String describe;
    private int price;

    public ItemDTO() {
    }

    public ItemDTO(int ItemID, String itemname, int price) {
        this.ItemID = ItemID;
        this.itemname = itemname;
        this.price = price;
    }

    public ItemDTO(int ItemID, String itemname, String describe, int price) {
        this.ItemID = ItemID;
        this.itemname = itemname;
        this.describe = describe;
        this.price = price;
    }

    public int getItemID() {
        return ItemID;
    }

    public void setItemID(int ItemID) {
        this.ItemID = ItemID;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    
}
