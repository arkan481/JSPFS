/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Config.DBConnection;
import com.sun.rowset.CachedRowSetImpl;
import java.sql.*;

/**
 *
 * @author arkan481
 */
public class BaseController {
    DBConnection connection = new DBConnection();
    
    public ResultSet get(String sql) {
        try {
            Connection con = connection.open();
            
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            CachedRowSetImpl crs = new CachedRowSetImpl();
            crs.populate(rs);
            
            con.close();
            return crs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
//    public void delete(String sql,Object...args) {
//        try {
//            Connection con = connection.open();
//            
//            PreparedStatement statement = con.prepareStatement(sql);
//            
//            for (int i = 0; i < args.length; i++) {
//                statement.setObject(i, args[i]);
//            }
//            statement.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
