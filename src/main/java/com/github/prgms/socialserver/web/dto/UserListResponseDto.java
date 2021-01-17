package com.github.prgms.socialserver.web.dto;

import com.github.prgms.socialserver.domain.user.User;
/*
 유저 리스트 조회
 */
public class UserListResponseDto {
    private String email;
    private String passWd;

    public UserListResponseDto(User entity){
        this.email = entity.getEmail();
        this.passWd = entity.getPassWd();
    }

    public String getEmail() {
        return email;
    }
    public String getPassWd() {
        return passWd;
    }
}
