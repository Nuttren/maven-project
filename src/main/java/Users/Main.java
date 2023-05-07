package Users;

import Employee.EmployeeDAO;
import Employee.EmployeeDAOImpl;

import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        UsersDAO usersDAO = new UsersDAOImpl();

        usersDAO.createUser(new Users("Ivan Ivanov", "NNN", "12345"));

        List<Users> users = usersDAO.getAllUsers();
        System.out.println(users);

        usersDAO.getUserById(UUID.randomUUID());
    }
}
