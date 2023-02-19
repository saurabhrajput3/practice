package com.project.ecommerce.Ecommerce.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_address")
public class Address {
    @Id
    @Column(name = "address_id")
    private Integer id;
    @Column(name = "address_name")
    private String name;
    @Column(name = "address_landmark")
    private String landmark;
    @Column(name = "address_pNumber")
    private String phoneNumber;
    @Column(name = "address_zipcode")
    private String zipcode;
    @Column(name = "address_state")
    private String state;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user; //foreign key mapping

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
