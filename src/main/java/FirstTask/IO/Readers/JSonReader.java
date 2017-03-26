package FirstTask.IO.Readers;

import FirstTask.AutoClub.AutoClub;
import org.eclipse.persistence.jaxb.JAXBContextProperties;
import org.eclipse.persistence.jaxb.xmlmodel.ObjectFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Evgen on 20.03.2017.
 */
public class JSonReader implements Reader {
    public static AutoClub readAutoClubFromFile(String filename) {
        try {
            Map<String, Object> properties = new HashMap<String, Object>(2);
            properties.put(JAXBContextProperties.MEDIA_TYPE, "application/json");
            properties.put(JAXBContextProperties.JSON_INCLUDE_ROOT, false);

            JAXBContext jc = JAXBContext.newInstance(new Class[] {AutoClub.class, ObjectFactory.class}, properties);

            StreamSource json = new StreamSource(new File(filename));

            Unmarshaller unmarshaller = jc.createUnmarshaller();
            AutoClub autoClub = unmarshaller.unmarshal(json, AutoClub.class).getValue();

            return autoClub;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
