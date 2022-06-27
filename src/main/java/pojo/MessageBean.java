package pojo;

public class MessageBean {
    private int id;
    private int from_id;
    private int to_id;
    private String title;
    private String username;
    private String create_time;
    private String content;
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getCreate_time() {
        return create_time;
    }
    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getFrom_id() {
        return from_id;
    }
    public void setFrom_id(int from_id) {
        this.from_id = from_id;
    }
    public int getTo_id() {
        return to_id;
    }
    public void setTo_id(int to_id) {
        this.to_id = to_id;
    }
    @Override
    public String toString() {
        return "MessageBean [id=" + id + ", from_id=" + from_id + ", to_id=" + to_id + ", title=" + title
                + ", username=" + username + ", create_time=" + create_time + ", content=" + content + "]";
    }

}
