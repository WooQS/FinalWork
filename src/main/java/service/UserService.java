package service;

import pojo.User;

import java.util.List;

public interface UserService {
    String userLogin(String username,String password);
    int userRegister(User user);
    User findByN(String name);
    User findById(int id);
    List<String> list();
}
