package AcentaSistemi.view;

import AcentaSistemi.helper.Helper;
import AcentaSistemi.model.Admin;
import AcentaSistemi.model.User;
import AcentaSistemi.helper.Config;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
//İlk girişteki Login ekranı
public class LoginGUI extends JFrame{
    private JPanel wrapper;
    private JTextField fld_user_name;
    private JTextField fld_user_pass;
    private JButton btn_login;
    private JButton çıkışYapButton;
    private JButton btn_signin;
 //Login Ekranının tasarımsal özellikleri
    public LoginGUI(){
        add(wrapper);
        setSize(450,550);
        setLocation(Helper.screenCenterPoint("x",getSize()),Helper.screenCenterPoint("y",getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);

        fld_user_pass.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    //login();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        //Logine basıldıgında çalışacak metot
        btn_login.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_user_name) || Helper.isFieldEmpty(fld_user_pass)){
                Helper.showMsg("fill");
            }
            else{
                User u = User.getFetch(fld_user_name.getText(), fld_user_pass.getText());
                if (u==null){
                    Helper.showMsg("Kullanıcı bulunmadı");
                }
                else {
                    switch (u.getType()){
                        case "admin":
                            AdminGUI opGUI = new AdminGUI((Admin) u);
                            break;
                        case "employee":
                            EmployeeGUI adGUI = new EmployeeGUI();
                            adGUI.setVisible(true);
                            dispose();
                            break;
                    }
                    dispose();
                }
            }
        });

       //Çıkış butonuna basıldıgında yazacak buton
        çıkışYapButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }


    public static void main(String[] args) {
        Helper.setTheme();
        LoginGUI login = new LoginGUI();
    }
}