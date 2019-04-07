package com.jika;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity{
    //向下兼容的Activity
//Activity是Android系统提供的一个活动基类
    //在断onCreate外面输入logt--按下tab键，会以当前类名作为值自动生成一TAG常量
    //重写onCreate（）方法 里面调用了父类的onCreate方法
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_three);

    }

}
