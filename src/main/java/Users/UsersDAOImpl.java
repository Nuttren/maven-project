package Users;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.annotations.Test;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import static org.testng.Assert.assertNotNull;

public class UsersDAOImpl implements  UsersDAO {
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
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        return session.createQuery("From Users").list();
    }


    @Override
    public Users getUserById(long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Users.class, id);
    }

    @Override
    public void updateUsers(Users users, long id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        users.setId(id);
        session.update(users);
        tx1.commit();
        session.close();

    }

    @Override
    public void deleteUser(Users users, long id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        users.setId(id);
        session.delete(users);
        tx1.commit();
        session.close();
    }
}


