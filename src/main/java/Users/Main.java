package Users;

import Employee.EmployeeDAO;
import Employee.EmployeeDAOImpl;

import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        UsersDAO usersDAO = new UsersDAOImpl();

        usersDAO.createUser(new Users("Ivan Ivanov", "NNN", "12345", false, false,false,false,false,false));

        List<Users> users = usersDAO.getAllUsers();
        System.out.println(users);

        usersDAO.getUserById(UUID.randomUUID());

        usersDAO.updateUsers(UUID.randomUUID(), new Users("Ivan Ivanov", "NNN", "12345", false, false,false,false,false,false));

        usersDAO.deleteUser(UUID.randomUUID());

        users=usersDAO.getAllByRoleManager();
        System.out.println(users);
    }
}
