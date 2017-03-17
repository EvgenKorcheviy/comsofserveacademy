package CarsAndUsers.AutoClub;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
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


    public String getNumber() {
        return number;
    }


    public String getBrand() {
        return brand;
    }


    public String getModel() {
        return model;
    }


    public String getYear() {
        return year.toString();
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
