package com.webwork.recruitsystem.Dao;

import com.webwork.recruitsystem.Model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    public User loginQuery(User user);
    public int insertQuery(User user);
    public int updateQuery(User user);
    public User selectQuery(User uesr);
    public User[] allQuery();

}
