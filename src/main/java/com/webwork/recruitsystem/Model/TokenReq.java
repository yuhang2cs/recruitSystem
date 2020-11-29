package com.webwork.recruitsystem.Model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class TokenReq {
    private int req_id;
    private int token_id;
    @NotNull
    @NotBlank
    private String rec_username;
    @NotNull
    @NotBlank
    private String req_username;
    private String req_desc;
    private Date created_time;
    private Date modified_time;
    private String state;

    public int getReq_id() {
        return req_id;
    }

    public void setReq_id(int req_id) {
        this.req_id = req_id;
    }

    public int getToken_id() {
        return token_id;
    }

    public void setToken_id(int token_id) {
        this.token_id = token_id;
    }

    public String getRec_username() {
        return rec_username;
    }

    public void setRec_username(String rec_username) {
        this.rec_username = rec_username;
    }

    public String getReq_username() {
        return req_username;
    }

    public void setReq_username(String req_username) {
        this.req_username = req_username;
    }

    public String getReq_desc() {
        return req_desc;
    }

    public void setReq_desc(String req_desc) {
        this.req_desc = req_desc;
    }

    public Date getCreated_time() {
        return created_time;
    }

    public void setCreated_time(Date created_time) {
        this.created_time = created_time;
    }

    public Date getModified_time() {
        return modified_time;
    }

    public void setModified_time(Date modified_time) {
        this.modified_time = modified_time;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


}
