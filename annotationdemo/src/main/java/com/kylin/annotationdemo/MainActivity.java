package com.kylin.annotationdemo;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.kylin.annotationdemo.adapter.LvAdapter;
import com.kylin.annotationdemo.bean.AppBean;
import com.kylin.annotationdemo.bean.FeedsBean;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    private static final String path = "http://litchiapi.jstv.com/api/GetFeeds?column=6&PageSize=20&pageIndex=1&val=100511D3BE5301280E0992C73A9DEC41";

    @ViewById(R.id.listView)
    PullToRefreshListView ptrListView;
    private List<FeedsBean> feedsList;
    private LvAdapter adapter;

    @AfterViews
    public void afterView() {

        init();
        loadData(path);
    }

    private void init() {
        feedsList = new ArrayList<>();
        adapter = new LvAdapter(feedsList, this);
        ptrListView.setAdapter(adapter);

    }

    private void loadData(String url) {
        getDataAsyncHttp(url);

    }

    public void getDataAsyncHttp(String url) {
        FinalHttp fh = new FinalHttp();
        fh.get(url, new AjaxCallBack<String>() {
            @Override
            public void onSuccess(String s) {
                super.onSuccess(s);
                Log.e("Result", s);
            }
        });

    }

    public void getDataXuitls(String url) {
        RequestParams params = new RequestParams(url);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                Log.e("result", result);
                AppBean appBean = JSONObject.parseObject(result, new TypeReference<AppBean>() {
                });
                String status = appBean.getStatus();

                if (status != null && !"".equals(status) && status.equals("ok")) {
                    feedsList.addAll(appBean.getParamz().getFeeds());
                    adapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

}
