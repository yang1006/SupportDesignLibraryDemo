package yll.self.supportdesignlibrarydemo;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yll on 2016/3/11.
 * CollapsingToolbarLayout包裹 Toolbar 的时候提供一个可折叠的 Toolbar，一般作为AppbarLayout的子视图使用。
 * CollapsingToolbarLayout 提供以下属性和方法是用：

 Collapsing title：ToolBar的标题，当CollapsingToolbarLayout全屏没有折叠时，title显示的是大字体，在折叠的过程中，
 title不断变小到一定大小的效果。你可以调用setTitle(CharSequence)方法设置title。
 Content scrim：ToolBar被折叠到顶部固定时候的背景，你可以调用setContentScrim(Drawable)方法改变背景或者
 在属性中使用 app:contentScrim=”?attr/colorPrimary”来改变背景。
 Status bar scrim：状态栏的背景，调用方法setStatusBarScrim(Drawable)。还没研究明白，不过这个只能在Android5.0以上系统有效果。
 Parallax scrolling children：CollapsingToolbarLayout滑动时，子视图的视觉差，
 可以通过属性app:layout_collapseParallaxMultiplier=”0.6”改变。
 CollapseMode ：子视图的折叠模式，有两种“pin”：固定模式，在折叠的时候最后固定在顶端；
            “parallax”：视差模式，在折叠的时候会有个视差折叠的效果。我们可以在布局中使用属性app:layout_collapseMode=”parallax”来改变。
 */
public class CollapsingToolbarActivity extends Activity {


    private RecyclerView recycler;
    private MyRecycleAdapter adapter;
    private List<String> list;

    private CollapsingToolbarLayout collapsing_toolbar;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collaping);
        recycler = (RecyclerView) findViewById(R.id.recycler);
        collapsing_toolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        initToolBar();
        initCollapsing();
        initRecyclerView();
    }


    private void initToolBar(){
//        setSupportActionBar(toolbar);
//        setTitle("Test");
        toolbar.setSubtitle("副标题");
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_card_sort));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CollapsingToolbarActivity.this, "icon被点击", Toast.LENGTH_SHORT).show();
            }
        });

        toolbar.setLogo(R.drawable.ic_launcher);
    }
    private void initCollapsing(){
        collapsing_toolbar.setTitle("标题");
        /**展开时文字颜色*/
        collapsing_toolbar.setExpandedTitleColor(Color.RED);
        /**折叠时文字颜色*/
        collapsing_toolbar.setCollapsedTitleTextColor(Color.WHITE);
        /**折叠时背景色*/
//        collapsing_toolbar.setContentScrimColor(Color.BLUE);
    }

    private void initRecyclerView(){
        adapter = new MyRecycleAdapter();
        recycler.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(CollapsingToolbarActivity.this, LinearLayoutManager.VERTICAL, false);
        recycler.setLayoutManager(layoutManager);

        recycler.addOnItemTouchListener( new RecyclerItemClickListener(CollapsingToolbarActivity.this,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        if (position >= 0 &&position < list.size()){
                            list.remove(position);
                            adapter.notifyItemRemoved(position);
                        }
                    }
                }));

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
            TextView textView = new TextView(CollapsingToolbarActivity.this);
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
