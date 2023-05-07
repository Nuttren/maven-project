package Users;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.UUID;

public class UsersDAOImpl implements  UsersDAO{
    @Override
    public void createUser(Users users) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(users);
        tx1.commit();
        session.close();
    }

    @Override
    public List<Users> getAllUsers() {
        List<Users> users = (List<Users>)
                HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Users").list();
        return users;
    }

    @Override
    public Users getUserById(UUID id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Users.class, id);
    }

    @Override
    public Users updateUsers(UUID id, Users users) {
        Session session = Employee.HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.createQuery("UPDATE Users SET modificationTime =?, userName = ?, userLogin = ?, userPassword = ?, roleAnalyst = ?, roleDesigner =?, roleDeveloper =?, roleQA =?, roleManager =?, roleDefault = ? WHERE id =?");
        tx1.commit();
        session.close();
        return users;
    }

    @Override
    public void deleteUser(UUID id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(id);
        tx1.commit();
        session.close();
    }

    @Override
    public List<Users> getAllByRoleManager() {
        List<Users> users = (List<Users>)
                HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Users WHERE roleManager").list();
        return users;
    }
}
