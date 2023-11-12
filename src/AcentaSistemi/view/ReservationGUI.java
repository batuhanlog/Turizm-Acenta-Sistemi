package AcentaSistemi.view;

import AcentaSistemi.helper.Config;

import javax.swing.*;

//Rezarvasyon Arayüzü
public class ReservationGUI extends JFrame{


    private JPanel wrapper;
    private JTextField fld_res_hotel_name;
    private JTextField fld_res_adress;
    private JTextField fld_res_phone;
    private JTextField fld_res_facility;
    private JTextField fld_res_room_name;
    private JTextField fld_res_season;
    private JTextField fld_res_room_features;
    private JTextField fld_res_room_type;
    private JTextField fld_res_adult_price;
    private JTextField fld_res_child_price;
    private JTextField fld_cust_name;
    private JTextField fld_cust_phone;
    private JTextField fld_cust_email;
    private JTextField fld_cust_note;
    private JComboBox cmb_cust_day;
    private JButton btn_res_call;
    private JButton btn_res_add;
    private JTextField fld_res_total_price;
      //Rezarvasyon Ekranın tasarımsal Özellikleri
    public ReservationGUI(){

        add(wrapper);
        setLocationRelativeTo(null);
        setSize(750, 450);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(true);
        setVisible(true);

    }
}
