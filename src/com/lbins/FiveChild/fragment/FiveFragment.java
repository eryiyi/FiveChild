package com.lbins.FiveChild.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.lbins.FiveChild.R;
import com.lbins.FiveChild.UniversityApplication;
import com.lbins.FiveChild.adapter.AnimateFirstDisplayListener;
import com.lbins.FiveChild.base.BaseFragment;
import com.lbins.FiveChild.base.InternetURL;
import com.lbins.FiveChild.ui.*;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

/**
 * Created by Administrator on 2016/1/22.
 */
public class FiveFragment extends BaseFragment implements View.OnClickListener {
    Resources res;
    View view;

    private ImageView head;
    private TextView nickname;
    private TextView tel;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    private ImageLoadingListener animateFirstListener = new AnimateFirstDisplayListener();
    ImageLoader imageLoader = ImageLoader.getInstance();//图片加载类

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.five_fragment, null);
        res = getActivity().getResources();
        initView();

        return view;
    }

    void initView(){
        //
        view.findViewById(R.id.text_pwr).setOnClickListener(this);
        view.findViewById(R.id.text_xuefei).setOnClickListener(this);
        view.findViewById(R.id.text_jifen).setOnClickListener(this);
        view.findViewById(R.id.text_qiandao).setOnClickListener(this);
        view.findViewById(R.id.text_chengji).setOnClickListener(this);
        view.findViewById(R.id.text_biaozhang).setOnClickListener(this);
        view.findViewById(R.id.text_video).setOnClickListener(this);
        view.findViewById(R.id.text_liuyan).setOnClickListener(this);
        view.findViewById(R.id.set).setOnClickListener(this);

        head = (ImageView) view.findViewById(R.id.head);
        nickname = (TextView) view.findViewById(R.id.nickname);
        tel = (TextView) view.findViewById(R.id.tel);
        imageLoader.displayImage(InternetURL.INTERNAL+(getGson().fromJson(getSp().getString("cover", ""), String.class)), head, UniversityApplication.txOptions, animateFirstListener);
        nickname.setText("掌中宝 "+(getGson().fromJson(getSp().getString("nick_name", ""), String.class)));
        tel.setText(getGson().fromJson(getSp().getString("user", ""), String.class));
    }
    @Override
    public void onClick(View view) {
//
        switch (view.getId()) {
            case R.id.text_pwr:
            {
                //
                Intent intent = new Intent (getActivity(), MinePwrUpdateActivity.class);
                startActivity(intent);
            }
                break;
            case R.id.text_xuefei:
            {
                //
                Intent intent = new Intent (getActivity(), IndexZhifuActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.text_jifen:
            {
                //
            }
            break;
            case R.id.text_qiandao:
            {
                //
            }
            break;
            case R.id.text_chengji:
            {
                //
                Intent intent = new Intent (getActivity(), MineChengjiActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.text_biaozhang:
            {
                //
                Intent intent = new Intent (getActivity(), MineBiaozhangActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.text_video:
            {
                //
            }
            break;
            case R.id.text_liuyan:
            {
                //
                Intent intent = new Intent (getActivity(), IndexTeacherLiuyanActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.set:
            {
                Intent intent = new Intent (getActivity(), MineSetActivity.class);
                startActivity(intent);
            }
                break;
        }
    }
}
