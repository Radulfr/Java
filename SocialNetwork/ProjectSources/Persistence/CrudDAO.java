package Persistence;

import java.sql.SQLException;
import java.util.LinkedList;

/**
 * DAO (J2EE Pattern)
 *
 * @param object type
 */
public abstract class CrudDAO<T> {
    
    public abstract T read(T obj) throws SQLException;
    
    public abstract void create(T obj) throws SQLException;

    public abstract void update(T obj) throws SQLException;

    public abstract void delete(T obj) throws SQLException;
    
    public abstract LinkedList<T> readAll(T obj) throws SQLException;
}

