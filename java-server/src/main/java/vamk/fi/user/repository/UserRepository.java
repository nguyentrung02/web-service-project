package vamk.fi.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import vamk.fi.user.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Integer> {
    
    Optional<UserModel> findByLoginAndPassword(String login, String password);
}
