package FirstTask.IO.Writers;

import FirstTask.AutoClub.AutoClub;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;


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
