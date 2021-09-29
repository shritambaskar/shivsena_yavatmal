package com.shivsena.yavatmal.model;

public class TalukaDetails {
    private String taluka;

    public TalukaDetails(String taluka) {
        this.taluka = taluka;
    }

    public String getTaluka() {
        return taluka;
    }

    public void setTaluka(String taluka) {
        this.taluka = taluka;
    }

    @Override
    public String toString() {
        return "TalukaDetails{" +
                "taluka='" + taluka + '\'' +
                '}';
    }
}
