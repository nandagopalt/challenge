package com.example.challenge.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.challenge.models.ListModel;
import com.example.challenge.repositories.ListRepository;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ListViewModel extends AndroidViewModel {
    private Application application;

    private ListRepository listRepository = new ListRepository();

    public ListViewModel(@NonNull @NotNull Application application) {
        super(application);
        this.application = application;
    }

    public LiveData<List<ListModel>> fetchRepositoryList() {
        return listRepository.getRemoteRepositoryInformation();
    }
}
