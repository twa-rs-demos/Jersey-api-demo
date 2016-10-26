package com.thoughtworks.twars.bean;

public class User {
    private String mobilePhone;
    private Integer id;
    private String email;
    private String password;



    public String getMobilePhone() {
        return mobilePhone;
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public User setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public User setId(Integer id) {
        this.id = id;
        return this;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }
}
