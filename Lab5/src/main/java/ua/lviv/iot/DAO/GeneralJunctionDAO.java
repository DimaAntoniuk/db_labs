package ua.lviv.iot.DAO;

public interface GeneralJunctionDAO<T> {
    void findAll();
    void findById(Integer id1, Integer id2);
    void create(T newItem);
    void delete(Integer id1, Integer id2);
}
