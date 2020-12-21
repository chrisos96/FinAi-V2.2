package com.example.finai;

public class RequestPro {

    private String Name;
    private String Description;
    private int Photo;

    public RequestPro() {
    }

    public RequestPro(String name, String des, int photo){

        Name = name;
        Description = des;
        Photo = photo;

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String des) {
        Description = des;
    }

    public int getPhoto() {
        return Photo;
    }

    public void setPhoto(int photo) {
        Photo = photo;
    }
}
