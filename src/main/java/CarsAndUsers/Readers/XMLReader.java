package CarsAndUsers.Readers;


import CarsAndUsers.AutoClub.AutoClub;
import CarsAndUsers.AutoClub.Car;
import CarsAndUsers.AutoClub.User;
import com.sun.jmx.remote.internal.Unmarshal;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.jws.soap.SOAPBinding;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Evgen on 16.03.2017.
 */
public class XMLReader implements Reader {
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
