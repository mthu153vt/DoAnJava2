/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DTO.EmployeeDTO;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author htthi
 */
public class AdminReportController implements Initializable {

    @FXML
    private Button btn_financial;
    @FXML
    private Button btn_employee;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void act_finacial_rep(ActionEvent event) {
    }

    @FXML
    private void act_emp_rep(ActionEvent event) {
        try{
        Document doc = new Document();
        
        PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream("report2"+".pdf"));
        
        doc.open();
        
        // dinh dang thuoc tinh cua file PDF (ten tac gia, nguoi lam, thoi tao)
        doc.addAuthor("Le Ngoc Minh Thu - Huynh Minh Thu - Le Van Long");
        doc.addCreationDate();
        doc.addCreator("Employee Management");
        doc.addTitle("Employee Report");
        doc.addSubject("Employee Report");
        
        // Dinh dang Font
        File fileTitleFont = new File ("Fonts/VU Arial Bold.ttf");
        File fileContentFont = new File ("Fonts/VU Arial.ttf");
        
        String urlFontBold = "Fonts/vuArialBold.ttf";
        String urlFont = "Fonts/vuArial.ttf";
        
        try{
        BaseFont bfontTitle = BaseFont.createFont(urlFontBold, BaseFont.IDENTITY_H, BaseFont.EMBEDDED );                
        BaseFont bfontContent = BaseFont.createFont(urlFont, BaseFont.IDENTITY_H, BaseFont.EMBEDDED ); 
        
        Font fontTitle_1 = new Font(bfontTitle,16);
        fontTitle_1.setColor(BaseColor.BLACK);
        
        Font fontTitle_2 = new Font(bfontTitle,14);
        fontTitle_2.setColor(BaseColor.BLACK);
        
        Font fontTitle_3 = new Font(bfontTitle,13);
        fontTitle_3.setColor(BaseColor.BLUE);
        
        Font fontTitle_4 = new Font(bfontTitle,12);
        fontTitle_4.setColor(BaseColor.BLUE);
        
        Font fontTitle_5 = new Font(bfontTitle,16);
        fontTitle_1.setColor(BaseColor.BLUE);
        
        Image logo = Image.getInstance("G:\\app\\BTTH5 va Lab1\\DoAnJava2\\src\\GUIs\\images\\LOGO.png");
        logo.setAbsolutePosition(80, 750);
        logo.scaleAbsolute(60,60);
        doc.add(logo);
        
        Paragraph parRestaurantName = new Paragraph("Sushimi Restaurant", fontTitle_3);
        parRestaurantName.setIndentationLeft(120);
        doc.add(parRestaurantName);
        
        Paragraph parRestaurantAdd = new Paragraph("Thu Duc Distric, Ho Chi Minh City", fontTitle_3);
        parRestaurantAdd.setIndentationLeft(120);
        doc.add(parRestaurantAdd);
        
        Paragraph parRestaurantPhone = new Paragraph("090-8888-8888", fontTitle_3);
        parRestaurantPhone.setIndentationLeft(120);
        doc.add(parRestaurantPhone);
        
        Paragraph parTitle = new Paragraph("Employee Information", fontTitle_1);
        parRestaurantPhone.setIndentationLeft(220);
        doc.add(parTitle);
        
        parTitle.setAlignment(Element.ALIGN_BASELINE);
        parTitle.setSpacingBefore(10);
        parTitle.setSpacingAfter(10);
        doc.add(parTitle);
        
        String emp = "";
        EmployeeDTO  employee = new EmployeeDTO();
        try{
        String sql = String.format("SELECT * FROM EMPLOYEE");
        PreparedStatement pres = LoginController.connection.con.prepareStatement(sql);
        //pres.setInt(1, employee.getEmployeeID());
        ResultSet rs = pres.executeQuery();
        
        while(rs.next()){
            List EmployeeList = new List(List.UNORDERED);
            EmployeeList.add(new ListItem("Full     name:    " + rs.getString(2).toUpperCase(),fontTitle_2));
            EmployeeList.add(new ListItem("Gender       :    " + rs.getString(3).toUpperCase(),fontTitle_2));
            EmployeeList.add(new ListItem("Address      :    " + rs.getString(4).toUpperCase(),fontTitle_2));
            EmployeeList.add(new ListItem("Numberphone  :    " + rs.getString(5).toUpperCase(),fontTitle_2));
            EmployeeList.add(new ListItem("Salary       :    " + rs.getInt(6),fontTitle_2));
            EmployeeList.add(new ListItem("Date     of      birth  :    " + rs.getDate(7),fontTitle_2));
            EmployeeList.add(new ListItem("Date     start      working  :    " + rs.getDate(8),fontTitle_2));
        }
        
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        
        }catch(IOException e){
            e.printStackTrace();
        }
        
        doc.close();
        writer.close();
        
        System.out.println("Successfull");
        
        }catch(DocumentException | FileNotFoundException e){
            System.err.println(e);
        }
        try{
            File file = new File("Report.pdf");
            if(!Desktop.isDesktopSupported()){
                System.out.println("Not support!");
                return;
            }
            Desktop desktop = Desktop.getDesktop();
            if(file.exists()){
                desktop.open(file);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    

    @FXML
    private void act_customer_rep(ActionEvent event) {
        
    }
    
}
