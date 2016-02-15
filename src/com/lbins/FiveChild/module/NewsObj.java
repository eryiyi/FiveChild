package com.lbins.FiveChild.module;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/2/15.
 *  "id": "19",
 "uid": "135",
 "school_id": "5",
 "title": "明天天气不错!",
 "content": "准备带小朋友出去旅游",
 "dateline": "2015-11-20 14:38:54",
 "class_id": "69"
 */
public class NewsObj  implements Serializable{
    private String id;
    private String uid;
    private String school_id;
    private String title;
    private String content;
    private String dateline;
    private String class_id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getSchool_id() {
        return school_id;
    }

    public void setSchool_id(String school_id) {
        this.school_id = school_id;
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

    public String getDateline() {
        return dateline;
    }

    public void setDateline(String dateline) {
        this.dateline = dateline;
    }

    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }
}
