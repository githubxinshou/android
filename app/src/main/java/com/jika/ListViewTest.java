package com.jika;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.jika.tools.Fruit;
import com.jika.tools.FruitAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListViewTest extends AppCompatActivity {
 /*   private String[] data={"Apple","Banana","Orange","Watermelon","Pear","Grape",
            "Pineapple","Strawberry","Cherry","Mango","Apple","Banana","Orange",
            "Watermelon","Pear","Grape", "Pineapple","Strawberry","Cherry","Mango"
    };*/

    private List<Fruit> fruitList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_activity);
//        在有tools工具类后，在写的下面控制添加点击事件
        initFruits();
        FruitAdapter adapter=new FruitAdapter(ListViewTest.this,R.layout.listview_fruit_item,fruitList);


/*传入当前上下文，ListView子项布局的id，以及要配的数据*/
//        ArrayAdapter<String> adapter=new ArrayAdapter<>(ListViewTest.this,android.R.layout.simple_list_item_1,data);
        ListView listView=findViewById(R.id.list_view_1);
        listView.setAdapter(adapter);
/*数组中的数据无法直接传递给ListView，我们需要借助适配器ArrayAdapter完成，它可以通过泛型来指定要适配的数据类型，然后在构造函数中把要适配的数据传入*/

//        对listView中的条目进行点击事件控制
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit=fruitList.get(position);
                AlertDialog.Builder dialog=new AlertDialog.Builder(ListViewTest.this);
                dialog.setTitle(fruit.getName());
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
            }
        });

    }

    private void initFruits() {
        for(int i=0;i<2;i++){
            Fruit apple=new Fruit("Apple",R.drawable.apple_pic);
            fruitList.add(apple);
            Fruit banana=new Fruit("Banana",R.drawable.banana_pic);
            fruitList.add(banana);
            Fruit orange=new Fruit("Orange",R.drawable.orange_pic);
            fruitList.add(orange);
            Fruit watermelon=new Fruit("Watermelon",R.drawable.watermelon_pic);
            fruitList.add(watermelon);
            Fruit pear=new Fruit("Pear",R.drawable.pear_pic);
            fruitList.add(pear);
            Fruit grape=new Fruit("Grape",R.drawable.grape_pic);
            fruitList.add(grape);
            Fruit pineapple=new Fruit("Pineapple",R.drawable.pineapple_pic);
            fruitList.add(pineapple);
            Fruit strawberry=new Fruit("Strawberry",R.drawable.strawberry_pic);
            fruitList.add(strawberry);
            Fruit cherry=new Fruit("Cherry",R.drawable.cherry_pic);
            fruitList.add(cherry);
            Fruit mango=new Fruit("Mango",R.drawable.mango_pic);
            fruitList.add(mango);



        }
    }
}
