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
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }


    public static void main(final String[] args) throws Exception {
        final Session session = getSession();
        try {
            System.out.println("querying all the managed entities...");
            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
            for (EntityType<?> entityType : metamodel.getEntities()) {
                final String entityName = entityType.getName();
                final Query query = session.createQuery("from " + entityName);
                System.out.println("executing: " + query.getQueryString());
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                }

            }
            EmployeeDAO employeeDAO = new EmployeeDAOImpl();

            List<Employee> employees = employeeDAO.getAllEmployee();

            System.out.println(employeeDAO.getEmployeeById(5));

            for (Employee employee : employees) {
                System.out.println("ID сотрудника: " + employee.getId());
                System.out.println("Имя сотрудника: " + employee.getFirstName());
                System.out.println("Фамилия сотрудника: " + employee.getLastName());
                System.out.println("Пол сотрудника: " + employee.getGender());
                System.out.println("ID города сотрудника: " + employee.getCityId());
            }


            Employee e2 = new Employee(12, "Kate", "Kate", "female", 20, 5);

            employeeDAO.createEmployee(e2);
            System.out.println(e2);

            System.out.println(employeeDAO.changeEmployee(3, new Employee(3, "KKKKate", "Kate", "female", 20, 2)));

            System.out.println(employeeDAO.getEmployeeById(5));
            employeeDAO.updateEmployee(new Employee(3, "Kate", "Kate", "female", 20, 2));
            employeeDAO.deleteEmployee(new Employee(3, "Kate", "Kate", "female", 20, 2));


        } finally {
            session.close();
        }
    }


}