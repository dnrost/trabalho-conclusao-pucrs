package desview.model.entities;

import desview.model.enums.VariableAccessType;
import desview.model.enums.VariableType;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Class that represents a variable.
 * @author Luiz Mello.
 * @author Diones Rossetto.
 * @since 28/03/2010.
 * @version 1.0
 */
@Entity
@Table(name = "Variable")
@NamedQueries({
    @NamedQuery(name = "Variable.findAll", query = "select v from Variable v"),
    @NamedQuery(name = "Variable.findByVariableLabel", query = "select v from Variable v where v.label = :label")})
public class Variable implements Serializable {

    private static final long serialVersionUID = 9801L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "type", nullable = true, length = 5)
    private VariableType type;
    @Column(name = "oid", nullable = false, length = 150)
    private String oid;
    @Column(name = "label", nullable = true, length = 200)
    private String label;
    @Column(name = "access", nullable = true, length = 5)
    private VariableAccessType access;
    @Column(name = "lower_value", nullable = true, length = 10)
    private String lower;
    @Column(name = "upper_value", nullable = true, length = 10)
    private String upper;
    @Column(name = "mib", nullable = true, length = 500)
    private String mib;
    @Column(name = "description", nullable = true, length = 1000)
    private String description;

    /**
     * Default constructor of the class.
     */
    public Variable() {
    }

    /**
     * Constructor of the class.
     * @param type the variable type.
     * @param oid the variable oid.
     * @param label the variable label.
     * @param access the access type of the variable.
     * @param lower the "lower" value.
     * @param upper the "upper" value.
     * @param mib the associated mib.
     * @param description the variable description.
     */
    public Variable(VariableType type, String oid, String label, VariableAccessType access, String lower, String upper, String mib, String description) {
        setType(type);
        setOid(oid);
        setLabel(label);
        setAccess(access);
        setLower(lower);
        setUpper(upper);
        setMib(mib);
    }

    /**
     * Constructor of the class.
     * @param oid the variable oid.
     * @param label the variable label.
     */
    public Variable(String oid, String label) {
        setOid(oid);
        setLabel(label);
    }

    /**
     * Sets the variable id.
     * @param id new id.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the variable id.
     * @return variable id.
     */
    public Long getId() {
        return id;
    }

    /**
     * Returns the access type.
     * @return access type.
     * @see VariableAccessType
     */
    public VariableAccessType getAccess() {
        return access;
    }

    /**
     * Sets the access type of the variable.
     * @param access the new access type.
     * @see VariableAccessType
     */
    public void setAccess(VariableAccessType access) {
        this.access = access;
    }

    /**
     * Returns the <i>lower</i> value if exists, else, it will be returned <i> null</i>.
     * @return the <i>lower</i> value.
     */
    public String getLower() {
        return lower;
    }

    /**
     * Altera o valor <i>lower</i>, caso tiver da variável, senão deve ser setado como <i>null</i>.
     * @param lower novo valor <i>lower</i>.
     */
    public void setLower(String lower) {
        this.lower = lower;
    }

    /**
     * Returns the associated mib.
     * @return the mib of the variable.
     */
    public String getMib() {
        return mib;
    }

    /**
     * Sets the variable mib.
     * @param mib the new mib.
     */
    public void setMib(String mib) {
        this.mib = mib;
    }

    /**
     * Returns the variable oid.
     * @return variable oid.
     */
    public String getOid() {
        return oid;
    }

    /**
     * Sets the variable oid.
     * @param oid the new oid.
     */
    public void setOid(String oid) {
        this.oid = oid;
    }

    /**
     * Returns the label of the variable.
     * @return label.
     */
    public String getLabel() {
        return label;
    }

    /**
     * Sets the label of the variable.
     * @param label the new label.
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Returns variable type.
     * @return variable type.
     * @see VariableType
     */
    public VariableType getType() {
        return type;
    }

    /**
     * Sets variable type.
     * @param type new type.
     * @see VariableType
     */
    public void setType(VariableType type) {
        this.type = type;
    }

    /**
     * Returns the <i>upper</i> value if exists, else, it will be returned <i> null</i>.
     * @return the <i>upper</i> value.
     */
    public String getUpper() {
        return upper;
    }

    /**
     * Sets the <i>upper</i> value.
     * @param upper new <i>upper</i> value.
     */
    public void setUpper(String upper) {
        this.upper = upper;
    }

    /**
     * Returns the description of the variable.
     * @return description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the variable description.
     * @param description new description.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Variable)) {
            return false;
        }
        Variable other = (Variable) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuffer s = new StringBuffer();
        if (oid != null) {
            s.append(oid);
        }
        if (label != null) {
            s.append(" (").append(label);
            s.append(")");
        }
        return s.toString();
    }

    /**
     * Returns a <code>toString()</code> different of the normal. It's customized with all fields.
     * @return String with all fields.
     */
    public String toStringFull() {
        StringBuffer s = new StringBuffer();
        s.append("Variable: ");
        if (mib != null) {
            s.append("mib =  ").append(mib);
        }
        if (label != null) {
            s.append(", label =  ").append(label);
        }
        if (lower != null) {
            s.append(", lower =  ").append(lower);
        }
        if (upper != null) {
            s.append(", upper =  ").append(upper);
        }
        if (type != null) {
            s.append(", type =  ").append(type);
        }
        if (oid != null) {
            s.append(", oid =  ").append(oid);
        }
        if (access != null) {
            s.append(", access =  ").append(access);
        }
        if (description != null) {
            s.append(", description =  ").append(description);
        }
        s.append("]");
        return s.toString();
    }
}
