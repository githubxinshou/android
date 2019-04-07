package com.jika.tools;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jika.R;


import java.util.List;

public class FruitAdapter extends ArrayAdapter<Fruit> {
    private int resourceId;

    public FruitAdapter(Context context, int textViewResourceId, List<Fruit> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
    }
    public View getView(int position, View converView, ViewGroup parent){
        Fruit fruit=getItem(position);

//3.0 加载获取id并存储到viewHolder中 ViewHolder是内部类
        View view;
        ViewHolder viewHolder;
        if (converView ==null){
            view=LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.fruitImage=view.findViewById(R.id.fruit_image);
            viewHolder.fruitName=view.findViewById(R.id.fruit_name);
            view.setTag(viewHolder);//将ViewHolder存储在View中
        }else {
            view=converView;
            viewHolder=(ViewHolder) view.getTag();
        }
        viewHolder.fruitImage.setImageResource(fruit.getImageId());
        viewHolder.fruitName.setText(fruit.getName());
        return view;



//        convertView参数，用于将之前加载好的布局进行缓存,提升效率  虽然不会再重复加载布局，但是还会调用View的findViewById()方法来获取一次控件的实例
/*
  2.0      View view;
        if (converView ==null){
            view=LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        }else {
            view=converView;
        }
*/

// 1.0       View view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);



/* 2.0       ImageView fruitImage =view.findViewById(R.id.fruit_image);
        TextView fruitName=view.findViewById(R.id.fruit_name);
        fruitImage.setImageResource(fruit.getImageId());
        fruitName.setText(fruit.getName());
        return view;*/
    }

    class ViewHolder{
        ImageView fruitImage;
        TextView fruitName;
    }
}
