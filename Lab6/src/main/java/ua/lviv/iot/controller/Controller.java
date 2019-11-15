package ua.lviv.iot.controller;

import java.util.List;

public interface Controller<T> {
    public List<T> getAll() {}
    public T getById(Integer id) {}
    public void create(T t) {}
    public void update(Integer id, T t) {}
    public void delete(Integer id)
}
