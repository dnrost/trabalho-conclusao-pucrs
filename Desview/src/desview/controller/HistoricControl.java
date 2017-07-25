package desview.controller;

import desview.model.dao.HistoricDAO;
import desview.model.entities.Historic;
import java.util.List;

/**
 * This class controls the update, insert, delete and retrieve of historics.
 * @author Diones Rossetto.
 * @author Luiz Mello.
 * @since 02/05/2010.
 * @version 1.0
 */
public class HistoricControl {

    private Historic historic;
    private HistoricDAO dao;

    /**
     *
     * @param historic
     */
    public HistoricControl(Historic historic) {
        dao = new HistoricDAO();
        this.setHistoric(historic);
    }

    /**
     *
     */
    public HistoricControl() {
        dao = new HistoricDAO();
    }

    /**
     *
     */
    public void insert() {
        if (historic == null) {
            throw new NullPointerException("Trying to insert a null historic. Try to set historic first.");
        } else {
            dao.saveOrUpdate(historic);
        }
    }

    /**
     *
     * @param historic
     */
    public void insert(Historic historic) {
        if (historic == null) {
            throw new NullPointerException("Trying to insert a null historic. Try to set historic first.");
        } else {
            setHistoric(historic);
            dao.saveOrUpdate(historic);
        }
    }

    /**
     *
     */
    public void delete() {
        if (historic == null) {
            throw new NullPointerException("Trying to delete a null historic. Try to set historic first");
        } else {
            dao.delete(historic);
        }
    }

    /**
     *
     * @param historic
     */
    public void delete(Historic historic) {
        if (historic == null) {
            throw new NullPointerException("Trying to delete a null historic. Try to set historic first");
        } else {
            this.setHistoric(historic);
            dao.delete(historic);
        }
    }

    /**
     *
     */
    public void atualiza() {
        if (historic == null) {
            throw new NullPointerException("Trying to update a null historic. Try to set historic first");
        } else {
            dao.saveOrUpdate(historic);
        }
    }

    /**
     *
     * @param historic
     */
    public void setHistoric(Historic historic) {
        this.historic = historic;
    }

    /**
     *
     * @return historics
     */
    public List<Historic> getHistorics() {
        return dao.get();
    }

    /**
     *
     * @return average by year
     */
    public List<Historic> getOIDAvgByYear() {
        return dao.getOIDAvgByYear();
    }

    /**
     *
     * @return average by month.
     */
    public List<Historic> getOIDAvgByMonth() {
        return dao.getOIDAvgByMonth();
    }

    /**
     *
     * @return average by oid.
     */
    public List<Historic> getOIDAvgByDay() {
        return dao.getOIDAvgByDay();
    }

    /**
     *
     * @param month
     * @return average by day.
     */
    public List<Historic> getOIDAvgByDayInMonth(String month) {
        return dao.getOIDAvgByDayInMonth(month);
    }

    /**
     *
     * @param oid
     * @param year
     * @param month
     * @return average by oid.
     */
    public List<Historic> getAvgByOIDYearMonth(String oid, String year, String month) {
        return dao.getAvgDayOIDByOIDYearMonth(oid, year, month);
    }

    /**
     *
     * @param oid
     * @param year
     * @return values by oid.
     */
    public List<Historic> getValuesByOIDYear(String oid, String year) {
        return dao.getValuesByOIDYear(oid, year);
    }

    /**
     * @return values.
     */
    public List<Historic> getValuesAMM() {
        return dao.getValuesAMM();
    }
}

