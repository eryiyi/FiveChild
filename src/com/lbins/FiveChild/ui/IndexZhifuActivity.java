package com.lbins.FiveChild.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.lbins.FiveChild.R;
import com.lbins.FiveChild.adapter.SearchNewsAdapter;
import com.lbins.FiveChild.adapter.ZhifuAdapter;
import com.lbins.FiveChild.base.BaseActivity;
import com.lbins.FiveChild.base.InternetURL;
import com.lbins.FiveChild.data.FeiyongObjData;
import com.lbins.FiveChild.data.SchoolObjDataSingle;
import com.lbins.FiveChild.module.FeiyongObj;
import com.lbins.FiveChild.util.StringUtil;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/1/22.
 */
public class IndexZhifuActivity extends BaseActivity implements View.OnClickListener {
    private ListView lstv;

    private List<FeiyongObj> lists = new ArrayList<FeiyongObj>();
    ZhifuAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index_zhifu_activity);
        lstv = (ListView) this.findViewById(R.id.lstv);

        adapter = new ZhifuAdapter(lists, IndexZhifuActivity.this);
        lstv.setAdapter(adapter);

        this.findViewById(R.id.back).setOnClickListener(this);
        getData();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back:
                finish();
                break;
        }
    }
    void getData(){
        //
        StringRequest request = new StringRequest(
                Request.Method.POST,
                InternetURL.GET_FEE__URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        if (StringUtil.isJson(s)) {
                            try {
                                JSONObject jo = new JSONObject(s);
                                String code1 =  jo.getString("code");
                                if(Integer.parseInt(code1) == 200){
                                    FeiyongObjData data = getGson().fromJson(s, FeiyongObjData.class);
                                    lists.clear();
                                    lists.addAll(data.getData());
                                    adapter.notifyDataSetChanged();
                                }else {
                                    Toast.makeText(IndexZhifuActivity.this, jo.getString("msg"), Toast.LENGTH_SHORT).show();
                                }
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                        } else {
                            Toast.makeText(IndexZhifuActivity.this, R.string.get_data_error, Toast.LENGTH_SHORT).show();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Toast.makeText(IndexZhifuActivity.this, R.string.get_data_error, Toast.LENGTH_SHORT).show();
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("user", getGson().fromJson(getSp().getString("user", ""), String.class));
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
}
