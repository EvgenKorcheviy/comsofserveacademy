package CarsAndUsers.AutoClub;

import com.fasterxml.jackson.annotation.JsonView;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Evgen on 14.03.2017.
 */

@XmlRootElement
public class AutoClub {

    @JsonView()
    private List<User> users;

    public AutoClub() {users = new ArrayList<>();}


    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

}
