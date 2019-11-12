package ua.lviv.iot.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import ua.lviv.iot.model.StationHasHouseholdEntity;

import java.io.Serializable;

public class StationHasHouseholdDAO implements GeneralJunctionDAO<StationHasHouseholdEntity>{
    private static SessionFactory sessionFactory;

    public StationHasHouseholdDAO() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public void findAll() {
        Session session = sessionFactory.openSession();
        Query query =  session.createQuery("FROM StationHasHouseholdEntity");
        for (Object obj : query.list()) {
            print((StationHasHouseholdEntity) obj);
        }
        session.close();
    }

    @Override
    public void findById(Integer id1, Integer id2) {
        Session session = sessionFactory.openSession();
        print(session.get(StationHasHouseholdEntity.class, (Serializable) new StationHasHouseholdEntity(id1, id2)));
    }

    @Override
    public void create(StationHasHouseholdEntity newItem) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(newItem);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Integer id1, Integer id2) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        StationHasHouseholdEntity entity = session.get(StationHasHouseholdEntity.class, (Serializable) new StationHasHouseholdEntity(id1, id2));
        session.delete(entity);
        transaction.commit();
        session.close();
    }

    public void print(StationHasHouseholdEntity entity) {
        System.out.println("Station " + entity.getStationId() + " has household "
                + entity.getHouseholdId());
    }
}
