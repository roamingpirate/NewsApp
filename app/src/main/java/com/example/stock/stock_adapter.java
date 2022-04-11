package com.example.stock;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class stock_adapter extends RecyclerView.Adapter<stock_adapter.stock_viewholder> {

        private  String  rup;
       stock_adapter(String rs)
       {
            rup=rs;
       }

    @Override
    public stock_viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.stock_view_card,parent,false);
        return new stock_viewholder(view);
       }

    @Override
    public void onBindViewHolder( stock_adapter.stock_viewholder holder, int position) {


        holder.t.setText(rup+"500");
    }

    @Override
    public int getItemCount() {
        return 30;
    }

    public class stock_viewholder extends RecyclerView.ViewHolder
     {
           TextView t;
         public stock_viewholder(View itemView) {
             super(itemView);

             t= itemView.findViewById(R.id.price);

         }
     }
};
