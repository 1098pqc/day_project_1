package com.example.day_project_1.adapter;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.day_project_1.R;
import com.example.day_project_1.data.ItemBean;

import java.util.ArrayList;

public class GridAdapter extends DelegateAdapter.Adapter {

    private GridLayoutHelper gridLayoutHelper;
    private ArrayList<ItemBean.DataDTO.BrandListDTO> brandList;

    public GridAdapter(GridLayoutHelper gridLayoutHelper, ArrayList<ItemBean.DataDTO.BrandListDTO> brandList) {
        this.gridLayoutHelper = gridLayoutHelper;
        this.brandList = brandList;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return gridLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_grid, null, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ItemBean.DataDTO.BrandListDTO brandListDTO = brandList.get(position);
        GridViewHolder gridViewHolder = (GridViewHolder) holder;
        gridViewHolder.name.setText(brandListDTO.getFloor_price()+"元起");
        gridViewHolder.title.setText(brandListDTO.getName());
        Glide.with(gridViewHolder.image).load(brandListDTO.getNew_pic_url()).into(gridViewHolder.image);
    }

    @Override
    public int getItemCount() {
        return brandList.size();
    }

    private class GridViewHolder extends RecyclerView.ViewHolder {

        private final TextView name;
        private final TextView title;
        private final ImageView image;

        public GridViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.grid_name);
            title = view.findViewById(R.id.grid_title);
            image = view.findViewById(R.id.grid_image);
        }
    }
}
