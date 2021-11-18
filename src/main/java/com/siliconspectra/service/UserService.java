package com.siliconspectra.service;

import com.siliconspectra.dao.UserDao;
import com.siliconspectra.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public void updateUser(String id, User user) {
        userDao.updateUser(id, user);
    }

    public void deleteUserById(String id) {
        userDao.deleteUserById(id);
    }

    public boolean createUser(User user) {
        return userDao.createUser(user);
    }

    public List<com.siliconspectra.vo.User> getAllUser() throws SQLException {
        List<User> users = userDao.getAllUsers();
        List<com.siliconspectra.vo.User> userList = new ArrayList<>();
        for (User u : users) {
            com.siliconspectra.vo.User user = new com.siliconspectra.vo.User();
            userList.add(userTransfer(u, user));
        }
        return userList;
    }

    public com.siliconspectra.vo.User getUserById(String id) throws SQLException {
        return userTransfer(userDao.getUserById(id), new com.siliconspectra.vo.User());
    }



    private com.siliconspectra.vo.User userTransfer(User u1, com.siliconspectra.vo.User u2) {

        u2.setId(u1.getId());
        u2.setUsername(u1.getUsername());
        return u2;
    }
}
