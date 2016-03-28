package com.kylin.afinaldemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.kylin.afinaldemo.adapter.LvAdapter;
import com.kylin.afinaldemo.bean.AppBean;
import com.kylin.afinaldemo.bean.FeedsBean;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;


public class MainActivity extends AppCompatActivity {

    private static final String path = "http://litchiapi.jstv.com/api/GetFeeds?column=6&PageSize=20&pageIndex=1&val=100511D3BE5301280E0992C73A9DEC41";
    private ListView listView;
    private LvAdapter adapter;
    private List<FeedsBean> feedsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        loadData();

    }

    private void initView() {
        listView = (ListView) this.findViewById(R.id.listView);
        feedsList = new ArrayList<>();
        adapter = new LvAdapter(feedsList, this);
        listView.setAdapter(adapter);

    }

    private void loadData() {
//        FinalHttp fh = new FinalHttp();
//        fh.get(path, new AjaxCallBack<String>() {
//            @Override
//            public void onSuccess(String s) {
//                super.onSuccess(s);
//                Log.e("s>>>>>>",s);
//            }
//        });

        HttpUtils.get(path, null, new AsyncHttpResponseHandler() {


            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Log.e("responseBody", new String(responseBody));
                if (statusCode == 200) {
                    AppBean appBean = JSONObject.parseObject(new String(responseBody), new TypeReference<AppBean>() {
                    });
                    if (appBean != null) {
                        feedsList.addAll(appBean.getParamz().getFeeds());
                        adapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }
}
