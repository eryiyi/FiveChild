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
import com.lbins.FiveChild.adapter.ItempersonAdapter;
import com.lbins.FiveChild.base.BaseActivity;
import com.lbins.FiveChild.base.InternetURL;
import com.lbins.FiveChild.data.PersonObjData;
import com.lbins.FiveChild.data.SlidePicData;
import com.lbins.FiveChild.module.PersonObj;
import com.lbins.FiveChild.util.StringUtil;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/1/21.
 */
public class IndexPengyouquanPersonActivity extends BaseActivity implements View.OnClickListener {
    private ListView lstv;
    private List<PersonObj> lists = new ArrayList<PersonObj>();

    ItempersonAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index_mine_banjiquan_person_activity);

        lstv = (ListView) this.findViewById(R.id.lstv);
        adapter = new ItempersonAdapter(lists, IndexPengyouquanPersonActivity.this);
        lstv.setAdapter(adapter);

        this.findViewById(R.id.back).setOnClickListener(this);
//        PersonObjData
        getAd();
    }

    private void getAd() {
        StringRequest request = new StringRequest(
                Request.Method.POST,
                InternetURL.GET_CLASS_CONTACT__URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        if (StringUtil.isJson(s)) {
                            try {
                                JSONObject jo = new JSONObject(s);
                                String code1 =  jo.getString("code");
                                if(Integer.parseInt(code1) == 200){
                                    PersonObjData data = getGson().fromJson(s, PersonObjData.class);
                                    lists.clear();
                                    lists.addAll(data.getData());
                                    adapter.notifyDataSetChanged();
                                }else {
                                    Toast.makeText(IndexPengyouquanPersonActivity.this, jo.getString("msg"), Toast.LENGTH_SHORT).show();
                                }
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                        } else {
                            Toast.makeText(IndexPengyouquanPersonActivity.this, R.string.get_data_error, Toast.LENGTH_SHORT).show();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Toast.makeText(IndexPengyouquanPersonActivity.this, R.string.get_data_error, Toast.LENGTH_SHORT).show();
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("class_id", getGson().fromJson(getSp().getString("class_id", ""), String.class));
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


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                finish();
                break;
        }
    }
}
