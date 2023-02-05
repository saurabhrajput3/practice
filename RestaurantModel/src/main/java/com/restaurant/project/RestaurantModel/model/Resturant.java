package com.restaurant.project.RestaurantModel.model;

public class Resturant {
    private String name;
    private String address;
    private String number;
    private String speciality;
    private int totalStaff;
    private String hours;

    public Resturant(String name, String address, String number, String speciality, int totalStaff, String hours) {
        this.name = name;
        this.address = address;
        this.number = number;
        this.speciality = speciality;
        this.totalStaff = totalStaff;
        this.hours = hours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public int getTotalStaff() {
        return totalStaff;
    }

    public void setTotalStaff(int totalStaff) {
        this.totalStaff = totalStaff;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return "Resturant{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", number='" + number + '\'' +
                ", speciality='" + speciality + '\'' +
                ", totalStaff=" + totalStaff +
                ", hours='" + hours + '\'' +
                '}';
    }
}
