package AcentaSistemi.model;

import AcentaSistemi.helper.DBConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//Hoteldeki odaların kontrol edilmesini saglayan kısım
public class Room {
    private int id;
    private String room_type;
    private int stock;
    private int season_id;
    private int adult_price;
    private int child_price;
    private int type_hotel_id;
    private int hotel_id;

    private HotelType hoteltype;
    private Hotel hotel;
    private HotelSeason hotelseason;

    public Room(){

    }
// Odaların Constructurı
    public Room(int id, String room_type, int stock, int season_id, int adult_price, int child_price, int type_hotel_id, int hotel_id) {
        this.id = id;
        this.room_type = room_type;
        this.stock = stock;
        this.season_id = season_id;
        this.adult_price = adult_price;
        this.child_price = child_price;
        this.type_hotel_id = type_hotel_id;
        this.hotel_id = hotel_id;
        this.hotel=Hotel.getFetch(hotel_id);
        this.hoteltype=HotelType.getFetch(type_hotel_id);

    }
    //Odaları listelemek istedigimiz de ihtiyacımız olacak olan ArrayListimiz
    public static ArrayList<Room> getList(){
        ArrayList<Room> roomList = new ArrayList<>();
        Room obj;
        try{
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM room");
            while (rs.next()){
                int id = rs.getInt("id");
                String room_type = rs.getString("room_type");
                int stock = rs.getInt("stock");
                int season_id = rs.getInt("season_id");
                int adult_price = rs.getInt("adult_price");
                int child_price = rs.getInt("child_price");
                int type_hotel_id = rs.getInt("type_hotel_id");
                int hotel_id = rs.getInt("hotel_id");
                obj = new Room(id,room_type,stock,season_id,adult_price,child_price,type_hotel_id,hotel_id);
                roomList.add(obj);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return roomList;
    }
    //Araam Kısmı için gerekli olan searchQuery methodumuz
    public static String searchQuery (String hotel_name, String hotel_city) {


        String query = "SELECT * FROM hotel RIGHT OUTER JOIN room ON hotel_id = hotel_id " +
                "WHERE hotel_name LIKE '%{{hotel_name}}%' AND " +
                "hotel_city LIKE '%{{hotel_city}}%'";



        query = query.replace("{{hotel_name}}", hotel_name);
        query = query.replace("{{hotel_city}}", hotel_city);

        System.out.println(query);
        return query;

    }
    //odayı kullanmak istegimiz zaman çagrıcagımız getFetch methodumuz
    public static Room getFetch(int id){
        Room obj = null;
        String query = "SELECT * FROM room WHERE id =?";
        try{
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1, String.valueOf(id));
            ResultSet rs = pr.executeQuery();
            while(rs.next()) {
                obj = new Room();
                obj.setId(rs.getInt("id"));
                obj.setRoom_type(rs.getString("room_type"));
                obj.setStock(rs.getInt("stock"));
                obj.setSeason_id(rs.getInt("season_id"));
                obj.setAdult_price(rs.getInt("adult_price"));
                obj.setChild_price(rs.getInt("child_price"));
                obj.setType_hotel_id(rs.getInt("type_hotel_id"));
                obj.setHotel_id(rs.getInt("hotel_id"));


            }

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return obj;
    }
    //Oda adımız
    public static String roomName(int id){
        String query = "SELECT room_type FROM room WHERE id = ?";
        String room_type = "";
        Room obj;
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1,id);
            ResultSet rs = pr.executeQuery();
            while (rs.next()){
                obj = new Room();
                obj.setRoom_type(rs.getString("room_type"));
                room_type += obj.getRoom_type();

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return room_type;
    }
    //oda silme işlemleri
    public static boolean delete(int id) {
        String query = "DELETE FROM room WHERE id =?";
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

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getSeason_id() {
        return season_id;
    }

    public void setSeason_id(int season_id) {
        this.season_id = season_id;
    }

    public int getAdult_price() {
        return adult_price;
    }

    public void setAdult_price(int adult_price) {
        this.adult_price = adult_price;
    }

    public int getChild_price() {
        return child_price;
    }

    public void setChild_price(int child_price) {
        this.child_price = child_price;
    }

    public int getType_hotel_id() {
        return type_hotel_id;
    }

    public void setType_hotel_id(int type_hotel_id) {
        this.type_hotel_id = type_hotel_id;
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public HotelType getHoteltype() {
        return hoteltype;
    }

    public void setHoteltype(HotelType hoteltype) {
        this.hoteltype = hoteltype;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public HotelSeason getHotelseason() {
        return hotelseason;
    }

    public void setHotelseason(HotelSeason hotelseason) {
        this.hotelseason = hotelseason;
    }
}
