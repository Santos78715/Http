package com.example.retrofit;

import static retrofit2.converter.gson.GsonConverterFactory.create;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient{

    public static Retrofit retrofit;

    public static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    public static Retrofit GetRetrofitInstance() {

        if (retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        }
        return  retrofit;
    }
}
