package com.lbins.FiveChild.module;

/**
 * Created by Administrator on 2016/1/20.
 */
public class IndexObj {
    private int id;
    private String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public IndexObj(int id, String title) {
        this.id = id;
        this.title = title;
    }
}
