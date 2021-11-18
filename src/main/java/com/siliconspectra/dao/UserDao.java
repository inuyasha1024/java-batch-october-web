package com.siliconspectra.dao;

import com.siliconspectra.demo.Config;
import com.siliconspectra.entity.User;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao {

    public void updateUser(String id, User user) {
        String sql = "UPDATE user " +
                "SET username = '"+user.getUsername()+"', password = '"+user.getPassword()+"'" +
                "WHERE id='" + id + "';";
        execute(sql);
    }

    public void deleteUserById(String id) {
        String sql = "delete from user where id ='" + id+ "'";
        execute(sql);
    }

    public List<User> getAllUsers() throws SQLException {
        String sql = "select * from user";
        ResultSet resultSet = query(sql);
        List<User> users = new ArrayList<>();
        if (resultSet == null) {
            return users;
        }
        while (resultSet.next()) {
            User user = new User(resultSet.getString("id"),
                    resultSet.getString("username"),resultSet.getString("password"));
            users.add(user);
        }
        return users;
    }

    public User getUserById(String id) throws SQLException {
        String sql = "select * from user where id='" + id + "'";
        ResultSet resultSet = query(sql);
        if (resultSet == null) {
            return new User();
        }
        while (resultSet.next()) {
            User user = new User(resultSet.getString("id"),
                    resultSet.getString("username"),resultSet.getString("password"));
            return user;
        }
        return new User();
    }

    public boolean createUser(User user) {
        String sql = "INSERT INTO user (username, password) " +
                "VALUES ('" + user.getUsername()+"', '"+user.getPassword()+"');";
        return execute(sql);
    }



    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String URL = "jdbc:mysql://insider-referral.c6e2azieknlv.us-east-2.rds.amazonaws.com/user";
    static final String USERNAME = "admin";
    static final String PASSWORD = "jj7539518426";

    public ResultSet query(String sql) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);
            System.out.println(rs);
            return rs;
        }catch (Exception e) {
            return null;
        }finally {
//            connection.close();
//            statement.close();
        }
    }

    public boolean execute(String sql) {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.createStatement();
            boolean rs = statement.execute(sql);
            return rs;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally {
//            connection.close();
//            statement.close();
        }
    }

}
