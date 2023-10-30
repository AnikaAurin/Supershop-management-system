/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class MenuController implements Initializable {

    @FXML
    private BorderPane bp;
    @FXML
    private Button p1;
    @FXML
    private Button p2;
    @FXML
    private Button p3;
    @FXML
    private Button p4;
    
   

    /**
     * Initializes the controller class.
     */
        @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
     public void loadScene(String filePath) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(filePath));
        bp.getChildren().remove(bp.getCenter()); //remove existing fxml from center.
        try {
            bp.setCenter(fxmlLoader.load());
        } catch (IOException e) {
              System.out.println("Can't load window" + filePath );
        }

    }
    

    

    @FXML
    private void Product(MouseEvent event) {
        
         
        loadScene("/login/Product.fxml");

}

    @FXML
    private void Supply(MouseEvent event) {
          loadScene("/login/Supplier.fxml");
    }

    @FXML
    private void Stock(MouseEvent event) {
         loadScene("/login/Stock.fxml");
    }
    @FXML
    private void Transaction(MouseEvent event) {
         loadScene("/login/Transaction.fxml");
    }
}

