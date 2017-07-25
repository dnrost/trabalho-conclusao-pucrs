package desview.controller;

import desview.model.dao.EquipmentDAO;
import desview.model.entities.Equipment;
import java.util.List;

/**
 * This class control an equipment (insertion, update, creation etc).
 * @author Diones Rossetto.
 * @author Luiz Mello.
 * @since 15/04/2010.
 * @version 1.0
 */
public class EquipmentControl {

    private Equipment equipment;
    private EquipmentDAO dao;

    /**
     * Constructor of class Equipment.
     * @param equipament the equipment.
     */
    public EquipmentControl(Equipment equipament) {
        dao = new EquipmentDAO();
        this.setEquipment(equipament);
    }

    /**
     * Default constructor.
     */
    public EquipmentControl() {
        dao = new EquipmentDAO();
    }

    /**
     * Insert an equipment.
     * @return true if the equipment was inserted, false otherwise.
     */
    public boolean insert() {
        if (equipment == null) {
            throw new NullPointerException("Trying to insert null equipment");
        } else {
            if (dao.saveOrUpdate(equipment)) {
                dao.finalizeSession();
                return true;
            } else {
                dao.finalizeSession();
                return false;
            }
        }
    }

    /**
     * Delete an equipment.
     * @param equipment equipment.
     */
    public void delete(Equipment equipment) {
        if (equipment == null) {
            throw new NullPointerException("Trying to delete null equipment");
        } else {
            this.setEquipment(equipment);
            dao.delete(equipment);
            dao.finalizeSession();
        }
    }

    /**
     * Delete an equipment.
     */
    public void delete() {
        if (equipment == null) {
            throw new NullPointerException("Trying to delete null equipment");
        } else {
            dao.delete(equipment);
            dao.finalizeSession();
        }
    }

    /**
     * Update an equipment.
     */
    public void update() {
        if (equipment == null) {
            throw new NullPointerException("Trying to update null equipment");
        } else {
            dao.saveOrUpdate(equipment);
            dao.finalizeSession();
        }
    }

    /**
     * Sets the equipment.
     * @param equipment the equipment.
     */
    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    /**
     * This method returns only the entities of equipment.
     * @return equipments.
     */
    public List<Equipment> getEquipments() {
        List<Equipment> list = dao.get();
        dao.finalizeSession();
        return list;
    }

    /**
     * This method returns all equipments including the relationships between the equipment and other tables.
     * @return list of all equipments.
     */
    public List<Equipment> getAllEquipments() {
        List<Equipment> list = dao.getAll();
        dao.finalizeSession();
        return list;
    }

    /**
     * This method returns the equipment that have the id.
     * @param id the id.
     * @return equipment.
     */
    public Equipment getEquipmentByID(Long id) {
        Equipment e = dao.findById(id);
        dao.finalizeSession();
        return e;
    }

    /**
     * Search the equipment name by like SQL.
     * @param name the name.
     * @return list of equipment that matches with the name
     */
    public List<Equipment> getEquipmentNameLike(String name) {
        List<Equipment> list = dao.getNameByLike(name);
        dao.finalizeSession();
        return list;
    }

    /**
     * Search the equipment name by like SQL.
     * @param ip the name.
     * @return list of equipments that matches with the name.
     */
    public List<Equipment> getEquipmentIPLike(String ip) {
        List<Equipment> list = dao.getIPByLike(ip);
        dao.finalizeSession();
        return list;
    }
}
