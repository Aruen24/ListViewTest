package com.example.listviewtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017/5/25 0025.
 */

public class FruitAdapter extends ArrayAdapter<Fruit>{
    private  int resourceId;

    public  FruitAdapter(Context context, int textViewResourceId, List<Fruit> objects){
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        Fruit fruit = getItem(position);
        //重复的加载布局
        // View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);

        /*（提高运行效率）
        1、convertView参数用于将之前加载好的布局进行缓存，以便之后进行重用，
        如果为空，就去加载布局，不为空，就对其进行重用。

        2、新增一个内部类ViewHolder用于对控件的实例进行缓存，没必要每次通过
        findViewById()方法来获取控件实例
        */
        View view;
        ViewHolder viewHolder;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
            viewHolder.fruitName = (TextView) view.findViewById(R.id.fruit_name);
            view.setTag(viewHolder);//将ViewHolder存储在View中
        }else{
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();//重新获取ViewHolder
        }

        viewHolder.fruitImage.setImageResource(fruit.getImageId());
        viewHolder.fruitName.setText(fruit.getName());
        return view;
    }

    class ViewHolder{
        ImageView fruitImage;
        TextView fruitName;
    }
}
