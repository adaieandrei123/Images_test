package com.ainnov.testapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 Data model for every object / methods
 */

public class Data {

    @SerializedName("all_images")
    private List<ImageModel> all_images;

    @SerializedName("my_images")
    private int[] my_images;

    @SerializedName("best_images")
    private int[] best_images;

    @SerializedName("category_1")
    private int[] category_1;
    @SerializedName("category_2")
    private int[] category_2;
    @SerializedName("category_3")
    private int[] category_3;
    @SerializedName("category_4")
    private int[] category_4;

    public int[] getCategory_1(){
        return category_1;
    }

    public int[] getCategory_2(){
        return category_2;
    }
    public int[] getCategory_3(){
        return category_3;
    }
    public int[] getCategory_4(){
        return category_4;
    }
    public int[] getMyImages(){
        return my_images;
    }

    public int[] getBestImages(){
        return best_images;
    }
    public List<ImageModel> getAllImages(){
        return all_images;
    }

}
