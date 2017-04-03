package Tests.hospitals;

/**
 * Created by Evgen on 03.04.2017.
 */
public class Main {
    public static void main(String[] args) {
        TestDAO testDAO = new TestDAO();
        System.out.println(testDAO.getUsersByRoleFromDatabase("ADMIN"));
    }
}
