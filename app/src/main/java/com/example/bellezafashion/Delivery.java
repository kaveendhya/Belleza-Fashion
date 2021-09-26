package com.example.bellezafashion;

public class Delivery {
    private String name;
    private Integer number;
    private String address;
    private String pref;
    private String note;
    private String sendas;

    public Delivery() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPref() {
        return pref;
    }

    public void setPref(String pref) {
        this.pref = pref;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getSendas() {
        return sendas;
    }

    public void setSendas(String sendas) {
        this.sendas = sendas;
    }
}
