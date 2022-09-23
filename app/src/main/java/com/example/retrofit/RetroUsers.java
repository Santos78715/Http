package com.example.retrofit;

import com.google.gson.annotations.SerializedName;

import kotlin.jvm.internal.SerializedIr;
//pojo class
public class RetroUsers {

    @SerializedName("username")
    public String username;

    public RetroUsers(String name) {
        this.username = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
