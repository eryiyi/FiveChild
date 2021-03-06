package com.lbins.FiveChild.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.lbins.FiveChild.R;
import com.lbins.FiveChild.module.NoticeObj;
import com.lbins.FiveChild.module.SchoolDtObj;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.util.List;

/**
 * Created by Administrator on 2015/5/27.
 */
public class DongtaiAdapter extends BaseAdapter {
    private ViewHolder holder;
    private List<SchoolDtObj> lists;
    private Context mContect;
    Resources res;

    ImageLoader imageLoader = ImageLoader.getInstance();//图片加载类
    private ImageLoadingListener animateFirstListener = new AnimateFirstDisplayListener();

    public DongtaiAdapter(List<SchoolDtObj> lists, Context mContect){
        this.lists = lists;
        this.mContect = mContect;
    }
    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        res = mContect.getResources();
        if (convertView == null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(mContect).inflate(R.layout.item_record,null);
            holder.title = (TextView) convertView.findViewById(R.id.title);
            holder.dateline = (TextView) convertView.findViewById(R.id.dateline);
            holder.content = (TextView) convertView.findViewById(R.id.content);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        SchoolDtObj noticeObj = lists.get(position);
        if(noticeObj != null){
            holder.title.setText(noticeObj.getInfo());
            holder.dateline.setText(noticeObj.getDateline());
            holder.content.setText(noticeObj.getInfo());
        }
        return convertView;
    }
    class ViewHolder {
        TextView title;
        TextView dateline;
        TextView content;
    }
}
