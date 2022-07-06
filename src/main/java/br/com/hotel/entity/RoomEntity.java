package br.com.hotel.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "room")
public class RoomEntity extends PanacheEntity {

    @Column(name = "number", nullable = false, unique = true)
    private int number;

    @Column(name = "hotel", nullable = false)
    private String hotelName;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }
}
