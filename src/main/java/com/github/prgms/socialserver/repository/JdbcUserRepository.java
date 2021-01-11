package com.github.prgms.socialserver.repository;

import com.github.prgms.socialserver.domain.user.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Repository
public class JdbcUserRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcUserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<User> userRowMapper = ((resultSet, i) -> new User(
            resultSet.getLong("seq"),
            resultSet.getString("email"),
            resultSet.getString("passwd"),
            resultSet.getInt("login_count"),
            resultSet.getObject("last_login_at", LocalDateTime.class),
            resultSet.getObject("create_at", LocalDateTime.class)
    ));


    public List<User> allUserList() throws DataAccessException {
        String query = "SELECT * FROM USER";
        return jdbcTemplate.query(query, userRowMapper);
    }

    public User userInfoList(String email) throws DataAccessException{
        String query = "SELECT * FROM USER WHERE email = ?";
        return jdbcTemplate.queryForObject(query,userRowMapper,email);
    }
}
