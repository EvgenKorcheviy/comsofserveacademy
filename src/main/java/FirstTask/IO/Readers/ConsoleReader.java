package FirstTask.IO.Readers;


import java.util.Scanner;

/**
 * Created by Evgen on 15.03.2017.
 */
public class ConsoleReader implements Reader {

    public String scanConsole() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public String readBrand() {
        System.out.println("Enter brand of car : ");
        return scanConsole();
    }

    public String readModel() {
        System.out.println("Enter model of car : ");
        return scanConsole();
    }

    public String readNumber() {
        System.out.println("Enter number of car : ");
        return scanConsole();
    }

    public String readDate() {
        System.out.println("Date of production : ");
        return scanConsole();
    }

    public String readName() {
        System.out.println("Enter name of user : ");
        return scanConsole();
    }

    public String readSurname() {
        System.out.println("Enter surname of user : ");
        return scanConsole();
    }

    public String readPhone() {
        System.out.println("Enter user's phone : ");
        return scanConsole();
    }

    public String readEmail() {
        System.out.println("Enter EMail : ");
        return scanConsole();
    }
}
