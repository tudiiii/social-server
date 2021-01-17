package com.github.prgms.socialserver.web.dto;

public class PostsUserResponseDto {
    private boolean success;
    private String response;

    public boolean isSuccess() {
        return success;
    }

    public String getResponse() {
        return response;
    }

    public PostsUserResponseDto(boolean success, String response){
        this.success = success;
        this.response = response;
    }
}
