package Tests.hospitals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

/**
 * Created by Evgen on 28.03.2017.
 */
public class TestDAO {

    private String driver;
    private String url;
    private String username;
    private String password;
    private Connection connection;


    public TestDAO() {
        connectToDatabase();
    }

    private void connectToDatabase() {
        getProperties();
        try {
            if (connection == null || connection.isClosed()) {
                Class.forName(driver);
                connection = DriverManager.getConnection(url, username, password);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    private void getProperties() {

        Properties properties = new Properties();
        InputStream inputStream = null;

        try {
            inputStream = new FileInputStream("D:\\comsofserveacademy\\src\\main\\resources\\database.properties");
            properties.load(inputStream);

            driver = properties.getProperty("db.driver");
            url = properties.getProperty("db.url");
            username = properties.getProperty("db.username");
            password = properties.getProperty("db.password");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public int getCountOfUsers (){
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE enabled = TRUE");
            int i = 0;
            while (resultSet.next()) i++;

            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }


    public List<String> getUsersEmailsFromDatabase() {
        List<String> result = new LinkedList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE enabled = TRUE ORDER BY email");
            while (resultSet.next()) result.add(resultSet.getString("email"));
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> getUsersByRoleFromDatabase(String role) {
        List<String> result = new LinkedList<>();
        try {
            Statement statement = connection.createStatement();

            ResultSet roleId = statement.executeQuery("SELECT id FROM role WHERE type = \'" + role + "\'");
            String idOfRole = "";
            while (roleId.next()) idOfRole = roleId.getString("id");
            ResultSet resultSet = statement.executeQuery("SELECT users.email FROM users INNER JOIN role_users ON users.id = " +
                    "role_users.users_id WHERE role_users.role_id = " + idOfRole + "ORDER BY email");
            while (resultSet.next()) {
                result.add(resultSet.getString(1));
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> getUsersByEmailFromDatabase(String email) {
        try {
            Statement statement = connection.createStatement();
            List<String> result = new LinkedList<>();
            ResultSet resultSet = statement.executeQuery("SELECT email from users");
            while (resultSet.next()) {
                if (resultSet.getString("email").contains(email)) result.add(resultSet.getString("email"));
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    /*public static List<User> getUsersFromDatabase(){
        return null;
    }*/

}
