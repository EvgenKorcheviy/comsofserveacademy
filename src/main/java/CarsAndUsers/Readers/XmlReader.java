package CarsAndUsers.Readers;

import CarsAndUsers.AutoClub.AutoClub;
import CarsAndUsers.AutoClub.User;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.regexp.internal.RE;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Evgen on 17.03.2017.
 */
public class XmlReader implements Reader {
    public static AutoClub readAutoClubFromFile(String filename) {
        try {
            File file = new File(filename);
            JAXBContext jaxbContext = JAXBContext.newInstance(AutoClub.class);

            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            AutoClub autoClub = (AutoClub) unmarshaller.unmarshal(file);

            return autoClub;

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return null;
    }
}
