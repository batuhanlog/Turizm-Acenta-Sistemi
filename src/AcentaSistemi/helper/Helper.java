package AcentaSistemi.helper;

import javax.swing.*;
import java.awt.*;
 //Projede ihtiyaç halinde kullanılmak üzere yazılmış metotlar.
public class Helper {
 //Ekran En Boy Oranı
    public static int screenCenterPoint(String axis, Dimension size){
        return switch (axis) {
            case "x" -> (Toolkit.getDefaultToolkit().getScreenSize().width - size.width) / 2;
            case "y" -> (Toolkit.getDefaultToolkit().getScreenSize().height - size.height) / 2;
            default -> 0;
        };
    }

    public static boolean isFieldEmpty(JTextField field){
        return field.getText().trim().isEmpty();
    }
    public static boolean isFieldEmpty(JEditorPane pane){
        return pane.getText().trim().isEmpty();
    }

    public static void showMsg(String str){ //Ekranda işlemlerin sonucunu ekrana yazdıran kısım
        optionPaneTR();
        String msg;
        String title;
        switch (str){
            case "fill":
                msg = "Lütfen tüm alanları doldurunuz.";
                title = "Hata!";
                break;
            case "done":
                msg = "İşlem Başarılı";
                title = "Sonuç";
                break;
            case "error":
                msg = "Bir hata oluştu.";
                title = "Hata!";
            default:
                msg = str;
                title = "Mesaj";

        }
        JOptionPane.showMessageDialog(null,msg,title,JOptionPane.INFORMATION_MESSAGE);
    }

    public static boolean confirm(String str){  //Sorgulama ekranı
        optionPaneTR();
        String msg;
        switch (str){
            case "sure":
                msg = "Bu işlemi gerçekleştirmek istediğinize emin misiniz?";
                break;
            default:
                msg=str;
        }
        return JOptionPane.showConfirmDialog(null,msg,"Son Kararın mı?", JOptionPane.YES_NO_OPTION) == 0;
    }
    public static void optionPaneTR(){
        UIManager.put("OptionPane.okButtonText","Tamam");
        UIManager.put("OptionPane.yesButtonText","Evet");
        UIManager.put("OptionPane.noButtonText","Hayır");

    }
     public static void setTheme() {

         for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
             if ("Nimbus".equals(info.getName())) {
                 try {
                     UIManager.setLookAndFeel(info.getClassName());

                 } catch (Exception e) {
                     System.out.println(e.getMessage());

                 }
                 break;

             }
         }
     }

}