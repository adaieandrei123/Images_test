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
 Fragment for display my images
 */

public class Fragment_my_images extends BaseFragment {
    public static final String TAG = "Fragment_my_images";
    private MainViewModel mMainViewModel;
    private List<ImageModel> mImageModels;
    private int [] my_images;
    private ArrayList<ImageModel> myImages;
    private ListView mListView;
    private TextView mTextView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_my_images, parent, false);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {


        mListView = view.findViewById(R.id.listview);
        mTextView = view.findViewById(R.id.textView);



        mMainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        mMainViewModel.getDataLiveData().observe(requireActivity(), new Observer<Data>() {
            @Override
            public void onChanged(Data data) {
                myImages = new ArrayList<>();
                mImageModels = data.getAllImages();
                my_images = data.getMyImages();

                for(ImageModel im:mImageModels){
                    if(containsImage(my_images,im.getId()))
                        myImages.add(im);
                }

                MyImagesAdapter listAdapter = new MyImagesAdapter(requireContext(),myImages);

                mListView.setAdapter(listAdapter);
                mListView.setClickable(true);
                mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent intent = new Intent(getActivity(), ImageActivity.class);
                            intent.putExtra("name",myImages.get(position).getName());
                            startActivity(intent);

                    }
                });

            }
        });

    }
}
