package web.servise;


import web.model.User;

import javax.transaction.Transactional;
import java.util.List;

public interface UserServise {

    List<User> getAllUsers();

    void addUser(User user);

    User getUser(int id);

    void removeUser(int id);
}
