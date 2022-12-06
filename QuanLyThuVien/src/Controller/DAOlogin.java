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
    public int checkTaiKhoan(String tk , String mk) throws SQLException{
      DAO d1 = new DAO();
      Connection conn= d1.getConnection();
      String sql="select * from users where tenDangNhap='"+tk+ "' and matKhau='"+mk+"'";
      Statement st = conn.createStatement();
        ResultSet rs =st.executeQuery(sql);
        while(rs.next()){
           int check = rs.getInt(3); //Cot thu 3 la cot itAdmin
           if(check==1)
               return 11;
           else
               return 1;
        }
        return 0 ;
}
}
