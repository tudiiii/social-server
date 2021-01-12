package com.github.prgms.socialserver.web.dto;

import com.github.prgms.socialserver.domain.user.User;

public class PostsUserRequestDto {
    private String principal;
   private String credentials;

    public String getPrincipal() {
        return principal;
    }

    public String getCredentials() {
        return credentials;
    }

    public static User BuilderUser(PostsUserRequestDto postsUserRequestDto){
        return User.builder()
                .email(postsUserRequestDto.principal)
                .password(postsUserRequestDto.credentials)
                .build();
    }
}
