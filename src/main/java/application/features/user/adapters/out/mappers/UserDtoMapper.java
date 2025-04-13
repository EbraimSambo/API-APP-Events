package application.features.user.adapters.out.mappers;

import application.features.user.adapters.out.dto.CreateUserDto;
import application.features.user.domain.dto.CreateDataUser;
import application.features.user.domain.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserDtoMapper {
    User toUser(CreateDataUser createDataUser);
    CreateDataUser toData(CreateUserDto dto);
}
