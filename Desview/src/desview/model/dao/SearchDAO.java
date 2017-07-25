package desview.model.dao;

import desview.model.entities.Search;
import desview.util.Message;
import desview.util.persistence.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Class DAO to entity Search.
 * @author Diones Rossetto.
 * @author Luiz Mello.
 * @since 02/05/2010.
 * @version 1.0
 */
@SuppressWarnings("rawtypes")
public class SearchDAO implements DAO {

    /**
     * Constructor of the class.
     */
    public SearchDAO() {
    }

    @Override
    public SessionFactory getSession() {
        return HibernateUtil.getSessionFactory();
    }

    @Override
    public void delete(Object search) throws Exception {
        Session sessao = getSession().getCurrentSession();
        Transaction transacao = sessao.beginTransaction();
        try {
            sessao.delete(search);
            transacao.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transacao.rollback();
            Message.error(null, "Delete", "Problem deleting search.");
            throw e;
        }
    }

    @Override
    public boolean saveOrUpdate(Object search) {
        Session sessao = getSession().getCurrentSession();
        Transaction transacao = sessao.beginTransaction();
        try {
            sessao.saveOrUpdate(search);
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
    public List<Search> getAll() {
        Session sessao = getSession().getCurrentSession();
        Transaction transacao = sessao.beginTransaction();
        List<Search> lista = new ArrayList<Search>();
        try {
            lista = sessao.createCriteria(Search.class).list();
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
            user = sessao.get(Search.class, id);
            transacao.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transacao.rollback();
        }
        return user;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Search> get() {
        Session sessao = getSession().getCurrentSession();
        Transaction transacao = sessao.beginTransaction();
        List<Search> resultados = null;
        try {
            Query query = sessao.createQuery("from Search s");
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
            sessao.flush();
            sessao.close();
        }
    }
}

