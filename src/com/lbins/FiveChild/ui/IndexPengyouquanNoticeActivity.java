package com.lbins.FiveChild.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import com.lbins.FiveChild.R;
import com.lbins.FiveChild.adapter.QuanNoticeAdapter;
import com.lbins.FiveChild.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/1/21.
 */
public class IndexPengyouquanNoticeActivity extends BaseActivity implements View.OnClickListener {
    private ListView lstv;

    private List<String> lists = new ArrayList<String>();
    private QuanNoticeAdapter adapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index_mine_banjiquan_notice_activity);
        lstv = (ListView) this.findViewById(R.id.lstv);
        lists.add("");
        lists.add("");
        lists.add("");
        lists.add("");
        lists.add("");
        lists.add("");
        adapter = new QuanNoticeAdapter(lists, IndexPengyouquanNoticeActivity.this);
        lstv.setAdapter(adapter);
    }

    public void back(View view){
        finish();
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
        }
    }
}
