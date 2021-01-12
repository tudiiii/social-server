package com.github.prgms.socialserver.service;

import com.github.prgms.socialserver.domain.user.User;
import com.github.prgms.socialserver.repository.JdbcUserRepository;
import com.github.prgms.socialserver.web.dto.PostsUserRequestDto;
import com.github.prgms.socialserver.web.dto.PostsUserResponseDto;
import com.github.prgms.socialserver.web.dto.UserListResponseDto;
import org.springframework.dao.DataAccessException;
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
        return jdbcUserRepository.allUserList().stream()
                .map(UserListResponseDto::new) // user -> new UserListResponseDto((user))
                .collect(Collectors.toList());
    }

    public UserListResponseDto userInfoList(String email) {
        return new UserListResponseDto(jdbcUserRepository.userInfoList(email));
    }

    public PostsUserResponseDto registerUser(PostsUserRequestDto postsUserRequestDto) {
        User user = PostsUserRequestDto.BuilderUser(postsUserRequestDto);
        try{
            jdbcUserRepository.registerUser(user);
        } catch (DataAccessException e){
            return new PostsUserResponseDto(false, "가입실패");
        } finally {
            return new PostsUserResponseDto(true, "가입성공");
        }

    }
}
