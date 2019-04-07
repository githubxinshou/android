package com.jika;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class SecondActivity extends BaseActivity implements View.OnClickListener{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent=getIntent();//getIntent()方法获取到用于启动SecondActivity的Intent
        //Bundle bundle= intent.getExtras();
        //String data=bundle.getString("extra_data");//获取不到数据 为空 不知什么原因。
        // 可能有活动被取消  原因找到：是因为报华为手机不让打印日志

        String data1=intent.getStringExtra("param1");
        String data2=intent.getStringExtra("param2");
        Log.d("SecondActivity",data1+"hhhhhhhhhhhhhhhhhhhhhhhhhhhhwwwwwwwwwwwwwwwwwwwww"+data2);

//        注册监听 通过继承View.OnclickListener
        Button button_activity_second=findViewById(R.id.button_activity_second);
        Button button_1=findViewById(R.id.button_2);
        Button button_AlertDialog=findViewById(R.id.button_AlertDialog);
        Button mainActivity=findViewById(R.id.mainActivity);
        Button list_view_1=findViewById(R.id.list_view_1);
        Button recycler_view1=findViewById(R.id.recycler_view1);

        button_activity_second.setOnClickListener(this);
        button_1.setOnClickListener(this);
        button_AlertDialog.setOnClickListener(this);
        mainActivity.setOnClickListener(this);
        list_view_1.setOnClickListener(this);
        recycler_view1.setOnClickListener(this);

    }

//    通过FirstActivity回调，返回这里的数据回去  如果用户是按的back键，那么重写onBackPressed（）方法，在下面
    public void onClick(View v){
        switch (v.getId()){
            case    R.id.button_activity_second:
                Intent intent=new Intent(SecondActivity.this,FirstActivity.class);
                startActivity(intent);
                break;
            case R.id.button_2:
                Intent intent2=new Intent();
                intent2.putExtra("data_return","hello FirstActivity,i come from secondActivity");
                setResult(RESULT_OK,intent2);//用于向上一个活动返回数据的。1参数：向上一个活动返回处理结果 2，参数：数据
                finish();//销毁当前活动
                break;
            case    R.id.button_AlertDialog:
                AlertDialog.Builder dialog=new AlertDialog.Builder(SecondActivity.this);
                dialog.setTitle("this is Dialog!!");
                dialog.setMessage("Something is wrong important.");
                dialog.setCancelable(false);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.show();
                break;
//                莫名其妙，为什么这个会打开ListView页面？？？？？？？因为没有写break;
            case R.id.mainActivity:
                Intent intent3=new Intent();
                intent3.setClass(SecondActivity.this,MainActivity.class);
                startActivity(intent3);
                break;
            case R.id.list_view_1:
                Intent intent4=new Intent(SecondActivity.this, ListViewTest.class);
                startActivity(intent4);
                break;
            case R.id.recycler_view1:
                Intent intent5=new Intent(SecondActivity.this, RecyclerViewTest.class);
                startActivity(intent5);
                break;
            default:
                break;

        }

    }
//    当按返回键传输的数据
    public void onBackPressed() {
        Intent intent5=new Intent();
        intent5.putExtra("data_return","hello FirstActivity,i come from secondActivity for back");
        setResult(RESULT_OK,intent5);
        finish();
    }


    //    封装intent传递数据的方法，从FirstActivity中传过来的值会被回调回去
    public static void actionStart(Context context, String data1, String data2){
        Intent intent =new Intent(context,SecondActivity.class);
        intent.putExtra("param1",data1);
        intent.putExtra("param2",data2);
        context.startActivity(intent);
    }

}
