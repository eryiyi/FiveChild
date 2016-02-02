package com.lbins.FiveChild.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import com.lbins.FiveChild.R;
import com.lbins.FiveChild.adapter.NewsAdapter;
import com.lbins.FiveChild.adapter.VideoAdapter;
import com.lbins.FiveChild.base.BaseFragment;
import com.lbins.FiveChild.ui.NewsDetailActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/1/23.
 */
public class TwoFragment extends BaseFragment implements View.OnClickListener {

    Resources res;
    View view;

    private ImageView head;
    private ImageView add;



    private ListView lstv;
    VideoAdapter adapterOne;
    List<String> lists = new ArrayList<String>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.two_fragment, null);
        res = getActivity().getResources();
        initView();

        return view;
    }

    void initView(){
        //
        head = (ImageView) view.findViewById(R.id.head);
        add = (ImageView) view.findViewById(R.id.add);
        head.setOnClickListener(this);
        add.setOnClickListener(this);

        lists.add("");
        lists.add("");
        lists.add("");
        lists.add("");
        lists.add("");
        lists.add("");
        lists.add("");

        adapterOne = new VideoAdapter(lists, getActivity());
        lstv = (ListView) view.findViewById(R.id.lstv);
        lstv.setAdapter(adapterOne);
        lstv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Intent detailV = new Intent(getActivity(), NewsDetailActivity.class);
//                startActivity(detailV);
            }
        });

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



}
