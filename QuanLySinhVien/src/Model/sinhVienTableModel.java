/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class sinhVienTableModel extends  AbstractTableModel{
    private final String[] tenCot = {"Tên đăng nhập", "Mật khẩu", "Họ tên","Tuổi","Giới tính"};
    private List<sinhVien> sinhVien;

    public sinhVienTableModel() {
        this.sinhVien = new ArrayList<>();
    }
    
    public void setData(List<sinhVien> sinhVien) {
        this.sinhVien = sinhVien;

        // Mỗi khi dữ liệu của tableModel được cập nhật qua hàm setData thì 
        // tableModel sẽ thông báo cho cái table trong View cập lại
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int i) {
        return tenCot[i];
    }
    
    @Override
    public int getRowCount() {
        return sinhVien.size();
    }

    @Override
    public int getColumnCount() {
        return tenCot.length;
    }

    @Override
    public Object getValueAt(int hang, int cot) {
        sinhVien sv = sinhVien.get(hang);
        switch(cot){
            case 0:
                return sv.getTenDangNhap();
            case 1: 
                return sv.getMatKhau();
            case 2: 
                return sv.getHoTen();
            case 3: 
                return sv.getTuoi();
            case 4:
                 return sv.getGioiTinh();
            
        }
        return null ;
    }
    
}
