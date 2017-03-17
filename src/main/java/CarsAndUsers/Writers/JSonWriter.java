package CarsAndUsers.Writers;

import CarsAndUsers.AutoClub.User;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * Created by Evgen on 17.03.2017.
 */
public class JSonWriter {
    public static void writeUserToFile(User user, String filename) {
        ObjectMapper mapper = new ObjectMapper();
        try{
            mapper.writeValue(new File(filename), user);


        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
