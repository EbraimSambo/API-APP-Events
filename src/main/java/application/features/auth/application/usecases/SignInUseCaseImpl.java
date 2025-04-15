package application.features.auth.application.usecases;

import application.features.auth.adapters.out.mappers.AuthMapper;
import application.features.auth.application.utils.PasswordUtils;
import application.features.auth.domain.dto.DataSignIn;
import application.features.auth.domain.dto.ResponseSignAuthDto;
import application.features.auth.domain.usecases.SignInUseCase;
import application.features.user.adapters.out.repositories.read.ReadUserRepositoryImpl;
import application.features.user.domain.entities.User;
import application.root.application.config.exeptions.custom.UnauthorizedException;
import org.springframework.stereotype.Service;

@Service
public class SignInUseCaseImpl implements SignInUseCase {

    private final ReadUserRepositoryImpl readUserRepository;

    private final PasswordUtils passwordUtils;

    private final AuthMapper authMapper;

    public SignInUseCaseImpl(ReadUserRepositoryImpl readUserRepository, PasswordUtils passwordUtils, AuthMapper authMapper) {
        this.readUserRepository = readUserRepository;
        this.passwordUtils = passwordUtils;
        this.authMapper = authMapper;
    }

    @Override
    public ResponseSignAuthDto signI(DataSignIn data) {
        User user = this.readUserRepository.findByEmail(data.getEmail()).orElseThrow(()-> new UnauthorizedException("Email errado"));

        if(!this.passwordUtils.validator(data.getPassword(), user.getPassword())){
            throw new UnauthorizedException("Senha errada");
        }

        System.out.println(user);
        return this.authMapper.toResponse(user);
    }
}
