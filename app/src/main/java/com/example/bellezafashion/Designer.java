package com.example.bellezafashion;

public class Designer {

    private String designerID;
    private String designerName;
    private String occupation;
    private String Email;
    private Integer phone;
    private Integer Cost;

    public Designer() {
    }

    public String getDesignerID() {
        return designerID;
    }

    public void setDesignerID(String designerID) {
        this.designerID = designerID;
    }

    public String getDesignerName() {
        return designerName;
    }

    public void setDesignerName(String designerName) {
        this.designerName = designerName;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Integer getCost() {
        return Cost;
    }

    public void setCost(Integer cost) {
        Cost = cost;
    }
}
