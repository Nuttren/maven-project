package Employee;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class CityDAOImpl implements CityDAO{
    @Override
    public City getCityById(long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().find(City.class, id);
    }

    @Override
    public void deleteCity(City city) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(city);
        tx1.commit();
        session.close();
    }

    @Override
    public void createCity(City city) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(city);
        tx1.commit();
        session.close();
    }


}
