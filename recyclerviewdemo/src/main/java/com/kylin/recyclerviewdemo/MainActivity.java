package com.kylin.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.kylin.recyclerviewdemo.adapter.RecyclerAdapter;
import com.kylin.recyclerviewdemo.bean.AppBean;
import com.kylin.recyclerviewdemo.bean.FeedsBean;
import com.kylin.recyclerviewdemo.view.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<FeedsBean> feedsLists;
    private RecyclerAdapter adapter;

    private static final String path = "http://litchiapi.jstv.com/api/GetFeeds?column=6&PageSize=20&pageIndex=1&val=100511D3BE5301280E0992C73A9DEC41";
    private RequestQueue queue;
    private StringRequest request;
    private Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        loadData();
    }

    private void initView() {
        gson = new Gson();
        mRecyclerView = (RecyclerView) this.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        feedsLists = new ArrayList<>();
        adapter = new RecyclerAdapter(feedsLists, this);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
    }


    private void loadData() {

         queue = Volley.newRequestQueue(this);
        request = new StringRequest(Request.Method.GET, path, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("response", response);
                AppBean appBean = gson.fromJson(response, AppBean.class);
                feedsLists.addAll(appBean.getParamz().getFeeds());
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        request.setTag(this);
        queue.add(request);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        request.cancel();
    }
}
