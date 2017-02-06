package com.hsenid.reader;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Vidushka on 25/01/17.
 */
public class BookJDBCTemplate implements BookDAO{
    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;

    public void setDataSource(DataSource ds) {
        this.dataSource = ds;
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    public List<Book> getBookList() {
        String sql = "SELECT * FROM tbl_book";
        List<Book> bl = jdbcTemplate.query(sql, new BookMapper());
        return bl;
    }
}
