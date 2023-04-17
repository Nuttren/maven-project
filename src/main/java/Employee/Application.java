package Employee;

import Book.Book;

import java.sql.*;
import java.util.List;

public class Application {
    public static void main(String[] args) throws SQLException {
//
//        // Задаем параметры для подключения к базе данных:
//        // имя пользователя, пароль и URL
//        final String user = "postgres";
//        final String password = "1";
//        final String url = "jdbc:postgresql://localhost:5432/skypro";
//
//        // Создаем соединение с базой данных внутри try-with-resources,
//        // чтобы автоматически закрыть его после использования
//        try (final Connection connection =
//                     DriverManager.getConnection(url, user, password);
//             // Создаем объект PreparedStatement с SQL-запросом
//             // для выборки всех записей из таблицы book
//             PreparedStatement statement =
//                     connection.prepareStatement("SELECT employee.first_name, employee.last_name, employee.gender, city.city_name FROM employee LEFT JOIN city ON employee.city_id=city.city_id")) {
//
//
//            // Выполняем SQL-запрос
//            // и получаем результаты в виде объекта ResultSet
//            ResultSet resultSet = statement.executeQuery();
//
//            // Обрабатываем результаты запроса, перебирая все записи в таблице
//            while (resultSet.next()) {
//                // Получаем значения полей записи и выводим их на экран
//
//                String fistNameOfEmployee = resultSet.getString("first_name");
//                System.out.println("Имя сотрудника: " + fistNameOfEmployee);
//
//                String lastNameOfEmployee = resultSet.getString("last_name");
//                System.out.println("Фамилия сотрудника: " + lastNameOfEmployee);
//
//                String genderOfEmployee = resultSet.getString("gender");
//                System.out.println("Пол сотрудника: " + genderOfEmployee);
//
//                String cityOfEmployee = resultSet.getString("city_name");
//                System.out.println("Город сотрудника: " + cityOfEmployee);
//            }
//
//        } catch (SQLException e) {
//            // В случае возникновения ошибки при работе с базой данных
//            // выводим сообщение об ошибке и информацию об исключении
//            System.out.println("Ошибка при подключении к БД!");
//            e.printStackTrace();
//        }

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        List<Employee> employees = employeeDAO.getAllEmployee();
        employeeDAO.createEmployee((Employee) employees);
        employeeDAO.getEmployeeById((int) ((Employee) employees).getId());
        employeeDAO.changeEmployee((Employee) employees);
        employeeDAO.deleteEmployee ((int) ((Employee) employees).getId());


        employeeDAO.createEmployee((Employee) employees);

        for (Employee employee : employees) {
            System.out.println("ID сотрудника: " + employee.getId());
            System.out.println("Имя сотрудника: " + employee.getFirst_name());
            System.out.println("Фамилия сотрудника: " + employee.getLast_name());
            System.out.println("Пол сотрудника: " + employee.getGender());
            System.out.println("ID города сотрудника: " + employee.getCity_id());
        }
    }
}