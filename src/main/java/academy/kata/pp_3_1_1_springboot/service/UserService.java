package academy.kata.pp_3_1_1_springboot.service;


import academy.kata.pp_3_1_1_springboot.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    void addUser(User user);
    void removeUser(User user);
    User getUserById(long id);
    void updateUser(User user);
}
