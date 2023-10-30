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
public class Productlist {
    int p_id;
    String p_name,p_brand,p_description;

    public Productlist(int p_id, String p_name, String p_brand, String p_description) {
        this.p_id = p_id;
        this.p_name = p_name;
        this.p_brand = p_brand;
        this.p_description = p_description;
    }

    public int getP_id() {
        return p_id;
    }

    public String getP_name() {
        return p_name;
    }

    public String getP_brand() {
        return p_brand;
    }

    public String getP_description() {
        return p_description;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public void setP_brand(String p_brand) {
        this.p_brand = p_brand;
    }

    public void setP_description(String p_description) {
        this.p_description = p_description;
    }
    
    
}
