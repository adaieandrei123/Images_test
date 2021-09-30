package com.ainnov.testapp.viewmodel;

import android.util.Log;

import com.ainnov.testapp.model.Data;
import com.ainnov.testapp.network.API;
import com.ainnov.testapp.network.RetroInstance;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ImageViewModel extends ViewModel {

    public static final String TAG = "IMAGEVIEWMODEL";
    private MutableLiveData<Data> mListMutableLiveData;

    public ImageViewModel() {
        mListMutableLiveData = new MutableLiveData<>();
        notifyAll();
    }

    public MutableLiveData<Data> getData(){
        return mListMutableLiveData;
    }

    public void apiCall(){
        API api = RetroInstance.getClient().create(API.class);
        Call<Data> listCall = api.getImages();

        listCall.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                if(response.body()!=null){
                   mListMutableLiveData.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                Log.d("RAS:","ERROR");
            }
        });

    }
}
