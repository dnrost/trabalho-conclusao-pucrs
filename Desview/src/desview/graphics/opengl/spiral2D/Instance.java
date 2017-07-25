package desview.graphics.opengl.spiral2D;

/**
 * This class is an instance with X, Y and RGB color, name etc.
 * <br> Thanks to Leonardo Peres.
 * @author Diones Rossetto.
 * @author Luiz Mello.
 * @version 1.0
 * @since 21/05/2010
 */
public class Instance {

    private float r, g, b;
    private String name;
    private double value, upper, lower;
    private int status = 0; // 0 good, 1 upper, -1 lower
    private String oid;
    private float tx, ty;

    public Instance(float r, float g, float b, String name, double value, int status) {
        setR(r);
        setG(g);
        setB(b);
        setName(name);
        setValue(value);
        setStatus(status);
    }

    public double getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public int getStatus() {
        return status;
    }

    public float getR() {
        return r;
    }

    public float getG() {
        return g;
    }

    public float getB() {
        return b;
    }

    public void setR(float r) {
        this.r = r;
    }

    public void setG(float g) {
        this.g = g;
    }

    public void setB(float b) {
        this.b = b;
    }

    /**
     * Sets the instance status.
     * <br> Available values:
     * <table border="1">
     * <tr>
     * <th>Value</th>
     * <th>-1</th>
     * </tr>
     * <tr>
     * <td>Status</td>
     * <td>Lower</td>
     * </tr>
     * <tr>
     * <th>Value</th>
     * <th>0</th>
     * </tr>
     * <tr>
     * <td>Status</td>
     * <td>Good</td>
     * </tr>
     * <tr>
     * <th>Value</th>
     * <th>1</th>
     * </tr>
     * <tr>
     * <td>Status</td>
     * <td>Upper</td>
     * </tr>
     * </table>
     * @param status the new status.
     */
    public void setStatus(int status) {
        if (status > -2 && status < 2) {
            this.status = status;
        } else {
            status = 0;//assumes normal
            System.err.println("Status instance is wrong");
        }
    }

    private void setName(String name) {
        this.name = name;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getLower() {
        return lower;
    }

    public void setLower(double lower) {
        this.lower = lower;
    }

    public double getUpper() {
        return upper;
    }

    public void setUpper(double upper) {
        this.upper = upper;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public float getTx() {
        return tx;
    }

    public void setTx(float tx) {
        this.tx = tx;
    }

    public float getTy() {
        return ty;
    }

    public void setTy(float ty) {
        this.ty = ty;
    }
}
