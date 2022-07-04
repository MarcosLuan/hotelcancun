package br.com.hotel.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "room")
public class RoomEntity extends PanacheEntityBase {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "number", nullable = false)
    private int number;

    @Column(name = "hotel", nullable = false)
    private String hotelName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
