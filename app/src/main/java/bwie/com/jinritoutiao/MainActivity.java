package bwie.com.jinritoutiao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hjm.bottomtabbar.BottomTabBar;

import org.xutils.view.annotation.ViewInject;

import fragment.FourFragment;
import fragment.OneFragment;
import fragment.ThreeFragment;
import fragment.TwoFragment;

public class MainActivity extends AppCompatActivity {
    @ViewInject(R.id.bottom_tab_bar)

    private BottomTabBar bottomTabBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomTabBar = (BottomTabBar) findViewById(R.id.bottom_tab_bar);
        bottomTabBar.init(getSupportFragmentManager())
                .addTabItem("首页", R.mipmap.ic_launcher, OneFragment.class)
                .addTabItem("西瓜视频", R.mipmap.ic_launcher, TwoFragment.class)
                .addTabItem("微头条", R.mipmap.ic_launcher, ThreeFragment.class)
                .addTabItem("登录", R.mipmap.ic_launcher, FourFragment.class);
    }
}
