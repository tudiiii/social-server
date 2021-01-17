package com.github.prgms.socialserver.repository;

import com.github.prgms.socialserver.domain.user.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcUserRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcUserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> allUserList() {
        String query = "SELECT * FROM USER";
        return jdbcTemplate.query(query,
                (rs, rowNum) -> User.builder()
                        .email(rs.getString("email"))
                        .passWd(rs.getString("passwd"))
                        .build());
    }

    public User userInfoList(String email){
        String query = "SELECT * FROM USER WHERE email = ?";
        return jdbcTemplate.queryForObject(query,
                (rs, rowNum) -> User.builder()
                        .email(rs.getString("email"))
                        .passWd(rs.getString("passwd"))
                        .build());

    }

    public boolean registerUser(User user){
        String query = "INSERT INTO USER (email,passwd) VALUES(?,?)";
        return  jdbcTemplate.update(query,user.getEmail(),user.getPassWd())==1;
    }
}
