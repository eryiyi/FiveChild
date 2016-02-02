package com.lbins.FiveChild.ui;

import android.os.Bundle;
import android.view.View;
import com.lbins.FiveChild.R;
import com.lbins.FiveChild.base.BaseActivity;

/**
 * Created by Administrator on 2016/2/2.
 */
public class NewsDetailActivity extends BaseActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mine_news_activity);

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
