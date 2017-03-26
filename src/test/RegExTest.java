package FirstTask.Test;



import FirstTask.AutoClub.Builders.CarBuilder;
import FirstTask.AutoClub.Car;
import FirstTask.AutoClub.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Evgen on 16.03.2017.
 */
public class RegExTest {
        public static void main(String[] args) {
            Pattern p = Pattern.compile("([A-Z]{2})([0-9]{4})([A-Z]{2})");
            Matcher m = p.matcher("AX1212BX");
            System.out.println(m.matches());
            CarBuilder builder = new CarBuilder();
            Car car = builder.buildCar("AX1221BX", "Volgsvagen", "Golf", "1998-12-21");
            System.out.println(car);
            System.out.println(builder.isCorectNumber("AX1221BX"));
            System.out.println(builder.isCorectDate("1998-12-21"));

            User user = new User();
        }
}
