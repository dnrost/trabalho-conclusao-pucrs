package desview.model.dao;

import desview.model.entities.Users;
import desview.util.Message;
import desview.util.persistence.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Class DAO to entity Users.
 * @author Diones Rossetto.
 * @author Luiz Mello.
 * @since 02/05/2010.
 * @version 1.0
 */
@SuppressWarnings("rawtypes")
public class UsersDAO implements DAO {

    /**
     * Constructor of the class.
     */
    public UsersDAO() {
    }

    @Override
    public SessionFactory getSession() {
        return HibernateUtil.getSessionFactory();
    }

    @Override
    public void delete(Object user) throws Exception {
        Session sessao = getSession().getCurrentSession();
        Transaction transacao = sessao.beginTransaction();
        try {
            sessao.delete(user);
            transacao.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transacao.rollback();
            Message.error(null, "Delete", "Problem deleting user");
            throw e;
        }
    }

    @Override
    public boolean saveOrUpdate(Object user) {
        Session sessao = getSession().getCurrentSession();
        Transaction transacao = sessao.beginTransaction();
        try {
            sessao.saveOrUpdate(user);
            transacao.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            transacao.rollback();
            return false;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Users> getAll() {
        Session sessao = getSession().getCurrentSession();
        Transaction transacao = sessao.beginTransaction();
        List<Users> lista = new ArrayList<Users>();
        try {
            lista = sessao.createCriteria(Users.class).list();
            transacao.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transacao.rollback();
        }
        return lista;
    }

    @Override
    public Object findById(Long id) {
        Session sessao = getSession().getCurrentSession();
        Transaction transacao = sessao.beginTransaction();
        Object user = null;
        try {
            user = sessao.get(Users.class, id);
            transacao.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transacao.rollback();
        }
        return user;
    }

    public Users findByName(String name) {
        Session sessao = getSession().getCurrentSession();
        Transaction transacao = sessao.beginTransaction();
        Users resultado = null;
        try {
            Query q = sessao.getNamedQuery("Users.findByName");
            q.setParameter("name", name);
            resultado = (Users) q.uniqueResult();
            transacao.commit();
        } catch (RuntimeException r) {
            r.printStackTrace();
        }
        return resultado;
    }

    public Users getLogin(String name, String password) {
        Session sessao = getSession().getCurrentSession();
        Transaction transacao = sessao.beginTransaction();
        Users resultado = null;
        try {
            Query q = sessao.getNamedQuery("Users.login");
            q.setParameter("name", name);
            q.setParameter("password", password);
            resultado = (Users) q.uniqueResult();
            transacao.commit();
        } catch (RuntimeException r) {
            r.printStackTrace();
        }
        return resultado;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Users> get() {
        Session sessao = getSession().getCurrentSession();
        Transaction transacao = sessao.beginTransaction();
        List<Users> resultados = null;
        try {
            Query query = sessao.createQuery("from Users u");
            resultados = query.list();
            transacao.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transacao.rollback();
        }
        return resultados;
    }

    @Override
    public Integer count() {
        List lista = get();
        Integer i = new Integer(lista.size());
        return i.intValue();
    }

    @Override
    public void finalizeSession() {
        Session sessao = getSession().getCurrentSession();
        if (sessao.isOpen()) {
            sessao.close();
        }
    }
}

