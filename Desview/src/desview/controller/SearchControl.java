package desview.controller;

import desview.model.dao.SearchDAO;
import desview.model.entities.Search;
import java.util.List;

/**
 * Control to search DAO.
 * @author Diones Rossetto.
 * @author Luiz Mello.
 * @since 27/05/2010.
 * @version 1.0
 */
public class SearchControl {

    private Search search;
    private SearchDAO dao;

    /**
     *
     */
    public SearchControl() {
        dao = new SearchDAO();
    }

    /**
     *
     * @return if inserted.
     */
    public boolean insert() {
        if (search == null) {
            throw new NullPointerException("Trying to insert null search");
        } else {
            if (dao.saveOrUpdate(search)) {
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * Delete a search.
     * @param search the search.
     */
    public void delete(Search search) {
        if (search == null) {
            throw new NullPointerException("Trying to delete null search");
        } else {
            try {
                this.setSearch(search);
                dao.delete(search);
            } catch (Exception ex) {
            }
        }
    }

    /**
     * Delete a search.
     */
    public void delete() {
        if (search == null) {
            throw new NullPointerException("Trying to delete null search");
        } else {
            try {
                dao.delete(search);
            } catch (Exception ex) {
            }
        }
    }

    /**
     * Update a search.
     */
    public void update() {
        if (search == null) {
            throw new NullPointerException("Trying to update null search");
        } else {
            dao.saveOrUpdate(search);
        }
    }

    /**
     * Sets the search.
     * @param search the search.
     */
    public void setSearch(Search search) {
        this.search = search;
    }

    /**
     * Get the searches.
     * @return list of searches.
     */
    public List<Search> getSearches() {
        return dao.get();
    }
}
