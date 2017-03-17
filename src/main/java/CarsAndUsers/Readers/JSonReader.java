package CarsAndUsers.Readers;

import CarsAndUsers.AutoClub.User;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * Created by Evgen on 17.03.2017.
 */
public class JSonReader {
    public static User readUserFromFile(String filename) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            User user = mapper.readValue(new File(filename), User.class);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
