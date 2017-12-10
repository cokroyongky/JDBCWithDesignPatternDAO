package dao;

import entity.EntityAware;
import java.util.List;

//  Generic
public interface BaseDAO<T extends EntityAware> {
    T save(T entity);
    T update(T entity);
    void delete (T entity);
    T findById (Integer id);
    List<T> findBy(T t);
    List<T> getAll();
}
