package com.ainnov.testapp.images_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ainnov.testapp.R;
import com.ainnov.testapp.model.Data;
import com.ainnov.testapp.model.ImageModel;
import com.ainnov.testapp.viewmodel.MainViewModel;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class Fragment_all_images extends BaseFragment {

    public static final String TAG = "Fragment_all_images";
    private MainViewModel mMainViewModel;
    private List<ImageModel> mImageModels;
    private ArrayList<ImageModel> cat1Array;
    private ArrayList<ImageModel> cat2Array;
    private ArrayList<ImageModel> cat3Array;
    private ArrayList<ImageModel> cat4Array;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_all_images, parent, false);
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        cat1Array = new ArrayList<>();
        cat2Array = new ArrayList<>();
        cat3Array = new ArrayList<>();
        cat4Array = new ArrayList<>();

        mMainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        mMainViewModel.getDataLiveData().observe(requireActivity(), new Observer<Data>() {
            @Override
            public void onChanged(Data data) {
                mImageModels = data.getAllImages();
                int[] cat1 = data.getCategory_1();
                int[] cat2 = data.getCategory_2();
                int[] cat3 = data.getCategory_3();
                int[] cat4 = data.getCategory_4();

                for(ImageModel im :mImageModels){
                    if(containsImage(cat1,im.getId()))
                        cat1Array.add(im);
                    if(containsImage(cat2,im.getId()))
                        cat2Array.add(im);
                    if(containsImage(cat3,im.getId()))
                        cat3Array.add(im);
                    if(containsImage(cat4,im.getId()))
                        cat4Array.add(im);
                }

            }
            });
    }


}
