package com.example.finai;

public class RegisterDatabaseHelper {

    String username;
    String xEmail;
    String xPassword;


    public RegisterDatabaseHelper(){

    }


    public RegisterDatabaseHelper(String Username, String xemail, String xpassword) {
        this.username = Username;
        this.xEmail = xemail;
        this.xPassword = xpassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String Username) {
        this.username = username;
    }

    public String getEmail() {
        return xEmail;
    }

    public void setEmail(String xemail) {
        xEmail = xemail;
    }

    public String getPassword() {
        return xPassword;
    }

    public void setPassword(String xpassword) {
        xPassword = xpassword;
    }
}
