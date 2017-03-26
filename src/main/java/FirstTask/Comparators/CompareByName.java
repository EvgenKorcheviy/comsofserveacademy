package FirstTask.Comparators;



import FirstTask.AutoClub.User;

import java.util.Comparator;

/**
 * Created by Evgen on 15.03.2017.
 */
public class CompareByName implements Comparator<User> {

    @Override
    public int compare(User u1, User u2) {
        return u1.getName().compareToIgnoreCase(u2.getName());
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }
}
