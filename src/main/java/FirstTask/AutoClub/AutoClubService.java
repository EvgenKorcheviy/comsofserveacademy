package FirstTask.AutoClub;


import FirstTask.Comparators.CompareByName;
import FirstTask.Comparators.CompareByPhone;
import FirstTask.Comparators.ReCompareByName;
import FirstTask.Comparators.ReCompareByPhone;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Evgen on 15.03.2017.
 */
public class    AutoClubService {

    private AutoClub autoClub;


    //Constructor what create composition
    public AutoClubService(AutoClub club) {
        this.autoClub = club;
    }




    //Sort/Reverse-sort methods
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



    //Find methods
    public List<User> findByFullname(String name) {
        List<User> users = autoClub.getUsers();
        return users.stream().filter(user -> user.getName().toLowerCase().
                contains(name.toLowerCase())).collect(Collectors.toList());
    }

    /*public User getByName(String name) {return null;}
    public User getByPhone(String phone){return null;}
    public User getUseByNumber(String number) {return null;}
    */


    //Adding
    public void addUser(User user){
        List<User> users = autoClub.getUsers();
        users.add(user);
        autoClub.setUsers(users);
    };


    //Removing
    public void removeUser(User user){
        List<User> users = autoClub.getUsers();
        users.remove(user);
        autoClub.setUsers(users);
    };
}
