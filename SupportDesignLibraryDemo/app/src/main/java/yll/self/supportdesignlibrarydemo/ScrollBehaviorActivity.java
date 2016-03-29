package yll.self.supportdesignlibrarydemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yll on 2016/3/24.
 *
 */
public class ScrollBehaviorActivity extends Activity {

    private RecyclerView recycler;
    private MyRecycleAdapter adapter;
    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_behavior);
        recycler = (RecyclerView) findViewById(R.id.recycler);
        initRecyclerView();
    }



    private void initRecyclerView(){
        adapter = new MyRecycleAdapter();
        recycler.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ScrollBehaviorActivity.this, LinearLayoutManager.VERTICAL, false);
        recycler.setLayoutManager(layoutManager);


        recycler.addOnItemTouchListener( new RecyclerItemClickListener(ScrollBehaviorActivity.this,
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
            TextView textView = new TextView(ScrollBehaviorActivity.this);
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
