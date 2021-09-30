package com.ainnov.testapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.ainnov.testapp.images_fragment.Fragment_best_images;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageSlider mImageSlider;
    private RelativeLayout mToolbar;
    private ImageView homeBtn;
    private FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViews();
        displayAllImages();

    }

    public void displayAllImages(){
        ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragmentContainer, new Fragment_best_images());
        ft.commit();
    }

    public void setupViews(){
        mImageSlider = findViewById(R.id.mySlider);
        mToolbar = findViewById(R.id.toolbar_include);
        mToolbar.bringToFront();

        homeBtn = findViewById(R.id.homeIcon);
        homeBtn.setOnClickListener(this);

        List<SlideModel> slideImages = new ArrayList<>();
        slideImages.add(new SlideModel("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg","Image 1"));
        slideImages.add(new SlideModel("https://cdn.pixabay.com/photo/2021/08/25/20/42/field-6574455__480.jpg","Image 2"));
        slideImages.add(new SlideModel("https://live.staticflickr.com/65535/50223166276_e3b3d6de3f_b.jpg","Image 3"));
        mImageSlider.setImageList(slideImages,true);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.homeIcon:
                displayAllImages();
                break;
            default:
                break;
        }
    }
}