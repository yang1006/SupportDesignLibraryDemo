package yll.self.supportdesignlibrarydemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Toast;

/**
 * Created by yll on 2016/3/24.
 * 自定义behavior实现FloatingActionButton随SnackBar移动
 */
public class TransLateBehaviorActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate_behavior);
        final CoordinatorLayout root = (CoordinatorLayout) findViewById(R.id.root);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(root, "一个SnackBar", Snackbar.LENGTH_SHORT)
                        .setAction("点击弹Toast", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(TransLateBehaviorActivity.this, "一个Toast", Toast.LENGTH_SHORT).show();
                            }
                        }).show();
            }
        });

    }
}
