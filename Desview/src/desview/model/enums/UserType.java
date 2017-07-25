package desview.model.enums;

/**
 * Enumeration that represents the types of users.
 * @author Diones Rossetto
 * @author Luiz Mello
 * @since 30/04/2010
 * @version 1.0
 */
public enum UserType {

    /**
     * Admin user, admin users can insert, change and delete tasks and modify the system.
     * Database code is 0.
     */
    ADMIN,
    /**
     * A normal user, normal users cannot change the system, they can only view and analyse tasks.
     * Database code is 1.
     */
    USER
}
