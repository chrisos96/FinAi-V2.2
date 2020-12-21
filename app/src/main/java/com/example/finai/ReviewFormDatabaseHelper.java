package com.example.finai;

public class ReviewFormDatabaseHelper {

    String mail;
    String rate;
    String review;


    public ReviewFormDatabaseHelper(){

    }



    public ReviewFormDatabaseHelper(String Mail, String Rate, String Review) {

        this.mail = Mail;
        this.rate = Rate;
        this.review = Review;

    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
