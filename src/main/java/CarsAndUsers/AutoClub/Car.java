package CarsAndUsers.AutoClub;

import javax.xml.bind.annotation.*;
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
    public String getNumber() {
        return number;
    }

    @XmlElement
    public String getBrand() {
        return brand;
    }

    @XmlElement
    public String getModel() {
        return model;
    }

    @XmlElement
    public String getYear() {
        return year.toString();
    }

    @XmlTransient
    public User getUser() {
        return user;
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
