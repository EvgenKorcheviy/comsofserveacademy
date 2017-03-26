package FirstTask.Menu;


import FirstTask.AutoClub.AutoClub;
import FirstTask.AutoClub.AutoClubService;
import FirstTask.AutoClub.Builders.UserBuilder;
import FirstTask.AutoClub.User;
import FirstTask.IO.Readers.ConsoleReader;
import FirstTask.IO.Readers.XmlReader;
import FirstTask.IO.Writers.JSonWriter;
import FirstTask.IO.Writers.XmlWriter;

import java.util.Scanner;

/**
 * Created by Evgen on 16.03.2017.
 */
public class ConsoleMenu {
    public static void choose(AutoClub autoClub, AutoClubService service, ConsoleReader cr) {

        System.out.println("Hello!!! It is program for working with Cars and their Users");
        System.out.println("Enter number for continue : ");
        System.out.println("1.Add User.");
        System.out.println("2.Show all Users.");
        System.out.println("3.Show user's Cars.");
        System.out.println("4.Sort Users by name.");
        System.out.println("5.Sort Users by phone.");
        System.out.println("6.Revers sort Users by name.");
        System.out.println("7.Revers sort Users by phone.");
        System.out.println("8.Find User by phone");
        System.out.println("9.Write Autoclub to XML File");
        System.out.println("10.Write AutoClub to JSon File");
        System.out.println("11.Read AutoClub from XML File");
        System.out.println("12.Read AutoClub from JSon File");
        System.out.println("13.Exit");



        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();



        if (i == 1) {
            User user = UserBuilder.buildUser(cr.readName(), cr.readSurname(), cr.readDate(),
                    cr.readPhone(), cr.readEmail());
            service.addUser(user);
            System.out.println(user);
            choose(autoClub, service, cr);
        }
        if (i == 2) {
            for (User u : autoClub.getUsers()) {
                System.out.println(u);
            }
            choose(autoClub, service, cr);
        }
        if (i == 3) {
            System.out.println("\tEnter users name ");
            String name = scanner.nextLine();
            System.out.println("\tEnter surname ");
            String surname = scanner.nextLine();
            /*System.out.println("\tEnter birthday ");
            String birthday = scanner.nextLine();
            System.out.println("\tEnter phone");
            String phone = scanner.nextLine();
            System.out.println("Enter email");
            String email = scanner.nextLine();*/
            for (User user : autoClub.getUsers()) {
                if (name.equals(user.getName())&&surname.equals(user.getSurname()))
                    System.out.println(user.toString());
            }
            choose(autoClub, service, cr);
        }
        if (i == 4){
            System.out.println(service.sortByName().toString());
            choose(autoClub, service, cr);
        }
        if (i == 5){
            System.out.println(service.sortByPhone().toString());
            choose(autoClub, service, cr);
        }
        if (i == 6){
            System.out.println(service.reversSortByName().toString());
            choose(autoClub, service, cr);
        }
        if (i == 7){
            System.out.println(service.reverseSortByPhone().toString());
            choose(autoClub, service, cr);
        }
        if (i == 8){
            System.out.println("\tEnter a phone");
            String phone = scanner.nextLine();
            for (User user : autoClub.getUsers()) {
                if (user.getPhone().equals(phone))
                    System.out.println(user.toString());
            }
            choose(autoClub, service, cr);
        }
        if (i == 9) {
            System.out.println("Enter a filename");
            String filename = new Scanner(System.in).nextLine();
            XmlWriter.writeAutoClubToFile(autoClub, filename);
            choose(autoClub, service, cr);

        }
        if (i == 10){
            System.out.println("Enter a filename");
            String filename = new Scanner(System.in).nextLine();
            JSonWriter.writeAutoClubToFile(autoClub, filename);
            choose(autoClub, service, cr);

        }
        if (i == 11){
            System.out.println("Enter a filename");
            String filename = new Scanner(System.in).nextLine();
            autoClub = XmlReader.readAutoClubFromFile(filename);
            choose(autoClub, service, cr);

        }
        if (i == 12){
            System.out.println("Enter a filename");
            String filename = new Scanner(System.in).nextLine();
            choose(autoClub, service, cr);

        }
        if (i == 13) {
            return;
        }
    }
}
