package com.lbins.FiveChild;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.*;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.lbins.FiveChild.adapter.AnimateFirstDisplayListener;
import com.lbins.FiveChild.base.BaseActivity;
import com.lbins.FiveChild.base.InternetURL;
import com.lbins.FiveChild.data.MemberObjData;
import com.lbins.FiveChild.fragment.*;
import com.lbins.FiveChild.module.MemberObj;
import com.lbins.FiveChild.util.StringUtil;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity  extends BaseActivity implements View.OnClickListener{

    ImageLoader imageLoader = ImageLoader.getInstance();//图片加载类
    private ImageLoadingListener animateFirstListener = new AnimateFirstDisplayListener();

    private FragmentTransaction fragmentTransaction;
    private FragmentManager fm;

    private FirstFragment oneFragment;
    private TwoFragment twoFragment;
    private ThreeFragment threeFragment;
    private FourFragment fourFragment;
    private FiveFragment fiveFragment;

    private ImageView foot_one;
    private ImageView foot_two;
    private ImageView foot_three;
    private ImageView foot_four;
    private ImageView foot_five;

    private long waitTime = 2000;
    private long touchTime = 0;

    //设置底部图标
    Resources res;

    private int index;
    // 当前fragment的index
    private int currentTabIndex = 0;
//    private MemberObj memberObj;


    protected static final String TAG = "MainActivity";
    // 账号在别处登录
    public boolean isConflict = false;
    public static  int tmpVisible = 0;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        res = getResources();
        fm = getSupportFragmentManager();
        initView();

        switchFragment(R.id.relate_one);

        getMember();


    }


    @Override
    public void onClick(View v) {
        switchFragment(v.getId());
    }

    private void initView() {
        foot_one = (ImageView) this.findViewById(R.id.foot_one);
        foot_two = (ImageView) this.findViewById(R.id.foot_two);
        foot_three = (ImageView) this.findViewById(R.id.foot_three);
        foot_four = (ImageView) this.findViewById(R.id.foot_four);
        foot_five = (ImageView) this.findViewById(R.id.foot_five);


        this.findViewById(R.id.relate_one).setOnClickListener(this);
        this.findViewById(R.id.relate_two).setOnClickListener(this);
        this.findViewById(R.id.relate_three).setOnClickListener(this);
        this.findViewById(R.id.relate_four).setOnClickListener(this);
        this.findViewById(R.id.relate_five).setOnClickListener(this);
    }


    public void switchFragment(int id) {
        fragmentTransaction = fm.beginTransaction();
        hideFragments(fragmentTransaction);
        switch (id) {
            case R.id.relate_one:
                if (oneFragment == null) {
                    oneFragment = new FirstFragment();
                    fragmentTransaction.add(R.id.content_frame, oneFragment);
                } else {
                    fragmentTransaction.show(oneFragment);
                }
                currentTabIndex = 0;
//                foot_one.setImageResource(R.drawable.foot_one_white);
//                foot_two.setImageResource(R.drawable.foot_two_red);
//                foot_three.setImageResource(R.drawable.foot_three_red);
//                foot_four.setImageResource(R.drawable.foot_four_red);
//                foot_five.setImageResource(R.drawable.foot_five_red);

                break;
            case R.id.relate_two:
                if (twoFragment == null) {
                    twoFragment = new TwoFragment();
                    fragmentTransaction.add(R.id.content_frame, twoFragment);
                } else {
                    fragmentTransaction.show(twoFragment);
                }

                currentTabIndex = 1;
                foot_one.setImageResource(R.drawable.bottom_icon_one);
                foot_two.setImageResource(R.drawable.bottom_icon_two_p);
                foot_three.setImageResource(R.drawable.bottom_icon_three);
                foot_four.setImageResource(R.drawable.bottom_icon_four);
                foot_five.setImageResource(R.drawable.bottom_icon_five);
                break;
            case R.id.relate_three:
                if (threeFragment == null) {
                    threeFragment = new ThreeFragment();
                    fragmentTransaction.add(R.id.content_frame, threeFragment);
                } else {
                    fragmentTransaction.show(threeFragment);
                }
                currentTabIndex = 3;
                foot_one.setImageResource(R.drawable.bottom_icon_one);
                foot_two.setImageResource(R.drawable.bottom_icon_two);
                foot_three.setImageResource(R.drawable.bottom_icon_three_p);
                foot_four.setImageResource(R.drawable.bottom_icon_four);
                foot_five.setImageResource(R.drawable.bottom_icon_five);

//                foot_one.setImageResource(R.drawable.foot_one_red);
//                foot_two.setImageResource(R.drawable.foot_two_red);
//                foot_three.setImageResource(R.drawable.foot_three_white);
//                foot_four.setImageResource(R.drawable.foot_four_red);
//                foot_five.setImageResource(R.drawable.foot_five_red);
                break;
            case R.id.relate_four:
                if (fourFragment == null) {
                    fourFragment = new FourFragment();
                    fragmentTransaction.add(R.id.content_frame, fourFragment);
                } else {
                    fragmentTransaction.show(fourFragment);
                }
                currentTabIndex = 4;
                foot_one.setImageResource(R.drawable.bottom_icon_one);
                foot_two.setImageResource(R.drawable.bottom_icon_two);
                foot_three.setImageResource(R.drawable.bottom_icon_three);
                foot_four.setImageResource(R.drawable.bottom_icon_four_p);
                foot_five.setImageResource(R.drawable.bottom_icon_five);
                break;
            case R.id.relate_five:
                if (fiveFragment == null) {
                    fiveFragment = new FiveFragment();
                    fragmentTransaction.add(R.id.content_frame, fiveFragment);
                } else {
                    fragmentTransaction.show(fiveFragment);
                }
                currentTabIndex = 4;
                foot_one.setImageResource(R.drawable.bottom_icon_one);
                foot_two.setImageResource(R.drawable.bottom_icon_two);
                foot_three.setImageResource(R.drawable.bottom_icon_three);
                foot_four.setImageResource(R.drawable.bottom_icon_four);
                foot_five.setImageResource(R.drawable.bottom_icon_five_p);
                break;

        }
        fragmentTransaction.commit();
    }

    private void hideFragments(FragmentTransaction ft) {
        if (oneFragment != null) {
            ft.hide(oneFragment);
        }
        if (twoFragment != null) {
            ft.hide(twoFragment);
        }
        if (threeFragment != null) {
            ft.hide(threeFragment);
        }
        if (fourFragment != null) {
            ft.hide(fourFragment);
        }
        if (fiveFragment != null) {
            ft.hide(fiveFragment);
        }
    }


    //再摁退出程序
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        PackageManager pm = getPackageManager();
//        ResolveInfo homeInfo =
//                pm.resolveActivity(new Intent(Intent.ACTION_MAIN).addCategory(Intent.CATEGORY_HOME), 0);
//        if (keyCode == KeyEvent.KEYCODE_BACK) {
//            ActivityInfo ai = homeInfo.activityInfo;
//            Intent startIntent = new Intent(Intent.ACTION_MAIN);
//            startIntent.addCategory(Intent.CATEGORY_LAUNCHER);
//            startIntent.setComponent(new ComponentName(ai.packageName, ai.name));
//            startActivitySafely(startIntent);
//            return true;
//        } else
//            return super.onKeyDown(keyCode, event);
//    }

//    private void startActivitySafely(Intent intent) {
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        try {
//            startActivity(intent);
//        } catch (ActivityNotFoundException e) {
//            Toast.makeText(this, "null",
//                    Toast.LENGTH_SHORT).show();
//        } catch (SecurityException e) {
//            Toast.makeText(this, "null",
//                    Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    void logout() {
//        final ProgressDialog pd = new ProgressDialog(this);
//        String st = getResources().getString(R.string.Are_logged_out);
//        // 重新显示登陆页面
//        finish();
//    }
//
//
//
//    // 账号被移除
//    private boolean isCurrentAccountRemoved = false;
//
//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        outState.putBoolean("isConflict", isConflict);
//        outState.putBoolean(Constant.ACCOUNT_REMOVED, isCurrentAccountRemoved);
//        super.onSaveInstanceState(outState);
//    }
//    /**
//     * 检查当前用户是否被删除
//     */
//    public boolean getCurrentAccountRemoved() {
//        return isCurrentAccountRemoved;
//    }
//
//
//    private android.app.AlertDialog.Builder conflictBuilder;
//    private android.app.AlertDialog.Builder accountRemovedBuilder;
//    private boolean isConflictDialogShow;
//    private boolean isAccountRemovedDialogShow;
//    private BroadcastReceiver internalDebugReceiver;
//
//    /**
//     * 显示帐号在别处登录dialog
//     */
//    private void showConflictDialog() {
//        isConflictDialogShow = true;
//        DemoHXSDKHelper.getInstance().logout(false,null);
//        String st = getResources().getString(R.string.Logoff_notification);
//        if (!MainActivity.this.isFinishing()) {
//            // clear up global variables
//            try {
//                if (conflictBuilder == null)
//                    conflictBuilder = new android.app.AlertDialog.Builder(MainActivity.this);
//                conflictBuilder.setTitle(st);
//                conflictBuilder.setMessage(R.string.connect_conflict);
//                conflictBuilder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
//
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                        conflictBuilder = null;
//                        finish();
//                        startActivity(new Intent(MainActivity.this, LoginActivity.class));
//                    }
//                });
//                conflictBuilder.setCancelable(false);
//                conflictBuilder.create().show();
//                isConflict = true;
//            } catch (Exception e) {
//                EMLog.e(TAG, "---------color conflictBuilder error" + e.getMessage());
//            }
//
//        }
//
//    }
//
//    /**
//     * 帐号被移除的dialog
//     */
//    private void showAccountRemovedDialog() {
//        isAccountRemovedDialogShow = true;
//        DemoHXSDKHelper.getInstance().logout(true,null);
//        String st5 = getResources().getString(R.string.Remove_the_notification);
//        if (!MainActivity.this.isFinishing()) {
//            // clear up global variables
//            try {
//                if (accountRemovedBuilder == null)
//                    accountRemovedBuilder = new android.app.AlertDialog.Builder(MainActivity.this);
//                accountRemovedBuilder.setTitle(st5);
//                accountRemovedBuilder.setMessage(R.string.em_user_remove);
//                accountRemovedBuilder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
//
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                        accountRemovedBuilder = null;
//                        finish();
//                        startActivity(new Intent(MainActivity.this, LoginActivity.class));
//                    }
//                });
//                accountRemovedBuilder.setCancelable(false);
//                accountRemovedBuilder.create().show();
//
//            } catch (Exception e) {
//                EMLog.e(TAG, "---------color userRemovedBuilder error" + e.getMessage());
//            }
//
//        }
//
//    }
//
//    @Override
//    protected void onNewIntent(Intent intent) {
//        super.onNewIntent(intent);
//        if (getIntent().getBooleanExtra("conflict", false) && !isConflictDialogShow) {
//            showConflictDialog();
//        } else if (getIntent().getBooleanExtra(Constant.ACCOUNT_REMOVED, false) && !isAccountRemovedDialogShow) {
//            showAccountRemovedDialog();
//        }
//    }
//
//
//    @Override
//    public void onResume() {
//        super.onResume();
//
//        // unregister this event listener when this activity enters the
//        // background
//        DemoHXSDKHelper sdkHelper = (DemoHXSDKHelper) DemoHXSDKHelper.getInstance();
//        sdkHelper.pushActivity(this);
//
//        // register the event listener when enter the foreground
//        EMChatManager.getInstance().registerEventListener(this,
//                new EMNotifierEvent.Event[] { EMNotifierEvent.Event.EventNewMessage ,EMNotifierEvent.Event.EventOfflineMessage, EMNotifierEvent.Event.EventConversationListChanged});
//    }
//
//    /**
//     * 监听事件
//     */
//    @Override
//    public void onEvent(EMNotifierEvent event) {
//        switch (event.getEvent()) {
//            case EventNewMessage: // 普通消息
//            {
//                EMMessage message = (EMMessage) event.getData();
//                // 提示新消息
//                HXSDKHelper.getInstance().getNotifier().onNewMsg(message);
//                break;
//            }
//            case EventOfflineMessage: {
//                break;
//            }
//            case EventConversationListChanged: {
//                break;
//            }
//            default:
//                break;
//        }
//    }
//
//    /**
//     * button点击事件
//     *
//     * @param view
//     */
//    public void onTabClicked(View view) {
//        switch (view.getId()) {
//            case R.id.btn_conversation:
//                FourFragment.index = 0;
//                break;
//            case R.id.btn_address_list:
//                FourFragment.index = 1;
//                break;
//            case R.id.btn_setting:
//                FourFragment.index = 2;
//                break;
//        }
//        if (FourFragment.currentTabIndex != FourFragment.index) {
//            FragmentTransaction trx = getSupportFragmentManager().beginTransaction();
//            trx.hide(FourFragment.fragments[FourFragment.currentTabIndex]);
//            if (!FourFragment.fragments[FourFragment.index].isAdded()) {
//                trx.add(R.id.fragment_container, FourFragment.fragments[FourFragment.index]);
//            }
//            trx.show(FourFragment.fragments[index]).commit();
//        }
//        FourFragment.mTabs[FourFragment.currentTabIndex].setSelected(false);
//        // 把当前tab设为选中状态
//        FourFragment.mTabs[FourFragment.index].setSelected(true);
//        FourFragment.currentTabIndex = FourFragment.index;
//    }

    MemberObj memberObj;
    void getMember(){
        StringRequest request = new StringRequest(
                Request.Method.POST,
                InternetURL.MEMBER__URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        if (StringUtil.isJson(s)) {
                            try {
                                JSONObject jo = new JSONObject(s);
                                String code =  jo.getString("code");
                                if(Integer.parseInt(code) == 200){
                                    MemberObjData data = getGson().fromJson(s, MemberObjData.class);
                                    memberObj = data.getData();
                                    initData();
                                }
                                else{
                                    Toast.makeText(MainActivity.this, jo.getString("msg"), Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(MainActivity.this, R.string.get_data_error, Toast.LENGTH_SHORT).show();
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("user", getGson().fromJson(getSp().getString("user", ""), String.class));
                params.put("access_token", getGson().fromJson(getSp().getString("access_token", ""), String.class));
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

    private void initData() {
        save("id", memberObj.getId());
        save("nick_name", memberObj.getNick_name());
        save("user", memberObj.getUser());
        save("mobile", memberObj.getMobile());
        save("email", memberObj.getEmail());
        save("cover", memberObj.getCover());
        save("rule1_name", memberObj.getRule1_name());
        save("class_id", memberObj.getClass_id());
        save("school_id", memberObj.getSchool_id());
        save("rule2_name", memberObj.getRule2_name());
        save("f_cover", memberObj.getF_cover());
        save("m_cover", memberObj.getM_cover());
        save("sex", memberObj.getSex());
        save("state", memberObj.getState());
        save("one", memberObj.getOne());
        save("birthday", memberObj.getBirthday());
        save("reg_time", memberObj.getReg_time());
        save("last_login", memberObj.getLast_login());
        save("last_ip", memberObj.getLast_ip());
//        imageLoader.displayImage( memberObj.getCover(), mine_head, UniversityApplication.txOptions, animateFirstListener);
//        nickname.setText(memberObj.getUser_name());
//        tel.setText("联系电话：" + memberObj.getMobile());
//        reg_num.setText("注册编号：" + memberObj.getRegister_num());
//        reg_date.setText("注册日期：" + memberObj.getRegister_date());
//        jifen.setText("会员积分：" + memberObj.getMember_points());
//        daijinquan.setText("代金券："+memberObj.getProp());
//        company_adddress.setText("公司地址："+memberObj.getCompany_address());
//        company_name.setText("公司名称："+memberObj.getCompany_name());
//        String lev = memberObj.getM_level()==null?"":memberObj.getM_level();
//        if(StringUtil.isNullOrEmpty(lev)){
//            lev = "0.0";
//        }
//        star_level.setRating(Float.valueOf(lev));

    }

}
