package ua.lviv.iot.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import ua.lviv.iot.model.StationEntity;

public class StationDAO implements GeneralDAO<StationEntity> {
    private static SessionFactory sessionFactory;

    public StationDAO() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public void findAll() {
        Session session = sessionFactory.openSession();
        Query query =  session.createQuery("FROM StationEntity");
        for (Object obj : query.list()) {
            print((StationEntity) obj);
        }
        session.close();
    }

    @Override
    public void findById(Integer id) {
        Session session = sessionFactory.openSession();
        print(session.get(StationEntity.class, id));
        session.close();
    }

    @Override
    public void create(StationEntity newItem) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(newItem);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Integer id, StationEntity newItem) {
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
        StationEntity entity = session.get(StationEntity.class, id);
        session.delete(entity);
        transaction.commit();
        session.close();
    }

    public void print(StationEntity entity) {
        System.out.println("PanelData " + entity.getId() + ": " + entity.getAddress() + ", "
                + entity.getNumberOfPanels() + ", " + entity.getTimeOfUsage());
    }
}
