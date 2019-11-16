package ua.lviv.iot.controller;

import java.util.List;

public interface Controller<T> {
    List<T> getAll();
    T getById(Integer id);
    void create(T t);
    void update(Integer id, T t);
    void delete(Integer id);
}
