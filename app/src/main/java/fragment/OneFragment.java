package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import bwie.com.jinritoutiao.R;

/**
 * 类描述：
 * 创建人：Liuzijun
 * 创建时间：2017/7/7 16:39
 */
public class OneFragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private String TAG = getClass().getSimpleName();
    private List<Fragment> fragmentsList;//fragment容器
    private List<String> titleList;//标签容器

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.onefragment, null);
        tabLayout = (TabLayout) view.findViewById(R.id.tab);
        viewPager = (ViewPager) view.findViewById(R.id.vp);
        fragmentsList = new ArrayList<>();
        titleList = new ArrayList<>();
        //加载
        load();
        return view;
    }

    private void load() {
        //将fragment添加到fragmentList的list容器里
        fragmentsList.add(new Fragments());
        //重复添加 只是填充  没什么用
        for (int i = 0; i < 50; i++) {
            fragmentsList.add(new Fragments());
        }
        titleList.add("推荐");
        titleList.add("热点");
        titleList.add("北京");
        titleList.add("视频");
        titleList.add("社会");
        titleList.add("图片");
        titleList.add("娱乐");
        titleList.add("问答");
        titleList.add("科技");
        titleList.add("汽车");
        titleList.add("财经");
        titleList.add("军事");
        titleList.add("体育");
        titleList.add("段子");
        titleList.add("美女");
        titleList.add("国际");
        titleList.add("趣图");
        titleList.add("健康");
        titleList.add("特卖");
        titleList.add("房产");

        //tab的模式如果标签多的话用MODE_SCROLLABLE  少的话用MODE_FIXED
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        FragViewAdapter adapter = new FragViewAdapter(getChildFragmentManager(), fragmentsList, titleList);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        //虽然过时了但是不能去掉，去掉后如果是滑动操作的话没事，但是使用标签点击的时候就不行了
        tabLayout.setTabsFromPagerAdapter(adapter);

        // 选择tablayout的监听，一般是用不到的
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getText().equals("新闻")) {
                    Toast.makeText(getActivity(), "滑动或点击了新闻", Toast.LENGTH_SHORT).show();
                }
                if (tab.getPosition() == 1) {
                    Toast.makeText(getActivity(), "滑动或点击了笑话", Toast.LENGTH_SHORT).show();
                }
            }


            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                if (tab.isSelected()) {
                    Toast.makeText(getActivity(), "切换了Pager", Toast.LENGTH_SHORT).show();
                }
                //Log.i(TAG, "tab.getTag()" + tab.getTag());
            }


            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                //不知道干啥的
            }
        });
    }

    //创建适配器，主要是为了fragmet与标题进行匹配的 继承FragmentPagerAdapter
    class FragViewAdapter extends FragmentPagerAdapter {
        List<Fragment> fragmentList_;
        List<String> titleList_;


        public FragViewAdapter(FragmentManager fm, List<Fragment> fragmentList, List<String> titleList) {
            super(fm);
            fragmentList_ = fragmentList;
            titleList_ = titleList;
        }


        @Override//fragment匹配
        public Fragment getItem(int position) {
            Log.i(TAG, "getItem  " + fragmentList_.get(position));
            return fragmentList_.get(position);
        }


        @Override//获取fragment的数量
        public int getCount() {
            return titleList_.size();
        }


        @Override//对标题进行匹配
        public CharSequence getPageTitle(int position) {
            Log.i(TAG, "getPageTitle  " + titleList_.get(position));
            return titleList_.get(position);
        }


        @Override//销毁 不知道这样做行不行
        public void destroyItem(ViewGroup container, int position, Object object) {
            super.destroyItem(container, position, object);
            fragmentList_.get(position).onDestroy();
        }
    }
}

