/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.sinhVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOsinhVien {
    // ------------------------------------------------------------đổ dữ liệu từ SQl đổ về list sinh viên 
        public List<sinhVien> getListSinhVien() throws SQLException {
        List<sinhVien> listSinhVien = new ArrayList<>();
          DAO d1=new DAO();
        Connection conn=d1.getConnection();
        try {
             Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from sinhVien1");
        while (rs.next()) {

            String tk = rs.getString("tenDangNhap");
            String mk = rs.getString("matKhau");
            String ht = rs.getString("hoTen");
            int tuoi = rs.getInt("tuoi");
            String gioiTinh = rs.getString("gioiTinh");
            sinhVien sv= new sinhVien(tk,mk,ht,tuoi,gioiTinh);
            listSinhVien.add(sv);
        
        }
        st.close();
        rs.close();
        } catch (Exception e) {
        }
       return listSinhVien ;
        
      
    }

       //------------------------------Dao thêm sinh viên
    public boolean themSinhVien(sinhVien sv){
        DAO d1=new DAO();
        Connection conn=d1.getConnection();
        String sql = "insert into sinhVien1 values(?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sv.getTenDangNhap());
            ps.setString(2, sv.getMatKhau());
            ps.setString(3, sv.getHoTen());
            ps.setInt(4, sv.getTuoi());
            ps.setString(5, sv.getGioiTinh());
            ps.executeUpdate();
            ps.close();
            return true;
            
        } catch (Exception e) {
        }
        return false ;
    }


    //-----------------------------------------------------DAO sửa sinh viên
public boolean suaSinhVien (sinhVien sv) throws SQLException{
  
          DAO d1=new DAO();
        Connection conn=d1.getConnection();
           String sql = "UPDATE sinhVien1 set tenDangNhap = ?, matKhau = ?,hoTen=?,tuoi= ?,gioiTinh=? WHERE tenDangNhap = ?";
    try {
        PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sv.getTenDangNhap());
            ps.setString(2, sv.getMatKhau());
            ps.setString(3, sv.getHoTen());
            ps.setInt(4, sv.getTuoi());
            ps.setString(5, sv.getGioiTinh());
            ps.setString(6, sv.getTenDangNhap());
            ps.executeUpdate();
            ps.close();
            return true;
    } catch (Exception e) {
    }

       
         return false ;
}

//----------------------------------------------------------------------------------DAO xóa sinh viên
public boolean xoaSinhVien(sinhVien sv){
      DAO d1=new DAO();
        Connection conn=d1.getConnection();
        String sql ="DELETE FROM sinhVien1 WHERE tenDangNhap= ?";
        try {
        PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, sv.getTenDangNhap());
            ps.executeUpdate();
            ps.close();
            return true;
    } catch (Exception e) {
    }
        return false ;
}



}