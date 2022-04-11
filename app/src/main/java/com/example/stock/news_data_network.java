package com.example.stock;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class news_data_network {

    private ArrayList<news_info> list;

    Context context;

    public news_data_network(Context context) {
        this.context = context;
    }

    public interface onCompletion
    {
        public void onSuccess(ArrayList<news_info> list);
        public  void onError();
    }


    public void get_Data(URL_news url_news,final onCompletion comp){

        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, url_news.get_url_final(), null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                list=new ArrayList<news_info>();
                try {
                    JSONArray news_array = response.getJSONArray("value");
                    Log.e("hoho count",String.valueOf(news_array.length()));

                    for(int i = 0; i<news_array.length(); i++)
                    {
                        JSONObject obj = news_array.getJSONObject(i);
                        String title=obj.getString("name");
                        String Description =obj.getString("description");
                        boolean is_img_obj_avaliable=false;
                        JSONObject image_obj = null;
                        try {
                              image_obj = obj.getJSONObject("image");
                              is_img_obj_avaliable=true;
                        }catch (JSONException e)
                        {
                           // Log.e("lol",String.valueOf(obj));
                            e.printStackTrace();
                        }

                        String Img_url="null";

                       if(is_img_obj_avaliable){
                             Img_url=image_obj.getString("contentUrl");
                       }

                        news_info data= new news_info(title,Description," ",Img_url);
                        data.setImage(null);
                        list.add(data);
                    }
                    comp.onSuccess(list);
                } catch (JSONException e) {

                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return url_news.getHeader();
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return url_news.getParams();
            }
        };
        RequestData.getInstance(context).addToRequestQueue(request);
    }

}
