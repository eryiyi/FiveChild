package com.lbins.FiveChild.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.lbins.FiveChild.R;
import com.lbins.FiveChild.base.BaseActivity;

/**
 * Created by Administrator on 2016/2/3.
 */
public class SelectClassActivity extends BaseActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_class_activity);

        this.findViewById(R.id.xiaoban).setOnClickListener(this);
        this.findViewById(R.id.xiaoxiaoban).setOnClickListener(this);
        this.findViewById(R.id.zhongban).setOnClickListener(this);
        this.findViewById(R.id.daban).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.xiaoxiaoban:
            case R.id.xiaoban:
            case R.id.zhongban:
            case R.id.daban:
                Intent reg = new Intent(SelectClassActivity.this, RegActivity.class);
                startActivity(reg);
                finish();
                break;
        }

    }
}
