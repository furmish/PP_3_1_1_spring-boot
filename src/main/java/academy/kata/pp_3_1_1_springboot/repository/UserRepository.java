package academy.kata.pp_3_1_1_springboot.repository;

import academy.kata.pp_3_1_1_springboot.model.User;

import java.util.List;

public interface UserRepository {
    List<User> listUsers();
    void createUser(User user);
    void removeUser(User user);
    User getUserById(long id);
    void updateUser(User user);
}
