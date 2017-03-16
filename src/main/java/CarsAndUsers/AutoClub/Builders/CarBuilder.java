package CarsAndUsers.AutoClub.Builders;


import CarsAndUsers.AutoClub.Car;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Evgen on 14.03.2017.
 */
public class CarBuilder {

    private static Set<String> busyNumbers = new LinkedHashSet<>();

    public static boolean isCorectNumber(String number) {
        if(busyNumbers.contains(number)) return false;
        Pattern p = Pattern.compile("([A-Z]{2})([0-9]{4})([A-Z]{2})");
        Matcher m = p.matcher(number);
        if (m.matches()) return true;
        return false;
    }

    public static boolean isCorectDate(String date) {
        Pattern p = Pattern.compile("^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$");
        Matcher m = p.matcher(date);
        if (m.matches()) return true;
        return false;
    }

    public static void addNumberToBase(String number) {
        busyNumbers.add(number);
    }

    public static Car buildCar(String number, String brand, String model, String date) {
        Car car = new Car();
        if (isCorectDate(date) && isCorectNumber(number)) {
            car.setBrand(brand);
            car.setModel(model);
            car.setNumber(number);
            car.setYear(LocalDate.parse(date));
            return car;
        }
        return null;
    }

}
