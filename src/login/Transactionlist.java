/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

/**
 *
 * @author MN
 */
public class Transactionlist {
    String productname;
    int quantity;
    float ppu,total;

    public Transactionlist(String productname, int quantity, float ppu, float total) {
        this.productname = productname;
        this.quantity = quantity;
        this.ppu = ppu;
        this.total = total;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPpu() {
        return ppu;
    }

    public void setPpu(float ppu) {
        this.ppu = ppu;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    
    
}
