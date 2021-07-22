package com.good.news.controllers.users;

import com.good.news.managers.users.UserManager;
import com.good.news.models.dto.users.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/api/users")
@AllArgsConstructor
public class UserController {

    private final UserManager userManager;

    @PostMapping
    public String save(@ModelAttribute(value = "user") @Valid UserDto userDto,
                       BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "/users/create";
        userManager.save(userDto);
        return "redirect:/login";
    }

}
