package ru.lab6s1.data.dao;

import javax.ejb.Remote;
import java.io.Serializable;
import java.util.List;

@Remote
public interface DAO<T extends Serializable> {
    List<T> selectList();
    T selectID(int id);
    void insert(T model);
    void delete(int id);
    void update(T model);
    void autoIncrement(T model);
}
