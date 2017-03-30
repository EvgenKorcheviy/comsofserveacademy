package Tests.hospitals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
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
            ResultSet resultSet = statement.executeQuery("SELECT * FROM user WHERE enable = TRUE");
            int i = 0;
            while (resultSet.next()) i++;

            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }


}
