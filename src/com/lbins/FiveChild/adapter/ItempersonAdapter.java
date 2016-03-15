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
import com.lbins.FiveChild.module.IndexObj;
import com.lbins.FiveChild.module.PersonObj;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.util.List;

/**
 * Created by Administrator on 2015/5/27.
 */
public class ItempersonAdapter extends BaseAdapter {
    private ViewHolder holder;
    private List<PersonObj> lists;
    private Context mContect;
    Resources res;

    ImageLoader imageLoader = ImageLoader.getInstance();//图片加载类
    private ImageLoadingListener animateFirstListener = new AnimateFirstDisplayListener();

    public ItempersonAdapter(List<PersonObj> lists, Context mContect){
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
            convertView = LayoutInflater.from(mContect).inflate(R.layout.item_index_person,null);
            holder.item_pic = (ImageView) convertView.findViewById(R.id.item_pic);
            holder.item_title = (TextView) convertView.findViewById(R.id.item_title);
            holder.item_title_two = (TextView) convertView.findViewById(R.id.item_title_two);
            holder.item_tel = (TextView) convertView.findViewById(R.id.item_tel);
            holder.item_tel_two = (TextView) convertView.findViewById(R.id.item_tel_two);
            holder.item_title = (TextView) convertView.findViewById(R.id.item_title);
            holder.name = (TextView) convertView.findViewById(R.id.name);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        PersonObj cell = lists.get(position);
        if(cell != null){
            imageLoader.displayImage(InternetURL.INTERNAL + (cell.getCover() == null ? "" : cell.getCover()), holder.item_pic, UniversityApplication.txOptions, animateFirstListener);
            holder.name.setText(cell.getName());
            holder.item_tel.setText(cell.getF_mobile()==null?"暂未设定":cell.getF_mobile());
            holder.item_tel_two.setText( cell.getM_mobile()==null?"暂未设定":cell.getM_mobile());
        }
        return convertView;
    }
    class ViewHolder {
        ImageView item_pic;
        TextView item_title;
        TextView item_title_two;
        TextView item_tel;
        TextView item_tel_two;
        TextView name;
    }
}
