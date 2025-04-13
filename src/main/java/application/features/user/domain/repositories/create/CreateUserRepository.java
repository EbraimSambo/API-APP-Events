package application.features.user.domain.repositories.create;

import application.features.user.domain.dto.ResponseUserDto;
import application.features.user.domain.entities.User;

public interface CreateUserRepository {
    ResponseUserDto save(User user);
}
