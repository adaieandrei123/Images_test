package com.ainnov.testapp.network;


import com.ainnov.testapp.model.Data;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 I used get method for api interface
 */

public interface API {

    @GET("handler/")
    Call<Data> getImages();
}
