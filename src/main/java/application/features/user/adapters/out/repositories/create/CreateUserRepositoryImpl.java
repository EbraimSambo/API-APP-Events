package application.features.user.adapters.out.repositories.create;

import application.features.auth.application.utils.PasswordUtils;
import application.features.user.adapters.out.entities.UserEntity;
import application.features.user.adapters.out.mappers.UserMapper;
import application.features.user.adapters.out.repositories.jpa.JpaUserRepository;
import application.features.user.domain.dto.ResponseUserDto;
import application.features.user.domain.entities.User;
import application.features.user.domain.repositories.create.CreateUserRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CreateUserRepositoryImpl implements CreateUserRepository {
    private final PasswordUtils passwordUtils;
    private final JpaUserRepository userRepository;
    private final UserMapper userMapper;

    public CreateUserRepositoryImpl(PasswordUtils passwordUtils, JpaUserRepository userRepository, UserMapper userMapper) {
        this.passwordUtils = passwordUtils;
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public ResponseUserDto save(User user) {
        user.setPassword(
                this.passwordUtils.hash(user.getPassword())
        );
        UserEntity createUser = this.userRepository.save(
                this.userMapper.toEntity(user)
        );
        return this.userMapper.toResponseDto(createUser);
    }
}
