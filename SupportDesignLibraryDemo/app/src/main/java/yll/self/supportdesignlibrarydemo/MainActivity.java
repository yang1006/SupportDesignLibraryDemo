package yll.self.supportdesignlibrarydemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends Activity implements View.OnClickListener {

    private Context ctx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ctx = MainActivity.this;
        init();
    }


    private void init(){
        findViewById(R.id.tv_1).setOnClickListener(this);
        findViewById(R.id.tv_2).setOnClickListener(this);
        findViewById(R.id.tv_3).setOnClickListener(this);
        findViewById(R.id.tv_4).setOnClickListener(this);
        findViewById(R.id.tv_5).setOnClickListener(this);
        findViewById(R.id.tv_6).setOnClickListener(this);
        findViewById(R.id.tv_7).setOnClickListener(this);
        findViewById(R.id.tv_8).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent intent = new Intent();
        switch (view.getId()){
            case R.id.tv_1:
                intent.setClass(ctx, TextInputLayoutActivity.class);
                break;
            case R.id.tv_2:
                intent.setClass(ctx, FloatingActionButtonActivity.class);
                break;
            case R.id.tv_3:
                intent.setClass(ctx, TabActivity.class);
                break;
            case R.id.tv_4:
                intent.setClass(ctx, NavigationViewActivity.class);
                break;
            case R.id.tv_5:
                intent.setClass(ctx, AppBarLayoutActivity.class);
                break;
            case R.id.tv_6:
                intent.setClass(ctx, CollapsingToolbarActivity.class);
                break;
            case R.id.tv_7:
                intent.setClass(ctx, TransLateBehaviorActivity.class);
                break;
            case R.id.tv_8:
                intent.setClass(ctx, ScrollBehaviorActivity.class);
                break;
        }
        startActivity(intent);

    }
}
