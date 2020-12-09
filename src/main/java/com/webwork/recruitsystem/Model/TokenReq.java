package com.webwork.recruitsystem.Model;

import java.util.Date;

public class TokenReq {
    private int req_id;
    private int token_id;
    private String owner_username;
    private String req_username;
    private String req_desc;
    private Date created_time;
    private Date modified_time;

    @Override
    public String toString() {
        return "TokenReq{" +
                "req_id=" + req_id +
                ", token_id=" + token_id +
                ", owner_username='" + owner_username + '\'' +
                ", req_username='" + req_username + '\'' +
                ", req_desc='" + req_desc + '\'' +
                ", created_time=" + created_time +
                ", modified_time=" + modified_time +
                ", state='" + state + '\'' +
                '}';
    }

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

    public String getowner_username() {
        return owner_username;
    }

    public void setowner_username(String owner_username) {
        this.owner_username = owner_username;
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
