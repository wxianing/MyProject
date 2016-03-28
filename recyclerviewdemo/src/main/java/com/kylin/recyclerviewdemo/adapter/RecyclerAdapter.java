package com.kylin.recyclerviewdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kylin.recyclerviewdemo.R;
import com.kylin.recyclerviewdemo.bean.FeedsBean;

import java.util.List;

/**
 * Package com.kylin.recyclerviewdemo.adapter
 * 创建人：wxianing
 * 作 用：
 * 时 间：2016/3/21
 * 修改人：
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {


    private List<FeedsBean> data;
    private Context context;
    private LayoutInflater inflater;

    public RecyclerAdapter(List<FeedsBean> data, Context context) {
        this.data = data;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder vh = new MyViewHolder(inflater.inflate(R.layout.item_recyclerview, parent, false));
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.MyViewHolder holder, int position) {
        holder.tv.setText(data.get(position).getData().getSubject());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv;

        public MyViewHolder(View view) {
            super(view);
            tv = (TextView) view.findViewById(R.id.tv);
        }
    }
}
