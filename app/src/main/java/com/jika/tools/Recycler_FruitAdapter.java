package com.jika.tools;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jika.R;

import java.util.List;

public class Recycler_FruitAdapter extends RecyclerView.Adapter<Recycler_FruitAdapter.ViewHolder> {
    private List<Fruit> mFruitList;
//    内部类
    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView fruitImage;
        TextView fruitName;
        public ViewHolder(View view){
            super(view);
            fruitImage=view.findViewById(R.id.fruit_image);
            fruitName=view.findViewById(R.id.fruit_name);
        }
    }

    public Recycler_FruitAdapter(List<Fruit> fruitList){
        mFruitList=fruitList;
    }



    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listview_fruit_item,viewGroup,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    public void onBindViewHolder( Recycler_FruitAdapter.ViewHolder viewHolder, int i) {
            Fruit fruit=mFruitList.get(i);
            viewHolder.fruitImage.setImageResource(fruit.getImageId());
            viewHolder.fruitName.setText(fruit.getName());
    }

    public int getItemCount() {
        return mFruitList.size();
    }






}
