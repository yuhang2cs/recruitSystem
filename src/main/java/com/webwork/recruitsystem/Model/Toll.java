package com.webwork.recruitsystem.Model;

import java.util.Date;

public class Toll {
    private int toll_id;
    private int req_id;
    private String owner_username;
    private String req_username;
    private Date date;
    private int owner_toll;
    private int req_toll;

    @Override
    public String toString() {
        return "Toll{" +
                "toll_id=" + toll_id +
                ", req_id=" + req_id +
                ", owner_username='" + owner_username + '\'' +
                ", req_username='" + req_username + '\'' +
                ", date=" + date +
                ", owner_toll=" + owner_toll +
                ", req_toll=" + req_toll +
                '}';
    }

    public int getToll_id() {
        return toll_id;
    }

    public void setToll_id(int toll_id) {
        this.toll_id = toll_id;
    }

    public int getReq_id() {
        return req_id;
    }

    public void setReq_id(int req_id) {
        this.req_id = req_id;
    }

    public String getOwner_username() {
        return owner_username;
    }

    public void setOwner_username(String owner_username) {
        this.owner_username = owner_username;
    }

    public String getReq_username() {
        return req_username;
    }

    public void setReq_username(String req_username) {
        this.req_username = req_username;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getOwner_toll() {
        return owner_toll;
    }

    public void setOwner_toll(int owner_toll) {
        this.owner_toll = owner_toll;
    }

    public int getReq_toll() {
        return req_toll;
    }

    public void setReq_toll(int req_toll) {
        this.req_toll = req_toll;
    }
}
