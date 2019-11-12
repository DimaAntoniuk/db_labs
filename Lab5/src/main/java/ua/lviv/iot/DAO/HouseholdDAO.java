package ua.lviv.iot.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import ua.lviv.iot.model.HouseholdEntity;

public class HouseholdDAO implements GeneralDAO<HouseholdEntity> {
    private static SessionFactory sessionFactory;

    public HouseholdDAO() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public void findAll() {
        Session session = sessionFactory.openSession();
        Query query =  session.createQuery("FROM HouseholdEntity");
        for (Object obj : query.list()) {
            print((HouseholdEntity) obj);
        }
        session.close();
    }

    @Override
    public void findById(Integer id) {
        Session session = sessionFactory.openSession();
        print(session.get(HouseholdEntity.class, id));
        session.close();
    }

    @Override
    public void create(HouseholdEntity newItem) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(newItem);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Integer id, HouseholdEntity newItem) {
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
        HouseholdEntity entity = session.get(HouseholdEntity.class, id);
        session.delete(entity);
        transaction.commit();
        session.close();
    }

    public void print(HouseholdEntity entity) {
        System.out.println("Household " + entity.getId() + ": " + entity.getName());
    }

}
