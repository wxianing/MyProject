package com.kylin.annotaiontest;


import android.support.v4.app.Fragment;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;


/**
 * A simple {@link Fragment} subclass.
 */
@EFragment(R.layout.fragment_my)
public class MyFragment extends Fragment {
    @ViewById
    TextView tv;

    @AfterViews
    void afterView(){
        tv.setText("这是一个Fragment！");
    }

}
