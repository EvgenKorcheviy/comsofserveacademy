package CarsAndUsers.Readers;


import CarsAndUsers.AutoClub.Car;
import CarsAndUsers.AutoClub.User;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.jws.soap.SOAPBinding;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Evgen on 16.03.2017.
 */
public class XMLReader {
    private Document document;
    Node root;

    public XMLReader(File file) {
        try {

            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            document = documentBuilder.parse(file);
            root = document.getDocumentElement();

        }
        catch (ParserConfigurationException e) {
            e.printStackTrace(System.out);
        }
        catch (IOException e) {
            e.printStackTrace(System.out);
        }
        catch (SAXException e) {
            e.printStackTrace(System.out);
        }

    }

    public List<User> readUsersFromFile() {
        NodeList users = root.getChildNodes();
        for (int i = 0; i < users.getLength(); i++) {
            Node user = users.item(i);

            if (user.getNodeType() != Node.TEXT_NODE) {

            }
        }

        return null;
    }

    public List<Car> readCarsFromFile() {
        return null;
    }





}
