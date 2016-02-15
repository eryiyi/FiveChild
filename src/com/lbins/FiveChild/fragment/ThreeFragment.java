package com.lbins.FiveChild.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.*;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.lbins.FiveChild.R;
import com.lbins.FiveChild.adapter.NewsAdapter;
import com.lbins.FiveChild.adapter.OnClickContentItemListener;
import com.lbins.FiveChild.adapter.ZhanshiAdapter;
import com.lbins.FiveChild.base.BaseFragment;
import com.lbins.FiveChild.base.InternetURL;
import com.lbins.FiveChild.data.NewsObjData;
import com.lbins.FiveChild.data.SlidePicData;
import com.lbins.FiveChild.module.NewsObj;
import com.lbins.FiveChild.ui.NewsDetailActivity;
import com.lbins.FiveChild.util.StringUtil;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/1/23.
 */
public class ThreeFragment extends BaseFragment implements View.OnClickListener,OnClickContentItemListener {

    Resources res;
    View view;

    private ImageView head;
    private ImageView add;

    private ListView lstv;
    NewsAdapter adapterOne;
    List<NewsObj> lists = new ArrayList<NewsObj>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.three_fragment, null);
        res = getActivity().getResources();
        initView();
        getData();
        return view;
    }

    void initView(){
        //
        head = (ImageView) view.findViewById(R.id.head);
        add = (ImageView) view.findViewById(R.id.add);
        head.setOnClickListener(this);
        add.setOnClickListener(this);

        adapterOne = new NewsAdapter(lists, getActivity());
        adapterOne.setOnClickContentItemListener(this);
        lstv = (ListView) view.findViewById(R.id.lstv);
        lstv.setAdapter(adapterOne);
        lstv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent detailV = new Intent(getActivity(), NewsDetailActivity.class);
                NewsObj newsObj = lists.get(i);
                detailV.putExtra("news", newsObj);
                startActivity(detailV);
            }
        });

    }

    private void getData() {
        StringRequest request = new StringRequest(
                Request.Method.POST,
                InternetURL.GET_NEWS_SCHOOL__URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        if (StringUtil.isJson(s)) {
                            try {
                                JSONObject jo = new JSONObject(s);
                                String code1 =  jo.getString("code");
                                if(Integer.parseInt(code1) == 200){
                                    NewsObjData data = getGson().fromJson(s, NewsObjData.class);
                                    lists.clear();
                                    lists.addAll(data.getData());
                                    adapterOne.notifyDataSetChanged();
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
                params.put("school_id", getGson().fromJson(getSp().getString("school_id", ""), String.class));
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


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.add:
            {
                //对号
            }
                break;
            case R.id.head:
            {
                //头像
            }
                break;
        }
    }


    @Override
    public void onClickContentItem(int position, int flag, Object object) {
        switch (flag){
            case 1:
                //
                Intent detailV = new Intent(getActivity(), NewsDetailActivity.class);
                NewsObj newsObj = lists.get(position);
                detailV.putExtra("news", newsObj);
                startActivity(detailV);
                break;
        }
    }
}
