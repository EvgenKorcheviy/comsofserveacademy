package FirstTask.IO.Writers;

import FirstTask.AutoClub.AutoClub;
import org.eclipse.persistence.jaxb.JAXBContextProperties;
import org.eclipse.persistence.jaxb.xmlmodel.ObjectFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Evgen on 20.03.2017.
 */
public class JSonWriter implements Writer {
    public static void writeAutoClubToFile(AutoClub autoClub, String filename) {
        try {
            Map<String, Object> properties = new HashMap<String, Object>(2);
            properties.put(JAXBContextProperties.MEDIA_TYPE, "application/json");
            properties.put(JAXBContextProperties.JSON_INCLUDE_ROOT, false);
            JAXBContext jc = JAXBContext.newInstance(new Class[] {AutoClub.class, ObjectFactory.class}, properties);

            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(autoClub, new File(filename));

        }
        catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
