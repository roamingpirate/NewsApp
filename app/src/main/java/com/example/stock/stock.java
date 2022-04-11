package com.example.stock;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class stock extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_stock, container, false);
        RecyclerView stock_list=(RecyclerView) view.findViewById(R.id.stock_list);
        String ru=getResources().getString(R.string.Rs);
        stock_list.setLayoutManager(new LinearLayoutManager(getActivity()));
        stock_list.setAdapter(new stock_adapter(ru));
         return  view;
    }
}