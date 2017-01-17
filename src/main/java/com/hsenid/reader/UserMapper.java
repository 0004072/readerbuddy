package com.hsenid.reader;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by hsenid on 1/17/17.
 */
public class UserMapper implements RowMapper<User> {
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setUsr_id(resultSet.getString("usr_id"));
        user.setUsr_pass(resultSet.getString("usr_pass"));
        user.setStatus(resultSet.getInt("usr_status"));
        return user;
    }
}
