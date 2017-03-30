package Tests.hospitals;

/**
 * Created by Evgen on 30.03.2017.
 */
public class Main {
    public static void main(String[] args) {
        TestDAO testDAO = new TestDAO();
        //System.out.println(testDAO);
        System.out.println(testDAO.getCountOfUsers());
    }
}
