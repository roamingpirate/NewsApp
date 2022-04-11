package com.example.stock;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.ImageRequest;

import java.util.ArrayList;
import java.util.List;

public class news_adapter extends RecyclerView.Adapter<news_adapter.news_viewholder> {

    private ArrayList<news_info> news_infoList;
    private Context context;
    private URL_news url_news;
    private  int page;
    public news_adapter(URL_news url_news,Context context)
    {
       this.context=context;
       this.url_news=url_news;
       page=0;
       news_infoList=new ArrayList<news_info>();
    }

    void set_image(news_viewholder holder,String url,int pos)
    {
                       ImageRequest img = new ImageRequest(url, new Response.Listener<Bitmap>() {
                   @Override
                   public void onResponse(Bitmap response) {
                       news_infoList.get(pos).setImage(response);
                       holder.img.setImageBitmap(response);
                       holder.img.setVisibility(View.VISIBLE);
                   }
               },600,300,null,null);
           RequestData.getInstance(holder.itemView.getContext()).addToRequestQueue(img);
    }

    void get_data()
    {
        news_data_network data_network=new news_data_network(context);

        data_network.get_Data(url_news, new news_data_network.onCompletion() {
            @Override
            public void onSuccess(ArrayList<news_info> list) {
                   news_infoList.addAll(list);
                   notifyDataSetChanged();
            }

            @Override
            public void onError() {

            }
        });
    }

    @Override
    public news_viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.news_view_card,parent,false);
        return new news_viewholder(view);
    }

    @Override
    public void onBindViewHolder( news_viewholder holder, int position) {

        if(position==news_infoList.size())
        {
            holder.title.setVisibility(View.GONE);
            holder.description.setVisibility(View.GONE);
            holder.source.setVisibility(View.GONE);
            holder.img.setVisibility(View.GONE);
            if(page<3) {
                holder.loader.setVisibility(View.VISIBLE);
                page++;
                url_news.setPage(page);
                get_data();
            }
            return;
        }

        holder.title.setVisibility(View.VISIBLE);
        holder.img.setVisibility(View.GONE);
        holder.description.setVisibility(View.GONE);
        holder.source.setVisibility(View.VISIBLE);
        holder.loader.setVisibility(View.GONE);


           news_info data = news_infoList.get(position);
        Bitmap image=data.getImage();
        String  title=data.getTitle();
        int t_len=(title.length()>80)?80:title.length();
        holder.title.setText(data.getTitle());

           String  des=data.getDescription();


           int len=(des.length()>100)?100:des.length();
        holder.description.setText(des.substring(0,len)+"...");


        if(image!=null)
        {
            holder.img.setVisibility(View.VISIBLE);
            holder.img.setImageBitmap(image);
        }
        else {

            if (data.getImage_url() != "null") {
                set_image(holder, data.getImage_url(), position);
                holder.title.setPadding(8, 8, 8, 8);

            } else {
                holder.description.setVisibility(View.VISIBLE);
            }
        }


        if(t_len==title.length()){holder.title.append(".");}
        else{holder.title.append("...");}


    }

    @Override
    public int getItemCount() {
        return news_infoList.size()+1;

    }

    public class news_viewholder extends RecyclerView.ViewHolder
    {
        TextView title;
        ImageView img;
        TextView description;
        LinearLayout layout;
        RelativeLayout source;
        ProgressBar loader;
        public news_viewholder(View itemView) {
            super(itemView);
           title= itemView.findViewById(R.id.title);
           img=itemView.findViewById(R.id.image);
           description=itemView.findViewById(R.id.Description);
           layout=itemView.findViewById(R.id.layout);
           source=itemView.findViewById(R.id.info);
           loader=itemView.findViewById(R.id.loader);

        }
    }
};
