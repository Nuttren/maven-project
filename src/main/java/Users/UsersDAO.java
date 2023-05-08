package Users;

import java.util.List;
import java.util.UUID;

public interface UsersDAO {

    void createUser(Users users);

    List<Users> getAllUsers();
//
    Users getUserById(long id);
//
     void updateUsers(Users users, long id);
//
    void deleteUser(Users users, long id);
//
//    public List<Users> getAllByRoleManager();
}
