package com.lbins.FiveChild.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.lbins.FiveChild.MainActivity;
import com.lbins.FiveChild.R;
import com.lbins.FiveChild.base.BaseActivity;

/**
 * Created by Administrator on 2016/2/3.
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        this.findViewById(R.id.reg).setOnClickListener(this);
        this.findViewById(R.id.forgetpwr).setOnClickListener(this);

    }

    public void sureLogin(View view){
        //登陆
        Intent loginV = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(loginV);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.forgetpwr:
                Intent forgetV = new Intent(LoginActivity.this, ForgetPwrActivity.class);
                startActivity(forgetV);
                break;
            case R.id.reg:
                Intent regV = new Intent(LoginActivity.this, SelectClassActivity.class);
                startActivity(regV);
                break;
        }
    }
}
