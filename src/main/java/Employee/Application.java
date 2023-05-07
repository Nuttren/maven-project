package Employee;

import Book.Book;
import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.metamodel.EntityType;
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
            CityDAO cityDAO = new CityDAOImpl();

//            List<Employee> employees = employeeDAO.getAllEmployee();
//
//            System.out.println(employeeDAO.getEmployeeById(5));
//
//            for (Employee employee : employees) {
//                System.out.println("ID сотрудника: " + employee.getId());
//                System.out.println("Имя сотрудника: " + employee.getFirstName());
//                System.out.println("Фамилия сотрудника: " + employee.getLastName());
//                System.out.println("Пол сотрудника: " + employee.getGender());
//                System.out.println("ID города сотрудника: " + employee.getCityId());
//            }
//
//
//            Employee e2 = new Employee(12, "Kate", "Kate", "female", 20, 5);
//
//            employeeDAO.createEmployee(e2);
//            System.out.println(e2);
//
//            System.out.println(employeeDAO.changeEmployee(3, new Employee(3, "KKKKate", "Kate", "female", 20, 2)));

//            System.out.println(employeeDAO.getEmployeeById(6));
//            System.out.println(cityDAO.getCityById(3).getEmployees());

//            employeeDAO.createEmployee(new Employee(16, "Kate", "Kate", "female", 20, 2));
//                employeeDAO.updateEmployee(new Employee(17, "Egor", "Kalmykov", "male", 20, 4));
//            employeeDAO.deleteEmployee(new Employee(16, "Kate", "Kate", "female", 20, 2));
//            cityDAO.deleteCity(new City(3,"London"));
//        System.out.println(cityDAO.getCityById(3).getEmployees());
        cityDAO.createCity(new City(6,"Munich"));
    }
}




