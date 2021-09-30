package com.ainnov.testapp.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroInstance {

    public static String URL = "https://admin-are-iu1l9xano-adaieandrei123.vercel.app/api/";

    private static Retrofit aRetrofit;

    public static Retrofit getClient(){

        if(aRetrofit == null){
            aRetrofit = new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return aRetrofit;
    }
}
