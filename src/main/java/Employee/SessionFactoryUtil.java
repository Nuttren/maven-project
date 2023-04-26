package Employee;

import Employee.Employee;
import Employee.EmployeeDAO;
import Employee.EmployeeDAOImpl;
import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import javax.persistence.metamodel.EntityType;

import java.util.List;

public class SessionFactoryUtil {
    private static final SessionFactory SessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            SessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return SessionFactory;
    }
}


