/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAL.DBConnection;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;



public class BillingController implements Initializable {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
  LocalDateTime now = LocalDateTime.now();             
    @FXML
    public AnchorPane pane_pane;
    @FXML
    public TextField txt_ID;
    @FXML
     public TextField txt_quantity;
    @FXML
     public Button btn_new_bill;
    @FXML
     public Button btn_add;
    @FXML
     public TextArea txt_bill;
    
    @FXML
     public Button btn_print;

    public String header;
     public String ID;
     int total_price;
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        header="=================================\n" + "Sushimi Restautant\n" + "Time and date: "+now.format(dtf)+"\n" + "============================";
        txt_bill.setText(header);
        txt_bill.setStyle("-fx-font-alignment: center");
        
        btn_add.setOnAction(e->{
            
            if(txt_ID.getText().isEmpty() ||txt_quantity.getText().isEmpty())
                txt_bill.setText("Please enter valid info");
            else {
                Integer price = null;
                String Name = null ;
                Integer a = Integer.valueOf(txt_ID.getText());
                Integer total;
            if (a==1){    
                    price=30000;
                    Name="Gunkan Maki";
            }
               if (a==2){ 
                    price=35000;
                    Name="Maguro Sashimi";
               }
                if (a==3){ 
                    price=22000;
                    Name="Sake Nigiri";
                }
                if (a==4){ 
                    price=23000;
                    Name="Salmon Hosomaki";
                }
                if (a==5){ 
                    price=25000;
                    Name="Ikura Gunkan Maki";
                }
                if (a==6){ 
                    price=20000;
                    Name="Kani Sushi";
                }
                if (a==7){ 
                    price=30000;
                    Name="Tako Sushi";
                }
                if (a==8){ 
                    price=30000;
                    Name="Sake Sashimi";
                }
                if (a==9){ 
                    price=15000;
                    Name="Aquafina";
                }
                if (a==10){ 
                    price=20000;
                    Name="Tiger Beer";
                }
                    
                if (a==11){ 
                    price=30000;
                    Name="Orange Juice";
                }
                if (a==12){ 
                    price=30000;
                    Name="Strawberry Juice";
                }
                Integer single_Item_Price=price*Integer.valueOf(txt_quantity.getText());
                header=header+"\n"+Name+"\t SL:"+txt_quantity.getText()+"       "+single_Item_Price;
                total_price+=single_Item_Price;
            txt_bill.setText(header+"\n================================="+"\nTotal:\t\t\t    "+total_price);
            }
        }
            
                );
          btn_print.setOnAction(e->{
               
                try {
   //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
                FileOutputStream fos = new FileOutputStream("C:\\Users\\lvlsp\\Desktop\\bill\\bill.txt");
                DataOutputStream dos = new DataOutputStream(fos);
   //Bước 2: Ghi dữ liệu
                dos.writeChars(header);
   //Bước 3: Đóng luồng
                fos.close();
                dos.close();
//                System.out.println("Done!");
               } catch (IOException ex) {
               ex.printStackTrace();
  } 
                         
               
               
        });
        btn_new_bill.setOnAction(e->{
             header="";
             txt_bill.setText(header);
        });
    }
     public static DBConnection connection = new DBConnection();
}

