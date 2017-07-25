package desview.model.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 * Interface que contém os métodos para a utilização do padrão DAO para as classes do modelo.
 * @param <T> </i>T</i>.
 * @author Diones Rossetto.
 * @author Luiz Mello.
 * @since 08/04/2010.
 * @version 1.0
 */
public interface DAO<T extends Serializable> {

    /**
     * This method open the hibernate session.
     * @return SessionFactory.
     */
    public SessionFactory getSession();

    /**
     * Find an object in database.
     * @param id the id.
     * @return object with the id.
     */
    public Object findById(Long id);

    /**
     * Save or update an object in database.
     * @param object the object.
     * @return true if success or false if fail.
     */
    public boolean saveOrUpdate(Object object);

    /**
     * Allows to delete an object.
     * @param object the object·
     * @throws Exception exception.
     */
    public void delete(Object object) throws Exception;

    /**
     * This method returns a list with all objects of a table, including the relationships.
     * @return list of objects.
     */
    public List<Object> getAll();

    /**
     * This method returns a list with all objects of a table, excluding the relationships.
     * @return list of objects.
     */
    public List<Object> get();

    /**
     * This method returns the number of elements of an entity in database.
     * @return number of elements.
     */
    public Integer count();

    /**
     * This method finalize the hibernate session.
     */
    public void finalizeSession();
}
