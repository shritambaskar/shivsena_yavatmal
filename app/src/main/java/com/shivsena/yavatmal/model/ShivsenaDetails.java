package com.shivsena.yavatmal.model;

public class ShivsenaDetails {
    private String name,mobile,post;
    String uid;
    private String taluka;

    public ShivsenaDetails() {
    }

    public ShivsenaDetails(String name, String mobile, String post) {
        this.name = name;
        this.mobile = mobile;
        this.post = post;
    }

    public ShivsenaDetails(String name, String mobile, String post, String taluka) {
        this.name = name;
        this.mobile = mobile;
        this.post = post;
        this.taluka = taluka;
    }

    public String getTaluka() {
        return taluka;
    }

    public void setTaluka(String taluka) {
        this.taluka = taluka;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
