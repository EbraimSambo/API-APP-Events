package application.features.user.application.services.read;

import application.features.user.adapters.out.repositories.read.ReadUserRepositoryImpl;
import application.features.user.domain.entities.User;
import application.features.user.domain.services.ReadUserService;
import application.root.application.config.exeptions.custom.UnauthorizedException;
import org.springframework.stereotype.Service;

@Service
public class ReadUserServiceImpl implements ReadUserService {

    private final ReadUserRepositoryImpl readUserRepository;

    public ReadUserServiceImpl(ReadUserRepositoryImpl readUserRepository) {
        this.readUserRepository = readUserRepository;
    }

    @Override
    public User findByEmail(String email) {
        return this.readUserRepository.findByEmail(email).orElseThrow(()-> new UnauthorizedException("Usuario nao encontrado"));
    }
}
