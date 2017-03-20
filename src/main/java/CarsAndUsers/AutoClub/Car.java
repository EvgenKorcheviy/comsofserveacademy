package CarsAndUsers.AutoClub;


import javax.xml.bind.annotation.*;
import java.io.Serializable;
import org.joda.time.LocalDate;

/**
 * Created by Evgen on 14.03.2017.
 */

public class Car {


    private String number;

    private String brand;

    private String model;

    private LocalDate year;

    private User user;


    @XmlAttribute
    public void setNumber(String number) {
        this.number = number;
    }
    @XmlTransient
    public void setUser(User user) {
        this.user = user;
    }
    @XmlElement
    public void setBrand(String brand) {
        this.brand = brand;
    }
    @XmlElement
    public void setModel(String model) {
        this.model = model;
    }
    @XmlElement
    public void setYear(LocalDate year) {
        this.year = year;
    }



    public String getNumber() {
        return number;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public LocalDate getYear() {
        return year;
    }

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
