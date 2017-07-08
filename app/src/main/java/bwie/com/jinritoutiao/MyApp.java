package bwie.com.jinritoutiao;

import android.app.Application;

import org.xutils.x;

/**
 * 类描述：
 * 创建人：Liuzijun
 * 创建时间：2017/7/7 17:02
 */
public class MyApp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(false);
    }
}
