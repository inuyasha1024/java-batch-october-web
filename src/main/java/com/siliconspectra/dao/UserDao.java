package com.siliconspectra.dao;

import com.siliconspectra.entity.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDao {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String URL = "jdbc:mysql://insider-referral.c6e2azieknlv.us-east-2.rds.amazonaws.com/user";
    static final String USERNAME = "admin";
    static final String PASSWORD = "jj7539518426";

    public User getUserByName(String username) {

        try {
            Class.forName(JDBC_DRIVER);
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            Statement statement = connection.createStatement();
            String sql = "select * from user where username = '" + username + "'";
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                User user = new User(rs.getString("id"), rs.getString("username"), rs.getString("password"));
                return user;
            }

            return null;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
