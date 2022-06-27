package service;

import pojo.Message;
import pojo.MessageBean;

import java.util.List;

public interface MessageService {
    //1.通过用户id获取
    public List<Message> findById(int to_id, int page, int limit);
    //2.查询总条数
    public int count(int id);
    //3.修改信息状态
    public int updateStatus(int id);
    //4.通过信息id查询
    public MessageBean findByMid(int id);
    //5.添加一条信息
    public int insert(Message message);
}
