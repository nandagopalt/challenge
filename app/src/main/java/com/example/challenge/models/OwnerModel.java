package com.example.challenge.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class OwnerModel {
    @SerializedName("avatar_url")
    @Expose
    private String avatar_url;

    public OwnerModel(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }
}
