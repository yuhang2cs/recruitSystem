package com.webwork.recruitsystem.Model;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;

public class User {
    private int user_id;
    @NotNull
    @NotBlank
    private String username;
    @NotNull
    @NotBlank
    private String password;
    //默认为0，代表用户，为1代表管理员
    private int user_type;
    private String name;
    private String cardtype;

    public String getCardtype() {
        return cardtype;
    }

    @NotNull
    private String cardnum;
    @NotNull
    private String phone;
    private int user_level;
    private String content;
    @NotNull
    private String address;
    private int age;

    public void setCardtype(String cardtype) {
        this.cardtype = cardtype;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private Date register_time;
    private Date modify_time;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
        user_level=1;
    }

    public int getUser_id() {
        return user_id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUser_type() {
        return user_type;
    }

    public void setUser_type(int user_type) {
        this.user_type = user_type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardnum() {
        return cardnum;
    }

    public void setCardnum(String cardnum) {
        this.cardnum = cardnum;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getUser_level() {
        return user_level;
    }

    public void setUser_level(int user_level) {
        this.user_level = user_level;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getRegister_time() {
        return register_time;
    }

    public void setRegister_time(Date register_time) {
        this.register_time = register_time;
    }

    public Date getModify_time() {
        return modify_time;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", user_type=" + user_type +
                ", name='" + name + '\'' +
                ", cardtype=" + cardtype +
                ", cardnum='" + cardnum + '\'' +
                ", phone='" + phone + '\'' +
                ", user_level=" + user_level +
                ", content='" + content + '\'' +
                ", address='" + address + '\'' +
                ", register_time=" + register_time +
                ", modify_time=" + modify_time +
                '}';
    }

    public void setModify_time(Date modify_time) {
        this.modify_time = modify_time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        int result=super.hashCode();
        result=31*result+username.hashCode();
        result=31*result+password.hashCode();
        return result;
    }
}
