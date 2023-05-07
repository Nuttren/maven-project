package Users;

import Employee.Employee;

import java.util.List;
import java.util.UUID;

public interface UsersDAO {

    void createUser(Users users);

    List<Users> getAllUsers();

    Users getUserById(UUID id);

    public Users updateUsers(UUID id, Users users);

    void deleteUser(UUID id);

    public List<Users> getAllByRoleManager();
}
