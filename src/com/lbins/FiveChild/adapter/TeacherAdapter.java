package com.lbins.FiveChild.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.lbins.FiveChild.R;
import com.lbins.FiveChild.UniversityApplication;
import com.lbins.FiveChild.module.TeacherObj;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.util.List;

/**
 * Created by Administrator on 2015/5/27.
 */
public class TeacherAdapter extends BaseAdapter {
    private ViewHolder holder;
    private List<TeacherObj> lists;
    private Context mContect;
    Resources res;

    ImageLoader imageLoader = ImageLoader.getInstance();//图片加载类
    private ImageLoadingListener animateFirstListener = new AnimateFirstDisplayListener();

    public TeacherAdapter(List<TeacherObj> lists, Context mContect){
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
            convertView = LayoutInflater.from(mContect).inflate(R.layout.item_tearcher,null);
            holder.tel = (TextView) convertView.findViewById(R.id.tel);
            holder.title = (TextView) convertView.findViewById(R.id.title);
            holder.head = (ImageView) convertView.findViewById(R.id.head);
            holder.type = (TextView) convertView.findViewById(R.id.type);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        TeacherObj teacherObj = lists.get(position);
        if (teacherObj != null){
            holder.title.setText(teacherObj.getName());
            holder.type.setText(teacherObj.getContent());
            holder.tel.setText(teacherObj.getTel());
            imageLoader.displayImage((teacherObj.getCover() == null ? "" : teacherObj.getCover()), holder.head, UniversityApplication.txOptions, animateFirstListener);
        }
        return convertView;
    }
    class ViewHolder {
        ImageView head;
        TextView title;
        TextView type;
        TextView tel;
    }
}
