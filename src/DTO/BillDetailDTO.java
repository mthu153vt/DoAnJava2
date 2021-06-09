/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author htthi
 */
/*
CREATE BILLDETAIL (
	BILL_ID 	NUMBER,
	ITEM_ID		NUMBER,
	QUANTITY	NUMBER,
	CONSTRAINT PK_CTHD PRIMARY KEY (BILL_ID, ITEM_ID)
)
*/

public class BillDetailDTO {
    private int BillID;
    private int ItemID;
    private int quantity;

    public BillDetailDTO() {
    }

    public BillDetailDTO(int ItemID, int quantity) {
        this.ItemID = ItemID;
        this.quantity = quantity;
    }

    public BillDetailDTO(int BillID, int ItemID, int quantity) {
        this.BillID = BillID;
        this.ItemID = ItemID;
        this.quantity = quantity;
    }

    public int getBillID() {
        return BillID;
    }

    public void setBillID(int BillID) {
        this.BillID = BillID;
    }

    public int getItemID() {
        return ItemID;
    }

    public void setItemID(int ItemID) {
        this.ItemID = ItemID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}


