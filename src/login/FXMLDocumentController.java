/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;

    @FXML
    private TextField txtuname;
    @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private PasswordField txtpass;

    private DBConnect dbc;
    private ResultSet rs;

    Connection con;
    PreparedStatement pat;

    private Statement stmt = null;
    @FXML
    private Button btn3;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void login(ActionEvent event) throws SQLException, ClassNotFoundException {
        DBConnect dbc = new DBConnect();
        dbc.connectToDB();

        //String uname = txtuname.getText();
        //String pass = txtpass.getText();
        String uname = "n";
        String pass = "1";

        if (uname.equals("") || pass.equals("")) {

            JOptionPane.showMessageDialog(null, "plz fill up all the info");
        } else {
            rs = dbc.queryToDB("select * from Users where UserName='" + uname + "' and Pass= '" + pass + "';");
            if (rs == null || !rs.next()) {

                JOptionPane.showMessageDialog(null, "Invalid User ");
            } else {

                JOptionPane.showMessageDialog(null, "Log in Sucessful ");
                try {

                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("Menu.fxml"));
                    /* 
                         * if "fx:controller" is not set in fxml
                         * fxmlLoader.setController(NewWindowController);
                     */
                    Scene scene = new Scene(fxmlLoader.load(),1400,800 );
                    Stage stage = new Stage();
                    stage.setTitle("New Window");
                    stage.setScene(scene);
                    stage.show();

                    /*Parent root1 = FXMLLoader.load(getClass().getResource("Menu.fxml"));
                     
                        Stage stage = new Stage();
                        stage.setScene(new Scene (root1));
                        stage.show();*/
                } catch (IOException e) {
                    System.out.println("can't load window");
                    System.out.println(e);

                }
            }

        }
    }

    @FXML
    private void signup(ActionEvent event) throws SQLException, ClassNotFoundException {
        DBConnect dbc = new DBConnect();
        dbc.connectToDB();

        String uname = txtuname.getText();
        String pass = txtpass.getText();

        if (uname.equals("") || pass.equals("")) {

            JOptionPane.showMessageDialog(null, "plz fill up all the info");
        } else {
            String query = "INSERT INTO Users (UserName,Pass)"
                    + "values('" + uname + "','" + pass + "');";
            try {
                if (dbc.insertDataToDB(query)) {
                    JOptionPane.showMessageDialog(null, "Sign Up Sucessfully");
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Already Exsists ");
            }

            dbc.disconnectFromDB();
        }

    }

    
    @FXML
    private void reset(MouseEvent event) {
        txtuname.setText("");
        txtpass.setText("");
    }

    
}
