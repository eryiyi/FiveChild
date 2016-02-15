package com.lbins.FiveChild.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.lbins.FiveChild.R;
import com.lbins.FiveChild.base.BaseActivity;

/**
 * Created by Administrator on 2016/1/21.
 */
public class IndexPengyouquanActivity extends BaseActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index_mine_banjiquan_activity);

        this.findViewById(R.id.relate_one).setOnClickListener(this);
        this.findViewById(R.id.relate_two).setOnClickListener(this);
        this.findViewById(R.id.relate_three).setOnClickListener(this);
        this.findViewById(R.id.relate_four).setOnClickListener(this);
        this.findViewById(R.id.relate_five).setOnClickListener(this);
        this.findViewById(R.id.relate_six).setOnClickListener(this);
        this.findViewById(R.id.relate_seven).setOnClickListener(this);
        this.findViewById(R.id.back).setOnClickListener(this);
    }

    public void back(View view){
        finish();
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.relate_one:
            {
                //班级相册
                Intent noticeV = new Intent(IndexPengyouquanActivity.this, IndexPengyouquanPhotoActivity.class);
                startActivity(noticeV);
            }
                break;
            case R.id.relate_two:
            {
                //宝宝动态
                Intent noticeV = new Intent(IndexPengyouquanActivity.this, IndexPengyouquanNoticeActivity.class);
                startActivity(noticeV);
            }
            break;
            case R.id.relate_three:
            {
                //营养食谱
                Intent noticeV = new Intent(IndexPengyouquanActivity.this, IndexPengyouquanShipuActivity.class);
                startActivity(noticeV);
            }
            break;
            case R.id.relate_four:
            {
                //宝贝课程
                Intent noticeV = new Intent(IndexPengyouquanActivity.this, IndexPengyouquanClassActivity.class);
                startActivity(noticeV);
            }
            break;
            case R.id.relate_five:
            {
                //私信空间
                Intent noticeV = new Intent(IndexPengyouquanActivity.this, IndexPengyouquanSixinActivity.class);
                startActivity(noticeV);
            }
            break;
            case R.id.relate_six:
            {
                //班级群组
                Intent noticeV = new Intent(IndexPengyouquanActivity.this, IndexPengyouquanGroupActivity.class);
                startActivity(noticeV);
            }
            break;
            case R.id.relate_seven:
            {
                //家长联系
                Intent noticeV = new Intent(IndexPengyouquanActivity.this, IndexPengyouquanPersonActivity.class);
                startActivity(noticeV);
            }
            break;
            case R.id.back:
                finish();
                break;
        }
    }
}
