package CarsAndUsers.AutoClub;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Evgen on 14.03.2017.
 */
public class AutoClub {
    private List<User> users;

    public AutoClub() {users = new ArrayList<>();}

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

}
