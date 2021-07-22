package com.good.news.models.dto.users;

import com.good.news.models.entity.users.Role;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
public class UserDto {

    private Long id;
    @NotEmpty(message = "{user.username.is.not.empty}")
    @Size(max = 32, message = "{user.username.size.max}")
    @Email(message = "{user.username.email}")
    private String username;
    @NotEmpty(message = "{user.password.is.not.empty}")
    @Size(min = 8, max = 16, message = "{user.password.size.max}")
    private String password;
//    @Pattern(regexp = "^+7(d{3})d{2}-d{2}-d{3}$", message = "{user.phone.pattern}")
    private String phone;
    @NotEmpty(message = "{user.first.name.is.not.empty}")
    @Size(min = 2, max = 32, message = "{user.first.name.size.max}")
    private String firstName;
    @NotEmpty(message = "{user.middle.name.is.not.empty}")
    @Size(min = 2, max = 32, message = "{user.middle.name.size.max}")
    private String middleName;
    @NotEmpty(message = "{user.last.name.is.not.empty}")
    @Size(min = 2, max = 32, message = "{user.last.name.size.max}")
    private String lastName;
    private Set<Role> roles;

}
