package FirstTask;


import FirstTask.AutoClub.AutoClub;
import FirstTask.AutoClub.AutoClubService;
import FirstTask.AutoClub.Builders.CarBuilder;
import FirstTask.AutoClub.Builders.UserBuilder;
import FirstTask.AutoClub.Car;
import FirstTask.AutoClub.User;
import FirstTask.IO.DataBaseManagement;
import FirstTask.IO.Readers.DataBaseReader;
import FirstTask.IO.Readers.JSonReader;
import FirstTask.IO.Readers.XmlReader;
import FirstTask.IO.Writers.JSonWriter;
import FirstTask.IO.Writers.XmlWriter;
import FirstTask.Menu.ConsoleMenu;
import FirstTask.IO.Readers.ConsoleReader;

import java.sql.DatabaseMetaData;


public class Main {

    public static void main(String[] args) {

        /*AutoClub autoClub = new AutoClub();
        AutoClubService service = new AutoClubService(autoClub);
        ConsoleReader cr = new ConsoleReader();

        User user = UserBuilder.buildUser("Evgen", "Korcheviy", "1998-12-21",
                "0994016858", "korcheviy@gmail.com");


        Car car = CarBuilder.buildCar("AX2112BX", "Volgsvagen", "Golf",
                "1998-12-21");


        user.addCar(car);
        service.addUser(user);

        //ConsoleMenu.choose(autoClub, service, cr);

        XmlWriter.writeAutoClubToFile(autoClub, "D:\\comsofserveacademy\\src\\main\\resources\\file.xml");
        System.out.println(XmlReader.readAutoClubFromFile("D:\\comsofserveacademy\\src\\main\\resources\\file.xml"));


        JSonWriter.writeAutoClubToFile(autoClub, "D:\\comsofserveacademy\\src\\main\\resources\\file.json");
        AutoClub cl = JSonReader.readAutoClubFromFile("D:\\comsofserveacademy\\src\\main\\resources\\file.json");
        System.out.println(cl);*/

//        XmlWriter.writeAutoClubToFile(DataBaseReader.readFromDatabase("jdbc:mysql://localhost:3306/autoclub",
//                "root", "0000"), "D:\\comsofserveacademy\\src\\main\\resources\\file.xml");

        //DataBaseManagement.createTables(DataBaseManagement.connectToDataBase("jdbc:mysql://localhost:3306/autoclub",
                //"root", "0000"));

        DataBaseManagement.createTableUser(DataBaseManagement.connectToDataBase("jdbc:mysql://localhost:3306/autoclub",
                "root", "0000"));
    }
}
