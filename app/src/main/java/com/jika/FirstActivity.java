package com.jika;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class FirstActivity extends BaseActivity {
    private EditText editText = null;
    private ImageView imageView;
    public ProgressBar progressBar;
    private static final String TAG = "FirstActivity";
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_first);
        ActionBar actionBar=getSupportActionBar();
                if (actionBar !=null){
                    actionBar.hide();
                }

        Log.d(TAG,this.toString()+"************************************************************************************");
//      收回之前保存的数据，，一直不知道怎么用的或者对不对？？？？？？？？？？？？？
        if(saveInstanceState !=null){
            String temData =saveInstanceState.getString("data_key");
            //取出值后再做相应的恢复操作就可以了，比如将文本内容重新赋值到文本输入框上
            Log.d(TAG,temData+"######################################################################");//因为我的没值，所以测试不出来，以后看看
        }


        Button button1=findViewById(R.id.button_1);//原先通过findViewById返回的是View对象，要向下强转，现在不需要了
        /*注册点击事件监听,然后写一个点击事件,就可以对之监听了*/
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(FirstActivity.this,"you chicked Button 1",Toast.LENGTH_LONG).show();
//                Intent intent=new Intent(FirstActivity.this,SecondActivity.class);
//                startActivity(intent);//这个意图很明显--显式intent
//                隐式Intent指定了一系列更为抽象的action和category等信息，交由系统去分析，下面为隐式Intent
//                Intent intent=new Intent("com.jika.ACTION_START");//这是Intent的另一个构造函数
//                intent.addCategory("com.jika.MY_CATEGORY");可以在AndroidManifest.xmlk添加一个，不然不能用

//                Intent intent=new Intent(Intent.ACTION_VIEW);//这是一个系统内置动作，常量值是android.intent.action.VIEW
//                intent.setData(Uri.parse("http://www.baidu.com"));


//                Intent intent=new Intent(Intent.ACTION_DIAL);//拨打电话
//                intent.setData(Uri.parse("tel:10086"));
//                传送数据到下一页
//                String data="hello--my name is liugang";
//                Intent intent=new Intent(FirstActivity.this,SecondActivity.class);
//                intent.putExtra("extra_data",data);
//                startActivity(intent);
//           SecondActivity中需要两个数据，但是不知道格式，所以这样定方便阅读，   通过类名.静态方法 调用

    SecondActivity.actionStart(FirstActivity.this, "wo shi liu gang@@@@@@@@@@@@@@@@@@", "wo zai zhe er%%%%%%%%%%%%%%%%%%%%%%%%%");

            }
        });
//
//         startActivityForResult(),返回数据给上一个活动,要重写方法onActivityResult() 用3步才达成
   /*     button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(FirstActivity.this,SecondActivity.class);
                startActivityForResult(intent,1);
            }
        });*/


        Button button_first=findViewById(R.id.button_first);
        //    获取Edit_text中的内容并显示在Toast中
        editText=findViewById(R.id.edit_text);
        button_first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText=editText.getText().toString();
                Toast.makeText(FirstActivity.this,inputText,Toast.LENGTH_LONG).show();

            }
        });
//        动态切换图片
        imageView=findViewById(R.id.image_first);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //怎么循循环切换图片？？？
                Log.d("FirstActivity",imageView.getResources()+"hahahhahahahahahhahahahahahhaha");
//                if(imageView.getResources()==R.drawable.img_1)
                imageView.setImageResource(R.drawable.img_3);
                //不能滑动，图片锁死
            }
        });
//隐藏进度条
        progressBar=findViewById(R.id.progress_bar);
        Button button_progressBar_first=findViewById(R.id.button_progressBar_first);
        button_progressBar_first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(progressBar.getVisibility()==View.GONE){
                    progressBar.setVisibility(View.VISIBLE);
                }else{
                    progressBar.setVisibility(View.GONE);
                }
            }
        });
    }
//由于startActivityForResult()方法来启动SecondActivity的，在SecondActivity被销毁之后会回调上一个活动的onActivityResult()方法
// 所以我们需要重写这个方法在下面@Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
      switch(requestCode){
          case 1:
              if(resultCode==RESULT_OK){
                  String returnedData =data.getStringExtra("data_return");
                  Log.d(TAG,returnedData);
              }
              break;
          default :
      }
    }

    //    重写onCreateOptionMenu()方法--创建菜单 getMenuInflater能够得到MenuInflater对象，再调用它的inflate方法就可以给当前活动创建菜单了
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);//1参数：通过哪个资源文件来创建菜单 2，指定我们的菜单项将添加到哪一个Menu对象中
        return true;
    }

    //    重写onOptionsItemSelected方法--定义菜单响应事件--没细说
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(FirstActivity.this,"you clicked ADD",Toast.LENGTH_LONG).show();
                break;
            case  R.id.remove_item:
                Toast.makeText(FirstActivity.this,"you clicked Remove",Toast.LENGTH_LONG).show();
                break;
            default:
        }
        return true;
    }


    //临时数据进行保存的方法 ,接下来在onCreate中可以取得数据 onSaveInstanceState()可以保证活动被回收之前一定会被调用
//    Bundle如果在活动被系统回收之前有通过onSaveInstanceState()方法来保存数据的话，这个参数就会带有之前所保存的全部数据
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        String temData="Now Something you should save,but we do!!";
        outState.putString("data_key",temData);

    }




}
