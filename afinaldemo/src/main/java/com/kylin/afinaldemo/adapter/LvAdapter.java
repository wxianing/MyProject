package com.kylin.afinaldemo.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kylin.afinaldemo.HttpUtils;
import com.kylin.afinaldemo.R;
import com.kylin.afinaldemo.bean.DataBean;
import com.kylin.afinaldemo.bean.FeedsBean;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.util.List;

import cz.msebera.android.httpclient.Header;


/**
 * Created by Kylin on 2016/3/18.
 */
public class LvAdapter extends BasicAdapter<FeedsBean> {
    public LvAdapter(List<FeedsBean> list, Context context) {
        super(list, context);
    }

    @Override
    public View createView(int position, View convertView, ViewGroup parent) {
        DataBean data = list.get(position).getData();
        ViewHolder vh = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_listview, parent, false);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }
        vh.summery.setText(data.getSummary());
        vh.subject.setText(data.getSubject());
//        x.image().bind(vh.img, "http://litchiapi.jstv.com/" + data.getCover());
        HttpUtils.image(vh.img,"http://litchiapi.jstv.com/" + data.getCover());


        return convertView;
    }

    private static class ViewHolder {
        private TextView subject;
        private TextView summery;
        private ImageView img;

        public ViewHolder(View view) {
            subject = (TextView) view.findViewById(R.id.subjexct);
            summery = (TextView) view.findViewById(R.id.summery);
            img = (ImageView) view.findViewById(R.id.img);
        }
    }
}
