package ua.lviv.iot.DAO;

public interface GeneralDAO<T> {
    void findAll();
    void findById(Integer id);
    void create(T newItem);
    void update(Integer id, T newItem);
    void delete(Integer id);
}