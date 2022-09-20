package web.dao;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;
import java.util.List;

@Repository
public class UserDAOImp implements UserDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public UserDAOImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    @Override
    public void save(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public List<User> listUsers() {
        Query<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        List<User> list = query.getResultList();
        return list;
    }

    @Override
    public User getUser(int id) {
        User user = sessionFactory.getCurrentSession().get(User.class, id);
        return user;
    }

    @Override
    public void deleteUser(int id) {
        Query<User> query = sessionFactory.getCurrentSession().createQuery("delete from User WHERE id =:userId");
        query.setParameter("userId", id);
        query.executeUpdate();
    }

}