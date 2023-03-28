package lt.viko.eif.neinoris.auctions;

import jakarta.xml.bind.JAXBException;
import lt.viko.eif.neinoris.auctions.model.*;
import lt.viko.eif.neinoris.utils.JaxbUtils;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.hibernate.boot.jaxb.mapping.JaxbVersion;
import org.w3c.dom.Text;

import javax.jms.*;
import java.util.List;
/*
public class MessageSender {
    private static final String QUEUE_NAME = "MY_QUEUE";

    public static void main(String... args) throws JMSException, JAXBException {
        Category category1 = new Category("category1");
        Pricing price1 = new Pricing(10.00, 2.00, 12.00);
        Item item1 = new Item("book", category1, price1);
        Account account1 = new Account("username1123");
        Seller seller1 = new Seller("vardenis", "pavardenis", "nickname", account1, List.of(item1));
        Account account2 = new Account("user1233");
        WonItem wonItem1 = new WonItem(item1);
        Customer customer1 = new Customer("customername", "customersurname", "cusnickname", List.of(wonItem1), account2);

        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
        Connection connection = connectionFactory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue(QUEUE_NAME);

        MessageProducer producer = session.createProducer(destination);
        TextMessage message = session.createTextMessage(JaxbUtils.converttoString(seller1));
        producer.send(message);
        System.out.println("Sending message " + message.getText() + " to " + QUEUE_NAME);

        connection.close();
    }
}
*/


public class MessageSender{
    private static final String QUEUE_NAME = "MY_QUEUE";
    private Connection connection;
    private MessageProducer producer;
    private Session session;

    /**
     * Method for sending message to activeMQ
     */
    public MessageSender(Seller seller) throws JMSException, JAXBException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
        Connection connection = connectionFactory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue(QUEUE_NAME);

        MessageProducer producer = session.createProducer(destination);
        TextMessage message = session.createTextMessage(JaxbUtils.converttoString(seller));
        producer.send(message);
        System.out.println("Sending message " + message.getText() + " to " + QUEUE_NAME);

        connection.close();
    }
}
