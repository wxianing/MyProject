package com.kylin.annotaiontest;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {
    @ViewById
    Button btn;

    @Click(R.id.btn)
    void onClick() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        MyFragment fragment = new MyFragment_();

        ft.add(R.id.layout,fragment , MyFragment.class.getName());
        ft.commit();
    }
}
