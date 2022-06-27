package pojo;

import java.io.Serializable;

public class Message implements Serializable {
    private Integer id;
    private Integer from_id;
    private String title;
    private String content;
    private Integer to_id;
    private Integer status;
    private String create_time;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getFrom_id() {
        return from_id;
    }
    public void setFrom_id(Integer from_id) {
        this.from_id = from_id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Integer getTo_id() {
        return to_id;
    }
    public void setTo_id(Integer to_id) {
        this.to_id = to_id;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getCreate_time() {
        return create_time;
    }
    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }
    @Override
    public String toString() {
        return "Message [id=" + id + ", from_id=" + from_id + ", title=" + title + ", content=" + content + ", to_id="
                + to_id + ", status=" + status + ", create_time=" + create_time + "]";
    }
}
