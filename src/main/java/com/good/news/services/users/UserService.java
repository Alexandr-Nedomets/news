package com.good.news.services.users;

import com.good.news.models.entity.users.User;
import com.good.news.repositories.users.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User update(Long id, User user) {
        User userForUpdate = findById(id);
        userForUpdate.setUsername(user.getUsername());
        userForUpdate.setPassword(user.getPassword());
        userForUpdate.setPhone(user.getPhone());
        userForUpdate.setActive(user.getActive());
        userForUpdate.setFirstName(user.getFirstName());
        userForUpdate.setMiddleName(user.getMiddleName());
        userForUpdate.setLastName(user.getLastName());
        userForUpdate.setRoles(user.getRoles());
        return userRepository.save(userForUpdate);
    }

}
