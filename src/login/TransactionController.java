/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.io.IOException;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MN
 */
public class TransactionController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField tp_id;

    @FXML
    private TextField ts_id;

    @FXML
    private TextField tquantity;

    @FXML
    private TextField tppu;

    @FXML
    private TextField td;

    @FXML
    private TextField tm;

    @FXML
    private TextField ty;

    @FXML
    private TableView<Transactionlist> list;

    @FXML
    private TableColumn<Transactionlist, String> tcproductname;

    @FXML
    private TableColumn<Transactionlist, Integer> tcquantity;

    @FXML
    private TableColumn<Transactionlist, Float> tcppu;

    @FXML
    private TableColumn<Transactionlist, Float> tctotal;

    @FXML
    private Button badd;

    @FXML
    private Button btransact;
    public int xx;

    
    public ObservableList<Transactionlist> t_list = FXCollections.observableArrayList();
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }
    
    @FXML
    void addtocart(MouseEvent event) {
        
        String productname="tt";
        xx=100;
        int quantity,p_id;
        float ppu,total;
        quantity=parseInt(tquantity.getText());
        p_id=parseInt(tp_id.getText());
        ppu=parseFloat(tppu.getText());
        total=quantity*ppu;
        quantity=parseInt(tquantity.getText());
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
        ResultSet resultset=null;
        
        resultset=dbc.queryToDB("select * from product where product_id='" + p_id + "';");
        //resultset=dbc.queryToDB("select * from product");
        try {
            //System.out.println(resultset.getString("productname"));
        //productname=resultset.getString("productname");
        while(resultset.next()){
                productname=resultset.getString("productname");
            }
        //int t=0;
        } catch (SQLException ex) {
        Logger.getLogger(TransactionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //System.out.println(productname);
        //System.out.println(quantity);
        //System.out.println(ppu);
        //System.out.println(total);
        
        t_list.add(new Transactionlist(productname,quantity,ppu,total));
        System.out.println(t_list.size());
        tcproductname.setCellValueFactory(new PropertyValueFactory<Transactionlist,String>("productname"));
        tcquantity.setCellValueFactory(new PropertyValueFactory<Transactionlist,Integer>("quantity"));
        tcppu.setCellValueFactory(new PropertyValueFactory<Transactionlist,Float>("ppu"));
        tctotal.setCellValueFactory(new PropertyValueFactory<Transactionlist,Float>("total"));
        
        list.setItems(t_list);
    }
    /*
    public TransactionController(ObservableList<Transactionlist> t_list) {
        System.out.println(t_list.size());
        this.t_list = t_list;
    }
    */
    

    public ObservableList<Transactionlist> getT_list() {
        System.out.println(this.t_list.size());
        return t_list;
    }

    public void setT_list() {
        this.t_list = t_list;
    } 
    @FXML
    void transact(MouseEvent event) {
        System.out.println("size = "+t_list.size());
        try {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("Finaltransaction.fxml"));
        /* 
         * if "fx:controller" is not set in fxml
         * fxmlLoader.setController(NewWindowController);
         */
        Scene scene = new Scene(fxmlLoader.load(), 1600, 1400);
        Stage stage = new Stage();
        stage.setTitle("New Window");
        stage.setScene(scene);
        stage.show();
    } catch (IOException e) {
        Logger logger = Logger.getLogger(getClass().getName());
        logger.log(Level.SEVERE, "Failed to create new Window.", e);
    }

    }
    
    
}
