package ua.lviv.iot.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import ua.lviv.iot.model.OwnerEntity;

public class OwnerDAO implements GeneralDAO<OwnerEntity> {
    private static SessionFactory sessionFactory;

    public OwnerDAO() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public void findAll() {
        Session session = sessionFactory.openSession();
        Query query =  session.createQuery("FROM OwnerEntity");
        for (Object obj : query.list()) {
            print((OwnerEntity) obj);
        }
        session.close();
    }

    @Override
    public void findById(Integer id) {
        Session session = sessionFactory.openSession();
        print(session.get(OwnerEntity.class, id));
        session.close();
    }

    @Override
    public void create(OwnerEntity newItem) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(newItem);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Integer id, OwnerEntity newItem) {
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
        OwnerEntity entity = session.get(OwnerEntity.class, id);
        session.delete(entity);
        transaction.commit();
        session.close();
    }

    public void print(OwnerEntity entity) {
        System.out.println("Owner " + entity.getId() + ": " + entity.getFirstName() + ", "
                            + entity.getLastName());
    }
}
