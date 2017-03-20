package CarsAndUsers.AutoClub;


import CarsAndUsers.Comparators.CompareByName;
import CarsAndUsers.Comparators.CompareByPhone;
import CarsAndUsers.Comparators.ReCompareByName;
import CarsAndUsers.Comparators.ReCompareByPhone;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Evgen on 15.03.2017.
 */
public class    AutoClubService {

    private AutoClub autoClub;

    public AutoClubService(AutoClub club) {
        this.autoClub = club;
    }

    public List<User> sortByName() {
        List<User> users = autoClub.getUsers();
        Collections.sort(users, new CompareByName());
        return users;
    };

    public List<User> reversSortByName(){
        List<User> users = autoClub.getUsers();
        Collections.sort(users, new ReCompareByName());
        return users;
    };

    public List<User> sortByPhone() {
        List<User> users = autoClub.getUsers();
        Collections.sort(users, new CompareByPhone());
        return users;
    }

    public List<User> reverseSortByPhone() {
        List<User> users = autoClub.getUsers();
        Collections.sort(users, new ReCompareByPhone());
        return users;
    }


    public List<User> findByFullname(String name) {
        List<User> users = autoClub.getUsers();
        return users.stream().filter(user -> user.getName().toLowerCase().
                contains(name.toLowerCase())).collect(Collectors.toList());
        /*if (!users.isEmpty()){
            List<User> linkedList = new LinkedList<>();
            for (User u : users) {
                if (u.getName().toLowerCase().contains(name.toLowerCase()))
                    linkedList.add(u);
            }
            return linkedList;
        }
        return null;*/
    }

    /*public User getByName(String name) {return null;}
    public User getByPhone(String phone){return null;}
    public User getUseByNumber(String number) {return null;}
    */

    public void addUser(User user){
        List<User> users = autoClub.getUsers();
        users.add(user);
        autoClub.setUsers(users);
    };

    public void removeUser(User user){
        List<User> users = autoClub.getUsers();
        users.remove(user);
        autoClub.setUsers(users);
    };
}
