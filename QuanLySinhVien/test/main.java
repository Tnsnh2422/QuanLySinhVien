
import Controller.controllerLOGIN;
import View.formLOGIN;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class main {
    public static void main(String[] args) {
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                formLOGIN form = new formLOGIN();
                     controllerLOGIN controLOGIN = new controllerLOGIN(form);
                     controLOGIN.showFormLogin();
                        
                
            }
        });
    }
}
