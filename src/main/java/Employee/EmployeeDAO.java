package Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {

    void createEmployee(Employee employee);

    void getEmployeeById(int id);


    List<Employee> getAllEmployee() throws SQLException;

    void changeEmployee(Employee employee);

    void deleteEmployee(int id);
}