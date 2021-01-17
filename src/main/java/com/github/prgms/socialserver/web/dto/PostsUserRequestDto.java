package com.github.prgms.socialserver.web.dto;

import com.github.prgms.socialserver.domain.user.User;

import javax.validation.constraints.NotNull;

public class PostsUserRequestDto {

    private String principal;
    private String credentials;

    public String getPrincipal() {
        return principal;
    }
    public String getCredentials() {
        return credentials;
    }

    public static User toEntity(PostsUserRequestDto postsUserRequestDto){
        return User.builder()
                .email(postsUserRequestDto.principal)
                .passWd(postsUserRequestDto.credentials)
                .build();
    }
}
