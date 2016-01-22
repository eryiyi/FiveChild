package com.lbins.FiveChild.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.lbins.FiveChild.R;
import com.lbins.FiveChild.base.BaseFragment;

/**
 * Created by Administrator on 2016/1/22.
 */
public class FiveFragment extends BaseFragment implements View.OnClickListener {
    Resources res;
    View view;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.five_fragment, null);
        res = getActivity().getResources();
        initView();

        return view;
    }

    void initView(){
        //
    }
    @Override
    public void onClick(View view) {

    }
}
