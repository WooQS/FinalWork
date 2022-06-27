package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtils {


    private final static String URL="jdbc:mysql://localhost:3306/test?characterEncoding=utf-8&useSSL=false";
    private final static String USERNAME="root";
    private final static String PASSWORD="";
    //加载驱动
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
            System.out.println("zheli ");
        }
    }
    //创建连接
    public static Connection getConnection() {
        Connection connection=null;
        try {
            connection=DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        return connection;
    }
    //关闭连接
    public static void close(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
    }
}
