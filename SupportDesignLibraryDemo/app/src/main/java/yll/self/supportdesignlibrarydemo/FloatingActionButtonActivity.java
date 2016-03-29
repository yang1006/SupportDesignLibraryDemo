package yll.self.supportdesignlibrarydemo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * Created by yll on 2016/3/7.
 * FloatingActionButton
 */
public class FloatingActionButtonActivity extends Activity {

    private FloatingActionButton fab1, fab2;
    private RelativeLayout rl_root;
    private Context ctx;
    private CoordinatorLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ctx = FloatingActionButtonActivity.this;
        setContentView(R.layout.actvity_floating_action_button);
        rl_root = (RelativeLayout) findViewById(R.id.rl_root);

        layout = (CoordinatorLayout) findViewById(R.id.layout);
        fab1 = (FloatingActionButton) findViewById(R.id.fab1);
        fab2 = (FloatingActionButton) findViewById(R.id.fab2);

        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ctx, "我是toast", Toast.LENGTH_SHORT).show();
            }
        });
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(layout, "一个SnackBar", Snackbar.LENGTH_LONG)
                        .setAction("点击弹toast", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(ctx, "我是toast", Toast.LENGTH_SHORT).show();

                            }
                        }).show();
            }
        });
    }
}
