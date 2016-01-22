package com.lbins.FiveChild.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.lbins.FiveChild.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.util.List;

/**
 * Created by Administrator on 2015/5/27.
 */
public class QuanPhotoAdapter extends BaseAdapter {
    private ViewHolder holder;
    private List<String> lists;
    private Context mContect;
    Resources res;

    ImageLoader imageLoader = ImageLoader.getInstance();//图片加载类
    private ImageLoadingListener animateFirstListener = new AnimateFirstDisplayListener();

    public QuanPhotoAdapter(List<String> lists, Context mContect){
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
            convertView = LayoutInflater.from(mContect).inflate(R.layout.item_photo,null);
            holder.gridview_detail_picture = (GridView) convertView.findViewById(R.id.gridview_detail_picture);
//            holder.item_title = (TextView) convertView.findViewById(R.id.item_title);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.gridview_detail_picture.setSelector(new ColorDrawable(Color.TRANSPARENT));
//        final String[] picUrls = cell.getRecordPicUrl().split(",");//图片链接切割
        final String[] picUrls = {"","","","","",""};

        holder.gridview_detail_picture.setAdapter(new ImageGridViewAdapter(picUrls, mContect));

        holder.gridview_detail_picture.setClickable(true);
        holder.gridview_detail_picture.setPressed(true);
        holder.gridview_detail_picture.setEnabled(true);
        holder.gridview_detail_picture.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(mContect, GalleryUrlActivity.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
//                intent.putExtra(Constants.IMAGE_URLS, picUrls);
//                intent.putExtra(Constants.IMAGE_POSITION, position);
//                mContext.startActivity(intent);
            }
        });
        return convertView;
    }
    class ViewHolder {
        ImageView item_pic;
        TextView item_title;
        GridView gridview_detail_picture;
    }
}
