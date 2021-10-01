package com.ainnov.testapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ainnov.testapp.R;
import com.ainnov.testapp.model.ImageModel;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;

/**
 Adapter for My Images / Best Images - use glide for real images
*/
public class MyImagesAdapter extends ArrayAdapter<ImageModel> {

    public MyImagesAdapter(Context context, ArrayList<ImageModel> imagesArrayList){

        super(context, R.layout.my_image_item,imagesArrayList);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ImageModel imageModel = getItem(position);

        if (convertView == null){

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.my_image_item,parent,false);

        }

        LinearLayout linearLayout = convertView.findViewById(R.id.image_v);
        int width = getContext().getResources().getDisplayMetrics().widthPixels/3;
        int height = getContext().getResources().getDisplayMetrics().heightPixels/3;
        linearLayout.setLayoutParams(new LinearLayoutCompat.LayoutParams(width,width));

        TextView myImage = convertView.findViewById(R.id.image_name);
        myImage.setText(imageModel.getName());

        return convertView;
    }
}
