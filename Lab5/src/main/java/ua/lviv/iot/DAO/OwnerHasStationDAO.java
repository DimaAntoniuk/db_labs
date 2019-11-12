package ua.lviv.iot.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import ua.lviv.iot.model.OwnerHasStationEntity;
import ua.lviv.iot.model.OwnerHasStationEntityPK;

import java.io.Serializable;

public class OwnerHasStationDAO implements GeneralJunctionDAO<OwnerHasStationEntity> {
    private static SessionFactory sessionFactory;

    public OwnerHasStationDAO() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public void findAll() {
        Session session = sessionFactory.openSession();
        Query query =  session.createQuery("FROM OwnerHasStationEntity");
        for (Object obj : query.list()) {
            print((OwnerHasStationEntity) obj);
        }
        session.close();
    }

    @Override
    public void findById(Integer id1, Integer id2) {
        Session session = sessionFactory.openSession();
        print(session.get(OwnerHasStationEntity.class, (Serializable) new OwnerHasStationEntityPK(id1, id2)));
    }

    @Override
    public void create(OwnerHasStationEntity newItem) {
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
        OwnerHasStationEntity entity = session.get(OwnerHasStationEntity.class, (Serializable) new OwnerHasStationEntityPK(id1, id2));
        session.delete(entity);
        transaction.commit();
        session.close();
    }

    public void print(OwnerHasStationEntity entity) {
        System.out.println("Owner " + entity.getOwnerId() + " has station "
                + entity.getStationId());
    }
}
