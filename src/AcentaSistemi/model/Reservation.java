package AcentaSistemi.model;

import AcentaSistemi.helper.DBConnector;
import AcentaSistemi.helper.Helper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

//Reservasyonların yapılacagı metot
public class Reservation {
    private int id;
    private String client_name;
    private String client_phone;
    private String client_email;
    private String client_note;
    private int room_id;
    private int total_price;
    private int hotel_id;
    private Hotel hotel;
    private Room room;
private LocalDate startDate;
private LocalDate endDate;
private int day;

    public Reservation(){

    }
    //Rezervasyon için gereken Constructorlar
    public Reservation(int id, String client_name, String client_phone, String client_email,
                       String client_note,int day,LocalDate startDate,LocalDate endDate,int room_id, int total_price,int hotel_id) {
        this.id = id;
        this.client_name = client_name;
        this.client_phone = client_phone;
        this.client_email = client_email;
        this.client_note = client_note;
        this.day=day;
        this.startDate=startDate;
        this.endDate=endDate;
        this.room_id = room_id;
        this.total_price = total_price;
        this.hotel_id = hotel_id;
        this.hotel = Hotel.getFetch(hotel_id);
        this.room = Room.getFetch(room_id);
    }
    public Reservation(String client_name, String client_phone, String client_email,
                       String client_note,int day,LocalDate startDate,LocalDate endDate,int room_id, int total_price,int hotel_id) {
        this.client_name = client_name;
        this.client_phone = client_phone;
        this.client_email = client_email;
        this.client_note = client_note;
        this.day=day;
        this.startDate=startDate;
        this.endDate=endDate;
        this.room_id = room_id;
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
                int day = rs.getInt("day");
                LocalDate start= LocalDate.parse(rs.getString("reservation_start"));
                LocalDate end = LocalDate.parse(rs.getString("reservation_end"));
                int room_id = rs.getInt("room_id");
                int total_price = rs.getInt("total_price");
                int hotel_id = rs.getInt("hotel_id");
                obj = new Reservation(id,client_name,client_phone,client_email,
                        client_note, day,start,end,room_id,total_price,hotel_id);
                reservationList.add(obj);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return reservationList;
    }

    public static boolean add(String client_name, String client_phone, String client_email,
                              String client_note, int day,LocalDate startDate,LocalDate endDate,int room_id ,int total_price,int hotel_id) {
        String query = "INSERT INTO reservation (client_name,client_phone,client_email,client_note, day, reservation_start, " +
                "reservation_end, room_id, total_price, hotel_id)" +
                " VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1,client_name);
            pr.setString(2,client_phone);
            pr.setString(3,client_email);
            pr.setString(4,client_note);
            pr.setInt(5,day);
            pr.setDate(6,java.sql.Date.valueOf(startDate));
            pr.setDate(7, java.sql.Date.valueOf(endDate));
            pr.setInt(9,room_id);
            pr.setInt(8,total_price);
            pr.setInt(10,hotel_id);

            int responce = pr.executeUpdate();
            if(responce == -1){
                Helper.showMsg("error");
            }
            return responce != -1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
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
    public boolean save (Reservation reservation ){
        String query = "INSERT INTO reservation (client_name, client_phone, client_email, " +
                " client_note,room_id, total_price, hotel_id)" +
                " VALUES (?,?,?,?,?,?,?)";

        try {
            PreparedStatement statement = DBConnector.getInstance().prepareStatement(query);
            statement.setString(1, reservation.getClient_name());
            statement.setString(2, reservation.getClient_phone());
            statement.setString(3, reservation.getClient_email());
            statement.setString(4, reservation.getClient_note());





            return statement.executeUpdate() != -1;

        } catch (Exception e) {
            e.printStackTrace();

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
