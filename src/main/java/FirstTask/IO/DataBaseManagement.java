package FirstTask.IO;

import FirstTask.AutoClub.User;
import com.mysql.jdbc.exceptions.MySQLSyntaxErrorException;

import java.sql.*;

/**
 * Created by Evgen on 22.03.2017.
 */
public class DataBaseManagement {

    //Connection
    public static Connection connectToDataBase(String dbURL, String user, String passWord) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(dbURL, user, passWord);

            return connection;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    //Creating
    public static void createTableUser(Connection connection) {
        try {
            dropTableUser(connection);
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE user(id VARCHAR(30) NOT NULL, " +
                        "name VARCHAR(30) NOT NULL, surname VARCHAR (30) NOT NULL, birthday DATE NOT NULL, phone VARCHAR(20) NOT NULL" +
                    ", email VARCHAR(50) NOT NULL, PRIMARY KEY (id, phone, email))");

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createTableCar(Connection connection) {
            dropTableCar(connection);
        try {
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE car(number VARCHAR(20) NOT NULL PRIMARY KEY, brand VARCHAR(30) NOT NULL, model" +
                    "VARCHAR(20) NOT NULL, year DATE NOT NULL, color VARCHAR(20) NOT NULL, )");

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    //Droping
    public static void dropTableCar(Connection connection) {
        try {
            if (isTableInDatabase(connection, "car")) {
                Statement statement = connection.createStatement();
                statement.execute("DROP TABLE car");

                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void dropTableUser(Connection connection) {
        try {
            if (isTableInDatabase(connection, "car")) {
                dropTableCar(connection);
            }
            if (isTableInDatabase(connection, "user")) {
                Statement statement = connection.createStatement();
                statement.execute("DROP TABLE user");

                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    //Executing
    public static boolean isTableInDatabase(Connection connection, String tableName) {
        try {
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet resultSet = metaData.getTables(null, null, tableName, new String[]{"TABLE"});
            boolean result = resultSet.next();
            return result;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static boolean closeConnection(Connection connection) {
        try {
            connection.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
