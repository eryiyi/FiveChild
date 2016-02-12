package com.lbins.FiveChild.fragment;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.lbins.FiveChild.R;
import com.lbins.FiveChild.UniversityApplication;
import com.lbins.FiveChild.adapter.AnimateFirstDisplayListener;
import com.lbins.FiveChild.adapter.ItemindexAdapter;
import com.lbins.FiveChild.adapter.OnClickContentItemListener;
import com.lbins.FiveChild.adapter.ViewPagerAdapter;
import com.lbins.FiveChild.base.BaseFragment;
import com.lbins.FiveChild.base.InternetURL;
import com.lbins.FiveChild.data.SlidePicData;
import com.lbins.FiveChild.module.IndexObj;
import com.lbins.FiveChild.module.SlidePic;
import com.lbins.FiveChild.ui.*;
import com.lbins.FiveChild.util.StringUtil;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/1/20.
 */
public class FirstFragment extends BaseFragment implements View.OnClickListener ,OnClickContentItemListener {
    private final static int SCANNIN_GREQUEST_CODE = 1;
    private ImageLoadingListener animateFirstListener = new AnimateFirstDisplayListener();
    ImageLoader imageLoader = ImageLoader.getInstance();//图片加载类

    //导航
    private ViewPager viewpager;
    private ViewPagerAdapter adapter;
    private LinearLayout viewGroup;
    private ImageView dot, dots[];
    private Runnable runnable;
    private int autoChangeTime = 5000;
    private List<SlidePic> lists = new ArrayList<SlidePic>();
    Resources res;
    View view;

    private GridView grid_one;
    private ItemindexAdapter adapterIndex;
    List<IndexObj> listindex = new ArrayList<IndexObj>();

    private ImageView head;
    public ProgressDialog progressDialog;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.one_fragment, null);
        res = getActivity().getResources();
        initView(view);

        getAd();
        return view;
    }

    void initView(View view){
        listindex.add(new IndexObj(R.drawable.index_icon_one, "校区信息"));
        listindex.add(new IndexObj(R.drawable.index_icon_two, "教师介绍"));
//        listindex.add(new IndexObj(R.drawable.index_icon_three, "活跃度"));
        listindex.add(new IndexObj(R.drawable.index_icon_four, "查询"));
        listindex.add(new IndexObj(R.drawable.index_icon_five, "班级圈"));
        listindex.add(new IndexObj(R.drawable.index_icon_six, "费用支付"));
        listindex.add(new IndexObj(R.drawable.index_icon_seven, "我的积分"));

        view.findViewById(R.id.sign).setOnClickListener(this);

        grid_one = (GridView) view.findViewById(R.id.grid_one);
        grid_one.setSelector(new ColorDrawable(Color.TRANSPARENT));
        adapterIndex = new ItemindexAdapter(listindex, getActivity());
        grid_one.setAdapter(adapterIndex);
        grid_one.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //
                switch (i){
                    case 0:
                    {
                        //校区信息
                        Intent xqV = new Intent(getActivity(), IndexXiaoquActivity.class);
                        startActivity(xqV);
                    }
                        break;
                    case 1:
                    {
                        //教师介绍
                        Intent banjiquanV = new Intent(getActivity(), IndexTearchActivity.class);
                        startActivity(banjiquanV);
                    }
                        break;
//                    case 2:
//                    {
//                        //活跃度
//                    }
//                    break;
                    case 2:
                    {
                        //查询
                        Intent banjiquanV = new Intent(getActivity(), IndexSearchActivity.class);
                        startActivity(banjiquanV);
                    }
                    break;
                    case 3:
                    {
                        //班级圈
                        Intent banjiquanV = new Intent(getActivity(), IndexPengyouquanActivity.class);
                        startActivity(banjiquanV);
                    }
                    break;
                    case 4:
                    {
                        //费用支付
                        Intent banjiquanV = new Intent(getActivity(), IndexZhifuActivity.class);
                        startActivity(banjiquanV);
                    }
                    break;
                    case 5:
                    {
                        //我的积分
                        Intent banjiquanV = new Intent(getActivity(), IndexJifenActivity.class);
                        startActivity(banjiquanV);
                    }
                    break;
                }
            }
        });

        head = (ImageView) view.findViewById(R.id.head);
        imageLoader.displayImage(InternetURL.INTERNAL+(getGson().fromJson(getSp().getString("cover", ""), String.class)), head, UniversityApplication.txOptions, animateFirstListener);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.sign:
                //签到
                progressDialog = new ProgressDialog(getActivity());
                progressDialog.setIndeterminate(true);
                progressDialog.show();
                sign();
                break;
        }
    }


    /**
     * 获取首页
     */
    private void getAd() {
        StringRequest request = new StringRequest(
                Request.Method.POST,
                InternetURL.GET_AD__URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        if (StringUtil.isJson(s)) {
                            try {
                                JSONObject jo = new JSONObject(s);
                                String code1 =  jo.getString("code");
                                if(Integer.parseInt(code1) == 200){
                                    SlidePicData data = getGson().fromJson(s, SlidePicData.class);
                                    lists.clear();
                                    lists.addAll(data.getData());
                                    initViewPager();
                                }else {
                                    Toast.makeText(getActivity(), jo.getString("msg"), Toast.LENGTH_SHORT).show();
                                }
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                        } else {
                            Toast.makeText(getActivity(), R.string.get_data_error, Toast.LENGTH_SHORT).show();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Toast.makeText(getActivity(), R.string.get_data_error, Toast.LENGTH_SHORT).show();
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Content-Type", "application/x-www-form-urlencoded");
                return params;
            }
        };
        getRequestQueue().add(request);
    }

    private void initViewPager() {
        adapter = new ViewPagerAdapter(getActivity());
        adapter.change(lists);
        adapter.setOnClickContentItemListener(this);
        viewpager = (ViewPager) view.findViewById(R.id.viewpager);
        viewpager.setAdapter(adapter);
        viewpager.setOnPageChangeListener(myOnPageChangeListener);
        initDot();
        runnable = new Runnable() {
            @Override
            public void run() {
                int next = viewpager.getCurrentItem() + 1;
                if (next >= adapter.getCount()) {
                    next = 0;
                }
                viewHandler.sendEmptyMessage(next);
            }
        };
        viewHandler.postDelayed(runnable, autoChangeTime);
    }


    // 初始化dot视图
    private void initDot() {
        viewGroup = (LinearLayout) view.findViewById(R.id.viewGroup);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                20, 20);
        layoutParams.setMargins(4, 3, 4, 3);

        dots = new ImageView[adapter.getCount()];
        for (int i = 0; i < adapter.getCount(); i++) {

            dot = new ImageView(getActivity());
            dot.setLayoutParams(layoutParams);
            dots[i] = dot;
            dots[i].setTag(i);
            dots[i].setOnClickListener(onClick);

            if (i == 0) {
                dots[i].setBackgroundResource(R.drawable.dotc);
            } else {
                dots[i].setBackgroundResource(R.drawable.dotn);
            }

            viewGroup.addView(dots[i]);
        }
    }

    ViewPager.OnPageChangeListener myOnPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageScrollStateChanged(int arg0) {
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageSelected(int arg0) {
            setCurDot(arg0);
            viewHandler.removeCallbacks(runnable);
            viewHandler.postDelayed(runnable, autoChangeTime);
        }

    };
    // 实现dot点击响应功能,通过点击事件更换页面
    View.OnClickListener onClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int position = (Integer) v.getTag();
            setCurView(position);
        }

    };

    /**
     * 设置当前的引导页
     */
    private void setCurView(int position) {
        if (position < 0 || position > adapter.getCount()) {
            return;
        }
        viewpager.setCurrentItem(position);
//        if (!StringUtil.isNullOrEmpty(lists.get(position).getNewsTitle())){
//            titleSlide = lists.get(position).getNewsTitle();
//            if(titleSlide.length() > 13){
//                titleSlide = titleSlide.substring(0,12);
//                article_title.setText(titleSlide);//当前新闻标题显示
//            }else{
//                article_title.setText(titleSlide);//当前新闻标题显示
//            }
//        }

    }

    /**
     * 选中当前引导小点
     */
    private void setCurDot(int position) {
        for (int i = 0; i < dots.length; i++) {
            if (position == i) {
                dots[i].setBackgroundResource(R.drawable.dotc);
            } else {
                dots[i].setBackgroundResource(R.drawable.dotn);
            }
        }
    }

    /**
     * 每隔固定时间切换广告栏图片
     */
    @SuppressLint("HandlerLeak")
    private final Handler viewHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            setCurView(msg.what);
        }

    };

//    SlidePic slidePic;
    @Override
    public void onClickContentItem(int position, int flag, Object object) {
//        slidePic = lists.get(position);
        switch (flag){
            case 0:
//                Intent webView = new Intent(getActivity(), WebViewActivity.class);
//                webView.putExtra("strurl", slidePic.getHref_url());
//                startActivity(webView);
                break;
        }
    }


    private void sign() {
        StringRequest request = new StringRequest(
                Request.Method.POST,
                InternetURL.GET_SIGN__URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        if (StringUtil.isJson(s)) {
                            try {
                                JSONObject jo = new JSONObject(s);
                                String code1 =  jo.getString("code");
                                if(Integer.parseInt(code1) == 200){
                                    Toast.makeText(getActivity(), jo.getString("msg"), Toast.LENGTH_SHORT).show();
                                }else {
                                    Toast.makeText(getActivity(), jo.getString("msg"), Toast.LENGTH_SHORT).show();
                                }
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                        } else {
                            Toast.makeText(getActivity(), R.string.get_data_error, Toast.LENGTH_SHORT).show();
                        }
                        if (progressDialog != null) {
                            progressDialog.dismiss();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        if (progressDialog != null) {
                            progressDialog.dismiss();
                        }
                        Toast.makeText(getActivity(), R.string.get_data_error, Toast.LENGTH_SHORT).show();
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("user", getGson().fromJson(getSp().getString("user", ""), String.class));
                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Content-Type", "application/x-www-form-urlencoded");
                return params;
            }
        };
        getRequestQueue().add(request);
    }

}
