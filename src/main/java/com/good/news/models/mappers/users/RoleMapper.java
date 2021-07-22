package com.good.news.models.mappers.users;

import com.good.news.models.dto.users.RoleDto;
import com.good.news.models.entity.users.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RoleMapper {

    RoleMapper ROLE_MAPPER = Mappers.getMapper(RoleMapper.class);

    Role toRole(RoleDto roleDto);

    RoleDto toRoleDto(Role role);

    List<RoleDto> toListRoleDto(List<Role> roles);
}
