package academy.kata.pp_3_1_1_springboot.service;

import academy.kata.pp_3_1_1_springboot.model.User;
import academy.kata.pp_3_1_1_springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private UserRepository repository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.repository = userRepository;
    }

    @Override
    public List<User> getUsers() {
        return repository.listUsers();
    }

    @Override
    public void addUser(User user) {
        repository.createUser(user);
    }

    @Override
    public void removeUser(User user) {
        repository.removeUser(user);
    }

    @Override
    public User getUserById(long id) {
        return repository.getUserById(id);
    }

    @Override
    public void updateUser(User user) {
        repository.updateUser(user);
    }
}
