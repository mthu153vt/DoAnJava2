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
    private String TableID;
    private String tabletype;
    private String status;
    
    public STableDTO(String TableID, String tabletype, String status){
        this.TableID = TableID;
        this.tabletype = tabletype;
        this.status = status;
    }

    public String getTableID() {
        return TableID;
    }

    public void setTableID(String TableID) {
        this.TableID = TableID;
    }

    public String getTabletype() {
        return tabletype;
    }
    
    public void setTabletype(String tabletype) {
        this.tabletype = tabletype;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
