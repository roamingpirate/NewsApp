package com.example.stock;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class news extends Fragment {

    URL_news link;
    String category;

    public news(String category) {
        this.category=category;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_news, container, false);

        URL_news link=new URL_news();
        link.setCategory(category);
        Log.e("haha ","i am active");

       RecyclerView news_list = (RecyclerView)  view.findViewById(R.id.news_list);
        news_list.setLayoutManager(new LinearLayoutManager(getActivity()));
      news_list.setAdapter(new news_adapter(link,view.getContext()));
        return  view;
    }
}