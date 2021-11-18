package com.siliconspectra.javabatchoctoberweb.service;

import com.siliconspectra.javabatchoctoberweb.entity.User;
import com.siliconspectra.javabatchoctoberweb.repository.UserDao;
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

    public List<com.siliconspectra.javabatchoctoberweb.vo.User> getAllUser() throws SQLException {
        List<User> users = userDao.getAllUsers();
        List<com.siliconspectra.javabatchoctoberweb.vo.User> userList = new ArrayList<>();
        for (User u : users) {
            com.siliconspectra.javabatchoctoberweb.vo.User user = new com.siliconspectra.javabatchoctoberweb.vo.User();
            userList.add(userTransfer(u, user));
        }
        return userList;
    }

    public com.siliconspectra.javabatchoctoberweb.vo.User getUserById(String id) throws SQLException {
        return userTransfer(userDao.getUserById(id), new com.siliconspectra.javabatchoctoberweb.vo.User());
    }



    private com.siliconspectra.javabatchoctoberweb.vo.User userTransfer(User u1, com.siliconspectra.javabatchoctoberweb.vo.User u2) {

        u2.setId(u1.getId());
        u2.setUsername(u1.getUsername());
        return u2;
    }
}
