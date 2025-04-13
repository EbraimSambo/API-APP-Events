package application.features.user.application.usecases.create;

import application.features.user.adapters.out.mappers.UserDtoMapper;
import application.features.user.adapters.out.repositories.create.CreateUserRepositoryImpl;
import application.features.user.adapters.out.repositories.read.ReadUserRepositoryImpl;
import application.features.user.domain.dto.CreateDataUser;
import application.features.user.domain.dto.ResponseUserDto;
import application.features.user.domain.entities.User;
import application.features.user.domain.usecases.CreateUserCase;
import application.root.application.config.exeptions.custom.ConflictException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class CreateUserCaseImpl implements CreateUserCase {
    private final CreateUserRepositoryImpl userRepository;
    private final UserDtoMapper userDtoMapper;
    private final ReadUserRepositoryImpl readUserRepository;

    public CreateUserCaseImpl(CreateUserRepositoryImpl userRepository, UserDtoMapper userDtoMapper, ReadUserRepositoryImpl readUserRepository) {
        this.userRepository = userRepository;
        this.userDtoMapper = userDtoMapper;
        this.readUserRepository = readUserRepository;
    }


    @Override
    public ResponseUserDto execute(CreateDataUser createDataUser) {

        Optional<User> user = this.readUserRepository.findByEmail(createDataUser.getEmail());

        if (user.isPresent()) {
            throw new ConflictException("Usuário com esse e-mail já existe.");
        }

        return this.userRepository.save(
                this.userDtoMapper.toUser(createDataUser)
        );
    }
}
