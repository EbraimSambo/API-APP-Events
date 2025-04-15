package application.features.auth.adapters.out.mappers;

import application.features.auth.adapters.out.dto.SignInDto;
import application.features.auth.domain.dto.DataSignIn;
import application.features.auth.domain.dto.ResponseSignAuthDto;
import application.features.user.domain.entities.User;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface AuthMapper {
    ResponseSignAuthDto toResponse(User user);
    DataSignIn toDataDomain(SignInDto dto);
}
