package FirstTask.IO.Readers;

import FirstTask.AutoClub.AutoClub;
import FirstTask.AutoClub.AutoClubService;
import FirstTask.AutoClub.Builders.CarBuilder;
import FirstTask.AutoClub.Builders.UserBuilder;
import FirstTask.AutoClub.Car;
import FirstTask.AutoClub.User;
import FirstTask.IO.DataBaseManagement;

import javax.jws.soap.SOAPBinding;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Evgen on 22.03.2017.
 */
public class DataBaseReader {


    public static AutoClub readFromDatabase(Connection connection) {
        List<User> userList = readUsersFromDatabase(connection);
        AutoClub autoClub = new AutoClub();
        AutoClubService autoClubService = new AutoClubService(autoClub);

        readCarsFromDatabase(connection, autoClub);

        return autoClub;
    }




    public static List<User> readUsersFromDatabase(Connection connection) {
        return readUserByField(connection, "5", "5");
    }




    public static void readCarsFromDatabase(Connection connection, AutoClub autoClub) {

        List<User> users = autoClub.getUsers();

        try {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM car INNER JOIN user ON user_id = user.id");

            while (resultSet.next()) {
                String number = resultSet.getString("number");
                String brand = resultSet.getString("brand");
                String model = resultSet.getString("model");
                String year = resultSet.getString("date");
                String userId = resultSet.getString("user_id");
                Car car = CarBuilder.buildCar(number, brand, model, year);

                for (User u : users) {
                    if (u.getId().equals(userId)) {
                        u.addCar(car);
                    }
                }
            }

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    private static List<User> readUserByField(Connection connection, String fieldName, String fielValue) {

        List<User> listOfUsers = new LinkedList<>();

        fieldName = fieldName+ "=";

        try {
            Statement statement= connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM user WHERE " + fieldName + fielValue);

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String birthday = resultSet.getString("birthday");

                User user = UserBuilder.buildUser(name, surname, birthday, phone, email);
                user.setId(id);
                listOfUsers.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listOfUsers;
    }



    public static User readUserFromDatabaseById(Connection connection, String value ) {
        List<User> userList = readUserByField(connection, "id", value);
        return userList.get(0);
    }

    public static List<User> readUsersFromDatabaseByName (Connection connection, String value) {
        return readUserByField(connection, "name", value);
    }

    
}