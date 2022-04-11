package com.example.stock;

import java.util.HashMap;
import java.util.Map;

public class URL_news {

    private String category;
    private String country;
    private String language;
    private String query;
    private int page;
    private final String api_key="pub_30844dfd0b3d404351b778c93b4b123892e2";
    private final String url ="https://api.bing.microsoft.com/v7.0/news/search?cc=en-IN";
    private Map<String,String> header;
    private  Map<String,String> params;
    public URL_news() {
        category="";
        country="";
        language="";
        query="";
        page=0;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getApi_key() {
        return api_key;
    }


    public String getUrl() {
        return url;
    }


    public String get_url_final()
    {
        String url= getUrl();
        url+="&q="+category+"+news";
        url+="&originalImg=true";
        url+="&count=10";
        url+="&offset="+String.valueOf((page)*10);
//        url+="&page="+String.valueOf(page);


        return  url;
    }

    public  Map getHeader()
    {
        header=new HashMap<String, String>();
        header.put("Ocp-Apim-Subscription-Key","3d84db8d085244f6bee6d4dc690e5ea9");
        return  header;
    }

    public  Map getParams()
    {
        params = new HashMap<String, String>();
       // params.put("originalImg","true");
       // params.put("category","sports");
        return params;
    }




}
