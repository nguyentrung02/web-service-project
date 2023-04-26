package vamk.fi.user.service;

import org.springframework.stereotype.Service;

import vamk.fi.user.model.UserModel;
import vamk.fi.user.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserModel authenticate(String login, String password) {
        return userRepository.findByLoginAndPassword(login, password).orElse(null);
    }
}
