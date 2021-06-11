/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author htthi
 */
public class MebershipController implements Initializable {

    @FXML
    private TextArea txt_ID;
    @FXML
    private Text txt_name;
    @FXML
    private Text txt_card_ID;
    @FXML
    private Button btn_back;
    @FXML
    private Button btn_print;
    @FXML
    private ImageView img_card_background;
    @FXML
    private Button btn_preview;
    @FXML
    private AnchorPane pane_card;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void act_back(ActionEvent event) {
        Stage stage = (Stage) btn_back.getScene().getWindow();
         stage.close();
    }
     
    @FXML
    private void act_print(ActionEvent event) {
        WritableImage image = pane_card.snapshot(new SnapshotParameters(), null);
	
	// TODO: probably use a file chooser here
	File file = new File("card.png");
	
    try {
        ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
    } catch (IOException e) {
    	// TODO: handle exception here
    }
       
    }

    @FXML
    private void act_preview(ActionEvent event) {
        Image silver= new Image("file:src/GUIs/images/silver.png");
        Image gold= new Image("file:src/GUIs/images/gold.png");
        Image platinum= new Image("file:src/GUIs/images/platinum.png");
        int point=3;
        if (point==3)
            img_card_background.setImage(silver);
    }
    
}
