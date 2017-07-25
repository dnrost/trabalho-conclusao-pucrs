package desview.graphics.charts.rt;

import desview.model.entities.Task;

/**
 * This class represents an object that will be Transfered.
 * @author Diones Rossetto.
 * @author Luiz Mello.
 * @since 04/05/2010.
 * @version 1.0
 */
public class TransferableObject {

    private Task task1, task2, task3, task4, task5;
    private String oid1, oid2, oid3, oid4, oid5;
    private String varName1, varName2, varName3, varName4, varName5;

    /**
     * Constructor of class TransferableObject.
     * @param task1
     * @param task2
     * @param task3
     * @param task4
     * @param oid1
     * @param task5
     * @param oid2
     * @param oid3
     * @param oid4
     * @param varName1
     * @param varName2
     * @param oid5
     * @param varName3
     * @param varName5
     * @param varName4
     */
    public TransferableObject(Task task1, Task task2, Task task3, Task task4, Task task5, String oid1, String oid2, String oid3, String oid4, String oid5, String varName1, String varName2, String varName3, String varName4, String varName5) {
        setOid1(oid1);
        setOid2(oid2);
        setOid3(oid3);
        setOid4(oid4);
        setOid5(oid5);
        setTask1(task1);
        setTask2(task2);
        setTask3(task3);
        setTask4(task4);
        setTask5(task5);
        setVarName1(varName1);
        setVarName2(varName2);
        setVarName3(varName3);
        setVarName4(varName5);
        setVarName5(varName5);
    }

    /**
     * Default constructor.
     */
    public TransferableObject() {
    }

    public String getOid1() {
        return oid1;
    }

    public void setOid1(String oid1) {
        this.oid1 = oid1;
    }

    public String getOid2() {
        return oid2;
    }

    public void setOid2(String oid2) {
        this.oid2 = oid2;
    }

    public String getOid3() {
        return oid3;
    }

    public void setOid3(String oid3) {
        this.oid3 = oid3;
    }

    public Task getTask1() {
        return task1;
    }

    public void setTask1(Task task1) {
        this.task1 = task1;
    }

    public Task getTask2() {
        return task2;
    }

    public void setTask2(Task task2) {
        this.task2 = task2;
    }

    public Task getTask3() {
        return task3;
    }

    public void setTask3(Task task3) {
        this.task3 = task3;
    }

    public String getVarName1() {
        return varName1;
    }

    public void setVarName1(String varName1) {
        this.varName1 = varName1;
    }

    public String getVarName2() {
        return varName2;
    }

    public void setVarName2(String varName2) {
        this.varName2 = varName2;
    }

    public String getVarName3() {
        return varName3;
    }

    public void setVarName3(String varName3) {
        this.varName3 = varName3;
    }

    public String getOid4() {
        return oid4;
    }

    public void setOid4(String oid4) {
        this.oid4 = oid4;
    }

    public String getOid5() {
        return oid5;
    }

    public void setOid5(String oid5) {
        this.oid5 = oid5;
    }

    public Task getTask4() {
        return task4;
    }

    public void setTask4(Task task4) {
        this.task4 = task4;
    }

    public Task getTask5() {
        return task5;
    }

    public void setTask5(Task task5) {
        this.task5 = task5;
    }

    public String getVarName4() {
        return varName4;
    }

    public void setVarName4(String varName4) {
        this.varName4 = varName4;
    }

    public String getVarName5() {
        return varName5;
    }

    public void setVarName5(String varName5) {
        this.varName5 = varName5;
    }
}
