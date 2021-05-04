package com.store.model;

import java.util.Objects;

public class Customer {
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private String gender;
    private int orderNumber;

    public Customer() {
    }

    public Customer(String name, String address, String phoneNumber, String email, String gender, int orderNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.gender = gender;
        this.orderNumber = orderNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Customer){
            Customer customer1 = (Customer) o;
            if (customer1.getEmail().equals(this.email) || customer1.getPhoneNumber().equals(this.phoneNumber)){
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumber, email);
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

    public  String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getOrderNumber() {
        return orderNumber;
    }
    public void setOrderNumber(int orderNumber){
        this.orderNumber = orderNumber;
    }
    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", Email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", orderNumber=" + orderNumber;
    }
    public String toStringNotOrder(){
        return "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", Email='" + email + '\'' +
                ", gender='" + gender + "'";
    }

    public String toStringCSV() {
        return name + "," + address + "," + phoneNumber + "," + email + "," + gender + "," + orderNumber + "\n";
    }
}
