package com.ainnov.testapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ainnov.testapp.R;
import com.ainnov.testapp.model.ImageModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

public class AllImagesAdapter extends RecyclerView.Adapter<AllImagesAdapter.ViewHolder> {

    List<ImageModel> images;
    LayoutInflater inflater;
    Context mContext;

    public AllImagesAdapter(Context ctx, List<ImageModel> images){
        this.images = images;
        this.inflater = LayoutInflater.from(ctx);
        this.mContext = ctx;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recycler_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(images.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.image_name);

            LinearLayout linearLayout = itemView.findViewById(R.id.image_v);
            int width = mContext.getResources().getDisplayMetrics().widthPixels/3;
            int height = mContext.getResources().getDisplayMetrics().heightPixels/3;
            linearLayout.setLayoutParams(new LinearLayoutCompat.LayoutParams(width,width));

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   // Toast.makeText(v.getContext(), "Clicked -> " + getAdapterPosition(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
