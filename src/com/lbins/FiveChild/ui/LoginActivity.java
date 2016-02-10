package com.lbins.FiveChild.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.lbins.FiveChild.MainActivity;
import com.lbins.FiveChild.R;
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
public class LoginActivity extends BaseActivity implements View.OnClickListener {
    private EditText mobile;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        mobile = (EditText) this.findViewById(R.id.mobile);
        password = (EditText) this.findViewById(R.id.password);

        this.findViewById(R.id.reg).setOnClickListener(this);
        this.findViewById(R.id.forgetpwr).setOnClickListener(this);

        if(!StringUtil.isNullOrEmpty(getGson().fromJson(getSp().getString("user", ""), String.class))){
            mobile.setText(getGson().fromJson(getSp().getString("user", ""), String.class));
        }
        if(!StringUtil.isNullOrEmpty(getGson().fromJson(getSp().getString("password", ""), String.class))){
            password.setText(getGson().fromJson(getSp().getString("password", ""), String.class));
        }
    }

    public void sureLogin(View view){
        //登陆
        if(StringUtil.isNullOrEmpty(mobile.getText().toString())){
            showMsg(LoginActivity.this, "请输入手机号");
            return;
        }
        if(StringUtil.isNullOrEmpty(password.getText().toString())){
            showMsg(LoginActivity.this, "请输入密码");
            return;
        }
        progressDialog = new ProgressDialog(LoginActivity.this);
        progressDialog.setIndeterminate(true);
        progressDialog.show();
        loginData();
//        Intent loginV = new Intent(LoginActivity.this, MainActivity.class);
//        startActivity(loginV);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.forgetpwr:
                Intent forgetV = new Intent(LoginActivity.this, ForgetPwrActivity.class);
                startActivity(forgetV);
                break;
            case R.id.reg:
                Intent regV = new Intent(LoginActivity.this, SelectSchoolActivity.class);
                startActivity(regV);
                break;
        }
    }

    void loginData(){
        StringRequest request = new StringRequest(
                Request.Method.POST,
                InternetURL.LOGIN__URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        if (StringUtil.isJson(s)) {
                            try {
                                JSONObject jo = new JSONObject(s);
                                String code =  jo.getString("code");
                                if(Integer.parseInt(code) == 200){
                                    EmpData data = getGson().fromJson(s, EmpData.class);
                                    saveAccount(data.getData());
                                }
                                else{
                                    Toast.makeText(LoginActivity.this, jo.getString("msg"), Toast.LENGTH_SHORT).show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        if (progressDialog != null) {
                            progressDialog.dismiss();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        if (progressDialog != null) {
                            progressDialog.dismiss();
                        }
                        Toast.makeText(LoginActivity.this, "登陆失败", Toast.LENGTH_SHORT).show();
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("user", mobile.getText().toString());
                params.put("password", password.getText().toString());
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

        Intent intent  =  new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();

    }

}
