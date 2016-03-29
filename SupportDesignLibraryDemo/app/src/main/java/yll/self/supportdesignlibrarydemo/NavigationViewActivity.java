package yll.self.supportdesignlibrarydemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by yll on 2016/3/9.
 */
public class NavigationViewActivity extends Activity {

    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private TextView tv_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView)findViewById(R.id.nav_view);
        tv_content = (TextView) findViewById(R.id.tv_content);

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
//                menuItem.setChecked(true);
                Toast.makeText(NavigationViewActivity.this, menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });


        tv_content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

}
