package com.github.prgms.socialserver.domain.user;

import java.time.LocalDateTime;

public class User {
    private final Long seq;
    private String email;
    private String passWd;
    private int loginCount;
    private LocalDateTime lastLoginAt;
    private final LocalDateTime createAt;

    public User(Long seq, String email, String passWd, Integer loginCount, LocalDateTime lastLoginAt, LocalDateTime createAt) {
        this.seq = seq;
        this.email = email;
        this.passWd = passWd;
        this.loginCount = loginCount;
        this.lastLoginAt = lastLoginAt;
        this.createAt = createAt;
    }

    public long getSeq() {
        return seq;
    }

    public String getEmail() {
        return email;
    }

    public String getPassWd() {
        return passWd;
    }

    public int getLoginCount() {
        return loginCount;
    }

    public LocalDateTime getLastLoginAt() {
        return lastLoginAt;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }
    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public static class UserBuilder {
        private Long seq;
        private String email;
        private String passWd;
        private int loginCount;
        private LocalDateTime lastLoginAt;
        private LocalDateTime createAt;

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }
        public UserBuilder password(String passWd) {
            this.passWd = passWd;
            return this;
        }

        public User build() {
            return new User(this);
        }

    }

    private User(UserBuilder builder) {
        this.seq = builder.seq;
        this.email = builder.email;
        this.passWd = builder.passWd;
        this.createAt = builder.createAt;
        this.loginCount = builder.loginCount;
    }

}
