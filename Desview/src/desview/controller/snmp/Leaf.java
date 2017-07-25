package desview.controller.snmp;

/**
 * Class for a leaf in MIB.
 * @author Diones Rossetto.
 * @author Luiz Mello.
 * @version 1.0
 * @since 12/04/2010.
 */
public class Leaf {

    // Atributos de uma folha da mib.
    private String name;
    private String oid;
    private String description;
    private String access;
    private String type;

    /**
     * Constructor of a leaf.
     * @param name a name.
     * @param oid  an oid.
     * @param description a description.
     * @param access the access.
     * @param type the type.
     */
    public Leaf(String name, String oid, String description, String access, String type) {
        setName(name);
        setOID(oid);
        setDescription(description);
        setAccess(access);
        setType(type);
    }

    /**
     * Default constructor.
     */
    public Leaf() {
    }

    /**
     * Returns the name.
     * @return the name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     * @param name new name.
     */
    public void setName(String name) {
        if (name != null) {
            this.name = name;
        } else {
            System.out.println("Name is null. Setting to default value: \"\"");
            this.name = "";
        }
    }

    /**
     * Returns the oid.
     * @return oid.
     */
    public String getOid() {
        return oid;
    }

    /**
     * Sets the oid.
     * @param oid new oid.
     */
    public void setOID(String oid) {
        if (oid != null) {
            this.oid = oid;
        } else {
            System.out.println("Oid is null. Setting to default value: \"\"");
            this.oid = "";
        }
    }

    /**
     * Returns the description.
     * @return the description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description.
     * @param description new description.
     */
    public void setDescription(String description) {
        if (description != null) {
            this.description = description;
        } else {
            System.out.println("Description is null. Setting to default value: \"\"");
            this.description = "";
        }
    }

    /**
     * Returns the access.
     * @return the access.
     */
    public String getAccess() {
        return access;
    }

    /**
     * Returns the type.
     * @return the type.
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the access.
     * @param access new access.
     */
    public void setAccess(String access) {
        if (access != null) {
            this.access = access;
        } else {
            System.out.println("Access is null. Setting to default value: \"\"");
            this.access = "";
        }
    }

    /**
     * Sets the type.
     * @param type New type.
     */
    public void setType(String type) {
        if (type != null) {
            this.type = type;
        } else {
            System.out.println("Type is null. Setting to default value: \"\"");
            this.type = "";
        }
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return name;
    }
}
