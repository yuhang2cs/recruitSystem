package com.webwork.recruitsystem.Model;

import java.util.Date;

public class TollByToken {
    private int token_id;
    private String username;
    private String token_type;
    private String token_name;
    private String token_desc;
    private int recruit_nums;
    private int cur_recruited_nums;
    private Date recruit_end ;
    private String photo;
    private Date created_time ;
    private Date modified_time ;
    private String state;

    private int total;

    @Override
    public String toString() {
        return "TollByToken{" +
                "token_id=" + token_id +
                ", username='" + username + '\'' +
                ", token_type='" + token_type + '\'' +
                ", token_name='" + token_name + '\'' +
                ", token_desc='" + token_desc + '\'' +
                ", recruit_nums=" + recruit_nums +
                ", cur_recruited_nums=" + cur_recruited_nums +
                ", recruit_end=" + recruit_end +
                ", photo='" + photo + '\'' +
                ", created_time=" + created_time +
                ", modified_time=" + modified_time +
                ", state='" + state + '\'' +
                ", total=" + total +
                '}';
    }

    public int getToken_id() {
        return token_id;
    }

    public void setToken_id(int token_id) {
        this.token_id = token_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public String getToken_name() {
        return token_name;
    }

    public void setToken_name(String token_name) {
        this.token_name = token_name;
    }

    public String getToken_desc() {
        return token_desc;
    }

    public void setToken_desc(String token_desc) {
        this.token_desc = token_desc;
    }

    public int getRecruit_nums() {
        return recruit_nums;
    }

    public void setRecruit_nums(int recruit_nums) {
        this.recruit_nums = recruit_nums;
    }

    public int getCur_recruited_nums() {
        return cur_recruited_nums;
    }

    public void setCur_recruited_nums(int cur_recruited_nums) {
        this.cur_recruited_nums = cur_recruited_nums;
    }

    public Date getRecruit_end() {
        return recruit_end;
    }

    public void setRecruit_end(Date recruit_end) {
        this.recruit_end = recruit_end;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
