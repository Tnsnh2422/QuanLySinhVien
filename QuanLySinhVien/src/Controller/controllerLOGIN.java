/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.FormQuanLySinhVien;
import View.formLOGIN;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class controllerLOGIN {

    private formLOGIN formLogin;
    private DAOlogin DAOlogin;

    public controllerLOGIN(formLOGIN view) {
        this.formLogin = view;
        DAOlogin = new DAOlogin();
        formLogin.addLoginListener(new addLoginListener());
    }

    public void showFormLogin() {
        formLogin.setVisible(true);
    }

    class addLoginListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String tk = formLogin.tfTaiKhoan.getText();
            String mk = formLogin.pwMatKhau.getText();
            try {
                if (DAOlogin.checkTaiKhoan(tk, mk) == true) {
                    formLogin.showMessage("Đăng nhâp thành công");

                    FormQuanLySinhVien formSinhVien = new FormQuanLySinhVien();
                    controllerQuanLySinhVien cnQuanLySinhVien = new controllerQuanLySinhVien(formSinhVien);
                    
                    
                    //////////////////////////////////////////////////////////////////
                    try {
                        cnQuanLySinhVien.showSinhVienView();
                        formLogin.setVisible(false);

                    } catch (SQLException ex) {

                    }
                } //////////////////////////////////////////////////////////////////////////
                else {
                    formLogin.showMessage("Đăng nhâp thất bại vui lòng kiểm tra lại tài khoản");
                }
            } catch (SQLException ex) {
                Logger.getLogger(controllerLOGIN.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
