package com.android.priyanka.jsonexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.android.priyanka.jsonexample.retrofit.activity.ShowDataRActivity;
import com.android.priyanka.jsonexample.volley.activity.ShowDataVActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btnRetrofit)
    Button btnRetrofit;
    @BindView(R.id.btnVolley)
    Button btnVolley;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btnRetrofit, R.id.btnVolley})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnRetrofit:
                Intent ir = new Intent(MainActivity.this, ShowDataRActivity.class);
                startActivity(ir);
                break;
            case R.id.btnVolley:
                Intent iv = new Intent(MainActivity.this, ShowDataVActivity.class);
                startActivity(iv);
                break;
        }
    }
}
