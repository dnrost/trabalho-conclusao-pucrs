package desview.controller;

import desview.model.dao.VariableDAO;
import desview.model.entities.Variable;
import java.util.List;

/**
 * This class permits to insert, update, retrieve or delete a variable in database.
 * @author Diones Rossetto.
 * @author Luiz Mello.
 * @since 17/04/2010.
 * @version 1.0
 */
public class VariableControl {

    private Variable variable;
    private VariableDAO dao;

    /**
     * Constructor of the VariableControl class.
     * @param variable the variable to control.
     */
    public VariableControl(Variable variable) {
        dao = new VariableDAO();
        this.setVariable(variable);
    }

    /**
     * Default contructor.
     */
    public VariableControl() {
        dao = new VariableDAO();
    }

    /**
     * Inserts the variable set in database.
     */
    public void insert() {
        if (variable == null) {
            throw new NullPointerException("Trying to insert null variable. Try to set the variable first");
        } else {
            dao.saveOrUpdate(variable);
            dao.finalizeSession();
        }
    }

    /**
     * Delete the variable in database.
     */
    public void delete() {
        if (variable == null) {
            throw new NullPointerException("Trying to delete null variable");
        } else {
            dao.delete(variable);
            dao.finalizeSession();
        }
    }

    /**
     * Delete the variable in database.
     * @param variable the variable.
     */
    public void delete(Variable variable) {
        this.setVariable(variable);
        delete(variable);
        dao.finalizeSession();
    }

    /**
     * Update the variable in database.
     * @return if updated
     */
    public boolean update() {
        if (variable == null) {
            throw new NullPointerException("Trying to update null variable");
        } else {
            if (dao.saveOrUpdate(variable)) {
                dao.finalizeSession();
                return true;
            } else {
                dao.finalizeSession();
                return false;
            }
        }
    }

    /**
     * Sets the variable.
     * @param variable the variable.
     */
    public void setVariable(Variable variable) {
        this.variable = variable;
    }

    /**
     * Returns only data from the table variable.
     * @return list of variables.
     */
    public List<Variable> getVariables() {
        return dao.get();
    }

    /**
     * Returns all variable including relationships.
     * @return list of variables.
     */
    public List<Variable> getAllVariables() {
        return dao.getAll();
    }

    /**
     * This method returns the variable with the id.
     * @param id the id.
     * @return variable that corresponds to id.
     */
    public Variable getVariableByID(Long id) {
        return (Variable) dao.findById(id);
    }

    /**
     *
     * @param name
     * @return variable by label
     */
    public Variable getVariableByLabel(String name) {
        return dao.getByLabel(name);
    }

    /**
     * Search the task name by like SQL.
     * @param name the name.
     * @return list of tasks that matches with the name.
     */
    public List<Variable> getVariableNameLike(String name) {
        return dao.getNameByLike(name);
    }
}
