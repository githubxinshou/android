package com.jika;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

public class ActivityCollector {
//    这个类作为一个活动的管理器，能够随时随地退出当前页面 通过List来暂存活动
    public static List<Activity> activities=new ArrayList<>();
    public static void addActivity(Activity activity){
        activities.add(activity);
    }

    public static void removeActivity(Activity activity){
        activities.remove(activity);
    }

//    这个方法的使用就是在相应的页面通过点击事件来调用这个函数，来一下子退出应用，而不是退多次
    public static void finishAll(){
        for(Activity activity:activities){
            if (!activity.isFinishing()){
                activity.finish();
            }
        }
    }

}
