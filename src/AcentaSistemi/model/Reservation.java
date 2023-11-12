package AcentaSistemi.model;

import AcentaSistemi.helper.DBConnector;
import AcentaSistemi.helper.Helper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//Reservasyonların yapılacagı metot
public class Reservation {
    private int id;
    private String client_name;
    private String client_phone;
    private String client_email;
    private String client_note;
    private int room_id;
    private String check_in;
    private String check_out;
    private int adult_numb;
    private int child_numb;
    private int total_price;
    private int hotel_id;
    private Hotel hotel;
    private Room room;

    public Reservation(){

    }
    //Rezervasyon için gereken Constructorlar
    public Reservation(int id, String client_name, String client_phone, String client_email,
                       String client_note,int room_id,String check_in,String check_out,int adult_numb,int child_numb, int total_price,int hotel_id) {
        this.id = id;
        this.client_name = client_name;
        this.client_phone = client_phone;
        this.client_email = client_email;
        this.client_note = client_note;
        this.room_id = room_id;
        this.check_in = check_in;
        this.check_out=check_out;
        this.adult_numb=adult_numb;
        this.child_numb=child_numb;
        this.total_price = total_price;
        this.hotel_id = hotel_id;
        this.hotel = Hotel.getFetch(hotel_id);
        this.room = Room.getFetch(room_id);
    }
    //Rezervasyonu listelemek için rezervasyon ArrayList'i
    public static ArrayList<Reservation> getList(){
        ArrayList<Reservation> reservationList = new ArrayList<>();
        Reservation obj;
        try{
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM reservation");
            while (rs.next()){
                int id = rs.getInt("id");
                String client_name = rs.getString("client_name");
                String client_phone = rs.getString("client_phone");
                String client_email = rs.getString("client_email");
                String client_note = rs.getString("client_note");
                int room_id = rs.getInt("room_id");
                String check_in = rs.getString("check_in");
                String check_out = rs.getString("check_out");
                int adult_numb = rs.getInt("adult_numb");
                int child_numb = rs.getInt("child_numb");
                int total_price = rs.getInt("total_price");
                int hotel_id = rs.getInt("hotel_id");
                obj = new Reservation(id,client_name,client_phone,client_email,client_note,room_id,check_in,check_out,adult_numb,child_numb,total_price,hotel_id);
                reservationList.add(obj);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return reservationList;
    }
    //Oluşturulan Rezervasyonu Silmek için Metot
    public static boolean delete(int id) {
        String query = "DELETE FROM reservation WHERE id =?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1, id);
            return pr.executeUpdate() != -1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getClient_phone() {
        return client_phone;
    }

    public void setClient_phone(String client_phone) {
        this.client_phone = client_phone;
    }

    public String getClient_email() {
        return client_email;
    }

    public void setClient_email(String client_email) {
        this.client_email = client_email;
    }

    public String getClient_note() {
        return client_note;
    }

    public void setClient_note(String client_note) {
        this.client_note = client_note;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public String getCheck_in() {
        return check_in;
    }

    public void setCheck_in(String check_in) {
        this.check_in = check_in;
    }

    public String getCheck_out() {
        return check_out;
    }

    public void setCheck_out(String check_out) {
        this.check_out = check_out;
    }

    public int getAdult_numb() {
        return adult_numb;
    }

    public void setAdult_numb(int adult_numb) {
        this.adult_numb = adult_numb;
    }

    public int getChild_numb() {
        return child_numb;
    }

    public void setChild_numb(int child_numb) {
        this.child_numb = child_numb;
    }

    public int getTotal_price() {
        return total_price;
    }

    public void setTotal_price(int total_price) {
        this.total_price = total_price;
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
