package FirstTask;


import FirstTask.IO.DataBaseManagement;


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
