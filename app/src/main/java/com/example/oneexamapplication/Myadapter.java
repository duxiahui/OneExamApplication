package com.example.oneexamapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.model.Bean;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Myadapter extends RecyclerView.Adapter<Myadapter.MyViewHoder> {

    private List<Bean.DataBean> list = new ArrayList<>();
    private Context context;
    public Myadapter(Context context){
        this.context = context;

    }
    public void ReFrsh(List<Bean.DataBean>list){
        this.list = list;
        for(int i = 0 ; i < list.size() ;i++){
            String title = list.get(i).getTitle();
            Log.e("s",title);
        }
        notifyDataSetChanged();

    }





    @NonNull
    @Override
    public MyViewHoder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout, null);

        return new MyViewHoder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHoder myViewHoder, int i) {
        myViewHoder.t1.setText(list.get(i).getFood_str());

        Picasso.with(context).load(list.get(i).getPic()).into(myViewHoder.imageView);// Glide 加载图片
      //  Glide.with(context).load(list.get(i).getPic()).into(myViewHoder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();    }

    public class MyViewHoder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView t1;
        public MyViewHoder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img);
            t1 = itemView.findViewById(R.id.t1);


        }
    }
}
