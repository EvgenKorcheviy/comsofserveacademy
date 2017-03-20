package CarsAndUsers.AutoClub;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.google.gson.annotations.Expose;
import com.sun.glass.ui.View;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by Evgen on 14.03.2017.
 */

public class Car {


    private String number;

    private String brand;

    private String model;

    private LocalDate year;

    private User user;



    public void setNumber(String number) {
        this.number = number;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(LocalDate year) {
        this.year = year;
    }



    @XmlElement
    @JsonView
    public String getNumber() {
        return number;
    }
    @XmlElement
    @JsonView
    public String getBrand() {
        return brand;
    }
    @JsonView
    @XmlElement
    public String getModel() {
        return model;
    }

    @XmlElement
    public String getYear() {
        return year.toString();
    }
    @JsonIgnore
    @XmlTransient
    public User getUser() {
        return user;
    }

    @JsonView
    public void setYear(String year) {
        this.year = LocalDate.parse(year);
    }



    @Override
    public String toString() {
        return "Car{" +
                "number='" + number + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                '}';
    }
}
