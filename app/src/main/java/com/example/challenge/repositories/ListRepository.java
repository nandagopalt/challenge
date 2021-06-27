package com.example.challenge.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.challenge.models.ListModel;
import com.example.challenge.models.OwnerModel;
import com.example.challenge.network.RetrofitAPIService;
import com.example.challenge.network.RetrofitInstance;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListRepository {
    private static final String TAG = "ListRepository";

    private MutableLiveData<List<ListModel>> mutableListLiveData;

    public LiveData<List<ListModel>> getRemoteRepositoryInformation() {
        if(mutableListLiveData == null)  {
            mutableListLiveData = new MutableLiveData<>();
            loadRepositoryInformation();
        }
        return mutableListLiveData;
    }

    private void loadRepositoryInformation() {
        //long id = Long.parseLong(UUID.randomUUID().toString());
        //OwnerModel ownerModel = new OwnerModel("https://avatars.githubusercontent.com/u/82592?v=4");
        /*List<ListModel> model = Arrays.asList(
                new ListModel(1, "Name 1", "Description 1", ownerModel),
                new ListModel(2, "Name 2", "Description 2", ownerModel),
                new ListModel(3, "Name 3", "Description 3", ownerModel),
                new ListModel(4, "Name 4", "Description 4", ownerModel),
                new ListModel(5, "Name 5", "Description 5", ownerModel),
                new ListModel(6, "Name 6", "Description 6", ownerModel),
                new ListModel(7, "Name 7", "Description 7", ownerModel),
                new ListModel(8, "Name 8", "Description 8", ownerModel),
                new ListModel(9, "Name 9", "Description 9", ownerModel),
                new ListModel(10, "Name 10", "Description 10", ownerModel),
                new ListModel(11, "Name 11", "Description 11", ownerModel));
        mutableListLiveData.setValue(model);*/

        Call<List<ListModel>> call = RetrofitInstance.getRetrofitAPIService().getRepositoryInformation();
        call.enqueue(new Callback<List<ListModel>>() {
            @Override
            public void onResponse(Call<List<ListModel>> call, Response<List<ListModel>> response) {
                mutableListLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<ListModel>> call, Throwable t) {
                mutableListLiveData.postValue(null);
            }
        });
    }
}



