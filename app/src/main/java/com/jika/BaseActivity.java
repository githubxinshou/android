package com.jika;

import android.app.Activity;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class BaseActivity extends AppCompatActivity {

    private static final String TAG ="BaseActivity";

    protected void onCreate(Bundle savedInstanceState) {
//      让活动页面继承，然后当活动页面Create时  能够判断当前的活动页面
        super.onCreate(savedInstanceState);
        Log.d(TAG,getClass().getSimpleName()+"  ---onCreate---$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        ActivityCollector.addActivity(this);//通过这种方式添加每个页面的活动，可控制
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,getClass().getSimpleName()+"    ---onRestart--$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        ActivityCollector.addActivity(this);
    }

    protected void onDestroy(){
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }


}
