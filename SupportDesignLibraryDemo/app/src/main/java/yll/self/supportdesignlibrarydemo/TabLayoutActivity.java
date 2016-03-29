package yll.self.supportdesignlibrarydemo;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.widget.Toast;

/**
 * Created by yll on 2016/3/9.
 */
public class TabLayoutActivity extends Activity {

    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);
        tabLayout= (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setTabTextColors(Color.WHITE, Color.BLACK);//设置文本在选中和未选中时候的颜色
        tabLayout.addTab(tabLayout.newTab().setText("第一个"), true);//添加 Tab,默认选中
        tabLayout.addTab(tabLayout.newTab().setText("第二个"),false);//添加 Tab,默认不选中
        tabLayout.addTab(tabLayout.newTab().setText("第三个"), false);//添加 Tab,默认不选中
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Toast.makeText(TabLayoutActivity.this, "" + tab.getPosition(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
