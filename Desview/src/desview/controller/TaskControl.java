package desview.controller;

import desview.model.dao.TaskDAO;
import desview.model.entities.Task;
import java.util.List;

/**
 * This class controls the DAO of a task.
 * @author Diones Rossetto.
 * @author Luiz Mello.
 * @since 17/04/2010.
 * @version 1.0
 */
public class TaskControl {

    private Task task;
    private TaskDAO dao;

    /**
     * Constructor of task control class.
     * @param task
     */
    public TaskControl(Task task) {
        dao = new TaskDAO();
        this.setTask(task);
    }

    /**
     *
     */
    public TaskControl() {
        dao = new TaskDAO();
    }

    /**
     *
     * @return if inserted
     */
    public boolean insert() {
        if (task == null) {
            throw new NullPointerException("Trying to insert null task");
        } else {
            if (dao.saveOrUpdate(task)) {
                dao.finalizeSession();
                return true;
            } else {
                dao.finalizeSession();
                return false;
            }
        }
    }

    /**
     *
     * @throws Exception
     */
    public void delete() throws Exception {
        if (task == null) {
            throw new NullPointerException("Trying to delete null task");
        } else {
            dao.delete(task);
            dao.finalizeSession();
        }
    }

    /**
     *
     * @param task
     * @throws Exception
     */
    public void delete(Task task) throws Exception {
        if (task == null) {
            throw new NullPointerException("Trying to delete null task");
        } else {
            this.setTask(task);
            dao.delete(task);
            dao.finalizeSession();
        }
    }

    /**
     * Update the set task.
     * @return true if the task was updated, false otherwise.
     */
    public boolean update() {
        if (task == null) {
            throw new NullPointerException("Trying to update null task");
        } else {
            dao.saveOrUpdate(task);
            dao.finalizeSession();
            return true;
        }
    }

    /**
     *
     * @param task
     */
    public void setTask(Task task) {
        this.task = task;
    }

    /**
     *
     * @return task created.
     */
    public Task createTask() {
        Task t = new Task();
        setTask(t);
        return t;
    }

    /**
     *
     * @return tasks
     */
    public List<Task> getTasks() {
        List<Task> list = dao.get();
        dao.finalizeSession();
        return list;
    }

    /**
     *
     * @return all tasks
     */
    public List<Task> getAllTasks() {
        List<Task> list = dao.getAll();
        dao.finalizeSession();
        return list;
    }

    /**
     *
     * @param name
     * @return task
     */
    public Task getTaskByName(String name) {
        Task t = dao.getByName(name);
        dao.finalizeSession();
        return t;
    }

    /**
     *
     * @param id
     * @return task by id
     */
    public Task getTaskByID(Long id) {
        Task t = (Task) dao.findById(id);
        dao.finalizeSession();
        return t;
    }

    /**
     * Search the task name by like SQL.
     * @param name the name.
     * @return list of tasks that matches with the name.
     */
    public List<Task> getTaskNameLike(String name) {
        List<Task> list = dao.getNameByLike(name);
        dao.finalizeSession();
        return list;
    }
}
