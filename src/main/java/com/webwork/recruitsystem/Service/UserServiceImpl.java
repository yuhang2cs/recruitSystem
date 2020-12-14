package com.webwork.recruitsystem.Service;

import com.webwork.recruitsystem.Dao.UserDao;
import com.webwork.recruitsystem.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public void changeAllUserLevel() {
        User[] users=userDao.allQuery();
        for(User u:users){
            int days= (int) ((new Date().getTime()-u.getRegister_time().getTime())/(1000*3600*24));
            if(days>1&&u.getUser_level()==1){
                u.setUser_level(2);
                userDao.updateLevel(u);
            }
            else if(days>90&&u.getUser_level()==2){
                u.setUser_level(3);
                userDao.updateLevel(u);
            }
        }
    }

    @Override
    public User loginQuery(User user) {
        return userDao.loginQuery(user);
    }

    @Override
    public int insertQuery(User user) {
        return userDao.insertQuery(user);
    }

    @Override
    public int updateQuery(User user) {
        return userDao.updateQuery(user);
    }

    @Override
    public User[] allQuery() {
        return userDao.allQuery();
    }

    @Override
    public User selectQuery(User user) {
        return userDao.selectQuery(user);
    }
}
