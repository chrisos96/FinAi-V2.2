package com.example.finai;

public class SupportFormDatabaseHelper {

    String fullname;
    String email;
    String phone;
    String address;
    String postcode;
    String query;

    public SupportFormDatabaseHelper(){

    }


    public SupportFormDatabaseHelper(String fullname, String email, String phone, String address, String postcode, String query) {
        this.fullname = fullname;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.postcode = postcode;
        this.query = query;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }


}
