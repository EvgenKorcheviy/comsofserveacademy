package CarsAndUsers.AutoClub;

import CarsAndUsers.AutoClub.Car;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import javax.xml.bind.annotation.*;
import java.time.LocalDate;
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
    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(String birthday) {
        this.birthday = LocalDate.parse(birthday);
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public void setId(String id) {
        this.id = id;
    }





    //getters
    @JsonView
    @XmlAttribute
    public String getId() {
        return id;
    }
    @JsonView
    @XmlElement
    public String getName() {
        return name;
    }
    @JsonView
    @XmlElement
    public String getSurname() {
        return surname;
    }
    @JsonView
    @XmlElement
    public String getPhone() {
        return phone;
    }
    @JsonView
    @XmlElement
    public String getBirthday() {
        return birthday.toString();
    }
    @JsonView
    @XmlElement
    public String getEmail() {
        return email;
    }

    @JsonIgnore
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
