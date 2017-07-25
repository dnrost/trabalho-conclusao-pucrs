package desview.model.dao;

import desview.model.entities.Equipment;
import desview.util.persistence.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.MatchMode;

/**
 * DAO for equipment entity.
 * @author Diones Rossetto.
 * @author Luiz Mello.
 * @since 08/04/2010.
 * @version 1.0
 */
@SuppressWarnings("rawtypes")
public class EquipmentDAO implements DAO {

    /**
     * Default constructor.
     */
    public EquipmentDAO() {
    }

    @Override
    public SessionFactory getSession() {
        return HibernateUtil.getSessionFactory();
    }

    @Override
    public void delete(Object equipment) {
        Session sessao = getSession().getCurrentSession();
        Transaction transacao = sessao.beginTransaction();
        try {
            sessao.delete(equipment);
            transacao.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transacao.rollback();
        }
    }

    @Override
    public boolean saveOrUpdate(Object equipment) {
        Session sessao = getSession().getCurrentSession();
        Transaction transacao = sessao.beginTransaction();
        try {
            sessao.saveOrUpdate(equipment);
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
    public List<Equipment> getAll() {
        Session sessao = getSession().getCurrentSession();
        Transaction transacao = sessao.beginTransaction();
        List<Equipment> lista = new ArrayList<Equipment>();
        try {
            lista = sessao.createCriteria(Equipment.class).list();
            transacao.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transacao.rollback();
        }
        return lista;
    }

    @Override
    public Equipment findById(Long id) {
        Session sessao = getSession().getCurrentSession();
        Transaction transacao = sessao.beginTransaction();
        Equipment equipamento = null;
        try {
            equipamento = (Equipment) sessao.get(Equipment.class, id);
            transacao.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transacao.rollback();
        }
        return equipamento;
    }

    @SuppressWarnings("unchecked")
    public Equipment find(String name, String ip) {
        Session sessao = getSession().getCurrentSession();
        Transaction transacao = sessao.beginTransaction();
        Equipment equipamento = null;
        try {
            Query query = sessao.createQuery("from Equipment e");
            List<Equipment> resultados = query.list();
            for (Equipment e : resultados) {
                if (name.equals(e.getName()) && name.equals(e.getName())) {
                    equipamento = e;
                }
            }
            transacao.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transacao.rollback();
        }
        return equipamento;
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

    @Override
    @SuppressWarnings("unchecked")
    public List<Equipment> get() {
        Session sessao = getSession().getCurrentSession();
        Transaction transacao = sessao.beginTransaction();
        List<Equipment> resultados = null;
        try {
            Query query = sessao.createQuery("from Equipment e");
            resultados = query.list();
            transacao.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transacao.rollback();
        }
        return resultados;
    }

    @SuppressWarnings("unchecked")
    public List<Equipment> getNameByLike(String name) {
        Session sessao = getSession().getCurrentSession();
        Transaction transacao = sessao.beginTransaction();
        List<Equipment> resultados;
        Criteria crit = sessao.createCriteria(Equipment.class);
        crit.add(Expression.ilike("equipmentName", "%" + name + "%", MatchMode.ANYWHERE));
        resultados = crit.list();
        return resultados;
    }

    @SuppressWarnings("unchecked")
    public List<Equipment> getIPByLike(String ip) {
        Session sessao = getSession().getCurrentSession();
        Transaction transacao = sessao.beginTransaction();
        List<Equipment> resultados;
        Criteria crit = sessao.createCriteria(Equipment.class);
        crit.add(Expression.ilike("ip", "%" + ip + "%", MatchMode.ANYWHERE));
        resultados = crit.list();
        return resultados;
    }
}

