package com.github.prgms.socialserver.service;

import com.github.prgms.socialserver.domain.user.User;
import com.github.prgms.socialserver.web.dto.PostsUserRequestDto;
import com.github.prgms.socialserver.web.dto.PostsUserResponseDto;
import com.github.prgms.socialserver.web.dto.UserListResponseDto;

import java.util.List;

public interface UserService {

    List<UserListResponseDto> allUserList();
    UserListResponseDto userInfoList(String email);

    PostsUserResponseDto registerUser(PostsUserRequestDto postsUserRequestDto);

}
