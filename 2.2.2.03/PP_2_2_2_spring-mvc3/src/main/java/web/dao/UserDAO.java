package web.dao;


import web.model.User;

import java.util.List;

public interface UserDAO {
    void add(User user);
    void save(User user);

     List<User> listUsers();
     User getUser(int id);

    void deleteUser(int id);
}
