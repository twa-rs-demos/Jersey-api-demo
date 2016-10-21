package com.thoughtworks.twars.bean;

public class User {
    private String mobilePhone;
    private Integer id;
    private String email;
    private String passWord;

    public String getMobilePhone() {
        return mobilePhone;
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
