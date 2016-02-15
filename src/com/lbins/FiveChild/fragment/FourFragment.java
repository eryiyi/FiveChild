package com.lbins.FiveChild.fragment;

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
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.lbins.FiveChild.R;
import com.lbins.FiveChild.adapter.ZhanshiAdapter;
import com.lbins.FiveChild.base.BaseFragment;
import com.lbins.FiveChild.base.InternetURL;
import com.lbins.FiveChild.data.NewsObjData;
import com.lbins.FiveChild.util.StringUtil;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/1/23.
 */
public class FourFragment extends BaseFragment implements View.OnClickListener {

    Resources res;
    View view;

    private ImageView head;
    private ImageView add;


    private ViewPager viewPager;//ҳ������
    private ImageView imageView;// ����ͼƬ
    private TextView textView1,textView2;
    private List<View> views;// Tabҳ���б�
    private int offset = 0;// ����ͼƬƫ����
    private int currIndex = 0;// ��ǰҳ�����
    private int bmpW;// ����ͼƬ���
    private View view1,view2;//����ҳ��

    private GridView gridViewOne;
    private GridView gridViewTwo;

    ZhanshiAdapter adapterOne;
    List<String> lists = new ArrayList<String>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.four_fragment, null);
        res = getActivity().getResources();
        initView();
        InitImageView();
        InitTextView();
        getData();
        return view;
    }

    private void getData() {
        StringRequest request = new StringRequest(
                Request.Method.POST,
                InternetURL.GET_SHOW_SCHOOL__URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        if (StringUtil.isJson(s)) {
                            try {
                                JSONObject jo = new JSONObject(s);
                                String code1 =  jo.getString("code");
                                if(Integer.parseInt(code1) == 200){
//                                    NewsObjData data = getGson().fromJson(s, NewsObjData.class);
//                                    lists.clear();
//                                    lists.addAll(data.getData());
//
                                }else {
                                    Toast.makeText(getActivity(), jo.getString("msg"), Toast.LENGTH_SHORT).show();
                                }

                            }catch (Exception e){
                                e.printStackTrace();
                            }
                        } else {
                            Toast.makeText(getActivity(), R.string.get_data_error, Toast.LENGTH_SHORT).show();
                        }
                        InitViewPager();
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


    void initView(){
        //
        head = (ImageView) view.findViewById(R.id.head);
        add = (ImageView) view.findViewById(R.id.add);
        head.setOnClickListener(this);
        add.setOnClickListener(this);


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

    private void InitViewPager() {
        viewPager=(ViewPager) view.findViewById(R.id.vPager);
        views=new ArrayList<View>();
        LayoutInflater inflater= getActivity().getLayoutInflater();
        view1=inflater.inflate(R.layout.layout_one, null);
        view2=inflater.inflate(R.layout.layout_two, null);
        gridViewOne = (GridView) view1.findViewById(R.id.gridView);
        gridViewTwo = (GridView) view2.findViewById(R.id.gridView);

        adapterOne = new ZhanshiAdapter(lists, getActivity());
        gridViewOne.setAdapter(adapterOne);
        gridViewTwo.setAdapter(adapterOne);

        views.add(view1);
        views.add(view2);

        viewPager.setAdapter(new MyViewPagerAdapter(views));
        viewPager.setCurrentItem(0);
        viewPager.setOnPageChangeListener(new MyOnPageChangeListener());
    }
    /**
     *  ��ʼ��ͷ��
     */

    private void InitTextView() {
        textView1 = (TextView) view.findViewById(R.id.text1);
        textView2 = (TextView) view.findViewById(R.id.text2);

        textView1.setOnClickListener(new MyOnClickListener(0));
        textView2.setOnClickListener(new MyOnClickListener(1));
    }

    /**
     2      * ��ʼ������
     3 */

    private void InitImageView() {
        imageView= (ImageView) view.findViewById(R.id.cursor);
        bmpW = BitmapFactory.decodeResource(getResources(), R.drawable.qiuzhi_line).getWidth();// ��ȡͼƬ���
        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenW = dm.widthPixels;// ��ȡ�ֱ��ʿ��
        offset = (screenW / 2 - bmpW) / 2;// ����ƫ����
        Matrix matrix = new Matrix();
        matrix.postTranslate(offset, 0);
        imageView.setImageMatrix(matrix);// ���ö�����ʼλ��
    }

    /**
     *
     * ͷ�������� 3 */
    private class MyOnClickListener implements View.OnClickListener {
        private int index=0;
        public MyOnClickListener(int i){
            index=i;
        }
        public void onClick(View v) {
            viewPager.setCurrentItem(index);
        }

    }

    public class MyViewPagerAdapter extends PagerAdapter{
        private List<View> mListViews;

        public MyViewPagerAdapter(List<View> mListViews) {
            this.mListViews = mListViews;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) 	{
            container.removeView(mListViews.get(position));
        }


        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(mListViews.get(position), 0);
            return mListViews.get(position);
        }

        @Override
        public int getCount() {
            return  mListViews.size();
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0==arg1;
        }
    }

    public class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {

        int one = offset * 2 + bmpW;// ҳ��1 -> ҳ��2 ƫ����
        int two = one * 2;// ҳ��1 -> ҳ��3 ƫ����
        public void onPageScrollStateChanged(int arg0) {


        }

        public void onPageScrolled(int arg0, float arg1, int arg2) {


        }

        public void onPageSelected(int arg0) {
			/*
			Animation animation = null;
			switch (arg0) {
			case 0:
				if (currIndex == 1) {
					animation = new TranslateAnimation(one, 0, 0, 0);
				} else if (currIndex == 2) {
					animation = new TranslateAnimation(two, 0, 0, 0);
				}
				break;
			case 1:
				if (currIndex == 0) {
					animation = new TranslateAnimation(offset, one, 0, 0);
				} else if (currIndex == 2) {
					animation = new TranslateAnimation(two, one, 0, 0);
				}
				break;
			case 2:
				if (currIndex == 0) {
					animation = new TranslateAnimation(offset, two, 0, 0);
				} else if (currIndex == 1) {
					animation = new TranslateAnimation(one, two, 0, 0);
				}
				break;

			}
			*/
            Animation animation = new TranslateAnimation(one*currIndex, one*arg0, 0, 0);
            currIndex = arg0;
            animation.setFillAfter(true);// True:ͼƬͣ�ڶ�������λ��
            animation.setDuration(300);
            imageView.startAnimation(animation);
        }

    }

}
