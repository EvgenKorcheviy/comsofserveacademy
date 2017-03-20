package CarsAndUsers.AutoClub;

import CarsAndUsers.AutoClub.Car;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import org.joda.time.LocalDate;

import javax.xml.bind.annotation.*;
import java.util.*;


/**
 * Created by Evgen on 14.03.2017.
 */

public class User {

    private String id;

    private String name;

    private String surname;

    private LocalDate birthday;

    private String phone;

    private String email;

    private List<Car> cars;



    public User() {
        cars = new ArrayList<>();
        this.id = UUID.randomUUID().toString();
    }




    //setters
    @XmlElement
    public void setName(String name) {
        this.name = name;
    }
    @XmlElement
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
    @XmlElement
    public void setSurname(String surname) {
        this.surname = surname;
    }
    @XmlElement
    public void setPhone(String phone) {
        this.phone = phone;
    }
    @XmlElement
    public void setEmail(String email) {
        this.email = email;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
    @XmlAttribute
    public void setId(String id) {
        this.id = id;
    }





    //getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getEmail() {
        return email;
    }

    public List<Car> getCars() {
        return cars;
    }



    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthday=" + birthday +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", cars=" + cars +
                '}';
    }



    public void addCar(Car car) {
        cars.add(car);
        car.setUser(this);
    }
}
