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
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
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
import java.text.NumberFormat;
import java.util.Locale;
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
    
    private File fileTitleFont = new File ("Fonts/VU Arial Bold.ttf");
    private File fileContentFont = new File ("Fonts/VU Arial.ttf");
    private String urlFontBold = "Fonts/vuArialBold.ttf";
    private String urlFont = "Fonts/vuArial.ttf";
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void act_finacial_rep(ActionEvent event) {
        try{
            Document doc = new Document();
        
            PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream("FinancialReport.pdf"));
       
            doc.open();
        
        // dinh dang thuoc tinh cua file PDF 
            doc.addAuthor("Le Ngoc Minh Thu - Huynh Minh Thu - Le Van Long");
            doc.addCreationDate();
            doc.addCreator("Financial Management");
            doc.addTitle("Financial Report");
            doc.addSubject("Financial Report");
        
        
            String urlFontBold = "Fonts/vuArialBold.ttf";
            String urlFont = "Fonts/vuArial.ttf";
        
        try{
            BaseFont bfontTitle = BaseFont.createFont(urlFontBold, BaseFont.IDENTITY_H, BaseFont.EMBEDDED );                
            BaseFont bfontContent = BaseFont.createFont(urlFont, BaseFont.IDENTITY_H, BaseFont.EMBEDDED ); 
        
            Font fontTitle_1 = new Font(bfontTitle,16);
            fontTitle_1.setColor(BaseColor.BLACK);
        
            Font fontTitle_3 = new Font(bfontTitle,13);
            fontTitle_3.setColor(BaseColor.BLUE);
             
            Font fontTitle_5 = new Font(bfontTitle,16);
            fontTitle_1.setColor(BaseColor.BLUE);
        
            Font fontTitle_6 = new Font(bfontTitle,11);
            fontTitle_6.setColor(BaseColor.BLACK);
        
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
        
        Paragraph parTitle = new Paragraph("REVENUE", fontTitle_1);
        parTitle.setAlignment(Element.ALIGN_CENTER);
        parTitle.setSpacingBefore(12);
        parTitle.setSpacingAfter(10);
        doc.add(parTitle);
        
        Paragraph chuThich = new Paragraph("*Display revenue of a month", fontTitle_6);
        doc.add(chuThich);
        
        try{
            String sql = String.format("SELECT  to_char(BILLDATE,'mm') MONTH, SUM(TOTAL) FROM    BILL GROUP BY    to_char(BILLDATE,'mm')");
            PreparedStatement pres = LoginController.connection.con.prepareStatement(sql);
            ResultSet rs = pres.executeQuery();
        
        while(rs.next()){
              Paragraph paraID = new Paragraph("Month:    " + rs.getInt(1));
              Paragraph para = new Paragraph("Revenue:    " + rs.getInt(2));

              paraID.setSpacingBefore(15);
              doc.add(paraID);
              doc.add(para);
        }
        
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        Paragraph chuThich2= new Paragraph("*Display Top 3 most favorite items ", fontTitle_6);
        chuThich2.setSpacingBefore(15);
        doc.add(chuThich2);
        
        try{
            String sqlTOP3 = String.format("SELECT *  FROM    (SELECT	B.ITEM_ID, ITEMNAME, SUM(QUANTITY) FROM	BILLDETAIL B JOIN ITEM I ON B.ITEM_ID = I.ITEM_ID GROUP BY	B.ITEM_ID, ITEMNAME ORDER BY	SUM(QUANTITY) DESC) WHERE   ROWNUM <=3" );
            PreparedStatement pres = LoginController.connection.con.prepareStatement(sqlTOP3);
            ResultSet result = pres.executeQuery();
        
        while(result.next()){
              Paragraph paraID = new Paragraph("Item ID:    " + result.getInt(1));
              Paragraph para = new Paragraph("Item Name:    " + result.getString(2));
              Paragraph para1 = new Paragraph("Chosen times:    " + result.getInt(3));
              
              paraID.setSpacingBefore(15);
              doc.add(paraID);
              doc.add(para);
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
            File file = new File("FinancialReport.pdf");
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
    private void act_emp_rep(ActionEvent event) {
        try{
            Document doc = new Document();
        
            PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream("EmployeeReport.pdf"));
       
            doc.open();
        
        // dinh dang thuoc tinh cua file PDF 
            doc.addAuthor("Le Ngoc Minh Thu - Huynh Minh Thu - Le Van Long");
            doc.addCreationDate();
            doc.addCreator("Employee Management");
            doc.addTitle("Employee Report");
            doc.addSubject("Employee Report");
        
        
            String urlFontBold = "Fonts/vuArialBold.ttf";
            String urlFont = "Fonts/vuArial.ttf";
        
        try{
            BaseFont bfontTitle = BaseFont.createFont(urlFontBold, BaseFont.IDENTITY_H, BaseFont.EMBEDDED );                
            BaseFont bfontContent = BaseFont.createFont(urlFont, BaseFont.IDENTITY_H, BaseFont.EMBEDDED ); 
        
            Font fontTitle_1 = new Font(bfontTitle,16);
            fontTitle_1.setColor(BaseColor.BLACK);
        
            Font fontTitle_2 = new Font(bfontContent,14);
            fontTitle_2.setColor(BaseColor.BLACK);

            Font fontTitle_3 = new Font(bfontTitle,13);
            fontTitle_3.setColor(BaseColor.BLUE);
        
            Font fontTitle_4 = new Font(bfontTitle,12);
            fontTitle_4.setColor(BaseColor.BLUE);
        
            Font fontTitle_5 = new Font(bfontTitle,16);
            fontTitle_1.setColor(BaseColor.BLUE);
        
            Font fontTitle_6 = new Font(bfontContent,11);
            fontTitle_6.setColor(BaseColor.BLACK);
        
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
        
        Paragraph parTitle = new Paragraph("EMPLOYEE INFORMATION", fontTitle_1);
        parTitle.setAlignment(Element.ALIGN_CENTER);
        parTitle.setSpacingBefore(12);
        parTitle.setSpacingAfter(10);
        doc.add(parTitle);
        
        Paragraph chuThich = new Paragraph("*Display employees are currently working in the restaurant", fontTitle_6);
        chuThich.setAlignment(Element.ALIGN_CENTER);
        doc.add(chuThich);
        
        try{
            String sql = String.format("SELECT * FROM EMPLOYEE");
            PreparedStatement pres = LoginController.connection.con.prepareStatement(sql);
            ResultSet rs = pres.executeQuery();
        
        while(rs.next()){
           Paragraph paraID = new Paragraph("ID:    " + rs.getString(1));
              Paragraph para = new Paragraph("Full name:    " + rs.getString(2));
              Paragraph para2 = new Paragraph("Gender:    " + rs.getString(3));
              Paragraph para3 = new Paragraph("Address:    " + rs.getString(4));
              Paragraph para4 = new Paragraph("Numberphone:    " + rs.getString(5));
              Paragraph para5 = new Paragraph("Salary:    " + rs.getInt(6));
              Paragraph para6 = new Paragraph("Date of birth:    " + rs.getDate(7));
              Paragraph para7 = new Paragraph("Date start working:    " + rs.getDate(8));
              
              paraID.setSpacingBefore(15);
              doc.add(paraID);
              doc.add(para);
              doc.add(para2);
              doc.add(para3);
              doc.add(para4);
              doc.add(para5);
              doc.add(para6);
              doc.add(para7);
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
            File file = new File("EmployeeReport.pdf");
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
        try{
            Document doc = new Document();
        
            PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream("CustomerReport.pdf"));
       
            doc.open();
        
        // dinh dang thuoc tinh cua file PDF 
            doc.addAuthor("Le Ngoc Minh Thu - Huynh Minh Thu - Le Van Long");
            doc.addCreationDate();
            doc.addCreator("Customer Management");
            doc.addTitle("Customer Report");
            doc.addSubject("Customer Report");
        
        
            String urlFontBold = "Fonts/vuArialBold.ttf";
            String urlFont = "Fonts/vuArial.ttf";
        
        try{
            BaseFont bfontTitle = BaseFont.createFont(urlFontBold, BaseFont.IDENTITY_H, BaseFont.EMBEDDED );                
            BaseFont bfontContent = BaseFont.createFont(urlFont, BaseFont.IDENTITY_H, BaseFont.EMBEDDED ); 
        
            Font fontTitle_1 = new Font(bfontTitle,16);
            fontTitle_1.setColor(BaseColor.BLACK);
        
            Font fontTitle_2 = new Font(bfontContent,14);
            fontTitle_2.setColor(BaseColor.BLACK);

            Font fontTitle_3 = new Font(bfontTitle,13);
            fontTitle_3.setColor(BaseColor.BLUE);
        
            Font fontTitle_4 = new Font(bfontContent,10);
            fontTitle_4.setColor(BaseColor.BLACK);
        
            Font fontTitle_5 = new Font(bfontTitle,16);
            fontTitle_1.setColor(BaseColor.BLUE);
        
            Font fontTitle_6 = new Font(bfontContent,12);
            fontTitle_6.setColor(BaseColor.BLACK);
        
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
        
        Paragraph parTitle = new Paragraph("CUSTOMER INFORMATION", fontTitle_1);
        parTitle.setAlignment(Element.ALIGN_CENTER);
        parTitle.setSpacingBefore(12);
        parTitle.setSpacingAfter(10);
        doc.add(parTitle);
        

        PdfPTable tbCustomer = new PdfPTable(4);
        tbCustomer.setWidthPercentage(80);
        tbCustomer.setSpacingBefore(15);
        tbCustomer.setSpacingAfter(15);

        int[] tb_ColumnWidths = {160,70,90,90};
        tbCustomer.setWidths(tb_ColumnWidths);
            
        PdfPCell cellName = new PdfPCell (new Paragraph("Full name", fontTitle_6));
        cellName.setBorderColor(BaseColor.BLACK);
        cellName.setHorizontalAlignment(Element.ALIGN_CENTER);
        cellName.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cellName.setMinimumHeight(30);
        tbCustomer.addCell(cellName);
        
        PdfPCell cellGender = new PdfPCell (new Paragraph("Gender", fontTitle_6));
        cellGender.setBorderColor(BaseColor.BLACK);
        cellGender.setHorizontalAlignment(Element.ALIGN_CENTER);
        cellGender.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cellGender.setMinimumHeight(30);
        tbCustomer.addCell(cellGender);
        
        PdfPCell cellNumber = new PdfPCell (new Paragraph("Telephone", fontTitle_6));
        cellNumber.setBorderColor(BaseColor.BLACK);
        cellNumber.setHorizontalAlignment(Element.ALIGN_CENTER);
        cellNumber.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cellNumber.setMinimumHeight(30);
        tbCustomer.addCell(cellNumber);
        
        PdfPCell cellTier = new PdfPCell (new Paragraph("Member Tier", fontTitle_6));
        cellTier.setBorderColor(BaseColor.BLACK);
        cellTier.setHorizontalAlignment(Element.ALIGN_CENTER);
        cellTier.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cellTier.setMinimumHeight(30);
        tbCustomer.addCell(cellTier);
        
//        PdfPCell cellPoint = new PdfPCell (new Paragraph("Member Point", fontTitle_6));
//        cellPoint.setBorderColor(BaseColor.BLACK);
//        cellPoint.setHorizontalAlignment(Element.ALIGN_CENTER);
//        cellPoint.setVerticalAlignment(Element.ALIGN_MIDDLE);
//        cellPoint.setMinimumHeight(30);
//        tbCustomer.addCell(cellPoint);

            
        try{
            String sql = String.format("SELECT * FROM CUSTOMER ORDER BY MEMBERSHIPPOINT DESC");
            PreparedStatement pres = LoginController.connection.con.prepareStatement(sql);
            ResultSet rs = pres.executeQuery();
        
        while(rs.next()){
            PdfPCell cellNameND = new PdfPCell (new Paragraph(rs.getString(2), fontTitle_4));
            tbCustomer.addCell(cellNameND);
            
            PdfPCell cellGenderND = new PdfPCell (new Paragraph(rs.getString(3), fontTitle_4));
            tbCustomer.addCell(cellGenderND);
            
            PdfPCell cellPhoneND = new PdfPCell (new Paragraph(rs.getString(4), fontTitle_4));
            tbCustomer.addCell(cellPhoneND);
            
            PdfPCell cellTierND = new PdfPCell (new Paragraph(rs.getString(5), fontTitle_4));
            tbCustomer.addCell(cellTierND);
            
//            PdfPCell cellPointND = new PdfPCell (new Paragraph(rs.getInt(6)));
//            tbCustomer.addCell(cellPointND);
        }
        
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        doc.add(tbCustomer);
        Paragraph chuThich = new Paragraph("*Display customer's information order by membership tier (PLATINUM > GOLD > SILVER)", fontTitle_6);
        chuThich.setAlignment(Element.ALIGN_CENTER);
        doc.add(chuThich);
        
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
            File file = new File("CustomerReport.pdf");
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
    
    private String DinhDang(int number){
        Locale localeEN = new Locale("en", "EN");
        NumberFormat en = NumberFormat.getInstance(localeEN);
        String str = en.format(number);
        return str;
    }
}
