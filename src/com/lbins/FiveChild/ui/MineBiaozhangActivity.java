package com.lbins.FiveChild.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import com.lbins.FiveChild.R;
import com.lbins.FiveChild.adapter.BiaoZhangAdapter;
import com.lbins.FiveChild.adapter.TeacherLiuYanAdapter;
import com.lbins.FiveChild.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/1/22.
 */
public class MineBiaozhangActivity extends BaseActivity implements View.OnClickListener {
    private ListView lstv;

    private List<String> lists = new ArrayList<String>();
    BiaoZhangAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mine_biaozhang_activity);
        lstv = (ListView) this.findViewById(R.id.lstv);
        lists.add("");
        lists.add("");
        lists.add("");
        lists.add("");
        lists.add("");
        lists.add("");
        adapter = new BiaoZhangAdapter(lists, MineBiaozhangActivity.this);
        lstv.setAdapter(adapter);

        this.findViewById(R.id.back).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back:
                finish();
                break;
        }
    }
}
