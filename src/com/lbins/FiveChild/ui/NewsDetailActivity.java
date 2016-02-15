package com.lbins.FiveChild.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.lbins.FiveChild.R;
import com.lbins.FiveChild.base.BaseActivity;
import com.lbins.FiveChild.module.NewsObj;

/**
 * Created by Administrator on 2016/2/2.
 */
public class NewsDetailActivity extends BaseActivity implements View.OnClickListener {
    private TextView title;
    private TextView dateline;
    private TextView content;
    private NewsObj news;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mine_news_activity);
        news = (NewsObj) getIntent().getExtras().get("news");
        this.findViewById(R.id.back).setOnClickListener(this);
        title = (TextView) this.findViewById(R.id.title);
        dateline = (TextView) this.findViewById(R.id.dateline);
        content = (TextView) this.findViewById(R.id.content);
        title.setText(news.getTitle());
        dateline.setText(news.getDateline());
        content.setText(news.getContent());
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
