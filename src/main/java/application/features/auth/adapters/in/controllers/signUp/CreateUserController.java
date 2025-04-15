package application.features.auth.adapters.in.controllers.signIn;

import application.features.user.adapters.out.dto.CreateUserDto;
import application.features.user.adapters.out.mappers.UserDtoMapper;
import application.features.user.application.usecases.create.CreateUserCaseImpl;
import application.features.user.domain.dto.ResponseUserDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/sign-in")
public class CreateUserController {

    private final CreateUserCaseImpl createUserCase;
    private final UserDtoMapper userDtoMapper;

    public CreateUserController(CreateUserCaseImpl createUserCase, UserDtoMapper userDtoMapper) {
        this.createUserCase = createUserCase;
        this.userDtoMapper = userDtoMapper;
    }

    @PostMapping
    private ResponseEntity<ResponseUserDto> create(
            @RequestBody @Valid CreateUserDto dto
            ){
        return ResponseEntity.ok(this.createUserCase.execute(
                this.userDtoMapper.toData(dto)
        ));
    }
}
