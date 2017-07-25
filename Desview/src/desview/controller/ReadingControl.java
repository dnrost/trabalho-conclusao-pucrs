package desview.controller;

import desview.model.dao.ReadingDAO;
import desview.model.entities.Reading;
import desview.model.entities.Task;
import desview.model.entities.Variable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 * This class controls the DAO of a reading: update, insertion, etc.
 * @author Diones Rossetto.
 * @author Luiz Mello.
 * @since 17/04/2010.
 * @version 1.0
 */
public class ReadingControl {

    private Reading reading;
    private ReadingDAO dao;

    /**
     *
     * @param reading
     */
    public ReadingControl(Reading reading) {
        dao = new ReadingDAO();
        this.setReading(reading);
    }

    /**
     *
     */
    public ReadingControl() {
        dao = new ReadingDAO();
    }

    /**
     *
     */
    public void insert() {
        if (reading == null) {
            throw new NullPointerException("Trying to insert null reading. Try to set reading first.");
        } else {
            dao.saveOrUpdate(reading);
        }
    }

    /**
     *
     */
    public void delete() {
        if (reading == null) {
            throw new NullPointerException("Trying to delete null reading");
        } else {
            dao.delete(reading);
        }
    }

    /**
     *
     * @param reading
     */
    public void delete(Reading reading) {
        if (reading == null) {
            throw new NullPointerException("Trying to delete null reading");
        } else {
            this.setReading(reading);
            dao.delete(reading);
        }
    }

    /**
     *
     */
    public void update() {
        if (reading == null) {
            throw new NullPointerException("Trying to update null reading");
        } else {
            dao.saveOrUpdate(reading);
        }
    }

    /**
     *
     * @param reading
     */
    public void setReading(Reading reading) {
        this.reading = reading;
    }

    /**
     * Create a reading, but this method <b>does not</b> insert the reading.
     * The read time is set here.
     * @param oid the oid.
     * @param varName the variable name.
     * @param value the read value.
     * @param task the associated task.
     * @param var the associated variable.
     * @return the reading.
     */
    public Reading createReading(String oid, String varName, String value, Task task, Variable var) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Calendar now = Calendar.getInstance();
        String today = dateFormat.format(now.getTime());
        Reading r = new Reading();
        r.setOid(oid);
        r.setReadValue(value);
        r.setVariable(var);
        r.setReadTime(today);
        r.setTask(task);
        r.setVariableName(varName);
        r.setVariable(var);
        setReading(r);
        return r;
    }

    /**
     * Create a reading and insert after the creation.
     * The read time is set here.
     * @param oid the variable oid.
     * @param varName the name of variable.
     * @param value the value read.
     * @param taskName  the name of task.
     * @return the created reading.
     */
    public Reading createReading(String oid, String varName, String value, String taskName) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Calendar now = Calendar.getInstance();
        String today = dateFormat.format(now.getTime());
        TaskControl c = new TaskControl();
        Task t = c.getTaskByName(taskName);
        VariableControl cv = new VariableControl();
        Variable v = cv.getVariableByLabel(varName);
        Reading r = new Reading();
        r.setOid(oid);
        r.setReadValue(value);
        r.setVariable(v);
        r.setReadTime(today);
        r.setTask(t);
        r.setVariableName(varName);
        setReading(r);
        return r;
    }

    /**
     * Create a reading.
     * The read time is set here.
     * @param oid the variable oid.
     * @param varName the name of variable.
     * @param value the value read.
     * @param task the task.
     * @return the created reading.
     */
    public Reading createReading(String oid, String varName, String value, Task task) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Calendar now = Calendar.getInstance();
        String today = dateFormat.format(now.getTime());
        VariableControl cv = new VariableControl();
        Variable v = cv.getVariableByLabel(varName);
        Reading r = new Reading();
        r.setOid(oid);
        r.setReadValue(value);
        r.setVariable(v);
        r.setReadTime(today);
        r.setTask(task);
        r.setVariableName(varName);
        setReading(r);
        return r;
    }

    /**
     * //TODO a bug was found in this method
     * Create a reading.
     * The read time is set here.
     * @param oid the variable oid.
     * @param varName the name of variable.
     * @param value the value read.
     * @param task the task.
     * @return the created reading.
     */
    public Reading createReadingAndInsert(String oid, String varName, String value, Task task) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Calendar now = Calendar.getInstance();
        String today = dateFormat.format(now.getTime());
        VariableControl cv = new VariableControl();
        Variable v = cv.getVariableByLabel(varName);
        Reading r = new Reading();
        r.setOid(oid);
        r.setReadValue(value);
        r.setVariable(v);
        r.setReadTime(today);
        r.setTask(task);
        r.setVariableName(varName);
        setReading(r);
        insert();
        return r;
    }

    /**
     *
     * @return readings
     */
    public List<Reading> getReadings() {
        return dao.get();
    }

    /**
     *
     * @return readings
     */
    public List<Reading> getAllReadings() {
        return dao.getAll();
    }

    /**
     *
     * @return readings
     */
    @SuppressWarnings("rawtypes")
    public List getDistinctReading() {
        return dao.getDistinct();
    }

    /**
     *
     * @return readings
     */
    @SuppressWarnings("rawtypes")
    public List getValuesToRT() {
        return dao.getValuesToRT();
    }

    /**
     *
     * @param id
     */
    public void delete(long id) {
        dao.delete(id);
    }

    /**
     *
     * @param oid
     * @param task
     * @return readings
     */
    public List<Reading> getReadingsByParameters(String oid, Task task) {
        return dao.getReadingByParameters(oid, task);
    }
}

