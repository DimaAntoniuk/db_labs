package ua.lviv.iot.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import ua.lviv.iot.model.PanelDataEntity;

public class PanelDataDAO implements GeneralDAO<PanelDataEntity> {
    private static SessionFactory sessionFactory;

    public PanelDataDAO() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public void findAll() {
        Session session = sessionFactory.openSession();
        Query query =  session.createQuery("FROM PanelDataEntity");
        for (Object obj : query.list()) {
            print((PanelDataEntity) obj);
        }
        session.close();
    }

    @Override
    public void findById(Integer id) {
        Session session = sessionFactory.openSession();
        print(session.get(PanelDataEntity.class, id));
        session.close();
    }

    @Override
    public void create(PanelDataEntity newItem) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(newItem);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Integer id, PanelDataEntity newItem) {
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
        PanelDataEntity entity = session.get(PanelDataEntity.class, id);
        session.delete(entity);
        transaction.commit();
        session.close();
    }

    public void print(PanelDataEntity entity) {
        System.out.println("PanelData " + entity.getId() + ": " + entity.getAngle() + ", "
                + entity.getChargeLevel() + ", " + entity.getPower()
                + ", " + entity.getPanelId());
    }
}
