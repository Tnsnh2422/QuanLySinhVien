/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.ThamKhao;

import Model.Books;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAObooks {
    // -----------------------đổ dữ liệu từ SQl đổ về list sach 
        public List<Books> getListbBooks() throws SQLException {
        List<Books> listBooks = new ArrayList<>();
        DAO d1=new DAO();
        Connection conn=d1.getConnection();
        try {
            Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from Sach");
        while (rs.next()) {

            String MaS = rs.getString("MaSach");
            String TenS = rs.getString("TenSach");
            String TL = rs.getString("TheLoai");
            Books book = new Books(MaS, TenS, TL);
            listBooks.add(book);
        }
        st.close();
        rs.close();
        } catch (Exception e) {
        }
       return listBooks ;
    }
       //------------------------------Dao thêm sach
    public boolean themSach(Books sach){
        DAO d1=new DAO();
        Connection conn=d1.getConnection();
        String sql = "insert into SACH values(?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sach.getMaSach());
            ps.setString(2, sach.getTenSach());
            ps.setString(3, sach.getTheLoai());
            return true;
        } catch (Exception e) {
        }
        return false ;
    }
    //-----------------------------------------------------DAO sửa sinh viên
    public boolean suaSach (Books sach) throws SQLException{

            DAO d1=new DAO();
            Connection conn=d1.getConnection();
            String sql = "UPDATE SACH set MaSach = ?, TenSach = ?, TheLoai=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, sach.getMaSach());
                ps.setString(2, sach.getTenSach());
                ps.setString(3, sach.getTheLoai());
                ps.close();
                return true;
        } catch (Exception e) {
        }
             return false ;
    }
//----------------------------------------------------------------------------------DAO xóa sinh viên
    public boolean xoaBook(Books sach){
          DAO d1=new DAO();
            Connection conn=d1.getConnection();
            String sql ="DELETE FROM SACH WHERE MaSach = ?";
            try {
            PreparedStatement ps = conn.prepareCall(sql);
                ps.setString(1, sach.getMaSach());
                ps.executeUpdate();
                ps.close();
                return true;
        } catch (Exception e) {
        }
            return false ;
    }
}