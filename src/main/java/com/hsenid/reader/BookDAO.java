package com.hsenid.reader;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Vidushka on 25/01/17.
 */
public interface BookDAO {
    void setDataSource(DataSource ds);

    List<Book> getBookList();
}
