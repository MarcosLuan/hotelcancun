package br.com.hotel.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity(name = "reserve")
public class ReserveEntity extends PanacheEntity {

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "user_document", nullable = false, unique = true)
    private String userDocument;

    @Column(name = "phone_user")
    private String phoneUser;

    @Column(name = "entry_date", nullable = false)
    private LocalDate entryDate;

    @Column(name = "departure_date", nullable = false)
    private LocalDate departureDate;

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
