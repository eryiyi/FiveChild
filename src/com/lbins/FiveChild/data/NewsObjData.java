package com.lbins.FiveChild.data;

import com.lbins.FiveChild.module.NewsObj;

import java.util.List;

/**
 * Created by Administrator on 2016/2/15.
 */
public class NewsObjData extends Data {
    private List<NewsObj> data;

    public List<NewsObj> getData() {
        return data;
    }

    public void setData(List<NewsObj> data) {
        this.data = data;
    }
}
