package Users;

public class RolesDAOImpl extends RolesDAO {

    @Override
    public Roles getRoleById (long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Roles.class, id);
    }

}
