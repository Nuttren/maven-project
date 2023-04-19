package Employee;

import java.sql.*;
import java.util.*;

public class EmployeeDAOImpl implements EmployeeDAO {
    private final String user = "postgres";
    private final String password = "1";
    private final String url = "jdbc:postgresql://localhost:5432/skypro";

    Map<Integer, Employee> employees = new HashMap<>();






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

                for (Employee employee : employees) {
                    if (employee.getId() == id) {
                        return employee;
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к БД!");
            e.printStackTrace();
        }

        return null;
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

    @Override
    public void deleteEmployee(int id) {
        employees.remove(id);
    }

private static final String CHANGE_EMPLOYEE = "UPDATE employee SET id =?, first_name = ?, last_name = ?, gender = ?, age = ?, city_id =? WHERE id =?";
    @Override
    public List<Employee> changeEmployee(int id, Employee employee) {
        List<Employee> changeEmployee = new ArrayList<>();
        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement =
                     connection.prepareStatement(CHANGE_EMPLOYEE)) {
            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,employee.getFirst_name());
            preparedStatement.setString(3,employee.getLast_name());
            preparedStatement.setString(4,employee.getGender());
            preparedStatement.setInt(5,employee.getAge());
            preparedStatement.setInt(6,employee.getCity_id());
            preparedStatement.setInt(7,id);

            preparedStatement.executeUpdate();

            PreparedStatement statement =
                    connection.prepareStatement("SELECT * FROM employee");{

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







