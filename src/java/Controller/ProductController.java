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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    
    public boolean create(ProductModel productModel) {
        Map<Integer,Object> map = new HashMap<>();
        map.put(1, productModel.getProductName());
        map.put(2, productModel.getCategory());
        map.put(3, productModel.getQty());
        map.put(4, productModel.getExpired_at());
        
        return this.preparedStatement(map, this.query.create);
    }
    
    public ProductModel show(String id) throws SQLException {
        ProductModel pm = new ProductModel();
        
        Map<Integer,Object> map = new HashMap<>();
        map.put(1, id);
        
        String sql = this.query.show;
        ResultSet rs = this.getWithParam(map, sql);
        
        if (rs.next()) {
            pm.setId(rs.getInt("id"));
            pm.setProductName(rs.getString("name"));
            pm.setCategory(rs.getString("category"));
            pm.setQty(rs.getInt("qty"));
            pm.setExpired_at(rs.getString("exipred_at"));
        }
        
        return pm;
    }
    
    public boolean update(ProductModel model) {
        Map<Integer,Object> map = new HashMap<>();
        map.put(1, model.getProductName());
        map.put(2, model.getCategory());
        map.put(3, model.getQty());
        map.put(4, model.getExpired_at());
        map.put(5, model.getId());
        
        String sql = this.query.update;
        
        return this.preparedStatement(map, sql);
    }
    
    public boolean delete(String id) {
        String sql = this.query.delete;
        
        Map<Integer,Object> map = new HashMap<>();
        map.put(1, id);
        
        return this.preparedStatement(map, sql);
    }
    
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
