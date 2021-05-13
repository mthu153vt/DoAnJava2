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

/*CREATE TABLE S_TABLE(
    TABLE_ID   	NUMBER NOT NULL,
    TABLETYPE 	VARCHAR2(10),
    STATUS    	VARCHAR2(10),
    
    CONSTRAINT PK_TABLE PRIMARY KEY (TABLE_ID)
)*/

public class STableDTO {
    private int TableID;
    private String tabletype;
    private String status;

    public STableDTO() {
    }

    public STableDTO(int TableID, String tabletype, String status) {
        this.TableID = TableID;
        this.tabletype = tabletype;
        this.status = status;
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

    /**
     * @return the tabletype
     */
    public String getTabletype() {
        return tabletype;
    }

    /**
     * @param tabletype the tabletype to set
     */
    public void setTabletype(String tabletype) {
        this.tabletype = tabletype;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
