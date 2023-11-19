package AcentaSistemi.view;

import AcentaSistemi.helper.Config;
import AcentaSistemi.helper.DBConnector;
import AcentaSistemi.helper.Helper;
import AcentaSistemi.model.Hotel;
import AcentaSistemi.model.HotelSeason;
import AcentaSistemi.model.HotelType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class AddBoardSeasonGUI extends JFrame {
    private final Connection connection;
    private JPanel wrapper;
    private JCheckBox cb_ultra_inclusive;
    private JCheckBox cb_inclusive;
    private JCheckBox cb_breakfast;
    private JCheckBox cb_full_hostel;
    private JCheckBox cb_half_hostel;
    private JCheckBox cb_just_bed;
    private JCheckBox cb_credit_wo_alcohol;
    private JCheckBox cb_summer;
    private JCheckBox cb_winter;
    private JCheckBox cb_spring;
    private JCheckBox cb_autumn;
    private JButton btn_hostel_add;
    private JButton btn_season_add;
    private JButton btn_season_exit;
    private Hotel hotel;
    private int selected_hotel_id=EmployeeGUI.getSelacted_hotelId();

    public AddBoardSeasonGUI(Hotel hotel) {
        this.hotel= hotel;
        this.connection= DBConnector.getInstance();
        this.add(wrapper);
        setSize(450,400);
        setLocation(Helper.screenCenterPoint("x",getSize()), Helper.screenCenterPoint("y",getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(true);
        setVisible(true);

        btn_hostel_add.addActionListener(e -> {
            if (areFieldsEmptyHostelFeatures()) {
                Helper.showMsg("fill");
                return;
            }
            if(cb_ultra_inclusive.isSelected()){
                String ultrainclusive = "Ultra Herşey Dahil";
                HotelType.add_hostel(ultrainclusive,selected_hotel_id);
            }
            if(cb_inclusive.isSelected()){
                String allinclusive = "Herşey Dahil";
                HotelType.add_hostel(allinclusive,selected_hotel_id);
            }
            if(cb_breakfast.isSelected()){
                String breakfast = "Oda Kahvaltı";
                HotelType.add_hostel(breakfast,selected_hotel_id);
            }
            if(cb_full_hostel.isSelected()){
                String fullpencion = "Tam Pansiyon";
                HotelType.add_hostel(fullpencion,selected_hotel_id);
            }
            if(cb_half_hostel.isSelected()){
                String halfhostel = "Yarım Pansiyon";
                HotelType.add_hostel(halfhostel,selected_hotel_id);
            }
            if(cb_just_bed.isSelected()){
                String justbed = "Sadece Yatak";
                HotelType.add_hostel(justbed,selected_hotel_id);
            }
            if(cb_credit_wo_alcohol.isSelected()){
                String fullcredit = "Sadece Yatak";
                HotelType.add_hostel(fullcredit,selected_hotel_id);
            }
            Helper.showMsg("done");

        });
        btn_season_exit.addActionListener(e -> {
            dispose();
        });
        btn_season_add.addActionListener(e -> {

            if (areFieldsEmptySeasonFeatures()) {
                Helper.showMsg("fill");
                return;
            }
            if(cb_summer.isSelected()){
                String sum = "Yaz Dönemi";
                String start = "2024-06-01";
                String end = "2024-09-01";
                HotelSeason.add(sum, selected_hotel_id ,start ,end);
            }
            if(cb_autumn.isSelected()){
                String autumn = "Son Bahar Dönemi";
                String start = "2024-09-02";
                String end = "2024-11-30";
                HotelSeason.add(autumn , selected_hotel_id,start,end);
            }
            if(cb_spring.isSelected()){
                String spring = "İlk Bahar Dönemi";
                String start = "2024-03-01";
                String end = "2024-05-31";
                HotelSeason.add(spring , selected_hotel_id,start,end);
            }
            if(cb_winter.isSelected()){
                String winter = "Genel Dönem";
                String start = "2024-03-01";
                String end = "2024-05-31";
                HotelSeason.add(winter , selected_hotel_id,start,end);
            }
            Helper.showMsg("done");

        });
    }
    private boolean areFieldsEmptyHostelFeatures() {
        return !(cb_ultra_inclusive.isSelected() || cb_inclusive.isSelected() ||  cb_breakfast.isSelected() ||
        cb_full_hostel.isSelected()|| cb_half_hostel.isSelected() || cb_just_bed.isSelected() || cb_credit_wo_alcohol.isSelected());
    }

    private boolean areFieldsEmptySeasonFeatures() {
        return !(cb_summer.isSelected()  || cb_autumn.isSelected()  ||cb_spring.isSelected() ||
                cb_winter.isSelected());
    }
}

