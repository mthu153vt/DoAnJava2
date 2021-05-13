/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.CustomerDTO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Computer
 */
public class CustomerDAL {
    public CustomerDAL(){}
    ObservableList<CustomerDTO> Data = FXCollections.observableArrayList();
}
