package com.nicos.inc.collections;

public class bottle {
    private int bottle_id;
    private String bottle_name;
    private String bottle_type;

    public String getBottle_type() {
        return bottle_type;
    }

    public void setBottle_type(String bottle_type) {
        this.bottle_type = bottle_type;
    }

    public bottle(int bottle_id, String bottle_name, int bottle_height, String content_name, String bottle_type) {
        this.bottle_id = bottle_id;
        this.bottle_name = bottle_name;
        this.bottle_height = bottle_height;
        this.content_name = content_name;
        this.bottle_type = bottle_type;
    }

    private int bottle_height;
    private String content_name;


    public int getBottle_id() {
        return bottle_id;
    }

    public void setBottle_id(int bottle_id) {
        this.bottle_id = bottle_id;
    }

    public String getBottle_name() {
        return bottle_name;
    }

    public void setBottle_name(String bottle_name) {
        this.bottle_name = bottle_name;
    }

    public int getBottle_height() {
        return bottle_height;
    }

    public void setBottle_height(int bottle_height) {
        this.bottle_height = bottle_height;
    }

    public String getContent_name() {
        return content_name;
    }

    public void setContent_name(String content_name) {
        this.content_name = content_name;
    }


}
