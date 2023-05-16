package com.kcraz.community.entity;

public class Page {
//    当前页码
    private int current = 1;
//    每页帖子数上限
    private int limit = 10;
//    当前页路径
    private String path;
//    总行数
    private int rows;

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        if (current >= 1) {

            this.current = current;
        }
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if (limit >= 1 && limit <= 20) {

            this.limit = limit;
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getTotal() {
        //rows / limit [+1]
        if (rows % limit == 0) {
            return rows / limit;
        } else {
            return rows / limit + 1;
        }
    }
    public int getOffset() {
        // current * limit - limit
        return (limit - 1) * current;
    }

    //获取起始页码
    public int getFrom() {
        int from = current - 2;
        return Math.max(from, 1);
    }

    //获取终止页码
    public int getTo() {
        int to = current + 2;
        return Math.min(to, getTotal());
    }
}
