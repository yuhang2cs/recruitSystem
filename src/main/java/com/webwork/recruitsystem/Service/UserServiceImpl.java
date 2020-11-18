package com.webwork.recruitsystem.Service;

import com.webwork.recruitsystem.Dao.UserDao;
import com.webwork.recruitsystem.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;
    @Override
    public User loginQuery(User user) {
        return userDao.loginQuery(user);
    }

    @Override
    public int insertQuery(User user) {
        return userDao.insertQuery(user);
    }

    @Override
    public User selectQuery(User user) {
        return userDao.selectQuery(user);
    }
}
