package application.features.auth.adapters.in.controllers.signin;

import application.features.auth.adapters.out.dto.SignInDto;
import application.features.auth.adapters.out.mappers.AuthMapper;
import application.features.auth.application.usecases.SignInUseCaseImpl;
import application.features.auth.domain.dto.ResponseSignAuthDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/sign-in")
public class SignInController {
    private final SignInUseCaseImpl signInUseCase;

    private final AuthMapper authMapper;

    public SignInController(SignInUseCaseImpl signInUseCase, AuthMapper authMapper) {
        this.signInUseCase = signInUseCase;
        this.authMapper = authMapper;
    }

    @PostMapping
   private ResponseEntity<ResponseSignAuthDto> signIn(
          @RequestBody @Valid SignInDto dto
           ){
       return ResponseEntity.ok(this.signInUseCase.signI(
               this.authMapper.toDataDomain(dto)
       ));
    }
}
