package com.example.myapplication;

public class ListItem {
    private String head;
    private  String desc;
    private String imageURL;
    public ListItem(String head, String desc,String imageURL) {
        this.head = head;
        this.desc = desc;
        this.imageURL = imageURL;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getHead() {
        return head;
    }
    public String getDesc() {
        return desc;
    }

}
