package br.com.hotel.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "room")
public class RoomEntity extends PanacheEntity {

    @Column(name = "number", nullable = false, unique = true)
    private int numberRoom;

    @Column(name = "hotel", nullable = false)
    private String hotelName;

    public int getNumberRoom() {
        return numberRoom;
    }

    public void setNumberRoom(int numberRoom) {
        this.numberRoom = numberRoom;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }
}
