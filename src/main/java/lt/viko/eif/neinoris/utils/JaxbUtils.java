package lt.viko.eif.neinoris.utils;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.PropertyException;
import lt.viko.eif.neinoris.auctions.model.Seller;

import java.io.StringWriter;

/**
* Utility class for Jaxb XML transformation
*/
public final class JaxbUtils {
    private JaxbUtils() {
    }

    ;

    /**
     * Method for converting object to XML
     */
    public static void converttoXML(Seller seller) {
        try {
            JAXBContext context = JAXBContext.newInstance(Seller.class);

            Marshaller marshaller = context.createMarshaller();

            marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);
            marshaller.marshal(seller, System.out);

        } catch (PropertyException e) {
            throw new RuntimeException(e);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

    }



    /**
     * Method for converting XML to string
     */
    public static String converttoString(Seller seller) throws JAXBException {
        StringWriter sw = new StringWriter();
        JAXBContext context = JAXBContext.newInstance(Seller.class);

        Marshaller marshaller = context.createMarshaller();

        marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);
        marshaller.marshal(seller, sw);
        String xmlString = sw.toString();

        return xmlString;
    }
}
