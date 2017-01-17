package com.hsenid.reader;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by 0004072 on 1/17/17.
 */
public interface UserDAO {
    //Setting the data source
    void setDataSource(DataSource ds);

    //Create a user instance
    void createUser(String uname, String pass);

    //Get a particular user
    User getUser(String uname);

    //Get all users
    List<User> listUsers();

    //Remove a particular user
    void deleteUser(String uname);

    //Change username
    void changeUserName(String oldName, String newName);

    //Change password
    void changePassword(String uname, String oldPassword, String newPassword);
}
