package fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bwie.com.jinritoutiao.R;

/**
 * 类描述：
 * 创建人：Liuzijun
 * 创建时间：2017/7/7 16:22
 */
public class Fragments extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=View.inflate(getActivity(), R.layout.fragments, null);
        return view;
    }
}
