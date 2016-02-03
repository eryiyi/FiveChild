package com.lbins.FiveChild.ui;

import android.os.Bundle;
import android.view.View;
import com.lbins.FiveChild.R;
import com.lbins.FiveChild.base.ActivityTack;
import com.lbins.FiveChild.base.BaseActivity;

/**
 * Created by Administrator on 2016/2/3.
 */
public class ForgetPwrActivity extends BaseActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forget_pwr_activity);


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

    public void sureForget(View view){
        ActivityTack.getInstanse().popUntilActivity(LoginActivity.class);
    }
}
