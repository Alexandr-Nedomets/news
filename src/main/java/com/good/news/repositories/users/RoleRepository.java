package com.good.news.repositories.users;

import com.good.news.models.entity.enums.RoleEnum;
import com.good.news.models.entity.users.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

//TODO   Role findByRoleEnum(RoleEnum roleEnum);

}
