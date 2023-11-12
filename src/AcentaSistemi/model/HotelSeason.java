package AcentaSistemi.model;

// Hotellerin Sezonlarının bulundugu metot
public class HotelSeason {
    private int id;
    private String season_start;
    private String season_end;
    private int hotel_id;

    public HotelSeason(int id, String season_start, String season_end, int hotel_id) {
        this.id = id;
        this.season_start = season_start;
        this.season_end = season_end;
        this.hotel_id = hotel_id;
    }
public HotelSeason(){

}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSeason_start() {
        return season_start;
    }

    public void setSeason_start(String season_start) {
        this.season_start = season_start;
    }

    public String getSeason_end() {
        return season_end;
    }

    public void setSeason_end(String season_end) {
        this.season_end = season_end;
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }
}
