package CarsAndUsers.Readers;

import CarsAndUsers.AutoClub.AutoClub;
import CarsAndUsers.AutoClub.User;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;


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
