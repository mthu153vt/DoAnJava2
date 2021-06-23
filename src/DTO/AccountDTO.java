/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/*
CREATE TABLE ACCOUNT(
    USERNAME    VARCHAR2(20) NOT NULL,
    PASSWORD    VARCHAR2(50) NOT NULL,
    ACCOUNTROLE    VARCHAR2(50) NOT NULL,
    CONSTRAINT  PK_ACCOUNT PRIMARY KEY (USERNAME)
)
*/

/**
 *
 * @author htthi
 */
public class AccountDTO {

    private String  Username;
    private String  password;
    private String  accountrole;

    public AccountDTO(){}
    
    public AccountDTO(String Username, String password, String accountrole) {
        this.Username = Username;
        this.password = password;
        this.accountrole = accountrole;
    }
    

    /**
     * @return the Username
     */
    public String getUsername() {
        return Username;
    }

    /**
     * @param Username the Username to set
     */
    public void setUsername(String Username) {
        this.Username = Username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    
    public String getAccountrole() {
        return accountrole;
    }

    
    public void setAccountrole(String accountrole) {
        this.accountrole = accountrole;
    }
}
