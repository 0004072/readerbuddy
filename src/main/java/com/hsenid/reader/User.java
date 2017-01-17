package com.hsenid.reader;

/**
 * Created by 0004072 on 1/16/17.
 *
 */
public class User {
    private String usr_id;
    private String usr_pass;
    private int status;

    public String getUsr_id() {
        return usr_id;
    }

    public void setUsr_id(String usr_id) {
        this.usr_id = usr_id;
    }

    public String getUsr_pass() {
        return usr_pass;
    }

    public void setUsr_pass(String usr_pass) {
        this.usr_pass = usr_pass;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
