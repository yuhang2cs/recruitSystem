package com.webwork.recruitsystem.Model;

import java.util.Date;

public class TollSummary {
    int id;
    Date date;
    String address;
    String token_type;
    int finish_num;
    int total;

    @Override
    public String toString() {
        return "TollSummary{" +
                "id=" + id +
                ", date=" + date +
                ", address='" + address + '\'' +
                ", token_type='" + token_type + '\'' +
                ", finish_num=" + finish_num +
                ", total=" + total +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public int getFinish_num() {
        return finish_num;
    }

    public void setFinish_num(int finish_num) {
        this.finish_num = finish_num;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
