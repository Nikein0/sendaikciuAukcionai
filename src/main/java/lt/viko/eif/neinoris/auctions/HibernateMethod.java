package lt.viko.eif.neinoris.auctions;

import lt.viko.eif.neinoris.auctions.model.*;
import lt.viko.eif.neinoris.utils.HibernateUtil;
import lt.viko.eif.neinoris.utils.JaxbUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import static org.hibernate.Hibernate.list;


public class HibernateMethod {

    /**
     * Hibernate method for database
     */
    public void Hibernate(Seller seller1){
        Transaction transaction = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(seller1);
            transaction.commit();
            //session.close();
            //seller1 = (Seller) session.get(Seller.class, 1);
            //System.out.println(seller1)
        } catch(Exception a){
            if(transaction != null) {
                transaction.rollback();
            }
            a.printStackTrace();
        }
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
           List<Seller> sellers = session.createQuery("from Seller", Seller.class).list();
           sellers.forEach(seller -> System.out.println(seller));

           sellers.forEach(seller -> JaxbUtils.converttoXML(seller));

           //server = Server.createTcpServer().start();
            System.in.read();
        }catch(Exception e){
            System.out.println(e.getMessage());
            if(transaction != null){
                transaction.rollback();
            }
        }


    }
}
