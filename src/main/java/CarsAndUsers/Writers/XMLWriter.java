package CarsAndUsers.Writers;


import CarsAndUsers.AutoClub.AutoClub;
import CarsAndUsers.AutoClub.User;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;


/**
 * Created by Evgen on 16.03.2017.
 */
public class XMLWriter {

    public static void writeAutoClubToFile(AutoClub autoClub, String fileName) {
        try {
            File file = new File(fileName);

            JAXBContext jaxbContext = JAXBContext.newInstance(AutoClub.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(autoClub, file);
            jaxbMarshaller.marshal(autoClub, System.out);


        }
        catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
