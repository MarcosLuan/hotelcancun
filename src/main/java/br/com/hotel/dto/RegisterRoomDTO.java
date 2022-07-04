package br.com.hotel.dto;

import io.smallrye.common.constraint.NotNull;

public class RegisterRoomDTO {

    @NotNull
    private Long id;

    @NotNull
    private Integer number;

    @NotNull
    private String hotelName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }
}
