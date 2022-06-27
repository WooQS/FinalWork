package util;

import java.io.Serializable;


public class PageInfo implements Serializable {
    //当前页数
    private int page;
    //每页条数
    private int limit;
    //总条数
    private int count;
    //总页数
    private int totalPage;

    public PageInfo() {
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    @Override
    public String toString() {
        return "PageInfo [page=" + page + ", limit=" + limit + ", count=" + count + ", totalPage=" + totalPage + "]";
    }

}
