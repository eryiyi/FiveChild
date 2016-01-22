package com.lbins.FiveChild.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import com.lbins.FiveChild.R;
import com.lbins.FiveChild.adapter.SearchNewsAdapter;
import com.lbins.FiveChild.adapter.ZhifuAdapter;
import com.lbins.FiveChild.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/1/22.
 */
public class IndexZhifuActivity extends BaseActivity implements View.OnClickListener {
    private ListView lstv;

    private List<String> lists = new ArrayList<String>();
    ZhifuAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index_mine_search_activity);
        lstv = (ListView) this.findViewById(R.id.lstv);
        lists.add("");
        lists.add("");
        lists.add("");
        lists.add("");
        lists.add("");
        lists.add("");
        adapter = new ZhifuAdapter(lists, IndexZhifuActivity.this);
        lstv.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {

    }
}
