package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import pojo.Message;
import pojo.MessageBean;
import pojo.User;
import service.MessageService;
import service.UserService;
import util.JDBCUtils;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessageServiceImpl implements MessageService {

    @Override
    public List<Message> findById(int to_id,int page,int limit) {
        Connection connection=JDBCUtils.getConnection();
        String sql="select * from message where status=1 and to_id="+to_id+" limit "+(page-1)*limit+","+limit;
        List<Message>list=new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery(sql);
            while (set.next()) {
                Message message=new Message();
                message.setTitle(set.getString("title"));
                message.setId(Integer.parseInt(set.getString("id")));
                message.setCreate_time(set.getString("create_time"));
                list.add(message);
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return list;
    }
    //总条数
    public int count(int id) {
        Connection connection=JDBCUtils.getConnection();
        String sql="select count(*) from message where status=1 and to_id="+id;
        int count =0;
        try {
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery(sql);
            if (set.next()) {
                count=Integer.parseInt(set.getString("count(*)"));
            }
        } catch (SQLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        return count;
    }
    @Override
    public int updateStatus(int id) {
        Connection connection= JDBCUtils.getConnection();
        String sql="update message set status=2 where id="+id;
        int i=0;
        try {
            Statement statement = connection.createStatement();
            i = statement.executeUpdate(sql);
        } catch (SQLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        return i;
    }
    @Override
    public MessageBean findByMid(int id) {
        Connection connection=JDBCUtils.getConnection();
        String sql="select * from message where id="+id;
        MessageBean bean=new MessageBean();
        int from_id=0;
        try {
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery(sql);
            if (set.next()) {
                bean.setTitle(set.getString("title"));
                bean.setContent(set.getString("content"));
                bean.setCreate_time(set.getString("create_time"));
                from_id=Integer.parseInt(set.getString("from_id"));
                bean.setId(set.getInt("id"));
                bean.setFrom_id(from_id);
                bean.setTo_id(set.getInt("to_id"));
            }
        } catch (SQLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        UserService uService=new UserServiceImpl();
        User user = uService.findById(from_id);
        bean.setUsername(user.getUsername());
        return bean;
    }
    @Override
    public int insert(Message m) {
        Connection connection=JDBCUtils.getConnection();
        String sql="insert into message(from_id,title,content,to_id,status,create_time)values(?,?,?,?,?,?)";
        int i=0;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, m.getFrom_id());
            statement.setString(2, m.getTitle());
            statement.setString(3, m.getContent());
            statement.setInt(4, m.getTo_id());
            statement.setInt(5, 1);
            java.util.Date date=new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dString = format.format(date);
            statement.setString(6, dString);
            i = statement.executeUpdate();
        } catch (SQLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        return i;
    }
}
