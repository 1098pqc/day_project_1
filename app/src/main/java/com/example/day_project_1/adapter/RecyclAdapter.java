package com.example.day_project_1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.day_project_1.R;
import com.example.day_project_1.data.ItemBean;

import java.util.ArrayList;

public class RecyclAdapter extends RecyclerView.Adapter<RecyclAdapter.ViewHolder> {

    private Context context;
    private ArrayList<ItemBean.DataDTO.TopicListDTO> topicList;

    public RecyclAdapter(Context context, ArrayList<ItemBean.DataDTO.TopicListDTO> topicList) {
        this.context = context;
        this.topicList = topicList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_itemm, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemBean.DataDTO.TopicListDTO topicListDTO = topicList.get(position);
        holder.title.setText(topicListDTO.getTitle());
        holder.name.setText(topicListDTO.getSubtitle());
        holder.jin.setText("¥"+topicListDTO.getPrice_info()+"元起");
        Glide.with(context).load(topicListDTO.getItem_pic_url()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return topicList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView title;
        private final ImageView image;
        private final TextView jin;
        private final TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.itemm_title);
            image = itemView.findViewById(R.id.itemm_image);
            jin = itemView.findViewById(R.id.itemm_jin);
            name = itemView.findViewById(R.id.itemm_name);
        }
    }
}
