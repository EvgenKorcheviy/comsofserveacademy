package CarsAndUsers.Writers;

import CarsAndUsers.AutoClub.AutoClub;
import CarsAndUsers.AutoClub.User;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Evgen on 17.03.2017.
 */
public class JSonWriter {
    public static void writeAutoclubToFile(AutoClub autoClub, String filename) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.writeValue(new File(filename), autoClub);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
