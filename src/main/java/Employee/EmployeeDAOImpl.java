package Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    private final String user = "postgres";
    private final String password = "1";
    private final String url = "jdbc:postgresql://localhost:5432/skypro";


    @Override
    public void createEmployee(Employee employee) {
        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement =
                     connection.prepareStatement("INSERT INTO employee (id,first_name, last_name, gender, age, city_id)   VALUES (7, 'Petr', 'Petrov', 'male', 30, 3)")) {
            ResultSet resultSet = statement.executeQuery();

            int idOfEmployee = resultSet.getInt("id");
            String firstNameOfEmployee = resultSet.getString("first_name");
            String lastNameOfEmployee = resultSet.getString("last_name");
            String genderNameOfEmployee = resultSet.getString("gender");
            int ageOfEmployee = resultSet.getInt("age");
            int cityIdOfEmployee = resultSet.getInt("city_id");

            Employee employee1 = new Employee(idOfEmployee, firstNameOfEmployee, lastNameOfEmployee, genderNameOfEmployee, ageOfEmployee, cityIdOfEmployee);

        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к БД!");
            e.printStackTrace();
        }
    }

    @Override
    public void getEmployeeById(int id) {
            try (final Connection connection = DriverManager.getConnection(url, user, password);
                 PreparedStatement statement =
                         connection.prepareStatement("SELECT * FROM employee WHERE id=7")) {

                ResultSet resultSet = statement.executeQuery();

                resultSet.next(); {

                    int idOfEmployee = resultSet.getInt("id");
                    String firstNameOfEmployee = resultSet.getString("first_name");
                    String lastNameOfEmployee = resultSet.getString("last_name");
                    String genderNameOfEmployee = resultSet.getString("gender");
                    int ageOfEmployee = resultSet.getInt("age");
                    int cityIdOfEmployee = resultSet.getInt("city_id");
                    Employee employees2 = new Employee(idOfEmployee, firstNameOfEmployee, lastNameOfEmployee, genderNameOfEmployee, ageOfEmployee, cityIdOfEmployee);
                    System.out.println(employees2);
                }
            } catch (SQLException e) {
                System.out.println("Ошибка при подключении к БД!");
                e.printStackTrace();
            }

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
        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement =
                     connection.prepareStatement("DELETE FROM employee WHERE id=7")) {

            ResultSet resultSet = statement.executeQuery();

            resultSet.next(); {

                int idOfEmployee = resultSet.getInt("id");
                String firstNameOfEmployee = resultSet.getString("first_name");
                String lastNameOfEmployee = resultSet.getString("last_name");
                String genderNameOfEmployee = resultSet.getString("gender");
                int ageOfEmployee = resultSet.getInt("age");
                int cityIdOfEmployee = resultSet.getInt("city_id");
                Employee employees2 = new Employee(idOfEmployee, firstNameOfEmployee, lastNameOfEmployee, genderNameOfEmployee, ageOfEmployee, cityIdOfEmployee);


            }
        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к БД!");
            e.printStackTrace();
        }


    }

    @Override
    public void changeEmployee(Employee employee) {
        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement =
                     connection.prepareStatement("UPDATE employee SET first_name = 'Basya' WHERE id = 7;")) {

            ResultSet resultSet = statement.executeQuery();

            resultSet.next(); {

                int idOfEmployee = resultSet.getInt("id");
                String firstNameOfEmployee = resultSet.getString("first_name");
                String lastNameOfEmployee = resultSet.getString("last_name");
                String genderNameOfEmployee = resultSet.getString("gender");
                int ageOfEmployee = resultSet.getInt("age");
                int cityIdOfEmployee = resultSet.getInt("city_id");
                Employee employees3 = new Employee(idOfEmployee, firstNameOfEmployee, lastNameOfEmployee, genderNameOfEmployee, ageOfEmployee, cityIdOfEmployee);
                System.out.println(employees3);
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к БД!");
            e.printStackTrace();
        }

    }


}
