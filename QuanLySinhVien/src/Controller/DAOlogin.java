/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOlogin {
    public boolean checkTaiKhoan(String tk , String mk) throws SQLException{
      DAO d1 = new DAO();
      Connection conn= d1.getConnection();
      String sql="select * from sinhVien1 where tenDangNhap='"+tk+ "' and matKhau='"+mk+"'";
      Statement st = conn.createStatement();
        ResultSet rs =st.executeQuery(sql);
        while(rs.next()){
           return true ;
         
              
        }
        return false ;
}
}
