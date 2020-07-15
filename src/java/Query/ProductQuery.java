/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Query;

/**
 *
 * @author arkan481
 */
public class ProductQuery {
    public String get = "SELECT * FROM PRODUCTS";
    public String create = "INSERT INTO PRODUCTS (name,category,qty,exipred_at) VALUES (?,?,?,?)";
    public String show = "SELECT * FROM PRODUCTS WHERE id = ?";
    public String update = "UPDATE PRODUCTS SET name = ?,category = ?,qty = ?,exipred_at = ? WHERE id = ?";
    public String delete = "DELETE FROM PRODUCTS WHERE id = ?";
}
