package test;

import util.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
    public static void main(String[] args) {
        Connection connection = JDBCUtils.getConnection();
        try {
            Statement statement = connection.createStatement();
            String sql = "select password from user where username = '573'";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                String password = resultSet.getString("password");
                System.out.println(password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
