package application.features.user.domain.usecases;

import application.features.user.domain.dto.CreateDataUser;
import application.features.user.domain.dto.ResponseUserDto;

public interface CreateUserCase {
  ResponseUserDto execute(CreateDataUser createDataUser);;
}
