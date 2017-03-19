package CarsAndUsers.Readers;

import CarsAndUsers.AutoClub.AutoClub;
import CarsAndUsers.AutoClub.User;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Evgen on 17.03.2017.
 */
public class JSonReader {
    public static AutoClub readUserFromFile(String filename) {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        try {
            FileReader fileReader = new FileReader(filename);
            AutoClub autoClub = gson.fromJson(fileReader, AutoClub.class);
            return autoClub;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
