package com.lbins.FiveChild.ui;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import com.lbins.FiveChild.R;
import com.lbins.FiveChild.adapter.ItemindexAdapter;
import com.lbins.FiveChild.base.BaseActivity;
import com.lbins.FiveChild.module.IndexObj;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/1/21.
 */
public class IndexPengyouquanGroupActivity extends BaseActivity implements View.OnClickListener {

    private GridView grid_one;
    private ItemindexAdapter adapterIndex;
    List<IndexObj> listindex = new ArrayList<IndexObj>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index_mine_banjiquan_group_activity);

        grid_one = (GridView) this.findViewById(R.id.gridview);

        listindex.add(new IndexObj(R.drawable.head, "赵晓"));
        listindex.add(new IndexObj(R.drawable.head, "赵晓"));
        listindex.add(new IndexObj(R.drawable.head, "赵晓"));
        listindex.add(new IndexObj(R.drawable.head, "赵晓"));
        listindex.add(new IndexObj(R.drawable.head, "赵晓"));
        listindex.add(new IndexObj(R.drawable.head, "赵晓"));
        listindex.add(new IndexObj(R.drawable.head, "赵晓"));
        listindex.add(new IndexObj(R.drawable.head, "赵晓"));
        grid_one.setSelector(new ColorDrawable(Color.TRANSPARENT));
        adapterIndex = new ItemindexAdapter(listindex, IndexPengyouquanGroupActivity.this);
        grid_one.setAdapter(adapterIndex);
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
