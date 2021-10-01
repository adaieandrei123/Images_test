package com.ainnov.testapp.images_fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.ainnov.testapp.ImageActivity;
import com.ainnov.testapp.R;
import com.ainnov.testapp.adapters.MyImagesAdapter;
import com.ainnov.testapp.model.Data;
import com.ainnov.testapp.model.ImageModel;
import com.ainnov.testapp.viewmodel.MainViewModel;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

/**
 Fragment for display best images
 */

public class Fragment_best_images extends BaseFragment {
    public static final String TAG = "Fragment_best_images";
    private MainViewModel mMainViewModel;
    private int [] best_images;
    private List<ImageModel> mImageModels;
    private ArrayList<ImageModel> bestImages;
    private ListView mListView;
    private TextView mTextView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_best_images, parent, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        mListView = view.findViewById(R.id.listview);
        mTextView = view.findViewById(R.id.textView);


        mMainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        mMainViewModel.getDataLiveData().observe(requireActivity(), new Observer<Data>() {
            @Override
            public void onChanged(Data data) {
                bestImages = new ArrayList<>();
                mImageModels = data.getAllImages();
                best_images = data.getBestImages();

                for(ImageModel im:mImageModels){
                    if(containsImage(best_images,im.getId()))
                        bestImages.add(im);
                }
                MyImagesAdapter listAdapter = new MyImagesAdapter(requireContext(),bestImages);

                mListView.setAdapter(listAdapter);
                mListView.setClickable(true);
                mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(getActivity(), ImageActivity.class);
                        intent.putExtra("name",bestImages.get(position).getName());
                        startActivity(intent);

                    }
                });
            }
        });
    }



}
