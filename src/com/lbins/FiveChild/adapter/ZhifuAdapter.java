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
import com.lbins.FiveChild.module.FeiyongObj;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.util.List;

/**
 * Created by Administrator on 2015/5/27.
 */
public class ZhifuAdapter extends BaseAdapter {
    private ViewHolder holder;
    private List<FeiyongObj> lists;
    private Context mContect;
    Resources res;

    ImageLoader imageLoader = ImageLoader.getInstance();//图片加载类
    private ImageLoadingListener animateFirstListener = new AnimateFirstDisplayListener();

    public ZhifuAdapter(List<FeiyongObj> lists, Context mContect){
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
            convertView = LayoutInflater.from(mContect).inflate(R.layout.item_zhifu,null);
            holder.title = (TextView) convertView.findViewById(R.id.title);
            holder.heji = (TextView) convertView.findViewById(R.id.heji);
            holder.btn = (TextView) convertView.findViewById(R.id.btn);
            holder.statue = (TextView) convertView.findViewById(R.id.statue);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        FeiyongObj cell = lists.get(position);
        if(cell != null){
            holder.title.setText(cell.getTerm()==null?"":cell.getTerm());
            holder.heji.setText(mContect.getString(R.string.heji) + (cell.getTerm()==null?"":cell.getTerm()));
            if("0".equals((cell.getStatus()==null?"":cell.getStatus()))){
                holder.statue.setText(mContect.getString(R.string.statue_one));
            }else{
                holder.statue.setText(mContect.getString(R.string.statue_two));
            }
        }
        return convertView;
    }
    class ViewHolder {
        TextView heji;
        TextView title;
        TextView btn;
        TextView statue;
    }
}
