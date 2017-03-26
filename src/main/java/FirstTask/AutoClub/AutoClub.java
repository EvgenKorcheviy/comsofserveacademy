package FirstTask.AutoClub;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Evgen on 14.03.2017.
 */

@XmlRootElement
public class AutoClub {

    private List<User> users;


    //Constructor without params
    public AutoClub() {users = new ArrayList<>();}


    //Getter
    public List<User> getUsers() {
        return users;
    }


    //Setter
    public void setUsers(List<User> users) {
        this.users = users;
    }



    //toString method
    @Override
    public String toString() {
        return "AutoClub{" +
                "users=" + users +
                '}';
    }
}
