package Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {

    void createEmployee(Employee employee);

    Employee getEmployeeById(long id);


    List<Employee> getAllEmployee() throws SQLException;

    List<Employee> changeEmployee(int id, Employee employee);

    void deleteEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

}

