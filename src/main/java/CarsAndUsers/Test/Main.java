package CarsAndUsers.Test;


import CarsAndUsers.AutoClub.AutoClub;
import CarsAndUsers.AutoClub.AutoClubService;
import CarsAndUsers.AutoClub.Builders.UserBuilder;
import CarsAndUsers.AutoClub.User;
import CarsAndUsers.Menu.ConsoleMenu;
import CarsAndUsers.Readers.ConsoleReader;
import CarsAndUsers.Writers.XMLWriter;

public class Main {
    public static void main(String[] args) {
        AutoClub autoClub = new AutoClub();
        AutoClubService service = new AutoClubService(autoClub);
        ConsoleReader cr = new ConsoleReader();

        //ConsoleMenu.choose(autoClub, service, cr);

        User user = UserBuilder.buildUser("Evgen", "Korcheviy", "1998-12-21",
                "0994016858", "korcheviy@gmail.com");
        XMLWriter.writeUserToFile(user, "D:\\comsofserveacademy/first.xml");
        System.out.println(user);
        ConsoleMenu.choose(autoClub, service, cr);
        System.out.println(user);

    }
}
