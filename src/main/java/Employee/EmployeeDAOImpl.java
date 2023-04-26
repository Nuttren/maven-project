package Employee;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.*;
import java.util.*;
import javax.swing.*;


public class EmployeeDAOImpl implements EmployeeDAO {
    private final String user = "postgres";
    private final String password = "1";
    private final String url = "jdbc:postgresql://localhost:5432/skypro";

    @Override
    public void createEmployee(Employee employee) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(employee);
        tx1.commit();
        session.close();
    }

    @Override
    public Employee getEmployeeById(long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Employee.class, id);
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
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(employee);
        tx1.commit();
        session.close();
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(employee);
        tx1.commit();
        session.close();
        return employee;
    }



    private static final String CHANGE_EMPLOYEE = "UPDATE employee SET id =?, first_name = ?, last_name = ?, gender = ?, age = ?, city_id =? WHERE id =?";

    @Override
    public List<Employee> changeEmployee(int id, Employee employee) {
        List<Employee> changeEmployee = new ArrayList<>();
        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement =
                     connection.prepareStatement(CHANGE_EMPLOYEE)) {
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, employee.getFirstName());
            preparedStatement.setString(3, employee.getLastName());
            preparedStatement.setString(4, employee.getGender());
            preparedStatement.setInt(5, employee.getAge());
            preparedStatement.setInt(6, employee.getCityId());
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









