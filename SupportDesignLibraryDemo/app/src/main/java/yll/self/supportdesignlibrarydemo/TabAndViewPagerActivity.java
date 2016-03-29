package yll.self.supportdesignlibrarydemo;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by yll on 2016/3/9.
 */
public class TabAndViewPagerActivity extends Activity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ArrayList<TextView> tvs;
    private PagerAdapter adapter;
    private String[] items = new String[]{"第一个", "第二个", "第三个"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_viewpager);
        init();
    }

    private void init(){
        tabLayout = (TabLayout)findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.vp);

        tvs = new ArrayList<TextView>();
        for (int i = 0; i < items.length; i++) {
            TextView tv = new TextView(this);
            tv.setText(items[i]);
            LinearLayout.LayoutParams lp =
                    new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            tv.setTextColor(Color.BLACK);
            tv.setBackgroundColor(Color.WHITE);
            tv.setGravity(Gravity.CENTER);
            tv.setLayoutParams(lp);
            tv.setTextSize(22);
            tvs.add(tv);
        }
        tabLayout.setTabTextColors(Color.WHITE, Color.GRAY);//设置文本在选中和为选中时候的颜色

        adapter = new MypageAdapter();
        viewPager.setAdapter(adapter);
        //用来设置tab的，同时也要覆写  PagerAdapter 的 CharSequence getPageTitle(int position) 方法，要不然 Tab 没有 title
        tabLayout.setupWithViewPager(viewPager);
        //关联 TabLayout viewpager
        tabLayout.setTabsFromPagerAdapter(adapter);
        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
    }

    class MypageAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return tvs.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return items[position];
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
        }

        @Override
        public int getItemPosition(Object object) {
            return super.getItemPosition(object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = null;
            view = tvs.get(position);
            try {
                container.addView(view);
            } catch (Exception e) {
                container.removeView(view);
                container.addView(view);
            }
            return view;
        }
    }
}
