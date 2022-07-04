package br.com.hotel.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "user")
public class UserEntity extends PanacheEntityBase {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "document", nullable = false)
    private String document;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phone")
    private String phone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
