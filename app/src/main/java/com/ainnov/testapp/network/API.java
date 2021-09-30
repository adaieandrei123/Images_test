package com.ainnov.testapp.network;


import com.ainnov.testapp.model.Data;

import retrofit2.Call;
import retrofit2.http.GET;


public interface API {

    @GET("handler/")
    Call<Data> getImages();
}
