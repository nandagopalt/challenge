package com.example.challenge.network;

import com.example.challenge.models.ListModel;

import java.util.List;


import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitAPIService {
    @GET("repos")
    Call<List<ListModel>> getRepositoryInformation();
}
