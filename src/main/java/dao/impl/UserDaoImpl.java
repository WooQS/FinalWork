package dao.impl;

import dao.UserDao;
import pojo.User;
import util.JDBCUtils;

import java.sql.*;

public class UserDaoImpl implements UserDao {
    @Override
    public String selectUserByUserName(String username) {
        Connection connection=null;
        Statement statement=null;
        String password = null;
        try {
            connection = JDBCUtils.getConnection();
            statement = connection.createStatement();
            String sql="select password from user where username = '"+username+"'";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                password = resultSet.getString("password");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(statement != null) {
                    statement.close();
                }
                if(connection != null) {
                    JDBCUtils.close(connection);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return password;
    }

    @Override
    public int insertUser(User user) {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement statement =null;
        int i=0;
        try {
            String sql="insert into user (username,password,email) value (?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1,user.getUsername());
            statement.setString(2,user.getPassword());
            statement.setString(3,user.getEmail());

            i= statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection != null) {
                JDBCUtils.close(connection);
            }

        }
        return i;
    }
}
