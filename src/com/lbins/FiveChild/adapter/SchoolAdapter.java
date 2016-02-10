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
import com.lbins.FiveChild.base.InternetURL;
import com.lbins.FiveChild.module.SchoolObj;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.util.List;

/**
 * Created by Administrator on 2015/5/27.
 */
public class SchoolAdapter extends BaseAdapter {
    private ViewHolder holder;
    private List<SchoolObj> lists;
    private Context mContect;
    Resources res;

    ImageLoader imageLoader = ImageLoader.getInstance();//图片加载类
    private ImageLoadingListener animateFirstListener = new AnimateFirstDisplayListener();

    public SchoolAdapter(List<SchoolObj> lists, Context mContect){
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
            convertView = LayoutInflater.from(mContect).inflate(R.layout.item_school,null);
            holder.head = (ImageView) convertView.findViewById(R.id.head);
            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.address = (TextView) convertView.findViewById(R.id.address);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        SchoolObj schoolObj = lists.get(position);
        if(schoolObj != null){
            imageLoader.displayImage(InternetURL.INTERNAL+(schoolObj.getCover() == null ? "" : schoolObj.getCover()), holder.head, UniversityApplication.txOptions, animateFirstListener);
            holder.name.setText(schoolObj.getName());
            holder.address.setText("地址:"+(schoolObj.getAddress()==null?"":schoolObj.getAddress()));
        }

        return convertView;
    }
    class ViewHolder {
        ImageView head;
        TextView name;
        TextView address;
    }
}
