package application.features.user.adapters.out.mappers;

import application.features.user.adapters.out.entities.UserEntity;
import application.features.user.domain.dto.ResponseUserDto;
import application.features.user.domain.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    ResponseUserDto toResponseDto(UserEntity userEntity);
    UserEntity toEntity(User user);
}
