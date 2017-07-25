package desview.util.persistence;

import desview.model.entities.Equipment;
import desview.model.entities.Historic;
import desview.model.entities.Reading;
import desview.model.entities.Search;
import desview.model.entities.Task;
import desview.model.entities.Users;
import desview.model.entities.Variable;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * This is the class of hibernate configuration.
 * This Class is configured for Postgresql database.
 * Thanks to Thafarel Camargo by support.
 * @author Diones Rossetto.
 * @author Luiz Mello.
 * @version 1.0
 * @since 27/03/2010.
 */
@SuppressWarnings("rawtypes")
public class HibernateUtil {

    // Configuracoes de conexao do banco de dados
    private static final String DATABASE_USER = new StringBuilder("postgres").toString();
    private static final String DATABASE_PASSWORD = new StringBuilder("postgres").toString();
    private static final String DATABASE_NAME = new StringBuilder("desview").toString();
    private static final String STORAGE_IP = new StringBuilder("localhost").toString();
    private static final String STORAGE_DB_PORT = new StringBuilder("5432").toString();
    private static final String SHOW_SQL = new StringBuilder("true").toString();
    private static final String DATABASE_DIALECT = new StringBuilder("org.hibernate.dialect.PostgreSQLDialect").toString();
    private static final String DATABASE_DRIVER = new StringBuilder("org.postgresql.Driver").toString();
    private static final String AUTO_COMMIT = new StringBuilder("true").toString();
    private static final String POOL_SIZE = new StringBuilder("20").toString();
    private static final String FACTORY_CLASS = new StringBuilder("org.hibernate.transaction.JDBCTransactionFactory").toString();
    private static final String PROVIDER_CLASS = new StringBuilder("org.hibernate.cache.NoCacheProvider").toString();
    private static final String CONTEXT_CLASS = new StringBuilder("thread").toString();
    private static final String TIPO_CRIACAO = new StringBuilder("update").toString();//create-drop, update ou none
    //private static final String TIPO_CRIACAO = new StringBuilder("create-drop").toString();
    private static final Class[] CLASSES = {
        Equipment.class,
        Task.class,
        Variable.class,
        Reading.class,
        Historic.class,
        Users.class,
        Search.class
    };

    static {
        try {
            StringBuilder url = new StringBuilder();
            url.append("jdbc:postgresql://").append(STORAGE_IP).append(":").append(STORAGE_DB_PORT).append("/").append(DATABASE_NAME);

            //seta as propriedades
            AnnotationConfiguration config = new AnnotationConfiguration();
            config.setProperty("hibernate.dialect", DATABASE_DIALECT);
            config.setProperty("hibernate.connection.driver_class", DATABASE_DRIVER);
            config.setProperty("hibernate.connection.url", url.toString());
            config.setProperty("hibernate.connection.username", DATABASE_USER);
            config.setProperty("hibernate.connection.password", DATABASE_PASSWORD);
            config.setProperty("hibernate.connection.pool_size", POOL_SIZE);
            config.setProperty("hibernate.connection.autocommit", AUTO_COMMIT);
            config.setProperty("hibernate.cache.provider_class", PROVIDER_CLASS);
            config.setProperty("hibernate.hbm2ddl.auto", TIPO_CRIACAO);
            config.setProperty("hibernate.show_sql", SHOW_SQL);
            config.setProperty("hibernate.transaction.factory_class", FACTORY_CLASS);
            config.setProperty("hibernate.current_session_context_class", CONTEXT_CLASS);

            for (Class entity : CLASSES) {
                config.addAnnotatedClass(entity);
            }
            sessionFactory = config.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }
    private static final SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public HibernateUtil() {
    }
}
