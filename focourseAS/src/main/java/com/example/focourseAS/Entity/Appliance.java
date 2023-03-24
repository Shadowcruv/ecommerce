package com.example.focourseAS.Entity;

import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
@ToString
public class Appliance {
    @javax.persistence.Id
    @SequenceGenerator(
            name = "appliance_sequence",
            sequenceName = "appliance_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator =  "appliance_sequence"
    )
    private Long Id;
    @Column( name = "Name_of_Appliance" )
    private String applianceName;

    private String category;
    private double pricePerUnit;
    private Long quantity;
    private double totalPrice;

    @Column( name = "Name_of_User" )
    private String nameOfUser;

    @Column( name = "Date_Entered" )
    private LocalDate dateEntered;

    public Appliance() {
    }

    public Appliance(String applianceName, String category, double pricePerUnit, long quantity){
        this.applianceName = applianceName;
        this.category = category;
        this.pricePerUnit = pricePerUnit;
        this.quantity = quantity;
    }

    public String getApplianceName() {
        return applianceName;
    }

    public String getCategory() {
        return category;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public long getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getNameOfUser() {
        return nameOfUser;
    }

    public LocalDate getDateEntered() {
        return dateEntered;
    }
/////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setDateEntered(LocalDate dateEntered) {
        this.dateEntered = dateEntered;
    }

    public void setApplianceName(String applianceName) {
        this.applianceName = applianceName;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
