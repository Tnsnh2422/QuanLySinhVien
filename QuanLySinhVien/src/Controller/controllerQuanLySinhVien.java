/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.sinhVien;
import Model.sinhVienTableModel;
import View.FormQuanLySinhVien;
import View.formLOGIN;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class controllerQuanLySinhVien {

    private FormQuanLySinhVien FormQuanLySinhVien;
    private DAOsinhVien DAOsinhVien;
    private sinhVienTableModel modelTable;
    private formLOGIN formLogin ;
    
     
    public controllerQuanLySinhVien(FormQuanLySinhVien view) {
        this.FormQuanLySinhVien = view;
        this.DAOsinhVien = new DAOsinhVien();
        this.modelTable = new sinhVienTableModel();
        this.formLogin=new formLOGIN();
         FormQuanLySinhVien.addThemActionListener(new themSinhVienListener());
        FormQuanLySinhVien.addSuaActionListener(new suaSinhVienListener());
        FormQuanLySinhVien.addXoaActionListener(new xoaSinhVienListener());
        FormQuanLySinhVien.addResetActionListener(new resetSinhVienListener());
        FormQuanLySinhVien.addQuayLaiActionListener(new quayLaiListener());
        FormQuanLySinhVien.addClickTable(new clickTableListener());
                
    }
    
   // xét model cho bảng sinh viên
    // lấy dữ liệu list sinh viên đổ về bảng sinh viên
    public void showSinhVienView() throws SQLException {
        List<sinhVien> listsv =  DAOsinhVien.getListSinhVien();
        modelTable.setData(listsv);
        FormQuanLySinhVien.setTableModel(modelTable);
        FormQuanLySinhVien.setVisible(true);
 //       FormQuanLySinhVien.clickTable(listsv);
    }

    class themSinhVienListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            sinhVien sv = FormQuanLySinhVien.getSinhVien();
            int tuoi =Integer.parseInt(FormQuanLySinhVien.tfTuoi.getText());
                    
              //-------------------khu vục check thông tin
          if(FormQuanLySinhVien.checkRong()==true){  /// check nếu có trường nào trống 
                FormQuanLySinhVien.showMessage("Không được để trống thông tin", 1);
                return ;
            }
          if(FormQuanLySinhVien.checkTuoi(sv.getTuoi())==true ){  // check tuổi xem có lơn hơn 18 và bé hơn 100 hay không 
                 FormQuanLySinhVien.showMessage("Tuổi phải hơn 18 và bé hơn 100", 1);
                  return;
            }
          
          if(FormQuanLySinhVien.checkMatKhau(sv.getMatKhau())== false )  // check mật khẩu có nhiều hơn 3 ký tự hay không 
          {
              FormQuanLySinhVien.showMessage("Mật khẩu phải nhiều hơn 3 ký tự", 1);
             
          }
          else{
              
            if (sv != null) {
                boolean themSinhVien = DAOsinhVien.themSinhVien(sv);
                if (themSinhVien == true) {
                    FormQuanLySinhVien.showMessage("Thêm sinh viên thành công", 1);
                    try {
                        showSinhVienView();
                    } catch (SQLException ex) {
                        Logger.getLogger(controllerQuanLySinhVien.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    FormQuanLySinhVien.reset();
                } else {
                    FormQuanLySinhVien.showMessage("Thêm sinh viên thấy bại", 1);
                }
            }
        }
          }
            
            

    }

    class suaSinhVienListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(FormQuanLySinhVien.checkRong()==true){
                FormQuanLySinhVien.showMessage("Không được để trống thông tin", 1);
            }
            else{
      
            sinhVien sv = FormQuanLySinhVien.getSinhVien();
              boolean suaSinhVien = false ;
            if (sv != null) {
              
                try {
                    suaSinhVien = DAOsinhVien.suaSinhVien(sv);
                } catch (SQLException ex) {
                    Logger.getLogger(controllerQuanLySinhVien.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (suaSinhVien == true) {
                    FormQuanLySinhVien.showMessage("Sửa sinh viên thành công", 1);
                     try {
                         
                        showSinhVienView();
                    } catch (SQLException ex) {
                        Logger.getLogger(controllerQuanLySinhVien.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    FormQuanLySinhVien.showMessage("Sửa sinh viên thất bại", 1);
                }
            }
        }
        }

    }

    class xoaSinhVienListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            sinhVien sv = FormQuanLySinhVien.getSinhVien();
            if (sv != null) {
                boolean xoaSinhVien = DAOsinhVien.xoaSinhVien(sv);
                if (xoaSinhVien == true) {
                    FormQuanLySinhVien.showMessage("xóa sinh viên thành công", 1);
                     try {
                        showSinhVienView();
                    } catch (SQLException ex) {
                        Logger.getLogger(controllerQuanLySinhVien.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    FormQuanLySinhVien.showMessage("xóa sinh viên thất bại", 1);
                }
            }
        }

    }
  //----------------------------class này để thực hiện các action của button trên view 
    class resetSinhVienListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            FormQuanLySinhVien.reset();
        }

    }
    // 
  class quayLaiListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            controllerLOGIN controllerLogin = new controllerLOGIN(formLogin);
            controllerLogin.showFormLogin();
            FormQuanLySinhVien.showMessage("Bạn vừa đăng xuất", 1);
            FormQuanLySinhVien.setVisible(false);
           
        }
      
}//------------------------- hàm này có mục đích khi click vào table sẽ lấy dữ liệu từ hàng đó chuyển sang các text field
  class clickTableListener implements MouseListener{
   
        @Override
        public void mouseClicked(MouseEvent e) {
            int chonHang = FormQuanLySinhVien.bangSinhVien.getSelectedRow();
            if(chonHang >=0){
                String tenDangNhap = (String) FormQuanLySinhVien.bangSinhVien.getValueAt(chonHang, 0);
                FormQuanLySinhVien.tfTenDangNhap.setText(tenDangNhap);
                FormQuanLySinhVien.tfMatKhau.setText((String) FormQuanLySinhVien.bangSinhVien.getValueAt(chonHang, 1));
                FormQuanLySinhVien.tfHoTen.setText((String) FormQuanLySinhVien.bangSinhVien.getValueAt(chonHang, 2));
                int tuoi =(int) FormQuanLySinhVien.bangSinhVien.getValueAt(chonHang, 3);
                FormQuanLySinhVien.tfTuoi.setText(String.valueOf(tuoi));
                FormQuanLySinhVien.cbGioiTinh.setSelectedItem(String.valueOf(FormQuanLySinhVien.bangSinhVien.getValueAt(chonHang,4)));
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
           
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
          
        }
      
  }
  
}