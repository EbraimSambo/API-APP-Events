package application.features.user.domain.repositories.read;

import application.features.user.domain.entities.User;

import java.util.Optional;

public interface ReadUserRepository {
    Optional<User> findByEmail(String email);
}
