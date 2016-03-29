package yll.self.supportdesignlibrarydemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by yll on 2016/3/10.
 *
 * AppBarLayout 是继承LinerLayout实现的一个ViewGroup容器组件，它是为了Material Design设计的App Bar，支持手势滑动操作。
 默认的AppBarLayout是垂直方向的，它的作用是把AppBarLayout包裹的内容都作为AppBar
 AppBarLayout是支持手势滑动效果的，不过的跟CoordinatorLayout配合使用

 * 总结： 为了使得Toolbar有滑动效果，必须做到如下三点：
   CoordinatorLayout必须作为整个布局的父布局容器。
   给需要滑动的组件设置 app:layout_scrollFlags=”scroll|enterAlways” 属性。
   给可滑动的组件，也就是RecyclerView 或者 NestedScrollView 设置如下属性：
 */
public class AppBarLayoutActivity extends Activity implements Toolbar.OnMenuItemClickListener {

    private Toolbar toolbar;
    private TabLayout tabs;

    private List<String> tabList;
    private List<TextView> tvs;

    private RecyclerView recycler;
    private MyRecycleAdapter adapter;

    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appbar);
        init();
    }

    private void init(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabs = (TabLayout) findViewById(R.id.tabs);
        recycler = (RecyclerView) findViewById(R.id.recycler);
        initToolBar();
        initTab();
        initRecyclerView();
    }

    private void initTab(){
        tabList = new ArrayList<>();
        tabList.add("Tab1");
        tabList.add("Tab2");
        tabList.add("Tab3");
        tabList.add("Tab4");
        tabList.add("Tab5");
        tabList.add("Tab6");
        tabList.add("Tab7");

        tvs = new ArrayList<>();
        for (int i = 0; i < tabList.size(); i++) {
            if (i ==0){
                tabs.addTab(tabs.newTab().setText(tabList.get(i)), true);
            }else {
                tabs.addTab(tabs.newTab().setText(tabList.get(i)), false);
            }
        }
    }

    private void initToolBar(){
        setTitle("标题");
        toolbar.setSubtitle("副标题");
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_card_sort));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AppBarLayoutActivity.this, "icon被点击", Toast.LENGTH_SHORT).show();
            }
        });

        toolbar.setLogo(R.drawable.ic_launcher);
        toolbar.setLogoDescription("logo描述");
        toolbar.setOnMenuItemClickListener(this);
    }


    private void initRecyclerView(){
        adapter = new MyRecycleAdapter();
        recycler.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(AppBarLayoutActivity.this, LinearLayoutManager.VERTICAL, false);
        recycler.setLayoutManager(layoutManager);


        recycler.addOnItemTouchListener( new RecyclerItemClickListener(AppBarLayoutActivity.this,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        if (position >= 0 &&position < list.size()){
                            list.remove(position);
                            adapter.notifyItemRemoved(position);
//                            list.add(position, "gdaudgsoasghdoi");
//                            adapter.notifyItemInserted(position);
                        }
                    }
                }));

    }


    @Override
    public boolean onMenuItemClick(MenuItem item) {
        String msg = "";
        switch (item.getItemId()) {
            case R.id.action_settings:
                msg += "Click setting";
                break;
        }
        Toast.makeText(AppBarLayoutActivity.this, msg, Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return  true;
    }

    class MyRecycleAdapter extends RecyclerView.Adapter<MyRecycleAdapter.MyViewHolder>{

        public MyRecycleAdapter(){
            list = new ArrayList<>();
            for (int i= 0; i < 100; i++){
                list.add(i+"");
            }
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, final int i) {
            TextView textView = new TextView(AppBarLayoutActivity.this);
            textView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 100));
            textView.setGravity(Gravity.CENTER_VERTICAL);
            return new MyViewHolder(textView);
        }

        @Override
        public void onBindViewHolder(MyViewHolder viewHolder, int i) {
            viewHolder.textView.setText(list.get(i));
        }

        @Override
        public int getItemCount() {
            return list == null ? 0 : list.size();
        }

        protected class MyViewHolder extends RecyclerView.ViewHolder{
            protected TextView textView;

            public MyViewHolder(View itemView) {
                super(itemView);
                this.textView  = (TextView) itemView;
            }
        }
    }


}
