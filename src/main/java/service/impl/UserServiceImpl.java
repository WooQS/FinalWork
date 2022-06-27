package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import pojo.User;
import service.UserService;
import util.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public String userLogin(String username,String password) {
        UserDao userDao = new UserDaoImpl();
        //数据库查询的密码
        String pass = userDao.selectUserByUserName(username);
        if(pass==null){
            return "登录失败";
        } else if (pass.equals(password)){
            return "登录成功";
        }else {
            return "登录失败";
        }
    }

    @Override
    public int userRegister(User user) {
        UserDao userDao = new UserDaoImpl();
        int i = userDao.insertUser(user);
        return i;
    }

    @Override
    public User findByN(String name) {
        Connection c = JDBCUtils.getConnection();
        String sql="select * from user where username='"+name+"'";
        User user=new User();
        try {
            Statement statement = c.createStatement();
            ResultSet set = statement.executeQuery(sql);
            if (set.next()) {
                user.setId(Integer.parseInt(set.getString("id")));
                user.setEmail(set.getString("email"));
                user.setPassword(set.getString("password"));
                user.setUsername(set.getString("username"));
            }
        } catch (SQLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User findById(int id) {
        Connection c = JDBCUtils.getConnection();
        String sql="select * from user where id="+id;
        User user=new User();
        try {
            Statement statement = c.createStatement();
            ResultSet set = statement.executeQuery(sql);
            if (set.next()) {
                user.setId(Integer.parseInt(set.getString("id")));
                user.setEmail(set.getString("email"));
                user.setPassword(set.getString("password"));
                user.setUsername(set.getString("username"));
            }
        } catch (SQLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<String> list() {
        Connection c = JDBCUtils.getConnection();
        String sql="select username from user";
        List<String>list=new ArrayList<String>();
        Statement statement;
        try {
            statement = c.createStatement();
            ResultSet set = statement.executeQuery(sql);
            while (set.next()) {
                list.add(set.getString("username"));
            }
        } catch (SQLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        return list;
    }
}
