package yll.self.supportdesignlibrarydemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by yll on 2016/3/9.
 * addTab(TabLayout.Tab tab, int position, boolean setSelected) 增加选项卡到 layout 中
   addTab(TabLayout.Tab tab, boolean setSelected) 同上
   addTab(TabLayout.Tab tab) 同上
   getTabAt(int index) 得到选项卡
   getTabCount() 得到选项卡的总个数
   getTabGravity() 得到 tab 的 Gravity
   getTabMode() 得到 tab 的模式
   getTabTextColors() 得到 tab 中文本的颜色
   newTab() 新建个 tab
   removeAllTabs() 移除所有的 tab
   removeTab(TabLayout.Tab tab) 移除指定的 tab
   removeTabAt(int position) 移除指定位置的 tab
   setOnTabSelectedListener(TabLayout.OnTabSelectedListener onTabSelectedListener) 为每个 tab 增加选择监听器
   setScrollPosition(int position, float positionOffset, boolean updateSelectedText) 设置滚动位置
   setTabGravity(int gravity) 设置 Gravity
   setTabMode(int mode) 设置 Mode
   setTabTextColors(ColorStateList textColor) 设置 tab 中文本的颜色
   setTabTextColors(int normalColor, int selectedColor) 设置 tab 中文本的颜色 默认 选中
   setTabsFromPagerAdapter(PagerAdapter adapter) 设置 PagerAdapter
   setupWithViewPager(ViewPager viewPager) 和 ViewPager 联动
 */
public class TabActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        findViewById(R.id.tv_1).setOnClickListener(this);
        findViewById(R.id.tv_2).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()){
            case R.id.tv_1:
                intent.setClass(TabActivity.this, TabLayoutActivity.class);
                break;
            case R.id.tv_2:
                intent.setClass(TabActivity.this, TabAndViewPagerActivity.class);
                break;
        }
        startActivity(intent);
    }
}
