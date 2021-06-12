/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAL.AccountDAL;
import DAL.BillDAL;
import DAL.BillDetailDAL;
import DAL.CustomerDAL;
import DAL.DBConnection;
import DAL.ItemDAL;
import DTO.AccountDTO;
import DTO.BillDTO;
import DTO.BillDetailDTO;
import DTO.CustomerDTO;
import DTO.ItemDTO;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;



public class BillingController implements Initializable {
    DateTimeFormatter datef = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate localDate = LocalDate.now();
    String dateString = datef.format(localDate);
    
    DateTimeFormatter timef = DateTimeFormatter.ofPattern("HH:mm:ss");
    LocalTime localTime = LocalTime.now();
    String localTimeString = timef.format(localTime);
    
    public String header;
    public String ID;
    int total_price;
     
     
    @FXML
    public AnchorPane pane_pane;
    @FXML
     public TextArea txt_bill;
    
     public Button btn_print;

    @FXML
    private Button btn_print_bill;
    @FXML
    private Button btn_add_item;
     @FXML
    private Button btn_search_username;
     
    @FXML
    private TableView<ItemDTO> tb_item;
    @FXML
    private TableView<BillDetailDTO> tb_bill_detail;
    @FXML
    private TextField txt_total_sum;
    
    @FXML
    private TextField txt_item_id;
    @FXML
    private TextField txt_item_name;
    @FXML
    private TextField txt_price;
    @FXML
    private TextField txt_total;
    @FXML
    private Spinner<Integer> spinner_quantity;
    
    @FXML
    private TextField txt_search_username;
    @FXML
    private Text txt_username;
    @FXML
    private Text txt_membershipter;
    
    @FXML
    private RadioButton btn_cash;
    @FXML
    private RadioButton btn_card;
    
    @FXML
    private Label lable_warning;
    
    @FXML
    private Button btn_new_bill;
    
    
    String paymentmethod = null;
    int sumTotal = 0;
    ObservableList<CustomerDTO> cus_data = FXCollections.observableArrayList();
    CustomerDAL cus_dal = new CustomerDAL();
    CustomerDTO customer = new CustomerDTO();
    
    ObservableList<ItemDTO> item_data = FXCollections.observableArrayList();
    ItemDAL item_dal = new ItemDAL();
    
    BillDAL bill_dal = new BillDAL();
    
    BillDetailDAL billDetail_dal = new BillDetailDAL();
    ObservableList<BillDetailDTO> list_billDetail = FXCollections.observableArrayList();
    @FXML
    private Button btn_back;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        header="=================================\n" + "Sushimi Restautant\n" + "Time and date: "+ dateString +"  "+ localTimeString +"\n" + "============================";
        txt_bill.setText(header);
        txt_bill.setStyle("-fx-font-alignment: center");
        
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50, 0);
        spinner_quantity.setValueFactory(valueFactory);
        
        //hiển thị dữ liệu cho table ITEM
        TableColumn itemIDCol = new TableColumn("ID");
        TableColumn itemnameCol = new TableColumn("ITEM NAME");
        TableColumn describeCol = new TableColumn("DESCRIBE");
        TableColumn priceCol = new TableColumn("PRICE");

        itemIDCol.setCellValueFactory(new PropertyValueFactory<>("ItemID"));
        itemnameCol.setCellValueFactory(new PropertyValueFactory<>("itemname"));
        describeCol.setCellValueFactory(new PropertyValueFactory<>("describe"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
 
        tb_item.getColumns().addAll(itemIDCol, itemnameCol, priceCol, describeCol);
        item_data = item_dal.GetData();
        tb_item.setItems(item_data);
        
        
        //hiển thị dữ liệu cho table BillDetail
        TableColumn b_itemIDCol = new TableColumn("ID");
        TableColumn quantityCol = new TableColumn("QUANTITY");
        
        b_itemIDCol.setCellValueFactory(new PropertyValueFactory<>("ItemID"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        tb_bill_detail.getColumns().addAll(b_itemIDCol, quantityCol);

        
//
    }
    

    
    @FXML
    private void Action_SearchUsername(ActionEvent event) {
        cus_data = cus_dal.GetData();
        boolean flag = false;
        for(CustomerDTO temp : cus_data){
            if(txt_search_username.getText().equals(temp.getUsername())){
                customer = temp;
                flag = true;
                break;
            }
        }
        if(flag){
            txt_username.setText(customer.getUsername());
            txt_membershipter.setText(customer.getMembershiptier());
            lable_warning.setVisible(false);
        }
        else{
            lable_warning.setVisible(true);
        }
    }
    
    @FXML
    private void act_cash(ActionEvent event) {
        btn_card.setSelected(false);
        paymentmethod = "CASH";
    }

    @FXML
    private void act_card(ActionEvent event) {
        btn_cash.setSelected(false);
        paymentmethod = "CARD";
    }
    
    @FXML
    private void act_clickItem(MouseEvent event) {
        ItemDTO item = tb_item.getSelectionModel().getSelectedItem();
    
        txt_item_id.setText(Integer.toString(item.getItemID()));
        txt_item_name.setText(item.getItemname());
        txt_price.setText(Integer.toString(item.getPrice()));
        
    }
    
    @FXML
    //click tăng giảm số lượng
    private void act_click_quantity(MouseEvent event) {
        int qty = spinner_quantity.getValue();
        int price = Integer.parseInt(txt_price.getText());
        int tol = qty * price;
        txt_total.setText(String.valueOf(tol));
    }
    
    @FXML
    private void Action_AddItem(ActionEvent event) {
        BillDetailDTO billDetail = new BillDetailDTO(Integer.parseInt(txt_item_id.getText()), spinner_quantity.getValue());
        list_billDetail.add(billDetail);
        tb_bill_detail.setItems(list_billDetail);
        
        //hiển thị Total
        sumTotal += Integer.parseInt(txt_total.getText());
        txt_total_sum.setText(String.valueOf(sumTotal));
        
        //hiển thị trên text field bill
        header = header + "\n" + txt_item_name.getText() + "\t SL:" + spinner_quantity.getValue() + "       " + txt_total.getText();
        txt_bill.setText(header);
        
    }
    
    @FXML
    private void Action_PrintBill(ActionEvent event) {
        if(CheckInput()){
            BillDTO bill = getBillInfoFromGUI();
            if(bill_dal.Insert(bill)){
//            for(BillDetailDTO b_temp : list_billDetail){
//                billDetail_dal.Insert(b_temp);
//            }
                list_billDetail.forEach((b_temp) -> {
                billDetail_dal.Insert(b_temp);
            });
            header = header+"\n================================="+"\nTotal:\t " + txt_total_sum.getText()
                    +"\n---------------------------------"+"\nCustomer:\t " + customer.getUsername()
                    +"\n---------------------------------"+"\nPayment method:\t " + paymentmethod;
            txt_bill.setText(header);
            }        
        }
        
    }

    private BillDTO getBillInfoFromGUI(){
        String date_String = datef.format(localDate);
        int total = Integer.parseInt(txt_total_sum.getText());
        
        BillDTO bill_;
        bill_ = new BillDTO(0, customer.getCustomerID(), date_String, paymentmethod, total);
        
        return bill_;
    }

    @FXML
    private void Action_NewBill(ActionEvent event) throws IOException {
        Stage stage = (Stage) btn_new_bill.getScene().getWindow();
        stage.close();
        
        ((Node) (event.getSource())).getScene().getWindow();
            //Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../GUIs/Billing.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    }

    @FXML
    private void act_back(ActionEvent event) throws IOException {
//        Stage stage = (Stage) btn_back.getScene().getWindow();
//        stage.close();
            ((Node) (event.getSource())).getScene().getWindow().hide();
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../GUIs/EmployeeHome.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    }

    private boolean CheckInput(){
        if(paymentmethod == null || paymentmethod.equals("")){
            String ErrorStr = "paymentmethod is empty";
            JOptionPane.showMessageDialog(null,ErrorStr,"Error", JOptionPane.ERROR_MESSAGE);      
            return false;
        }
        
        return true;
    }

    

    

   
    
}

//        btn_add.setOnAction(e->{
//            
//            if(txt_ID.getText().isEmpty() ||txt_quantity.getText().isEmpty())
//                txt_bill.setText("Please enter valid info");
//            else {
//                Integer price = null;
//                String Name = null ;
//                Integer a = Integer.valueOf(txt_ID.getText());
//                Integer total;
//            if (a==1){    
//                    price=30000;
//                    Name="Gunkan Maki";
//            }
//               if (a==2){ 
//                    price=35000;
//                    Name="Maguro Sashimi";
//               }
//                if (a==3){ 
//                    price=22000;
//                    Name="Sake Nigiri";
//                }
//                if (a==4){ 
//                    price=23000;
//                    Name="Salmon Hosomaki";
//                }
//                if (a==5){ 
//                    price=25000;
//                    Name="Ikura Gunkan Maki";
//                }
//                if (a==6){ 
//                    price=20000;
//                    Name="Kani Sushi";
//                }
//                if (a==7){ 
//                    price=30000;
//                    Name="Tako Sushi";
//                }
//                if (a==8){ 
//                    price=30000;
//                    Name="Sake Sashimi";
//                }
//                if (a==9){ 
//                    price=15000;
//                    Name="Aquafina";
//                }
//                if (a==10){ 
//                    price=20000;
//                    Name="Tiger Beer";
//                }
//                    
//                if (a==11){ 
//                    price=30000;
//                    Name="Orange Juice";
//                }
//                if (a==12){ 
//                    price=30000;
//                    Name="Strawberry Juice";
//                }
//                Integer single_Item_Price=price*Integer.valueOf(txt_quantity.getText());
//                header=header+"\n"+Name+"\t SL:"+txt_quantity.getText()+"       "+single_Item_Price;
//                total_price+=single_Item_Price;
//            txt_bill.setText(header+"\n================================="+"\nTotal:\t\t\t    "+total_price);
//            }
//        }
//            
//                );
//          btn_print.setOnAction(e->{
//               
//                try {
//   //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
//                FileOutputStream fos = new FileOutputStream("C:\\Users\\lvlsp\\Desktop\\bill\\bill.txt");
//                DataOutputStream dos = new DataOutputStream(fos);
//   //Bước 2: Ghi dữ liệu
//                dos.writeChars(header);
//   //Bước 3: Đóng luồng
//                fos.close();
//                dos.close();
////                System.out.println("Done!");
//               } catch (IOException ex) {
//               ex.printStackTrace();
//  } 
//                         
//               
//               
//        });
//        btn_new_bill.setOnAction(e->{
//             header="""
//               ============================
//               Sushimi Restautant
//               Time and date:
//               ============================""";
//             txt_bill.setText(header);
//        });

