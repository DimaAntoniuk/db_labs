package ua.lviv.iot.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import ua.lviv.iot.model.PanelEntity;

public class PanelDAO implements GeneralDAO<PanelEntity> {
    private static SessionFactory sessionFactory;

    public PanelDAO() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public void findAll() {
        Session session = sessionFactory.openSession();
        Query query =  session.createQuery("FROM PanelEntity");
        for (Object obj : query.list()) {
            print((PanelEntity) obj);
        }
        session.close();
    }

    @Override
    public void findById(Integer id) {
        Session session = sessionFactory.openSession();
        print(session.get(PanelEntity.class, id));
        session.close();
    }

    @Override
    public void create(PanelEntity newItem) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(newItem);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Integer id, PanelEntity newItem) {
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
        PanelEntity entity = session.get(PanelEntity.class, id);
        session.delete(entity);
        transaction.commit();
        session.close();
    }

    public void print(PanelEntity entity) {
        System.out.println("Panel " + entity.getId() + ": " + entity.getType() + ", "
                + entity.getCapacity() + ", " + entity.getStationId());
    }
}
