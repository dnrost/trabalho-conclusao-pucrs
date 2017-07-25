package desview.model.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Class for a search entity.
 * @author Luiz Mello.
 * @author Diones Rossetto.
 * @since 27/05/2010.
 * @version 1.0.
 */
@Entity
@Table(name = "Search")
public class Search implements Serializable {

    private static final long serialVersionUID = -45262152L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "query", nullable = false, length = 2000)
    private String query;
    @Column(name = "date", nullable = false, length = 250)
    private String date;
    //TODO change to USER TABLE
    @Column(name = "users", nullable = false, length = 250)
    private String user;

    /**
     * Default constructor.
     */
    public Search() {
    }

    /**
     * Constructor of class search.
     * @param query the search query.
     * @param date the date.
     * @param user the user
     */
    public Search(String query, String date, String user) {
        setQuery(query);
        setDate(date);
        setUser(user);
    }

    /**
     * Returns search id.
     * @return id.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id.
     * @param id new id.
     */
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Search)) {
            return false;
        }
        Search other = (Search) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuffer s = new StringBuffer();
        s.append(query);
        s.append(" (").append(date);
        s.append(")");
        if (user != null) {
            s.append(" from user: ").append(user);
        }
        return s.toString();
    }
}
