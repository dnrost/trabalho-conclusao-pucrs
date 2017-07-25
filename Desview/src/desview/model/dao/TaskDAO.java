package desview.model.dao;

import desview.model.entities.Task;
import desview.util.Message;
import desview.util.persistence.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.MatchMode;

/**
 * DAO for Task entity.
 * @author Diones Rossetto.
 * @author Luiz Mello.
 * @since 08/04/2010.
 * @version 1.0
 */
@SuppressWarnings("rawtypes")
public class TaskDAO implements DAO {

    /**
     * Default constructor.
     */
    public TaskDAO() {
    }

    @Override
    public SessionFactory getSession() {
        return HibernateUtil.getSessionFactory();
    }

    @Override
    public void delete(Object task) throws Exception {
        Session sessao = getSession().getCurrentSession();
        Transaction transacao = sessao.beginTransaction();
        try {
            sessao.delete(task);
            transacao.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transacao.rollback();
            Message.error(null, "Delete", "Problem trying to delete task");
            throw e;
        }
    }

    @Override
    public boolean saveOrUpdate(Object task) {
        Session sessao = getSession().getCurrentSession();
        Transaction transacao = sessao.beginTransaction();
        try {
            sessao.saveOrUpdate(task);
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
    public List<Task> getAll() {
        Session sessao = getSession().getCurrentSession();
        Transaction transacao = sessao.beginTransaction();
        List<Task> lista = new ArrayList<Task>();
        try {
            lista = sessao.createCriteria(Task.class).list();
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
        Object tarefa = null;
        try {
            tarefa = sessao.get(Task.class, id);
            transacao.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transacao.rollback();
        }
        return tarefa;
    }

    @SuppressWarnings("unchecked")
    public Task find(String name, String equipmentName) {
        Session sessao = getSession().getCurrentSession();
        Transaction transacao = sessao.beginTransaction();
        Task tarefa = null;
        try {
            Query query = sessao.createQuery("from Task t");
            List<Task> resultados = query.list();
            for (Task t : resultados) {
                if (name.equals(t.getTaskName()) && equipmentName.equals(t.getEquipment().getName())) {
                    tarefa = t;
                }
            }
            transacao.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transacao.rollback();
        }
        return tarefa;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Task> get() {
        Session sessao = getSession().getCurrentSession();
        Transaction transacao = sessao.beginTransaction();
        List<Task> resultados = null;
        try {
            Query query = sessao.createQuery("from Task t");
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

    public Task getByName(String name) {
        Session sessao = getSession().getCurrentSession();
        Transaction transacao = sessao.beginTransaction();
        Task resultado = null;
        try {
            Query q = sessao.getNamedQuery("Task.findByTaskName");
            q.setParameter("taskName", name);
            resultado = (Task) q.uniqueResult();
            transacao.commit();
        } catch (RuntimeException r) {
            r.printStackTrace();
        }
        return resultado;
    }

    @SuppressWarnings("unchecked")
    public List<Task> getNameByLike(String name) {
        Session sessao = getSession().getCurrentSession();
        Transaction transacao = sessao.beginTransaction();
        List<Task> resultados;
        Criteria crit = sessao.createCriteria(Task.class);
        crit.add(Expression.ilike("taskName", "%" + name + "%", MatchMode.ANYWHERE));
        resultados = crit.list();
        return resultados;
    }
}

