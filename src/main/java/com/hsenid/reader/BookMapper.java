package com.hsenid.reader;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Vidushka on 27/01/17.
 */
public class BookMapper implements RowMapper<Book> {
    public Book mapRow(ResultSet resultSet, int i) throws SQLException {
        Book book = new Book();
        book.setBk_id(resultSet.getString("bk_id"));
        book.setBk_title(resultSet.getString("bk_title"));
        book.setBk_author(resultSet.getString("bk_author"));
        book.setBk_desc(resultSet.getString("bk_desc"));
        book.setBk_submiter("bk_submitter");
        book.setBk_accepter("bk_accepter");
        book.setBk_source("bk_source");
        book.setBk_status("bk_status");
        return book;
    }
}
