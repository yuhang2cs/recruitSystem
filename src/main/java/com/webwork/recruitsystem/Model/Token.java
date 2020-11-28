package com.webwork.recruitsystem.Model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class Token {
    private int token_id;
    private int user_id;
    @NotNull
    @NotBlank
    private String username;
    @NotNull
    private String token_type;
    @NotBlank
    @NotNull
    private String token_name;
    private String token_desc;
    private int recruit_number;
    private int cur_recruit;
    private Date recruit_end ;

    @Override
    public String toString() {
        return "Token{" +
                "token_id=" + token_id +
                ", user_id=" + user_id +
                ", username='" + username + '\'' +
                ", token_type='" + token_type + '\'' +
                ", token_name='" + token_name + '\'' +
                ", token_desc='" + token_desc + '\'' +
                ", recruit_number=" + recruit_number +
                ", cur_recruit=" + cur_recruit +
                ", recruit_end=" + recruit_end +
                ", photo='" + photo + '\'' +
                ", created_time=" + created_time +
                ", modified_time=" + modified_time +
                ", state='" + state + '\'' +
                '}';
    }

    public int getCur_recruit() {
        return cur_recruit;
    }

    public void setCur_recruit(int cur_recruit) {
        this.cur_recruit = cur_recruit;
    }

    private String photo;
    @NotNull
    private Date created_time ;
    private Date modified_time ;
    @NotNull
    private String state;

    public int getToken_id() {
        return token_id;
    }

    public void setToken_id(int recruit_id) {
        this.token_id = recruit_id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getUser_id() {
        return user_id;
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

    public int getRecruit_number() {
        return recruit_number;
    }

    public void setRecruit_number(int recruit_number) {
        this.recruit_number = recruit_number;
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

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
