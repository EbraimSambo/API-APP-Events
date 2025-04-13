package application.features.user.adapters.out.repositories.create;

import application.features.user.adapters.out.entities.UserEntity;
import application.features.user.adapters.out.mappers.UserMapper;
import application.features.user.adapters.out.repositories.jpa.JpaUserRepository;
import application.features.user.domain.dto.ResponseUserDto;
import application.features.user.domain.entities.User;
import application.features.user.domain.repositories.create.CreateUserRepository;

public class CreateUserRepositoryImpl implements CreateUserRepository {
    private final JpaUserRepository userRepository;
    private final UserMapper userMapper;

    public CreateUserRepositoryImpl(JpaUserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public ResponseUserDto save(User user) {
        UserEntity createUser = this.userRepository.save(
                this.userMapper.toEntity(user)
        );
        return this.userMapper.toResponseDto(createUser);
    }
}
