package desview.controller;

import desview.model.dao.UsersDAO;
import desview.model.entities.Users;
import java.util.List;

/**
 * Control to users DAO.
 * @author Diones Rossetto.
 * @author Luiz Mello.
 * @since 02/05/2010.
 * @version 1.0
 */
public class UsersControl {

    private Users user;
    private UsersDAO dao;

    /**
     *
     * @param user
     */
    public UsersControl(Users user) {
        dao = new UsersDAO();
        this.setUser(user);
    }

    /**
     *
     */
    public UsersControl() {
        dao = new UsersDAO();
    }

    /**
     *
     * @return if inserted
     */
    public boolean insert() {
        if (user == null) {
            throw new NullPointerException("Trying to insert null user");
        } else {
            if (dao.saveOrUpdate(user)) {
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     *
     * @param u
     */
    public void delete(Users u) {
        if (u == null) {
            throw new NullPointerException("Trying to delete null user");
        } else {
            try {
                this.setUser(u);
                dao.delete(u);
            } catch (Exception ex) {
            }
        }
    }

    /**
     *
     */
    public void delete() {
        if (user == null) {
            throw new NullPointerException("Trying to delete null user");
        } else {
            try {
                dao.delete(user);
            } catch (Exception ex) {
            }
        }
    }

    /**
     *
     * @return if updated
     */
    public boolean update() {
        if (user == null) {
            throw new NullPointerException("Trying to update null user");
        } else {
            if (dao.saveOrUpdate(user)) {
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     *
     * @param user
     */
    public void setUser(Users user) {
        this.user = user;
    }

    /**
     *
     * @return users
     */
    public List<Users> getUsers() {
        return dao.get();
    }

    /**
     *
     * @return all users.
     */
    public List<Users> getAllUsers() {
        return dao.getAll();
    }

    /**
     *
     * @param id
     * @return user by id
     */
    public Users getUsersByID(Long id) {
        return (Users) dao.findById(id);
    }

    /**
     *
     * @param name
     * @return user by name
     */
    public Users getUsersByName(String name) {
        return dao.findByName(name);
    }

    /**
     *
     * @param name
     * @param password
     * @return login
     */
    public Users getLoginUser(String name, String password) {
        return dao.getLogin(name, password);
    }
}
