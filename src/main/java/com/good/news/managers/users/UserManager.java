package com.good.news.managers.users;

import com.good.news.models.dto.users.UserDto;
import com.good.news.models.entity.enums.RoleEnum;
import com.good.news.models.entity.users.User;
import com.good.news.services.users.RoleService;
import com.good.news.services.users.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

import static com.good.news.models.mappers.users.UserMapper.USER_MAPPER;

@Service
@AllArgsConstructor
public class UserManager {

    private final UserService userService;
    private final RoleService roleService;

    public List<UserDto> findAll() {
        return USER_MAPPER.toListUserDto(userService.findAll());
    }

    public UserDto findById(Long id) {
        return USER_MAPPER.toUserDto(userService.findById(id));
    }

    public void deleteById(Long id) {
        userService.deleteById(id);
    }

    public UserDto save(UserDto userDto) {
        User user = USER_MAPPER.toUser(userDto);
        user.setActive(Boolean.TRUE);
        user.setRoles(Collections.singleton(roleService.findByRoleEnum(RoleEnum.AUTHOR)));
        return USER_MAPPER.toUserDto(userService.save(user));
    }

    public User update(Long id, User user) {
        return userService.update(id, user);
    }

}
