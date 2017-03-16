package CarsAndUsers.Comparators;


import CarsAndUsers.AutoClub.User;

/**
 * Created by Evgen on 16.03.2017.
 */
public class ReCompareByPhone extends CompareByPhone {
    public int compare (User u1, User u2) {
        return -1 * (u1.getPhone().compareToIgnoreCase(u2.getPhone()));
    }
}
