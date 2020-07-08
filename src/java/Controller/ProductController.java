/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ProductModel;
import Query.ProductQuery;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author arkan481
 */
public class ProductController extends BaseController {

    private ProductQuery query = new ProductQuery();
    private List<ProductModel> products = new ArrayList<>();

    public List<ProductModel> get() {
        String query = this.query.get;
        ResultSet rs = this.get(query);

        try {
            while (rs.next()) {
                ProductModel productModel = new ProductModel();
                productModel.setCategory(rs.getString("category"));
                productModel.setId(rs.getInt("id"));
                productModel.setQty(rs.getInt("qty"));
                productModel.setProductName(rs.getString("name"));
                productModel.setExpired_at(rs.getDate("exipred_at").toString());

                products.add(productModel);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return products;
        }
    }
    
//    public void deleteByID() {
//        String query = this.query.deletebyID;
//        this.delete(query,new int[]{1});
//    }
    
//    
//    public static void main(String[] args) {
//        ProductController productController = new ProductController();
//        List<ProductModel> productModels = productController.get();
//        
//        for (int i = 0; i < productModels.size(); i++) {
//            System.out.println(productModels.get(i).getCategory()+"");
//            
//        }
//    }

}
