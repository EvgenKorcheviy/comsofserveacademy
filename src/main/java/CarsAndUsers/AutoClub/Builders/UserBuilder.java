package CarsAndUsers.AutoClub.Builders;


import CarsAndUsers.AutoClub.User;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Evgen on 14.03.2017.
 */
public class UserBuilder {

    // Methods whats check if data is corect
    private static boolean isCorrect(String regEx, String data) {
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(data);
        if (m.matches()) return true;
        return false;
    }

    public static boolean isCorectEmail(String email) {
        return isCorrect("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])", email);
    }

    public static boolean isCorectPhone(String phone) {
        return isCorrect("^[0-9\\-\\+]{9,15}$", phone);
    }

    public static boolean isCorectName(String name) {
        return isCorrect("[A-z]", name);
    }

    public static boolean isCorectBirthday(String birthday) {
        return isCorrect("^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$"
                ,birthday);
    }

    public static boolean isDataCorrect(String name, String surname,
                                        String birthday, String phone, String email){
        if (isCorectBirthday(birthday) &&
                isCorectEmail(email) && isCorectPhone(phone)) return true;
        return false;
    }

    public static User buildUser(String name, String surname, String birthday,
                                 String phone, String email) {
        User user = new User();
        if(isDataCorrect(name, surname, birthday, phone, email)) {
            user.setName(name);
            user.setSurname(surname);
            user.setBirthday(LocalDate.parse(birthday));
            user.setPhone(phone);
            user.setEmail(email);
            return user;
        }
        return user;
    }
}
