package com.example.model;

import java.io.Serializable;

public class User implements Serializable {
    private String id;
    private String Name;
    private String address;
    private String ImageUrl;
    private String ImageName;
    private String initialAmount;

    public User(String id, String name, String address, String imageUrl, String imageName, String initialAmount) {
        this.setInitialAmount(initialAmount);
        this.setId(id);
        setName(name);
        this.setAddress(address);
        setImageUrl(imageUrl);
        setImageName(imageName);

    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getImageName() {
        return ImageName;
    }

    public void setImageName(String imageName) {
        ImageName = imageName;
    }

    public String getInitialAmount() {
        return initialAmount;
    }

    public void setInitialAmount(String initialAmount) {
        this.initialAmount = initialAmount;
    }
}
