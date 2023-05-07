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
        List<Users> users = (List<Users>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Users").list();
        return users;
    }

    @Override
    public Users getUserById(UUID id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Users.class, id);
    }
}
