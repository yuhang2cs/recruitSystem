package com.webwork.recruitsystem.Service;

import com.webwork.recruitsystem.Model.User;

public interface UserService {
    User loginQuery(User user);
    User selectQuery(User user);
    int insertQuery(User user);
}
