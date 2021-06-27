package com.example.challenge.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    private static final String TAG = "RetrofitInstance";
    // https://api.github.com/orgs/square/repos

    public static final String BASE_URL = "https://api.github.com/orgs/square/";
    private static Retrofit retrofit;

    private static Retrofit getRetrofitClient() {
        if(retrofit == null) {
            synchronized (RetrofitInstance.class) {
                if (retrofit == null) {
                    retrofit = new Retrofit.Builder()
                            .baseUrl(BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                }
            }
        }
        return retrofit;
    }

    public static RetrofitAPIService getRetrofitAPIService() {
        return getRetrofitClient().create(RetrofitAPIService.class);
    }
}
