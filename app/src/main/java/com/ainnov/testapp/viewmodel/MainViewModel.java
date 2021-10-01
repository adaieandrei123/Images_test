package com.ainnov.testapp.viewmodel;

import com.ainnov.testapp.model.Data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

/**
 This is the MainViewModel for the livedata
 */
public class MainViewModel extends ViewModel {
    private LiveData<Data> mDataLiveData;

    public MainViewModel() {
        super();
        Repository repository = Repository.getInstance();
        mDataLiveData = repository.getData();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }


    public LiveData<Data> getDataLiveData() {
        return mDataLiveData;
    }

}
