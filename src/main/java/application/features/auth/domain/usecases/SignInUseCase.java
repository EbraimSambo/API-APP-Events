package application.features.auth.domain.usecases;

import application.features.auth.domain.dto.DataSignIn;
import application.features.auth.domain.dto.ResponseSignAuthDto;

public interface SignInUseCase {
    ResponseSignAuthDto signI(DataSignIn data);
}
