package ua.lviv.iot.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import ua.lviv.iot.model.OutputEntity;

public class OutputDAO implements GeneralDAO<OutputEntity> {
    private static SessionFactory sessionFactory;

    public OutputDAO() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public void findAll() {
        Session session = sessionFactory.openSession();
        Query query =  session.createQuery("FROM OutputEntity");
        for (Object obj : query.list()) {
            print((OutputEntity) obj);
        }
        session.close();
    }

    @Override
    public void findById(Integer id) {
        Session session = sessionFactory.openSession();
        print(session.get(OutputEntity.class, id));
        session.close();
    }

    @Override
    public void create(OutputEntity newItem) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(newItem);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Integer id, OutputEntity newItem) {
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
        OutputEntity entity = session.get(OutputEntity.class, id);
        session.delete(entity);
        transaction.commit();
        session.close();
    }

    public void print(OutputEntity entity) {
        System.out.println("Output " + entity.getId() + ": " + entity.getPowerPerHour() + ", "
                            + entity.getTimeStart() + ", " + entity.getTimeEnd() + ", " + entity.getPriceId()
                            + ", " + entity.getStationId());
    }
}
