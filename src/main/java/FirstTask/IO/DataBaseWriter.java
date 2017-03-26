package FirstTask.IO;

import FirstTask.AutoClub.AutoClub;
import FirstTask.AutoClub.Car;
import FirstTask.AutoClub.User;

import javax.jws.soap.SOAPBinding;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Created by Evgen on 22.03.2017.
 */
public class DataBaseWriter {
    public static void writeAutoclubToDataBase(Connection connection, AutoClub autoClub) {
            List<User> list = autoClub.getUsers();
            for (User u : list) {
                writeUserToDatabase(connection, u);
            }
    }

    public static void writeCarToDatabase(Connection connection, Car car, User user) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO car VALUE (" + car.getNumber() + "," + car.getBrand() + ","
                    + car.getModel() + "," + user.getId() + ")");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void writeCarsToDatabase(Connection connection, User user) {
        List<Car> cars = user.getCars();
        for (Car c : cars) {
            writeCarToDatabase(connection, c, user);
        }
    }

    public static void writeUserToDatabase(Connection connection, User user) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO user VALUE (" + user.getId() + "," + user.getName() + "," + user.getBirthday()
                    + "," + user.getPhone() + "," + user.getEmail() + ")");
            writeCarsToDatabase(connection, user);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}