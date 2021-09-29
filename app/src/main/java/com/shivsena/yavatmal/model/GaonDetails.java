package com.shivsena.yavatmal.model;

public class GaonDetails {
    private String gaon;

    public GaonDetails(String gaon) {
        this.gaon = gaon;
    }

    public String getGaon() {
        return gaon;
    }

    public void setGaon(String gaon) {
        this.gaon = gaon;
    }

    @Override
    public String toString() {
        return "GaonDetails{" +
                "gaon='" + gaon + '\'' +
                '}';
    }
}
