/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class ProductController implements Initializable {

    private static Connection ConnectDB() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button addproduct;
    @FXML
    private TextField T2;
    @FXML
    private TextField T3;
    @FXML
    private TextField T4;
    @FXML
    private TableView<Productlist> produc;

    @FXML
    private TableColumn<Productlist, Integer> p_id;

    @FXML
    private TableColumn<Productlist, String> p_name;

    @FXML
    private TableColumn<Productlist, String> p_brand;

    @FXML
    private TableColumn<Productlist, String> p_description;
    
    
    
    //ResultSet resultset;
    
    
    public static ObservableList<Productlist> getDataProductlist(){
        DBConnect dbc = new DBConnect();
        
        try {
            dbc.connectToDB();
            System.out.println("connected");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("can't connect");
            System.out.println(ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("can't connect");
            System.out.println(ex);
        }
        ObservableList<Productlist> p_list= FXCollections.observableArrayList();
        try{
            
            ResultSet resultset=null;
            resultset=dbc.queryToDB("select * from product");
            while(resultset.next()){
                p_list.add(new Productlist(resultset.getInt("product_id"),resultset.getString("productname"),resultset.getString("brand"),resultset.getString("descrip")));
            }
            System.out.println("fetched");
        }catch(Exception e){
            System.out.println("can't fetch");
            System.out.println(e);
        }
        
        
        return p_list;
    }
    public void initialization() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        DBConnect dbc = new DBConnect();
        try {
            dbc.connectToDB();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ObservableList<Productlist> p_list;
        p_list=getDataProductlist();
        p_id.setCellValueFactory(new PropertyValueFactory<Productlist,Integer>("p_id"));
        p_name.setCellValueFactory(new PropertyValueFactory<Productlist,String>("p_name"));
        p_brand.setCellValueFactory(new PropertyValueFactory<Productlist,String>("p_brand"));
        p_description.setCellValueFactory(new PropertyValueFactory<Productlist,String>("p_description"));
        produc.setItems(p_list);
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb){
        // TODO
        /*DBConnect dbc = new DBConnect();
        try {
            dbc.connectToDB();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ObservableList<Productlist> p_list;
        p_list=getDataProductlist();
        p_id.setCellValueFactory(new PropertyValueFactory<Productlist,Integer>("p_id"));
        p_name.setCellValueFactory(new PropertyValueFactory<Productlist,String>("p_name"));
        p_brand.setCellValueFactory(new PropertyValueFactory<Productlist,String>("p_brand"));
        p_description.setCellValueFactory(new PropertyValueFactory<Productlist,String>("p_description"));
        produc.setItems(p_list);
        */
        //T2.setText("777");
        initialization();

    }
    
    
    @FXML
    private void addnewproduct(MouseEvent event) throws SQLException, ClassNotFoundException {
        DBConnect dbc = new DBConnect();
        dbc.connectToDB();
        String pname,brand,description;
        pname= T2.getText();
        brand= T3.getText();
        description= T4.getText();
        dbc.insertDataToDB("insert into product(productname,brand,descrip) values('"+pname+"','"+brand+"','"+description+"')");
        initialization();
        
    }    

    
    
}
