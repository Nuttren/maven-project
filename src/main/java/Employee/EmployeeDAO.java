package Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {

    void createEmployee(Employee employee);

    Employee getEmployeeById(int id);


    List<Employee> getAllEmployee() throws SQLException;

    List<Employee> changeEmployee(int id, Employee employee);

    void deleteEmployee(int id);

}

