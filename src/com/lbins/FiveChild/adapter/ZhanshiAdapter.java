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
import com.lbins.FiveChild.module.ShowObj;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.util.List;

/**
 * Created by Administrator on 2015/5/27.
 */
public class ZhanshiAdapter extends BaseAdapter {
    private ViewHolder holder;
    private List<ShowObj> lists;
    private Context mContect;
    Resources res;

    ImageLoader imageLoader = ImageLoader.getInstance();//图片加载类
    private ImageLoadingListener animateFirstListener = new AnimateFirstDisplayListener();

    public ZhanshiAdapter(List<ShowObj> lists, Context mContect){
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
            convertView = LayoutInflater.from(mContect).inflate(R.layout.item_grid_two,null);
            holder.pic = (ImageView) convertView.findViewById(R.id.pic);
            holder.title = (TextView) convertView.findViewById(R.id.title);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        ShowObj cell = lists.get(position);
        if(cell != null){
            //
            imageLoader.displayImage(InternetURL.INTERNAL+(cell.getPicture() == null ? "" : cell.getPicture()), holder.pic, UniversityApplication.options, animateFirstListener);
            holder.title.setText(cell.getType() + " " + cell.getChild_name() +" " +cell.getClass_name());
        }
        return convertView;
    }
    class ViewHolder {
        ImageView pic;
        TextView title;
    }
}
