/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.sinhVien;
import Model.sinhVienTableModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Le Trong Nam
 */
public class FormQuanLySinhVien extends JFrame {

    Scanner nhap = new Scanner(System.in);
    public JTextField tfTenDangNhap, tfMatKhau, tfHoTen, tfTuoi;
    public JComboBox cbGioiTinh;
    public JButton btnThem, btnSua, btnXoa, btnReset, btnQuayLai;
    public JLabel lbThongBaoTuoi ;
    public JTable bangSinhVien;
    public DefaultTableModel model;

    public FormQuanLySinhVien() {
        init();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void init() {
        this.setTitle("Quản lý sinh vien");
        this.setSize(900, 900);
        this.setLayout(new BorderLayout());
        this.add(pnNhapThongTin(), BorderLayout.NORTH);
//        this.add(pnButton(),BorderLayout.CENTER);
//        this.add(pnBangSinhVien(), BorderLayout.SOUTH);
        this.add(pnBottom(), BorderLayout.CENTER);
    }

    public JPanel pnNhapThongTin() {

        JPanel pn1 = new JPanel();
        pn1.setLayout(new GridLayout(3, 2, 20, 40));
        pn1.setBackground(new Color(153, 255, 153));

        JLabel lbTDN = new JLabel("Tên đăng nhập:");
        lbTDN.setFont(new Font("Serif", Font.PLAIN, 30));
        pn1.add(lbTDN);
        tfTenDangNhap = new JTextField();
        tfTenDangNhap.setFont(new Font("Serif", Font.PLAIN, 20));
        pn1.add(tfTenDangNhap);

        JLabel lbMK = new JLabel("Mật khẩu   :");
        lbMK.setFont(new Font("Serif", Font.PLAIN, 30));
        pn1.add(lbMK);
        tfMatKhau = new JTextField();
        tfMatKhau.setFont(new Font("Serif", Font.PLAIN, 20));
        pn1.add(tfMatKhau);

        JLabel lbHT = new JLabel("Họ tên    :");
        lbHT.setFont(new Font("Serif", Font.PLAIN, 30));
        pn1.add(lbHT);
        tfHoTen = new JTextField();
        tfHoTen.setFont(new Font("Serif", Font.PLAIN, 20));
        pn1.add(tfHoTen);

        JLabel lbTuoi = new JLabel("Tuổi :");
        lbTuoi.setFont(new Font("Serif", Font.PLAIN, 30));
        pn1.add(lbTuoi);
        tfTuoi = new JTextField();
        tfTuoi.setFont(new Font("Serif", Font.PLAIN, 20));
        pn1.add(tfTuoi);
//        lbThongBaoTuoi= new JLabel();
//        lbThongBaoTuoi.setText("sinh vien ");
//        pn1.add(lbThongBaoTuoi);
        
        String s1[] = {"Nam", "Nữ", "Khác"};
        JLabel lbGT = new JLabel("Giới tính :");
        lbGT.setFont(new Font("Serif", Font.PLAIN, 30));
        pn1.add(lbGT);
        cbGioiTinh = new JComboBox(s1);
        pn1.add(cbGioiTinh);
        return pn1;

    }

    public JPanel pnButton() {
        JPanel pn2 = new JPanel();
        pn2.setSize(900, 300);
        pn2.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 30));
        pn2.setBackground(new Color(153, 255, 255));
        btnThem = new JButton("Thêm");// ,icon
        btnThem.setFont(new Font("Serif", Font.PLAIN, 30));
        btnSua = new JButton("Sửa");
        btnSua.setFont(new Font("Serif", Font.PLAIN, 30));
        btnXoa = new JButton("Xóa");
        btnXoa.setFont(new Font("Serif", Font.PLAIN, 30));
        btnReset = new JButton("Clear");
        btnReset.setFont(new Font("Serif", Font.PLAIN, 30));
        btnQuayLai = new JButton("Quay lại");
        btnQuayLai.setFont(new Font("Serif", Font.PLAIN, 30));
        pn2.add(btnThem);
        pn2.add(btnSua);
        pn2.add(btnSua);
        pn2.add(btnXoa);
        pn2.add(btnReset);
        pn2.add(btnQuayLai);
        return pn2;

    }

    public JPanel pnBangSinhVien() {
        JPanel pn3 = new JPanel();
        pn3.setLayout(new BorderLayout());
        bangSinhVien = new JTable();
         bangSinhVien.setRowHeight(40);
//        String[] tenCot = {"tên đăng nhâp", "mật khẩu", "họ tên", "tuổi", "giới tính"};
//        Object[][] data = {{"le nam", null, null, null, null}};
//        model = new DefaultTableModel(data, tenCot);
//        bangSinhVien = new JTable();
//        bangSinhVien.setModel(model);
//        bangSinhVien.setFont(new Font("Serif", Font.BOLD, 20));
        JScrollPane sp = new JScrollPane(bangSinhVien);
        pn3.add(sp, BorderLayout.CENTER);

        return pn3;
    }

    public JPanel pnBottom() {
        JPanel pn4 = new JPanel();
        pn4.setLayout(new BorderLayout());
        pn4.add(pnButton(), BorderLayout.NORTH);
        pn4.add(pnBangSinhVien(), BorderLayout.CENTER);
        return pn4;
    }
    public void setTableModel(sinhVienTableModel tableModel) {
        bangSinhVien.setModel(tableModel);
    }
    

    public void addThemActionListener(ActionListener log) {
        btnThem.addActionListener(log);
    }

    public void addSuaActionListener(ActionListener log) {
        btnSua.addActionListener(log);
    }

    public void addXoaActionListener(ActionListener log) {
        btnXoa.addActionListener(log);
    }

    public void addResetActionListener(ActionListener log) {
        btnReset.addActionListener(log);
    }
    public void addQuayLaiActionListener(ActionListener log){
        btnQuayLai.addActionListener(log);
    }
    public void addClickTable (MouseListener log){
        bangSinhVien.addMouseListener(log);
        
    }
    public boolean checkRong(){
        if(tfTenDangNhap.getText().equals("") ||tfMatKhau.getText().equals("")||tfHoTen.getText().equals("")||tfTuoi.getText().equals("") ){
            return true ;
        }
        return false ;
    
            }

    // --------------------------------------------------------------------lấy dữ liệu từ các text field đổi thành 1 đôi tượng sinh vien 
    public sinhVien getSinhVien() {

        String tenDangNhap = tfTenDangNhap.getText();
        String mk = tfMatKhau.getText();
        String ht = tfHoTen.getText();
        String gt = cbGioiTinh.getSelectedItem().toString();
        sinhVien sv = null ;
         int tuoi = 0 ;
        try {
            tuoi = Integer.parseInt(tfTuoi.getText());
         sv = new sinhVien(tenDangNhap, mk, ht, tuoi, gt);
        } catch (Exception e) {
            showMessage("Tuổi không hợp lệ xin vui lòng nhập lại",1);
            
        }
       
       
        return sv;
    }
    /////-------------------------------------------------------hàm check họ tên không được có ký tự lạ nào 
    public boolean checkHoTen(String text){
        return true ;
    }
    /////////////---------------------------------------------------hàm check mat khau khong duoc duoi 3 ký tụ
    public boolean checkMatKhau(String text){
        if(text.length() <= 3){
             return false ;
        }else{
            return true ;
        }
       
    }
    //-----------------------------------------------hàm check tuoi khong qua cao qua thap 
    public boolean checkTuoi(int tuoi){
      if(tuoi < 18 || tuoi > 100){
           return true ;
      }
      else{
           return false ;
      }

    }
    ////////////////////////----------------------------------------------------------------------------------------- show các thông báo 
    public void showMessage(String msg, int option) {
        switch (option) {
            case 1: {
                JOptionPane.showMessageDialog(null, msg);
                break;
            }
            case 2: {
                int result = JOptionPane.showConfirmDialog(null, null, msg, JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                   
                }
                break ;
            }
            
        }
    }
  //--------------------------------------------------------------- hàm reset các text File
    public void reset(){
        tfTenDangNhap.setText("");
        tfMatKhau.setText("");
        tfHoTen.setText("");
        tfTuoi.setText("");
      }

    public static void main(String[] args) {

        new FormQuanLySinhVien().setVisible(true);

    }

}
