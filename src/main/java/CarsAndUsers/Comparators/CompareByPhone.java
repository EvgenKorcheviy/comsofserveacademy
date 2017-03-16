package CarsAndUsers.Comparators;


import CarsAndUsers.AutoClub.User;

import java.util.Comparator;

/**
 * Created by Evgen on 16.03.2017.
 */
public class CompareByPhone implements Comparator<User> {

    @Override
    public int compare(User u1, User u2) {
            return u1.getName().compareToIgnoreCase(u2.getName());
    }
}
