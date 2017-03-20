package CarsAndUsers;


import CarsAndUsers.AutoClub.AutoClub;
import CarsAndUsers.AutoClub.AutoClubService;
import CarsAndUsers.AutoClub.Builders.CarBuilder;
import CarsAndUsers.AutoClub.Builders.UserBuilder;
import CarsAndUsers.AutoClub.Car;
import CarsAndUsers.AutoClub.User;
import CarsAndUsers.Readers.ConsoleReader;
import CarsAndUsers.Readers.JSonReader;
import CarsAndUsers.Readers.XmlReader;
import CarsAndUsers.Writers.JSonWriter;
import CarsAndUsers.Writers.XmlWriter;


public class Main {

    public static void main(String[] args) {

        AutoClub autoClub = new AutoClub();
        AutoClubService service = new AutoClubService(autoClub);
        ConsoleReader cr = new ConsoleReader();

        User user = UserBuilder.buildUser("Evgen", "Korcheviy", "1998-12-21",
                "0994016858", "korcheviy@gmail.com");


        Car car = CarBuilder.buildCar("AX2112BX", "Volgsvagen", "Golf",
                "1998-12-21");


        user.addCar(car);
        service.addUser(user);

        //XmlWriter.writeAutoClubToFile(autoClub, "D:\\comsofserveacademy\\src\\main\\resources\\file.xml");
        //System.out.println(XmlReader.readAutoClubFromFile("D:\\comsofserveacademy\\src\\main\\resources\\file.xml"));


        JSonWriter.writeAutoClubToFile(autoClub, "D:\\comsofserveacademy\\src\\main\\resources\\file.json");
        System.out.println(JSonReader.readAutoClubFromFile("D:\\comsofserveacademy\\src\\main\\resources\\file.json"));
    }
}
