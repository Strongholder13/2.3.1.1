package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDAO;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    public UserServiceImp(UserDAO userDao) {
        this.userDao = userDao;
    }
    private UserDAO userDao;
    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Transactional
    @Override
    public void update(User user) {userDao.save(user); }
    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Transactional(readOnly = true)
    @Override
    public User findById(int id) {
        return userDao.getUser(id);
    }

    @Transactional
    @Override
    public void delete(int id) {
        userDao.deleteUser(id);
    }

}
