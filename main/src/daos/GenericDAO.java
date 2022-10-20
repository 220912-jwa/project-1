package daos;

import java.util.List;

public interface GenericDAO<T> {

    // CRUD Methods - > Create, REad, update, delete

    //READ
    T getById(int id);

    List<T> getAll();

    // CREATE
    T create(T t);

    // UPDATE
    void update(T tUpdated);

    // DELETE
    void delete(int id);

}
