package FirstTask.AutoClub.Builders;


import FirstTask.AutoClub.Car;

import org.joda.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Evgen on 14.03.2017.
 */
public class CarBuilder {
    //Busy numbers
    private static Set<String> busyNumbers = new LinkedHashSet<>();

    //Methods what check if data is correct
    private static boolean isCorrect(String regEx, String data) {
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(data);
        return m.matches();
    }

    public static boolean isCorrectNumber(String number) {
        return isCorrect("([A-Z]{2})([0-9]{4})([A-Z]{2})", number);
    }

    public static boolean isCorrectDate(String date) {
        return isCorrect("^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$", date);
    }


    //Method what add busy numbers to list
    public static void addNumberToBase(String number) {
        busyNumbers.add(number);
    }


    //Method what build car from correct data
    public static Car buildCar(String number, String brand, String model, String date) {
        Car car = new Car();
        if (isCorrectDate(date) && isCorrectNumber(number)) {
            car.setBrand(brand);
            car.setModel(model);
            car.setNumber(number);
            car.setYear(LocalDate.parse(date));
            return car;
        }
        return null;
    }

}
