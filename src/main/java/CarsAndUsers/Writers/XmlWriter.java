package CarsAndUsers.Writers;

import CarsAndUsers.AutoClub.AutoClub;
import CarsAndUsers.AutoClub.User;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Evgen on 17.03.2017.
 */
public class XmlWriter implements Writer{
    public static void writeAutoClubToFile(AutoClub autoClub, String filename) {
        try {
            File file = new File(filename);

            JAXBContext jaxbContext = JAXBContext.newInstance(AutoClub.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(autoClub, file);

        }
        catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
