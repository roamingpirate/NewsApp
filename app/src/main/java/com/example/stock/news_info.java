package com.example.stock;

import android.graphics.Bitmap;

public class news_info {

    private String title;
    private  String description;
    private Bitmap Image;
    private String Source;
    private String Image_url;

    public String getImage_url() {
        return Image_url;
    }

    public news_info(String title, String description, String src, String image_url) {
        this.title = title;
        this.description = description;
         Image_url=image_url;
        Source=src;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(Bitmap image) {
        Image = image;
    }

    public void setSource(String source) {
        Source = source;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Bitmap getImage() {
        return Image;
    }

    public String getSource() {
        return Source;
    }
}
