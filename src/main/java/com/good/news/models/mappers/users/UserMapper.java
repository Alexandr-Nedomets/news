package com.good.news.models.mappers.users;

import com.good.news.models.dto.users.UserDto;
import com.good.news.models.entity.users.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Collection;
import java.util.List;

@Mapper
public interface UserMapper {

    UserMapper USER_MAPPER = Mappers.getMapper(UserMapper.class);

    User toUser(UserDto userDto);

    UserDto toUserDto(User user);

    List<UserDto> toListUserDto(Collection<User> users);

}
