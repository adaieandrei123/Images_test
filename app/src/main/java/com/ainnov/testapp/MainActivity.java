package com.ainnov.testapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.ainnov.testapp.images_fragment.Fragment_all_images;
import com.ainnov.testapp.images_fragment.Fragment_best_images;
import com.ainnov.testapp.images_fragment.Fragment_my_images;
import com.ainnov.testapp.model.Data;
import com.ainnov.testapp.viewmodel.ImageViewModel;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageSlider mImageSlider;
    private RelativeLayout mToolbar;
    private ImageView homeBtn;
    private Button miBtn,bimBtn;
    private FragmentTransaction ft;
    private ImageViewModel mImageViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViews();
        displayAllImages();

        mImageViewModel = new ViewModelProvider(this).get(ImageViewModel.class);
        mImageViewModel.getData().observe(this, new Observer<Data>() {
            @Override
            public void onChanged(Data data) {

            }
        });

    }

    public void displayAllImages(){
        ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragmentContainer, new Fragment_all_images());
        ft.commit();
    }

    public void displayMyImages(){
        ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragmentContainer, new Fragment_my_images());
        ft.commit();
    }

    public void displayBestImages(){
        ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragmentContainer, new Fragment_best_images());
        ft.commit();
    }

    public void setupViews(){
        mImageSlider = findViewById(R.id.mySlider);
        mToolbar = findViewById(R.id.toolbar_include);
        mToolbar.bringToFront();

        homeBtn = findViewById(R.id.homeIcon);
        miBtn = findViewById(R.id.myImagesBtn);
        bimBtn = findViewById(R.id.bestImagesBtn);

        miBtn.setOnClickListener(this);
        bimBtn.setOnClickListener(this);
        homeBtn.setOnClickListener(this);

        List<SlideModel> slideImages = new ArrayList<>();
        slideImages.add(new SlideModel("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg","Image 1"));
        slideImages.add(new SlideModel("https://cdn.pixabay.com/photo/2021/08/25/20/42/field-6574455__480.jpg","Image 2"));
        slideImages.add(new SlideModel("https://live.staticflickr.com/65535/50223166276_e3b3d6de3f_b.jpg","Image 3"));
        mImageSlider.setImageList(slideImages,true);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.homeIcon:
                displayAllImages();
                break;
            case R.id.myImagesBtn:
                displayMyImages();
                break;
            case R.id.bestImagesBtn:
                displayBestImages();
                break;
            default:
                break;
        }
    }
}