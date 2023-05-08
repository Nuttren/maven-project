package Users;

import Employee.EmployeeDAO;
import Employee.EmployeeDAOImpl;

import javax.management.relation.Role;
import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        UsersDAO usersDAO = new UsersDAOImpl();
        RolesDAO rolesDAO = new RolesDAOImpl();

        usersDAO.createUser(new Users("Sergey", "NNN", "12345")); // метод создания пользователя без ролей

        List<Users> users = usersDAO.getAllUsers(); // метод получения всех пользователей
        System.out.println(users);

        System.out.println(usersDAO.getUserById(2).getRoles()); // метод получения пользователя и его ролей

        usersDAO.updateUsers(new Users("Ivan Ivanov", "NNN", "12345"), 10); // метод обновления пользователя

        System.out.println(rolesDAO.getRoleById(2).getUsers()); // метод получения пользователей по конкретной роли

        usersDAO.deleteUser(new Users("Ivan Ivanov", "NNN", "12345"), 5); // метод удаления пользователя из обоих таблиц

        Roles managerRole = rolesDAO.getRoleById(2);
        Users user = new Users("Sergey", "NNN", "12345");
        Set<Roles> roles = new HashSet<>();
        roles.add(managerRole);
        user.setRoles(roles);
        usersDAO.createUser(user);
    }
}
