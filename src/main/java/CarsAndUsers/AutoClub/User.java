package CarsAndUsers.AutoClub;

import CarsAndUsers.AutoClub.Car;

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

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public User() {
        cars = new ArrayList<>();
        this.id = UUID.randomUUID().toString();
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
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


    //getters
    public String getName() {
        return name;
    }

    //
    public void addCar(Car car) {
        cars.add(car);
        car.setUser(this);
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
}
