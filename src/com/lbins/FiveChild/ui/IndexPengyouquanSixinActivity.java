package com.lbins.FiveChild.ui;

import android.os.Bundle;
import android.view.View;
import com.lbins.FiveChild.R;
import com.lbins.FiveChild.base.BaseActivity;

/**
 * Created by Administrator on 2016/1/21.
 */
public class IndexPengyouquanSixinActivity extends BaseActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index_mine_banjiquan_sixin_activity);


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
