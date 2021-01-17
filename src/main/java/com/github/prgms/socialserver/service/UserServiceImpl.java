package com.github.prgms.socialserver.service;

import com.github.prgms.socialserver.domain.user.User;
import com.github.prgms.socialserver.repository.JdbcUserRepository;
import com.github.prgms.socialserver.web.dto.PostsUserRequestDto;
import com.github.prgms.socialserver.web.dto.PostsUserResponseDto;
import com.github.prgms.socialserver.web.dto.UserListResponseDto;
import org.springframework.context.MessageSource;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    private final JdbcUserRepository jdbcUserRepository;
    private final MessageSource messageSource;

    public UserServiceImpl(JdbcUserRepository userRepository, MessageSource messageSource) {
        this.jdbcUserRepository = userRepository;
        this.messageSource = messageSource;
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
        User user = PostsUserRequestDto.toEntity(postsUserRequestDto);

        try{
            return new PostsUserResponseDto(true, messageSource.getMessage("message.user.success", null, Locale.ENGLISH));
        } catch (DataAccessException e){
            return new PostsUserResponseDto(false, messageSource.getMessage("message.user.fail", null, Locale.ENGLISH));
        }

    }
}
