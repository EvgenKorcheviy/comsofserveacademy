package CarsAndUsers.Writers;


import CarsAndUsers.AutoClub.User;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;


/**
 * Created by Evgen on 16.03.2017.
 */
public class XMLWriter {

    public static void writeUserToFile(User user, String fileName) {
        try {
            File file = new File(fileName);

            JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(user, file);
            jaxbMarshaller.marshal(user, System.out);
        }
        catch (JAXBException e){};
    }
}
