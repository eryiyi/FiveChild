package com.lbins.FiveChild.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.lbins.FiveChild.R;
import com.lbins.FiveChild.base.ActivityTack;
import com.lbins.FiveChild.base.BaseActivity;
import com.lbins.FiveChild.base.InternetURL;
import com.lbins.FiveChild.data.EmpData;
import com.lbins.FiveChild.module.Emp;
import com.lbins.FiveChild.util.StringUtil;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/2/3.
 */
public class RegActivity extends BaseActivity implements View.OnClickListener {
    Resources res;
    private EditText mobile;
    private EditText code;
    private EditText password;
    private EditText nickname;
    private Button btn_code;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reg_activity);

        res = getResources();

        mobile = (EditText) this.findViewById(R.id.mobile);
        code = (EditText) this.findViewById(R.id.code);
        password = (EditText) this.findViewById(R.id.password);
        nickname = (EditText) this.findViewById(R.id.nickname);
        btn_code = (Button) this.findViewById(R.id.btn_code);
        btn = (Button) this.findViewById(R.id.btn);

        btn_code.setOnClickListener(this);
        btn.setOnClickListener(this);
        this.findViewById(R.id.back).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back:
                finish();
                break;
            case R.id.btn_code:
                //验证码
                if(StringUtil.isNullOrEmpty(mobile.getText().toString())){
                    showMsg(RegActivity.this, "请输入手机号码");
                    return;
                }
                btn_code.setClickable(false);//不可点击
                MyTimer myTimer = new MyTimer(60000,1000);
                myTimer.start();
                getCard();
                break;
            case R.id.btn:
                //确定
                if(StringUtil.isNullOrEmpty(nickname.getText().toString())){
                    showMsg(RegActivity.this, "请输入昵称");
                    return;
                }if(StringUtil.isNullOrEmpty(mobile.getText().toString())){
                    showMsg(RegActivity.this, "请输入手机号码");
                    return;
                }
                if(StringUtil.isNullOrEmpty(code.getText().toString())){
                    showMsg(RegActivity.this, "请输入验证码");
                    return;
                }
                if(StringUtil.isNullOrEmpty(password.getText().toString())){
                    showMsg(RegActivity.this, "请输入密码");
                    return;
                }

                reg();
                break;
        }
    }


    void getCard(){
        StringRequest request = new StringRequest(
                Request.Method.POST,
                InternetURL.REG_SEND_CODE_URL ,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        if (StringUtil.isJson(s)) {
                            try {
                                JSONObject jo = new JSONObject(s);
                                String code =  jo.getString("code");
                                if(Integer.parseInt(code) == 200) {
//                                    Toast.makeText(Regist.this, jo.getString("msg") , Toast.LENGTH_SHORT).show();
                                }else {
                                    Toast.makeText(RegActivity.this, jo.getString("msg"), Toast.LENGTH_SHORT).show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        } else {
                            Toast.makeText(RegActivity.this, R.string.get_cart_error, Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Toast.makeText(RegActivity.this, R.string.get_cart_error, Toast.LENGTH_SHORT).show();
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("user", mobile.getText().toString());
                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Content-Type", "application/x-www-form-urlencoded");
                return params;
            }
        };
        getRequestQueue().add(request);
    }

    class MyTimer extends CountDownTimer {

        public MyTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onFinish() {
            btn_code.setText(res.getString(R.string.daojishi_three));
            btn_code.setClickable(true);//可点击
        }

        @Override
        public void onTick(long millisUntilFinished) {
            btn_code.setText(res.getString(R.string.daojishi_one) + millisUntilFinished / 1000 + res.getString(R.string.daojishi_two));
        }
    }

    void reg(){
        StringRequest request = new StringRequest(
                Request.Method.POST,
                InternetURL.REG__URL ,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        if (StringUtil.isJson(s)) {
                            try {
                                JSONObject jo = new JSONObject(s);
                                String code =  jo.getString("code");
                                if(Integer.parseInt(code) == 200) {
                                    EmpData data = getGson().fromJson(s, EmpData.class);
                                    saveAccount(data.getData());
                                    Toast.makeText(RegActivity.this, "注册成功" , Toast.LENGTH_SHORT).show();
                                    finish();
                                    //huanxin
//                                    register(data.getData());
                                }else {
                                    Toast.makeText(RegActivity.this, jo.getString("msg") , Toast.LENGTH_SHORT).show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        } else {
                            Toast.makeText(RegActivity.this, R.string.get_cart_error, Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Toast.makeText(RegActivity.this, R.string.get_cart_error, Toast.LENGTH_SHORT).show();
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("nick_name" , nickname.getText().toString());
                params.put("user" , mobile.getText().toString());
                params.put("code" , code.getText().toString());
                params.put("password" , password.getText().toString());
                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Content-Type", "application/x-www-form-urlencoded");
                return params;
            }
        };
        getRequestQueue().add(request);
    }

    public void saveAccount(Emp emp) {
        // 登陆成功，保存用户名密码
        save("id", emp.getId());
        save("nick_name", emp.getNick_name());
        save("password", password.getText().toString());
        save("user", emp.getUser());
        save("mobile", emp.getMobile());
        save("email", emp.getEmail());
        save("cover", emp.getCover());
        save("rule1_name", emp.getRule1_name());
        save("class_id", emp.getClass_id());
        save("school_id", emp.getSchool_id());
        save("rule2_name", emp.getRule2_name());
        save("f_cover", emp.getF_cover());
        save("m_cover", emp.getM_cover());
        save("group_id", emp.getGroup_id());
        save("sex", emp.getSex());
        save("state", emp.getState());
        save("one", emp.getOne());
        save("birthday", emp.getBirthday());
        save("reg_time", emp.getReg_time());
        save("last_login", emp.getLast_login());
        save("last_ip", emp.getLast_ip());
        save("access_token", emp.getAccess_token());

        save("isLogin", "1");//1已经登录了  0未登录


    }

}
