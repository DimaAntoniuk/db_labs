package ua.lviv.iot.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import ua.lviv.iot.model.PriceEntity;

public class PriceDAO implements GeneralDAO<PriceEntity> {
    private static SessionFactory sessionFactory;

    public PriceDAO() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public void findAll() {
        Session session = sessionFactory.openSession();
        Query query =  session.createQuery("FROM PriceEntity");
        for (Object obj : query.list()) {
            print((PriceEntity) obj);
        }
        session.close();
    }

    @Override
    public void findById(Integer id) {
        Session session = sessionFactory.openSession();
        print(session.get(PriceEntity.class, id));
        session.close();
    }

    @Override
    public void create(PriceEntity newItem) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(newItem);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Integer id, PriceEntity newItem) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        newItem.setId(id);
        session.update(newItem);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Integer id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        PriceEntity entity = session.get(PriceEntity.class, id);
        session.delete(entity);
        transaction.commit();
        session.close();
    }

    public void print(PriceEntity entity) {
        System.out.println("Price " + entity.getId() + ": " + entity.getValue() + ", "
                + entity.getTimeOfPriceBegin() + ", " + entity.getTimeOfPriceEnd());
    }
}
