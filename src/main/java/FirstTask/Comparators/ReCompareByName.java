package FirstTask.Comparators;


import FirstTask.AutoClub.User;

/**
 * Created by Evgen on 15.03.2017.
 */
public class ReCompareByName extends CompareByName {
    public int compare (User u1, User u2) {
        return -1*(u1.getName().compareToIgnoreCase(u2.getName()));
    }
}
