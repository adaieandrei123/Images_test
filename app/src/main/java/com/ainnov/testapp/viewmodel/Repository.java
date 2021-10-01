package com.ainnov.testapp.viewmodel;

import android.util.Log;

import com.ainnov.testapp.model.Data;
import com.ainnov.testapp.network.API;
import com.ainnov.testapp.network.RetroInstance;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {

    public static final String TAG = "IMAGEVIEWMODEL";
    public MutableLiveData<Data> mListMutableLiveData = new MutableLiveData<>();
    private static final Repository ourInstance = new Repository();
    private API api;

    public static Repository getInstance() {
        return ourInstance;
    }

    public Repository() {
        api = RetroInstance.getClient().create(API.class);
    }

    public LiveData<Data> getData() {
        api.getImages().enqueue(new Callback<Data>() {
            @Override
            public void onResponse(@NonNull Call<Data> call, @NonNull Response<Data> response) {
                mListMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<Data> call, @NonNull Throwable t) {
                Log.d(TAG, "onFailure: failed to fetch todo list from server");
            }
        });
        return mListMutableLiveData;
    }

//    public void apiCall(){
//        API api = RetroInstance.getClient().create(API.class);
//        Call<Data> listCall = api.getImages();
//
//        listCall.enqueue(new Callback<Data>() {
//            @Override
//            public void onResponse(Call<Data> call, Response<Data> response) {
//                if(response.body()!=null){
//                   mListMutableLiveData.postValue(response.body());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Data> call, Throwable t) {
//                Log.d("RAS:","ERROR");
//            }
//        });
//
//    }
}
