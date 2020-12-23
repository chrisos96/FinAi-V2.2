package com.example.finai;

public class HouseFormDatabaseHelper {

    String house_id;
    int price;
    int bedrooms;
    int bathrooms;
    int sqft_living;
    int sqft_lot;
    int floors;
    int waterfront;
    int house_view;
    int condition;
    int grade;
    int sqft_above;
    int sqft_basement;
    int year_built;
    int year_renovated;


    public HouseFormDatabaseHelper() {

    }

    public HouseFormDatabaseHelper(String House_id, int Price, int Bedrooms, int Bathrooms, int SQFT_living, int SQFT_lot, int Floors, int Waterfront, int House_view, int Condition, int Grade, int SQFT_above, int SQFT_basement, int Year_built,int Year_renovated) {

        this.house_id = House_id;
        this.price = Price;
        this.bedrooms = Bedrooms;
        this.bathrooms = Bathrooms;
        this.sqft_living = SQFT_living;
        this.sqft_lot = SQFT_lot;
        this.floors = Floors;
        this.waterfront = Waterfront;
        this.house_view = House_view;
        this.condition = Condition;
        this.grade = Grade;
        this.sqft_above = SQFT_above;
        this.sqft_basement = SQFT_basement;
        this.year_built = Year_built;
        this.year_renovated = Year_renovated;
    }

    public String getHouse_id() {
        return house_id;
    }

    public void setHouse_id(String house_id) {
        this.house_id = house_id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public int getSqft_living() {
        return sqft_living;
    }

    public void setSqft_living(int sqft_living) {
        this.sqft_living = sqft_living;
    }

    public int getSqft_lot() {
        return sqft_lot;
    }

    public void setSqft_lot(int sqft_lot) {
        this.sqft_lot = sqft_lot;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public int getWaterfront() {
        return waterfront;
    }

    public void setWaterfront(int waterfront) {
        this.waterfront = waterfront;
    }

    public int getHouse_view() {
        return house_view;
    }

    public void setHouse_view(int house_view) {
        this.house_view = house_view;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getSqft_above() {
        return sqft_above;
    }

    public void setSqft_above(int sqft_above) {
        this.sqft_above = sqft_above;
    }

    public int getSqft_basement() {
        return sqft_basement;
    }

    public void setSqft_basement(int sqft_basement) {
        this.sqft_basement = sqft_basement;
    }

    public int getYear_built() {
        return year_built;
    }

    public void setYear_built(int year_built) {
        this.year_built = year_built;
    }

    public int getYear_renovated() {
        return year_renovated;
    }

    public void setYear_renovated(int year_renovated) {
        this.year_renovated = year_renovated;
    }
}
