package application.features.user.adapters.out.repositories.read;

import application.features.user.adapters.out.entities.UserEntity;
import application.features.user.adapters.out.mappers.UserMapper;
import application.features.user.adapters.out.repositories.jpa.JpaUserRepository;
import application.features.user.domain.entities.User;
import application.features.user.domain.repositories.read.ReadUserRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ReadUserRepositoryImpl implements ReadUserRepository {
    private final JpaUserRepository userRepository;
    private final UserMapper userMapper;

    public ReadUserRepositoryImpl(JpaUserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public Optional<User> findByEmail(String email) {
       return this.userRepository.findByEmail(email).map(userMapper::toDomain);
    }
}
