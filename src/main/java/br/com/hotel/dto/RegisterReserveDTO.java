package br.com.hotel.dto;

import io.smallrye.common.constraint.NotNull;

import javax.ejb.Local;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class RegisterReserveDTO {

    @NotNull
    private Long id;

    @NotNull
    private String userName;

    @NotNull
    private String userDocument;

    private String phoneUser;

    @NotNull
    private LocalDate entryDate;

    @NotNull
    private LocalDate departureDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserDocument() {
        return userDocument;
    }

    public void setUserDocument(String userDocument) {
        this.userDocument = userDocument;
    }

    public String getPhoneUser() {
        return phoneUser;
    }

    public void setPhoneUser(String phoneUser) {
        this.phoneUser = phoneUser;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }
}
