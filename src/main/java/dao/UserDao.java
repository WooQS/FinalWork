package dao;

import pojo.User;

public interface UserDao {
    String selectUserByUserName(String username);
    int insertUser(User user);
}
