package com.github.prgms.socialserver.domain.user;

import java.time.LocalDateTime;

public class User {

    private final Long seq;
    private String email;
    private String passWd;
    private int loginCount;
    private LocalDateTime lastLoginAt;
    private final LocalDateTime createAt;

    public User(UserBuilder builder) {
        this.seq = builder.seq;
        this.email = builder.email;
        this.passWd = builder.passWd;
        this.loginCount = builder.loginCount;
        this.lastLoginAt = builder.lastLoginAt;
        this.createAt = builder.createAt;
    }

    public String getEmail() {
        return email;
    }
    public String getPassWd() {
        return passWd;
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public static UserBuilder builder(Long seq, LocalDateTime createAt) {
        return new UserBuilder(seq, createAt);
    }

    public static class UserBuilder {
        private Long seq;
        private String email;
        private String passWd;
        private int loginCount;
        private LocalDateTime lastLoginAt;
        private LocalDateTime createAt;

        UserBuilder() {
        }

        public UserBuilder(Long seq, LocalDateTime createAt) {
            this.seq = seq;
            this.createAt = createAt;
        }

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder passWd(String passWd) {
            this.passWd = passWd;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

}
