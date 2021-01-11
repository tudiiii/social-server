package com.github.prgms.socialserver.web;

import com.github.prgms.socialserver.domain.user.User;
import com.github.prgms.socialserver.service.UserService;
import com.github.prgms.socialserver.web.dto.UserListResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<UserListResponseDto> userList(){
        return userService.allUserList();
    }

}
