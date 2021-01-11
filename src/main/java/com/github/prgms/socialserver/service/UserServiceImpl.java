package com.github.prgms.socialserver.service;

import com.github.prgms.socialserver.domain.user.User;
import com.github.prgms.socialserver.repository.JdbcUserRepository;
import com.github.prgms.socialserver.web.dto.UserListResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    private final JdbcUserRepository jdbcUserRepository;

    public UserServiceImpl(JdbcUserRepository userRepository){
        this.jdbcUserRepository = userRepository;
    }

    public List<UserListResponseDto> allUserList(){
        return jdbcUserRepository.userList().stream()
                .map(UserListResponseDto::new) // user -> new UserListResponseDto((user))
                .collect(Collectors.toList());
    }
}
