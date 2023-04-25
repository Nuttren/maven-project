package Employee;

import javax.persistence.*;
import java.sql.*;
import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmployeeDAOImpl implements EmployeeDAO {
    private final String user = "postgres";
    private final String password = "1";
    private final String url = "jdbc:postgresql://localhost:5432/skypro";


    private EntityManager entityManager;
    private EntityManagerFactory emf;


//    public EmployeeDAOImpl () {
//        this.emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
//        this.entityManager = this.emf.createEntityManager();
//    }
    @Override
    public void createEmployee(Employee employee) {


        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement =
                     connection.prepareStatement("SELECT * FROM employee")) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idOfEmployee = resultSet.getInt("id");
                String firstNameOfEmployee = resultSet.getString("first_name");
                String lastNameOfEmployee = resultSet.getString("last_name");
                String genderNameOfEmployee = resultSet.getString("gender");
                int ageOfEmployee = resultSet.getInt("age");
                int cityIdOfEmployee = resultSet.getInt("city_id");


                Employee e = new Employee(idOfEmployee, firstNameOfEmployee, lastNameOfEmployee, genderNameOfEmployee, ageOfEmployee, cityIdOfEmployee);
                System.out.println(e);
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к БД!");
            e.printStackTrace();
        }

    }

    @Override
    public Employee getEmployeeById(int id) {
       Query query = entityManager.createNamedQuery("find by Id");
       query.setParameter("id", id);
       return (Employee) query.getSingleResult();
    }


    @Override
    public List<Employee> getAllEmployee() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement =
                     connection.prepareStatement("SELECT * FROM employee")) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idOfEmployee = resultSet.getInt("id");
                String firstNameOfEmployee = resultSet.getString("first_name");
                String lastNameOfEmployee = resultSet.getString("last_name");
                String genderNameOfEmployee = resultSet.getString("gender");
                int ageOfEmployee = resultSet.getInt("age");
                int cityIdOfEmployee = resultSet.getInt("city_id");

                employees.add(new Employee(idOfEmployee, firstNameOfEmployee, lastNameOfEmployee, genderNameOfEmployee, ageOfEmployee, cityIdOfEmployee));
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к БД!");
            e.printStackTrace();
        }
        return employees;
    }

    private static final String DELETE_EMPLOYEE = "DELETE FROM employee WHERE id =?";

    @Override
    public void deleteEmployee(Employee employee) {
        entityManager.getTransaction().begin();
        entityManager.remove(employee);
        entityManager.getTransaction().commit();
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        Employee employeeToUpdate = getEmployeeById(employee.getId());
        entityManager.getTransaction().begin();
        employeeToUpdate.setFirst_name(employee.getFirst_name());
        employeeToUpdate.setLast_name(employee.getLast_name());
        employeeToUpdate.setGender(employeeToUpdate.getGender());
        employeeToUpdate.setAge(employeeToUpdate.getAge());
        employeeToUpdate.setCity_id(employeeToUpdate.getCity_id());
        entityManager.getTransaction().commit();
        return employeeToUpdate;
    }


    private static final String CHANGE_EMPLOYEE = "UPDATE employee SET id =?, first_name = ?, last_name = ?, gender = ?, age = ?, city_id =? WHERE id =?";

    @Override
    public List<Employee> changeEmployee(int id, Employee employee) {
        List<Employee> changeEmployee = new ArrayList<>();
        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement =
                     connection.prepareStatement(CHANGE_EMPLOYEE)) {
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, employee.getFirst_name());
            preparedStatement.setString(3, employee.getLast_name());
            preparedStatement.setString(4, employee.getGender());
            preparedStatement.setInt(5, employee.getAge());
            preparedStatement.setInt(6, employee.getCity_id());
            preparedStatement.setInt(7, id);

            preparedStatement.executeUpdate();

            PreparedStatement statement =
                    connection.prepareStatement("SELECT * FROM employee");
            {

                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    int idOfEmployee = resultSet.getInt("id");
                    String firstNameOfEmployee = resultSet.getString("first_name");
                    String lastNameOfEmployee = resultSet.getString("last_name");
                    String genderNameOfEmployee = resultSet.getString("gender");
                    int ageOfEmployee = resultSet.getInt("age");
                    int cityIdOfEmployee = resultSet.getInt("city_id");

                    changeEmployee.add(new Employee(idOfEmployee, firstNameOfEmployee, lastNameOfEmployee, genderNameOfEmployee, ageOfEmployee, cityIdOfEmployee));
                }
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к БД!");
            e.printStackTrace();
        }

        return changeEmployee;
    }
}









