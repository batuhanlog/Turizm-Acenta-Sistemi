package AcentaSistemi.view;


import AcentaSistemi.helper.DBConnector;
import AcentaSistemi.helper.Helper;
import AcentaSistemi.model.Hotel;
import AcentaSistemi.model.Reservation;
import AcentaSistemi.model.Room;
import AcentaSistemi.model.User;
import AcentaSistemi.helper.Config;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import static AcentaSistemi.model.Room.searchQuery;
// Otel Yönetim Sistemimiz

public class EmployeeGUI extends JFrame {
    private final DefaultTableModel mdl_room_list;
    private final DefaultTableModel mdl_reservation_list;
    private static int selected_hotelId;
    private static int selected_reservationId;
    private  Object [] row_reservation_list;
    private JTabbedPane tab_admin;
    private JPanel wrapper;
    private JTextField fld_hotel_region;
    private JTextField fld_hotel_city;
    private JTextField fld_hotel_adress;
    private JTextField fld_hotel_name;
    private JTextField fld_hotel_mail;
    private JTextField fld_hotel_tel;
    private JTextField fld_hotel_stars;
    private JTextField fld_hotel_features;
    private JButton btn_hotel_add;
    private JTextField fld_hotel_board;
    private JLabel ismi;
    private JTable tbl_hotel_list;
    private JButton btn_room_refresh;
    private JTextField fld_region_hotelName;
    private JTextField fld_chec_in;
    private JTextField fld_chec_out;
    private JButton odaAraButton;
    private JTextField fld_room_id;
    private JButton btn_room_delete;
    private JButton btn_exit;
    private JTable tbl_room_list;
    private JTextField fld_room_city;
    private JTextField fld_;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton ekleButton;
    private JButton btn_room_search;
    private JTable tbl_reservation_list;
    private JButton btn_refresh;
    private JTextField fld_res_id;
    private JButton btn_res_delete;
    private JTextField fld_hotel_id;
    private JButton btn_hotel_delete;
    private JButton btn_reservation_add;
    private JTextField fld_sh_hotel_name;
    private JTextField fld_sh_hotel_city;
    private JTextField fld_sh_hotel_region;
    private JButton btn_hotel_sh;
    private JTextField fld_sh_hotel_star;
    private JButton btn_room_deletee;
    private User user;
    private Hotel hotel;
    private final Connection connection;
    
    private Object[] row_room_list;

    private DefaultTableModel mdl_hotel_list = new DefaultTableModel();
    private Object[] row_hotel_list;

    //Otel , Oda Ve Rezervasyon işlemleri için ihtiyacımız olan metot
    public EmployeeGUI() {

        //Employee Sınıfının Veritabanı baglantısı ve arayüz için gerekli olan kodların yazıldıgı kısım
        this.hotel=new Hotel();
        this.connection= DBConnector.getInstance();
        this.add(wrapper);
        this.startGUI(900, 700);
        setLocation(Helper.screenCenterPoint("x",getSize()), Helper.screenCenterPoint("y",getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(true);
        this.user = user;
        //Hotel ekle butonuna basıldıgında çalışacak kısım
        btn_hotel_add.addActionListener(e -> {
            if(Helper.isFieldEmpty(fld_hotel_name) ||
            Helper.isFieldEmpty(fld_hotel_city)||
            Helper.isFieldEmpty(fld_hotel_region)||
            Helper.isFieldEmpty(fld_hotel_tel)||
            Helper.isFieldEmpty(fld_hotel_adress)||
            Helper.isFieldEmpty(fld_hotel_mail)||
            Helper.isFieldEmpty(fld_hotel_features)||
            Helper.isFieldEmpty(fld_hotel_board) ||
            Helper.isFieldEmpty(fld_hotel_stars)) {
                Helper.showMsg("fill");
            }else{
                String hotel_name = fld_hotel_name.getText();
                String hotel_city = fld_hotel_city.getText();
                String hotel_region = fld_hotel_region.getText();
                String hotel_address = fld_hotel_adress.getText();
                String hotel_mail = fld_hotel_mail.getText();
                String hotel_tel = fld_hotel_tel.getText();
                String hotel_stars = fld_hotel_stars.getText();
                String hotel_features = fld_hotel_features.getText();
                String hotel_board = fld_hotel_board.getText();
                Hotel.add(hotel_name, hotel_address, hotel_city, hotel_region, hotel_mail, hotel_tel, hotel_stars, hotel_features, hotel_board);
                Helper.showMsg("done");
                loadHotelList();
                fld_hotel_name.setText(null);
                fld_hotel_city.setText(null);
                fld_hotel_name.setText(null);
                fld_hotel_adress.setText(null);
                fld_hotel_mail.setText(null);
                fld_hotel_tel.setText(null);
                fld_hotel_stars.setText(null);
            }
        });
        //**************Model Room List Start*******************
        mdl_room_list = new DefaultTableModel();
        Object[] col_roomList = {"ID","Pansiyon Tipi","Stok","Dönem","Yetişkin Fiyat","Çocuk Ücreti","Hotel özellik","Otel Adı"};
        mdl_room_list.setColumnIdentifiers(col_roomList);
        row_room_list = new Object[col_roomList.length];
        loadRoomList();
        tbl_room_list.setModel(mdl_room_list);
        tbl_room_list.getColumnModel().getColumn(0).setMaxWidth(75);
        tbl_room_list.getTableHeader().setReorderingAllowed(false);
        //Room listesine basıldıgında çalışacak kod
        tbl_room_list.getSelectionModel().addListSelectionListener(e -> {
            try{
                String selected_room_id = tbl_room_list.getValueAt(tbl_room_list.getSelectedRow(),0).toString();
                selected_hotelId = Integer.parseInt(selected_room_id);
                fld_room_id.setText(selected_room_id);

            }catch (Exception exception){
            }
        });

        mdl_hotel_list = new DefaultTableModel();
        //Eklenmiş otelin özelliklerinin bulundugu kısım
        Object[] col_hotel_list = {"ID", "Otel İsmi","Şehir","Yıldız","Telefon","Mail"};
        mdl_hotel_list.setColumnIdentifiers(col_hotel_list);
        row_hotel_list = new Object[col_hotel_list.length];
        loadHotelList();
        tbl_hotel_list.setModel(mdl_hotel_list);
        tbl_hotel_list.getTableHeader().setReorderingAllowed(false);

        tbl_hotel_list.getSelectionModel().addListSelectionListener(e -> {
            try{
                String selected_hotel_id = tbl_hotel_list.getValueAt(tbl_hotel_list.getSelectedRow(),0).toString();
                selected_hotelId = Integer.parseInt(selected_hotel_id);
                fld_hotel_id.setText(selected_hotel_id);

            }catch (Exception exception){
            }
        });


        tbl_hotel_list.addMouseListener

                //Mouse
                (new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        Point point = e.getPoint();
                        int selected_row = tbl_hotel_list.rowAtPoint(point);
                        tbl_hotel_list.setRowSelectionInterval(selected_row, selected_row);

                    }
                });


        btn_room_search.addActionListener(e -> {
            String hotel_name = fld_region_hotelName.getText();
            String hotel_city =fld_room_city.getText();
            String query = searchQuery(hotel_name, hotel_city);
            ArrayList<Hotel> filterHotels = hotel.search_hotel(query);
            loadHotelTable(filterHotels);


        });
        mdl_reservation_list = new DefaultTableModel();
        //Rezervasyon ekranında yazılmasını istedigimiz kısımların oluşturuldugu yer
        Object[] col_reservationList = {"ID","Müşteri Adı","Telefon Numarası","E-mail","Müşteri Notu","Oda Adı","Giriş Tarihi","Çıkış Tarihi","Yetişkin Fiyatı","Çocuk Fiyatı","Toplam Fiyatı","Hotel Adı"};
        mdl_reservation_list.setColumnIdentifiers(col_reservationList);
        row_reservation_list = new Object[col_reservationList.length];
        loadReservationList();
        tbl_reservation_list.setModel(mdl_reservation_list);
        tbl_reservation_list.getColumnModel().getColumn(0).setMaxWidth(75);
        tbl_reservation_list.getTableHeader().setReorderingAllowed(false);
        //Seçilen bir satır üzerinden işlem yapabilme
        tbl_reservation_list.getSelectionModel().addListSelectionListener(e -> {
            try{
                String selected_reservation_id = tbl_reservation_list.getValueAt(tbl_reservation_list.getSelectedRow(),0).toString();
                selected_reservationId = Integer.parseInt(selected_reservation_id); //seçtiğim otel
                fld_res_id.setText(selected_reservation_id);
            }catch (Exception exception){
            }
        });

        //Seçili Rezervasyonu Silme
        btn_res_delete.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_res_id)){
                Helper.showMsg("error");
            }else{
                int reservation_id = Integer.parseInt(fld_res_id.getText());
                if (Reservation.delete(reservation_id)){
                    Helper.showMsg("done");
                    loadReservationModel();
                }
            }
        });

        //Rezervasyon Listesini Yenileme
        btn_refresh.addActionListener(e -> {
            loadReservationModel();
        });
        btn_exit.addActionListener(e -> dispose());


        btn_hotel_delete.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_hotel_id)){
                Helper.showMsg("fill");
            }else{
                int hotel_id = Integer.parseInt(fld_hotel_id.getText());
                if ( Hotel.delete(hotel_id)){
                    Helper.showMsg("done");
                    loadHotelList();
                }else{
                    Helper.showMsg("error");
                }
            }
        });
        //Room sil butonuna basıldıgında
        btn_room_delete.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_room_id)){
                Helper.showMsg("fill");
            }else{
                int room_id = Integer.parseInt(fld_room_id.getText());
                if (Room.delete(room_id)){
                    Helper.showMsg("done");
                    loadRoomList();
                }else{
                    Helper.showMsg("error");
                }
            }

        });
        //Yenileye bastıgımızda çalışacak kısım
        btn_room_refresh.addActionListener(e -> {
            loadRoomList();
        });
        //Rezervasyon ekleye tıklayınca çalışacak kısım
        btn_reservation_add.addActionListener(e -> {
          if(Helper.isFieldEmpty(fld_room_id)){
              Helper.showMsg("error");
          } else{
              ReservationGUI res = new ReservationGUI();
          }
        });
        btn_hotel_sh.addActionListener(e -> {
            String hotel_name = fld_sh_hotel_name.getText();
            String hotel_city = fld_sh_hotel_city.getText();
            String hotel_region = fld_sh_hotel_region.getText();
            String hotel_stars = fld_sh_hotel_star.getText();
            String query = Hotel.searchQuery(hotel_name,hotel_city,hotel_region,hotel_stars);
            ArrayList<Hotel> searchingHotel = Hotel.search_hotel(query);
            loadHotelModel(searchingHotel);
        });
    }
    public void loadHotelModel(ArrayList<Hotel> list){
        DefaultTableModel clearModel = (DefaultTableModel) tbl_hotel_list.getModel();
        clearModel.setRowCount(0);
        for (Hotel obj : list) {
            int i = 0;
            row_hotel_list[i++] = obj.getHotel_id();
            row_hotel_list[i++] = obj.getHotel_name();
            row_hotel_list[i++] = obj.getHotel_city();
            row_hotel_list[i++] = obj.getHotel_region();
            row_hotel_list[i++] = obj.getHotel_address();
            row_hotel_list[i++] = obj.getHotel_mail();
            row_hotel_list[i++] = obj.getHotel_tel();
            row_hotel_list[i++] = obj.getHotel_stars();
            mdl_hotel_list.addRow(row_hotel_list);
        }
    }


    //Oda modellerimiz
    private void loadRoomModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_room_list.getModel();
        clearModel.setRowCount(0);
        for (Room obj : Room.getList()) {
            int i = 0;
            row_room_list[i++] = obj.getId();
            row_room_list[i++] = obj.getRoom_type();
            row_room_list[i++] = obj.getStock();
            row_room_list[i++] = obj.getSeason_id();
            row_room_list[i++] = obj.getAdult_price();
            row_room_list[i++] = obj.getChild_price();
            row_room_list[i++] = obj.getType_hotel_id();
            row_room_list[i++] = obj.getHotel_id();

            mdl_room_list.addRow(row_room_list);
        }
    }
    //Oluşturulan otellerin load edilmesi için gereken kod
    private void loadReservationModel(){
        DefaultTableModel clearModel = (DefaultTableModel) tbl_reservation_list.getModel();
        clearModel.setRowCount(0);
        int i = 0;
        for(Reservation obj : Reservation.getList()){
            i = 0;
            row_reservation_list[i++] = obj.getId();
            row_reservation_list[i++] = obj.getClient_name();
            row_reservation_list[i++] = obj.getClient_phone();
            row_reservation_list[i++] = obj.getClient_email();
            row_reservation_list[i++] = obj.getClient_note();
            row_reservation_list[i++] = obj.getRoom() != null ? obj.getRoom().getRoom_type():" ";
            row_reservation_list[i++] = obj.getCheck_in();
            row_reservation_list[i++] = obj.getCheck_out();
            row_reservation_list[i++] = obj.getAdult_numb();
            row_reservation_list[i++] = obj.getChild_numb();
            row_reservation_list[i++] = obj.getTotal_price();
            row_reservation_list[i++] = obj.getHotel() != null ? obj.getHotel().getHotel_name():" ";
            mdl_reservation_list.addRow(row_reservation_list);
        }
    }
    //Oluşturulan Rezervasyonun Listelenmesi için gereken List Kısmı
    private void loadReservationList() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_reservation_list.getModel();
        clearModel.setRowCount(0);
        for(Reservation obj : Reservation.getList()){
            int i = 0;
            row_reservation_list[i++] = obj.getId();
            row_reservation_list[i++] = obj.getClient_name();
            row_reservation_list[i++] = obj.getClient_phone();
            row_reservation_list[i++] = obj.getClient_email();
            row_reservation_list[i++] = obj.getClient_note();
            row_reservation_list[i++] = Room.roomName(obj.getRoom_id());
            row_reservation_list[i++] = obj.getCheck_in();
            row_reservation_list[i++] = obj.getCheck_out();
            row_reservation_list[i++] = obj.getAdult_numb();
            row_reservation_list[i++] = obj.getChild_numb();
            row_reservation_list[i++] = obj.getTotal_price();
            row_reservation_list[i++] = Hotel.hotelName(obj.getHotel_id());
            mdl_reservation_list.addRow(row_reservation_list);
        }
    }

    //Ekranda otellerin hangi özelliklerini yazmak istedigimiz kısım
    public void loadHotelTable(ArrayList<Hotel> hotelList) {
        Object[] hotel_column = {"ID", "Otel İsmi","Şehir","Yıldız","Telefon","Mail"};
        ArrayList<Object[]> hotelArrayList =
                this.hotel.getForTableSearch(hotel_column.length, hotelList);
        this.createTable(this.mdl_hotel_list, tbl_hotel_list,
                hotel_column, hotelArrayList);
    }
    //table'ın özellikleri
    public void createTable (DefaultTableModel model, JTable table, Object [] columns, ArrayList<Object []> rows) {

        model.setColumnIdentifiers(columns);
        table.setModel(model);
        table.getTableHeader().setReorderingAllowed(false);
        table.getColumnModel().getColumn(0).setMaxWidth(75);
        table.setEnabled(false);

        DefaultTableModel clearModel = (DefaultTableModel) table.getModel();
        clearModel.setRowCount(0);

        if (rows == null) {
            rows = new ArrayList<>();
        }

        for (Object[] row: rows) {
            model.addRow(row);
        }

    }
       //Room Listleri
    private void loadRoomList() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_room_list.getModel();
        clearModel.setRowCount(0);
        for (Room obj : Room.getList()) {
            int i = 0;
            row_room_list[i++] = obj.getId();
            row_room_list[i++] = obj.getRoom_type();
            row_room_list[i++] = obj.getStock();
            row_room_list[i++] = obj.getSeason_id();
            row_room_list[i++] = obj.getAdult_price();
            row_room_list[i++] = obj.getChild_price();
            row_room_list[i++] = obj.getType_hotel_id();
            row_room_list[i++] = obj.getHotel_id();

            mdl_room_list.addRow(row_room_list);
        }
    }
     //Start GUI'nin proje adı ve arayüz gibi kısımları
    public void startGUI ( int width, int height){
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.setTitle(Config.PROJECT_TITLE);
            this.setSize(width, height);
            setLocationRelativeTo(null);
            this.setVisible(true);

    }


    public boolean save (Hotel hotel){
        String query = "INSERT INTO hotel (hotel_name, hotel_address, hotel_city," +
                "hotel_region, hotel_mail, hotel_tel, hotel_stars, hotel_features ,hotel_board) VALUES (?, ?, ?, ?, ?, ?,?,?,?)";

        try {
            PreparedStatement statement = DBConnector.getInstance().prepareStatement(query);
            statement.setString(1, hotel.getHotel_name());
            statement.setString(2, hotel.getHotel_address());
            statement.setString(3, hotel.getHotel_city());
            statement.setString(4, hotel.getHotel_region());
            statement.setString(5, hotel.getHotel_mail());
            statement.setString(6, hotel.getHotel_tel());
            statement.setString(7, hotel.getHotel_stars());
            statement.setString(8, hotel.getHotel_features());
            statement.setString(9, hotel.getHotel_board());




            return statement.executeUpdate() != -1;

        } catch (Exception e) {
            e.printStackTrace();

        }
        return true;

    }

    private void loadHotelList() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_hotel_list.getModel();
        clearModel.setRowCount(0);
        int i = 0;
        for (Hotel obj : Hotel.getList()) {
            i = 0;
            row_hotel_list[i++] = obj.getHotel_id();
            row_hotel_list[i++] = obj.getHotel_name();
            row_hotel_list[i++] = obj.getHotel_city();
            row_hotel_list[i++] = obj.getHotel_stars();
            row_hotel_list[i++] = obj.getHotel_tel();
            row_hotel_list[i++] = obj.getHotel_mail();
            mdl_hotel_list.addRow(row_hotel_list);


        }

    }



}