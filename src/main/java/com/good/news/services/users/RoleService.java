package com.good.news.services.users;

import com.good.news.models.entity.enums.RoleEnum;
import com.good.news.models.entity.users.Role;
import com.good.news.repositories.users.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public Role findByRoleEnum(RoleEnum roleEnum) {
        return roleRepository.findByRoleEnum(roleEnum);
    }

}
