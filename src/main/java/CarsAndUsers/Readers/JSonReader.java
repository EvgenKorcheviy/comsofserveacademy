package CarsAndUsers.Readers;

import CarsAndUsers.AutoClub.AutoClub;
import CarsAndUsers.AutoClub.User;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.regexp.internal.RE;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Evgen on 17.03.2017.
 */
public class JSonReader implements Reader {
    public static AutoClub readAutoClubFromFile(String filename) {
        ObjectMapper mapper = new ObjectMapper();

        AutoClub autoClub = null;
        try {
            autoClub = mapper.readValue(new File(filename), AutoClub.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return autoClub;
    }
}
