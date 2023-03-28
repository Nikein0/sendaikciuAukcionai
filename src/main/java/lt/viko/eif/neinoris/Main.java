package lt.viko.eif.neinoris;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import lt.viko.eif.neinoris.auctions.HibernateMethod;
import lt.viko.eif.neinoris.auctions.MessageSender;
import lt.viko.eif.neinoris.auctions.model.*;

import javax.jms.JMSException;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) throws JAXBException, IOException {

        JAXBContext context = JAXBContext.newInstance(Seller.class);

        Category category1 = new Category("category1");
        Pricing price1 = new Pricing(10.00, 2.00, 12.00);
        Item item1 = new Item("book", category1, price1);
        Account account1 = new Account("username1123");
        Seller seller1 = new Seller("nicolas", "einoris", "nickname", account1, List.of(item1));
        Account account2 = new Account("user1233");
        WonItem wonItem1 = new WonItem(item1);
        Customer customer1 = new Customer("customername", "customersurname", "cusnickname", List.of(wonItem1), account2);
        System.out.println(seller1);

        //HibernateMethod hibernateMethod = new HibernateMethod();
        //hibernateMethod.Hibernate(seller1);
        try {
            MessageSender messageSender = new MessageSender(seller1);
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
        /*
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);
        OutputStream os = new FileOutputStream("generated.xml");
        marshaller.marshal(seller1, System.out);
        marshaller.marshal(seller1, os);

        Unmarshaller unmarshaller = context.createUnmarshaller();
        Path path = Path.of("generated.xml");
        String xmlContent = Files.readString(path);
        System.out.println(xmlContent);
        StringReader reader = new StringReader(xmlContent);
        Seller seller = (Seller) unmarshaller.unmarshal(reader);
        System.out.println(seller);

         */

    }
}