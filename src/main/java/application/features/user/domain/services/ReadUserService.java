package application.features.user.domain.services;

import application.features.user.domain.entities.User;

public interface ReadUserService {
    User findByEmail(String email);
}
