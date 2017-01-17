package com.hsenid.reader;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by 0004072 on 1/17/17.
 */
public class UserJDBCTemplate implements UserDAO {
    private DataSource ds;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource ds) {
        this.ds = ds;
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    public void createUser(String uname, String pass) {
        String sql = "INSERT INTO tbl_usr(usr_id, usr_pass, usr_status) VALUES(?, ?, 0);";
        jdbcTemplate.update(sql, uname, pass);
        System.out.println("New user created");
    }

    public User getUser(String uname) {
        String sql = "SELECT * FROM tbl_usr WHERE usr_id = ?;";
        User user = null;
        try {
            user = jdbcTemplate.queryForObject(sql, new Object[]{uname}, new UserMapper());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return user;
    }

    public List<User> listUsers() {
        String sql = "SELECT * FROM tbl_usr;";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
    }

    public void deleteUser(String uname) {
        String sql = "UPDATE tbl_usr SET usr_status = -1 WHERE usr_id = ?";
        try {
            jdbcTemplate.update(sql, uname);
            System.out.println("Successfully deleted");
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    public void changeUserName(String oldName, String newName) {
        String sql = "UPDATE tbl_usr SET usr_id = ? WHERE usr_id = ?;";
        try {
            jdbcTemplate.update(sql, oldName, newName);
            System.out.println("Successfully updated");
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    public void changePassword(String uname, String oldPassword, String newPassword) {
        User user = getUser(uname);
        if (user != null) {
            if (user.getUsr_pass().equals(oldPassword)) {
                String sql = "UPDATE tbl_usr SET usr_pass = ? WHERE usr_id = ?;";
                try {
                    jdbcTemplate.update(sql, uname, newPassword);
                    System.out.println("Password has been successfully changed!");
                } catch (DataAccessException e) {
                    e.printStackTrace();
                }
            } else {
                //Invalid old password
                System.out.println("Invalid old password!");
            }
        }
    }
}
