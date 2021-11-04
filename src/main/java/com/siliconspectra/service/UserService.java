package com.siliconspectra.service;

import com.siliconspectra.dao.UserDao;
import com.siliconspectra.entity.User;

public class UserService {
    UserDao userDao = new UserDao();

    public boolean usernameValidate(String username) {
        User user = userDao.getUserByName(username);
        return user == null ? true : false;
    }
}
